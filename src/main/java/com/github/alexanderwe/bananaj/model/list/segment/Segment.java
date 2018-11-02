package com.github.alexanderwe.bananaj.model.list.segment;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.exceptions.SegmentException;
import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.model.list.member.Member;
import com.github.alexanderwe.bananaj.model.list.member.MemberStatus;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 04.02.16.
 */
public class Segment extends MailchimpObject {

    /** The name. */
    private String name;
    
    /** The type. */
    private SegmentType type;
    
    /** The list id. */
    private String list_id;
    
    /** The created at. */
    private LocalDateTime created_at;
    
    /** The updated at. */
    private LocalDateTime updated_at;
    
    /** The member count. */
    private int member_count;
    
    /** The options. */
    private Options options;
    
    /** The connection. */
    private MailChimpConnection connection;

    /**
     * Instantiates a new segment.
     *
     * @param id the id
     * @param name the name
     * @param list_id the list id
     * @param type the type
     * @param created_at the created at
     * @param updated_at the updated at
     * @param member_count the member count
     * @param options the options
     * @param connection the connection
     * @param jsonRepresentation the json representation
     */
    public Segment(int id, String name, String list_id, SegmentType type, LocalDateTime created_at, LocalDateTime updated_at, int member_count, Options options, MailChimpConnection connection, JSONObject jsonRepresentation){
        super(String.valueOf(id), jsonRepresentation);
        this.name = name;
        this.list_id = list_id;
        this.type = type;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.member_count = member_count;
        this.options = options;
        this.connection = connection;
    }

    /**
     * Used when created a Segment locally with the Builder class.
     *
     * @param b the b
     * @see Builder
     */
    public Segment(Builder b){
        this.name = b.name;
        this.type = b.type;
        setJSONRepresentation(b.jsonRepresentation);
    }

    /**
     * Add a member to this segment, only STATIC segments allowed.
     *
     * @param member the member
     * @throws Exception the exception
     */
    public void addMember(Member member) throws Exception{
        if (!SegmentType.STATIC.equals(this.getType())){
            throw new SegmentException();
        }
        getConnection().do_Post(new URL(connection.getListendpoint()+"/"+this.getList_id()+"/segments/"+this.getId()+"/members"),member.getJSONRepresentation().toString(),connection.getApikey());
    }

    /**
     * Get all members in this list.
     *
     * @param count x first members
     * @param offset skip x first members
     * @return the members
     * @throws Exception the exception
     */
    public ArrayList<Member> getMembers(int count, int offset) throws Exception{

        ArrayList<Member> members = new ArrayList<Member>();
        final JSONObject list;
        if(count != 0){
            list = new JSONObject(getConnection().do_Get(new URL("https://"+connection.getServer()+".api.mailchimp.com/3.0/lists/"+this.getList_id()+"/segments/"+this.getId()+"/members?count="+count+"&offset="+offset),connection.getApikey()));
        } else {
            list = new JSONObject(getConnection().do_Get(new URL("https://"+connection.getServer()+".api.mailchimp.com/3.0/lists/"+this.getList_id()+"/segments/"+this.getId()+"/members?count="+this.getMember_count()+"&offset="+offset),connection.getApikey()));
        }

        final JSONArray membersArray = list.getJSONArray("members");


        for (int i = 0 ; i < membersArray.length();i++)
        {
            final JSONObject memberDetail = membersArray.getJSONObject(i);
            final JSONObject memberMergeTags = memberDetail.getJSONObject("merge_fields");
            final JSONObject memberStats = memberDetail.getJSONObject("stats");

            HashMap<String, String> merge_fields = new HashMap<String, String>();

            Iterator<String> a = memberMergeTags.keys();
            while(a.hasNext()) {
                String key = a.next();
                // loop to get the dynamic key
                String value = memberMergeTags.getString(key);
                merge_fields.put(key, value);
            }
            Member member = new Member(memberDetail.getString("id"),connection.getList(this.getList_id()),merge_fields,memberDetail.getString("unique_email_id"), memberDetail.getString("email_address"), MemberStatus.valueOf(memberDetail.getString("status").toUpperCase()),memberDetail.getString("timestamp_signup"),memberDetail.getString("ip_signup"),memberDetail.getString("timestamp_opt"),memberDetail.getString("ip_opt"),memberStats.getDouble("avg_open_rate"),memberStats.getDouble("avg_click_rate"),memberDetail.getString("last_changed"),this.getConnection(),memberDetail);
            members.add(member);

        }
        return members;
    }

    /**
     * Remove a member from this segment, only STATIC segments allowed.
     *
     * @param member the member
     * @throws Exception the exception
     */
    public void removeMember(Member member) throws Exception{
        if (!SegmentType.STATIC.equals(this.getType())){
            throw new SegmentException();
        }
        getConnection().do_Delete(new URL(connection.getListendpoint()+"/"+this.getList_id()+"/segments/"+this.getId()+"/members/"+member.getId()),connection.getApikey());
    }

    /**
     * Update a segment with a local segment.
     *
     * @param updatedSegment the updated segment
     * @throws Exception the exception
     */
    public void update(Segment updatedSegment) throws Exception{
        getConnection().do_Patch(new URL(connection.getListendpoint()+"/"+this.getList_id()+"/segments/"+this.getId()),updatedSegment.getJSONRepresentation().toString(),connection.getApikey());
    }


    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public SegmentType getType() {
        return type;
    }

    /**
     * Gets the list id.
     *
     * @return the list id
     */
    public String getList_id() {
        return list_id;
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    /**
     * Gets the updated at.
     *
     * @return the updated at
     */
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    /**
     * Gets the member count.
     *
     * @return the member count
     */
    public int getMember_count() {
        return member_count;
    }

    /**
     * Gets the options.
     *
     * @return the options
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public MailChimpConnection getConnection() {
        return connection;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return  "ID: " + this.getId() +  System.lineSeparator() +
                "Name: " + this.getName() +  System.lineSeparator() +
                "Type: " + this.getType() + System.lineSeparator() +
                "List ID: " + this.getList_id() + System.lineSeparator() +
                "Created at: " + this.getCreated_at() + System.lineSeparator() +
                "Updated at: " + this.getUpdated_at() +  System.lineSeparator() +
                "Member count: " +  this.getMember_count() + System.lineSeparator() +
                "Options :" +this.getOptions() +  System.lineSeparator();
    }

    /**
     * The Class Builder.
     */
    public static class Builder {
        
        /** The name. */
        private String name;
        
        /** The type. */
        private SegmentType type;
        
        /** The json representation. */
        private JSONObject jsonRepresentation = new JSONObject();

        /**
         * Name.
         *
         * @param s the s
         * @return the builder
         */
        public Builder name(String s) {
            this.name = s;
            jsonRepresentation.put("name", s);
            return this;
        }

        /**
         * Type.
         *
         * @param type the type
         * @return the builder
         */
        public Builder type(SegmentType type) {
            this.type = type;
            jsonRepresentation.put("type", type.value());
            return this;
        }
        
        /**
         * Builds the.
         *
         * @return the segment
         */
        public Segment build() {
            return new Segment(this);
        }
    }
}
