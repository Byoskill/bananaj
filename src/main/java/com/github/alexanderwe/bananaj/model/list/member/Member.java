/**
 * @author alexanderweiss
 * @date 06.11.2015
 */
package com.github.alexanderwe.bananaj.model.list.member;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.exceptions.EmailException;
import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.model.list.MailChimpList;
import com.github.alexanderwe.bananaj.utils.EmailValidator;

// TODO: Auto-generated Javadoc
/**
 * Object for representing a mailchimp member.
 *
 * @author alexanderweiss
 */
public class Member extends MailchimpObject {

    private static final Logger      LOGGER = LoggerFactory.getLogger(Member.class);

    /** The mail chimp list. */
    private MailChimpList            mailChimpList;

    /** The merge fields. */
    private Map<String, Object>      merge_fields;

    /** The unique email id. */
    private String                   unique_email_id;

    /** The email address. */
    private String                   email_address;

    /** The status if new. */
    private MemberStatus             status_if_new;

    /** The email type. */
    private EmailType                email_type;

    /** The status. */
    private MemberStatus             status;

    /** The timestamp signup. */
    private String                   timestamp_signup;

    /** The timestamp opt. */
    private String                   timestamp_opt;

    /** The ip signup. */
    private String                   ip_signup;

    /** The ip opt. */
    private String                   ip_opt;

    /** The avg open rate. */
    private double                   avg_open_rate;

    /** The avg click rate. */
    private double                   avg_click_rate;

    /** The last changed. */
    private String                   last_changed;

    /** The member activities. */
    private List<MemberActivity>     memberActivities;

    /** The member interest. */
    private HashMap<String, Boolean> memberInterest;

    /** The connection. */
    private MailChimpConnection      connection;

    /**
     * Instantiates a new member.
     *
     * @param mailChimpList the mail chimp list
     * @param member        the member
     */
    public Member(MailChimpList mailChimpList, JSONObject member) {
        super(member.getString("id"), member);
        final JSONObject memberMergeTags = member.optJSONObject("merge_fields");
        final JSONObject memberStats = member.optJSONObject("stats");
        final JSONObject interests = member.optJSONObject("interests");

        Map<String, Object> merge_fields = new HashMap<>();
        if (memberMergeTags != null) {
            Iterator<String> mergeTagsI = memberMergeTags.keys();
            while (mergeTagsI.hasNext()) {
                String key = mergeTagsI.next();
                // loop to get the dynamic key
                Object value = memberMergeTags.get(key);
                merge_fields.put(key, value);
            }
        }

        HashMap<String, Boolean> memberInterest = new HashMap<>();
        if (interests != null) {
            Iterator<String> interestsI = interests.keys();
            while (interestsI.hasNext()) {
                String key = interestsI.next();
                boolean value = interests.getBoolean(key);
                memberInterest.put(key, value);
            }
        }

        this.mailChimpList = mailChimpList;
        this.merge_fields = merge_fields;
        this.unique_email_id = member.getString("unique_email_id");
        this.email_address = member.getString("email_address");
        if (member.has("status_if_new")) {
            String value = member.getString("status_if_new");
            if (value.length() > 0) {
                this.status = MemberStatus.valueOf(member.getString("status_if_new").toUpperCase());
            }
        }
        this.email_type = EmailType.fromValue(member.getString("email_type"));
        this.status = MemberStatus.valueOf(member.getString("status").toUpperCase());
        this.timestamp_signup = member.getString("timestamp_signup");
        this.timestamp_opt = member.getString("timestamp_opt");
        this.ip_signup = member.getString("ip_signup");
        this.ip_opt = member.getString("ip_opt");
        this.avg_open_rate = memberStats.getDouble("avg_open_rate");
        this.avg_click_rate = memberStats.getDouble("avg_click_rate");
        this.last_changed = member.getString("last_changed");
        this.memberInterest = memberInterest;
        this.connection = mailChimpList.getConnection();
    }

    /**
     * Instantiates a new member.
     *
     * @param id                 the id
     * @param mailChimpList      the mail chimp list
     * @param merge_fields       the merge fields
     * @param unique_email_id    the unique email id
     * @param email_address      the email address
     * @param status             the status
     * @param timestamp_signup   the timestamp signup
     * @param ip_signup          the ip signup
     * @param timestamp_opt      the timestamp opt
     * @param ip_opt             the ip opt
     * @param avg_open_rate      the avg open rate
     * @param avg_click_rate     the avg click rate
     * @param last_changed       the last changed
     * @param connection         the connection
     * @param jsonRepresentation the json representation
     */
    public Member(String id, MailChimpList mailChimpList, Map<String, Object> merge_fields, String unique_email_id,
            String email_address, MemberStatus status, String timestamp_signup, String ip_signup, String timestamp_opt,
            String ip_opt, double avg_open_rate, double avg_click_rate, String last_changed,
            MailChimpConnection connection, JSONObject jsonRepresentation) {
        super(id, jsonRepresentation);
        this.mailChimpList = mailChimpList;
        this.merge_fields = merge_fields;
        this.unique_email_id = unique_email_id;
        this.email_address = email_address;
        this.status = status;
        this.timestamp_signup = timestamp_signup;
        this.timestamp_opt = timestamp_opt;
        this.ip_signup = ip_signup;
        this.ip_opt = ip_opt;
        this.avg_open_rate = avg_open_rate;
        this.avg_click_rate = avg_click_rate;
        this.last_changed = last_changed;
        this.memberInterest = new HashMap<String, Boolean>();
        this.connection = connection;
    }

    /**
     * Instantiates a new member.
     */
    public Member() {

    }

    /**
     * Update the mailChimpList of this member.
     *
     * @param listId the list id
     * @throws Exception the exception
     */
    public void changeList(String listId) throws Exception {
        JSONObject updateMember = new JSONObject();
        updateMember.put("list_id", listId);
        this.getConnection().do_Patch(
                new URL("https://" + mailChimpList.getConnection().getServer() + ".api.mailchimp.com/3.0/lists/"
                        + getMailChimpList().getId() + "/members/" + getId()),
                updateMember.toString(), connection.getApikey());
        this.mailChimpList = this.getConnection().getList(listId);
    }

    /**
     * Update the email Address of this member.
     *
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public void changeEmailAddress(String emailAddress) throws Exception {

        EmailValidator validator = EmailValidator.getInstance();
        if (validator.validate(emailAddress)) {
            JSONObject updateMember = new JSONObject();
            updateMember.put("email_Address", emailAddress);
            this.getConnection()
                    .do_Patch(new URL("https://" + mailChimpList.getConnection().getServer()
                            + ".api.mailchimp.com/3.0/lists/" + getMailChimpList().getId() + "/members/" + getId()),
                            updateMember.toString(), connection.getApikey());
            this.email_address = emailAddress;
        } else {
            throw new EmailException(emailAddress);
        }
    }

    /**
     * Update the email address of this member.
     *
     * @param status the status
     * @throws Exception the exception
     */
    public void changeMemberStatus(MemberStatus status) throws Exception {
        JSONObject updateMember = new JSONObject();
        updateMember.put("status", status.getStringRepresentation());
        this.getConnection().do_Patch(
                new URL("https://" + mailChimpList.getConnection().getServer() + ".api.mailchimp.com/3.0/lists/"
                        + getMailChimpList().getId() + "/members/" + getId()),
                updateMember.toString(), connection.getApikey());
        this.status = status;
    }

    /**
     * Gets the unique email id.
     *
     * @return the unique_email_id
     */
    public String getUnique_email_id() {
        return unique_email_id;
    }

    /**
     * Gets the email address.
     *
     * @return the email_Address
     */
    public String getEmail_address() {
        return email_address;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public MemberStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(MemberStatus status) {
        this.status = status;
    }

    /**
     * Gets the status if new.
     *
     * @return the status_if_new
     */
    public MemberStatus getStatus_if_new() {
        return status_if_new;
    }

    /**
     * Set the status_if_new when creating a new member.
     *
     * @param status_if_new the new status if new
     */
    public void setStatus_if_new(MemberStatus status_if_new) {
        this.status_if_new = status_if_new;
    }

    /**
     * Gets the email type.
     *
     * @return the email type
     */
    public EmailType getEmail_type() {
        return email_type;
    }

    /**
     * Sets the email type.
     *
     * @param email_type the new email type
     */
    public void setEmail_type(EmailType email_type) {
        this.email_type = email_type;
    }

    /**
     * Gets the timestamp signup.
     *
     * @return the timestamp_signup
     */
    public String getTimestamp_signup() {
        return timestamp_signup;
    }

    /**
     * Gets the timestamp opt.
     *
     * @return the timestamp_opt
     */
    public String getTimestamp_opt() {
        return timestamp_opt;
    }

    /**
     * Gets the avg open rate.
     *
     * @return the avg_open_rate
     */
    public double getAvg_open_rate() {
        return avg_open_rate;
    }

    /**
     * Gets the avg click rate.
     *
     * @return the avg_click_rate
     */
    public double getAvg_click_rate() {
        return avg_click_rate;
    }

    /**
     * Gets the mail chimp list.
     *
     * @return the listId
     */
    public MailChimpList getMailChimpList() {
        return mailChimpList;
    }

    /**
     * Gets the last changed.
     *
     * @return the last_changed date
     */
    public String getLast_changed() {
        return last_changed;
    }

    /**
     * Set the member activities fot this specific member.
     *
     * @param unique_email_id the unique email id
     * @param listID          the list ID
     * @throws Exception the exception
     */
    private void setMemberActivities(String unique_email_id, String listID) throws Exception {
        List<MemberActivity> activities = new ArrayList<>();

        final JSONObject activity = new JSONObject(this.getConnection().do_Get(
                new URL("https://" + this.mailChimpList.getConnection().getServer() + ".api.mailchimp.com/3.0/lists/"
                        + this.mailChimpList.getId() + "/members/" + this.getId() + "/activity"),
                connection.getApikey()));
        final JSONArray activityArray = activity.optJSONArray("activity");

        if (activityArray != null) {
            for (int i = 0; i < activityArray.length(); i++) {
                try {
                    final JSONObject activityDetail = activityArray.getJSONObject(i);
                    MemberActivity memberActivity = new MemberActivity(this.unique_email_id,
                            this.mailChimpList.getId(), activityDetail.getString("action"),
                            activityDetail.getString("timestamp"), activityDetail.getString("campaign_id"),
                            activityDetail.getString("title"));
                    activities.add(memberActivity);
                } catch (JSONException jsone) {
                    final JSONObject activityDetail = activityArray.getJSONObject(i);
                    MemberActivity memberActivity = new MemberActivity(this.unique_email_id,
                            this.mailChimpList.getId(), activityDetail.getString("action"),
                            activityDetail.getString("timestamp"), activityDetail.getString("campaign_id"));
                    activities.add(memberActivity);
                }

            }
        }

        this.memberActivities = activities;
    }

    /**
     * Gets the interest.
     *
     * @return the member interests. The map key is the interest/segment identifier
     *         and value is the subscription boolean.
     */
    public HashMap<String, Boolean> getInterest() {
        return memberInterest;
    }

    /**
     * Add/Update an intrests subscription.
     *
     * @param key       the key
     * @param subscribe the subscribe
     * @return the previous value associated with key, or null if there was none.)
     */
    public Boolean putInterest(String key, Boolean subscribe) {
        if (memberInterest == null) {
            memberInterest = new HashMap<>();
        }
        return memberInterest.put(key, subscribe);
    }

    /**
     * Gets the member activities.
     *
     * @return the member activities
     */
    public List<MemberActivity> getMemberActivities() {
        if (memberActivities == null) {
            try {
                // cache member activity
                synchronized (this) {
                    if (memberActivities == null) {
                        setMemberActivities(unique_email_id, mailChimpList.getId());
                    }
                }
            } catch (Exception e) {
                LOGGER.error("Cannot obtain the member activities", e);
            }
        }
        return this.memberActivities;
    }

    /**
     * Gets the connection.
     *
     * @return the MailChimp com.github.alexanderwe.bananaj.connection
     */
    public MailChimpConnection getConnection() {
        return connection;
    }

    /**
     * Gets the merge fields.
     *
     * @return a HashMap of all merge fields
     */
    public Map<String, Object> getMerge_fields() {
        return merge_fields;
    }

    /**
     * Add/update a merge field.
     *
     * @param key   the key
     * @param value the value
     * @return the previous value associated with key, or null if there was none.)
     */
    public Object putMerge_fields(String key, Object value) {
        return merge_fields.put(key, value);
    }

    /**
     * Gets the ip signup.
     *
     * @return the sign up IP Address
     */
    public String getIp_signup() {
        return ip_signup;
    }

    /**
     * Gets the ip opt.
     *
     * @return the opt-in IP Address
     */
    public String getIp_opt() {
        return ip_opt;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Entry<String, Object>> it = getMerge_fields().entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> pair = it.next();
            stringBuilder.append(pair.getKey()).append(": ").append(pair.getValue()).append("\n");
            it.remove(); // avoids a ConcurrentModificationException
        }

        return System.lineSeparator() + "ID: " + this.getId() + "\t" + System.getProperty("line.separator")
                + "Unique email Address: " + this.getUnique_email_id() + System.getProperty("line.separator")
                + "Email address: " + this.getEmail_address() + System.getProperty("line.separator")
                + "Status: " + this.getStatus().getStringRepresentation() + System.getProperty("line.separator")
                + "Sign_Up: " + this.getTimestamp_signup() + System.getProperty("line.separator")
                + "Opt_In: " + this.getTimestamp_opt() + System.lineSeparator()
                + "Last changed: " + this.getLast_changed() + System.lineSeparator()
                + stringBuilder.toString()
                + "_________________________________________________";
    }

}
