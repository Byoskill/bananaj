/**
 * @author alexanderweiss
 * @date 06.12.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

import java.net.URL;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.exceptions.CampaignSettingsException;
import com.github.alexanderwe.bananaj.exceptions.EmailException;
import com.github.alexanderwe.bananaj.utils.EmailValidator;

// TODO: Auto-generated Javadoc
/**
 * Class for representing settings for a campaign, including subject, from name, reply-to address, and more.
 * @author alexanderweiss
 *
 */
public class CampaignSettings {
	
	/** The subject line. */
	// Campaign Settings 
	private String subject_line;
	
	/** The title. */
	//private String preview_text; // The preview text for the campaign.
	private String title;
	
	/** The to name. */
	private String to_name;
	
	/** The from name. */
	private String from_name;
	
	/** The reply to. */
	private String reply_to;
	
	/** The template id. */
	private int template_id;
	
	/** The auto footer. */
	private Boolean auto_footer;
	
	/** The use conversation. */
	private Boolean use_conversation;
	
	/** The authenticate. */
	private Boolean authenticate;
	
	/** The timewarp. */
	private Boolean timewarp;
	
	/** The auto tweet. */
	private Boolean auto_tweet;
	
	/** The fb comments. */
	private Boolean fb_comments;
	
	/** The drag and drop. */
	private Boolean drag_and_drop;
	
	/** The inline css. */
	private Boolean inline_css;
	//private Boolean auto_tweet;  // Automatically tweet a link to the campaign archive page when the campaign is sent.
	/** The folder id. */
	//List<> auto_fb_post;  // An array of Facebook page ids to auto-post to.
	private String folder_id;
	
	/** The campaign id. */
	// Convince references
	private String campaignId;
	
	/** The connection. */
	private MailChimpConnection connection;
	
	/**
	 * Instantiates a new campaign settings.
	 *
	 * @param subject_line the subject line
	 * @param title the title
	 * @param from_name the from name
	 * @param reply_to the reply to
	 * @param campaignId the campaign id
	 * @param connection the connection
	 */
	public CampaignSettings(String subject_line, String title, String from_name, String reply_to, String campaignId, MailChimpConnection connection) {
		this.subject_line = subject_line;
		this.title = title;
		this.from_name = from_name;
		this.reply_to = reply_to;
		this.campaignId = campaignId;
		this.connection = connection;
	}

	/**
	 * Instantiates a new campaign settings.
	 *
	 * @param connection the connection
	 * @param campaignId the campaign id
	 * @param settings the settings
	 */
	public CampaignSettings(MailChimpConnection connection, String campaignId, JSONObject settings) {
		subject_line = getString(settings, "subject_line");
		title = getString(settings, "title");
		to_name = getString(settings, "to_name");
		from_name = getString(settings, "from_name");
		reply_to = getString(settings, "reply_to");
		template_id = settings.getInt("template_id");
		auto_footer = getBoolean(settings, "auto_footer");
		use_conversation = getBoolean(settings, "use_conversation");
		authenticate = getBoolean(settings, "authenticate");
		timewarp = getBoolean(settings, "timewarp");
		auto_tweet = getBoolean(settings, "auto_tweet");
		fb_comments = getBoolean(settings, "fb_comments");
		drag_and_drop = getBoolean(settings, "drag_and_drop");
		inline_css = getBoolean(settings, "inline_css");
		folder_id = getString(settings, "folder_id");
		this.campaignId = campaignId;
		this.connection = connection;
	}
	
	/**
	 * Instantiates a new campaign settings.
	 *
	 * @param b the b
	 * @throws CampaignSettingsException the campaign settings exception
	 */
	private CampaignSettings(Builder b) throws CampaignSettingsException{

		if(b.subject_line == null){
			throw new CampaignSettingsException("You need to provide a 'subject line' for a campaign setting");
		} else {
			this.subject_line = b.subject_line;
		}

		if(b.title == null){
			throw new CampaignSettingsException("You need to provide a 'title' for a campaign setting");
		} else {
			this.title = b.title;
		}

		this.to_name = b.to_name;
		
		if(b.from_name == null){
			throw new CampaignSettingsException("You need to provide a 'From name' for a campaign setting");
		} else {
			this.from_name = b.from_name;
		}

		if(b.reply_to == null){
			throw new CampaignSettingsException("You need to provide a 'Reply to email address' for a campaign setting");
		} else {
			this.reply_to = b.reply_to;
		}

		this.reply_to = b.reply_to;
		this.template_id = b.template_id;
		this.auto_footer = b.auto_footer;
		this.use_conversation = b.use_conversation;
		this.authenticate = b.authenticate;
		this.timewarp = b.timewarp;
		this.auto_tweet = b.auto_tweet;
		this.fb_comments = b.fb_comments;
		this.drag_and_drop = b.drag_and_drop;
		this.inline_css = b.inline_css;
		this.folder_id = b.folder_id;
		this.campaignId = b.campaignId;
		this.connection = b.connection;
	}

	/**
	 * Gets the string.
	 *
	 * @param settings the settings
	 * @param key the key
	 * @return the string
	 */
	private String getString(JSONObject settings, String key) {
		if (settings.has(key)) {
			return settings.getString(key);
		}
		return null;
	}
	
	/**
	 * Gets the boolean.
	 *
	 * @param settings the settings
	 * @param key the key
	 * @return the boolean
	 */
	private Boolean getBoolean(JSONObject settings, String key) {
		if (settings.has(key)) {
			return settings.getBoolean(key);
		}
		return null;
	}
	
	/**
	 * Change the subject line of this campaign.
	 *
	 * @param newSubject the new subject
	 * @throws Exception the exception
	 */
	public void changeSubjectLine(String newSubject) throws Exception{
		JSONObject updatedCampaign = new JSONObject();
		JSONObject updatedSettings = new JSONObject();
		updatedSettings.put("subject_line", newSubject);
		updatedCampaign.put("settings", updatedSettings);
		this.getConnection().do_Patch(new URL(this.getConnection().getCampaignendpoint()+"/"+this.getCampaignId()),updatedCampaign.toString(),this.getConnection().getApikey());
		this.subject_line = newSubject;
	}

	/**
	 * Change the title of this campaign.
	 *
	 * @param newTitle the new title
	 * @throws Exception the exception
	 */
	public void changeTitle(String newTitle) throws Exception{
		JSONObject updatedCampaign = new JSONObject();
		JSONObject updatedSettings = new JSONObject();
		updatedSettings.put("title", newTitle);
		updatedCampaign.put("settings", updatedSettings);
		this.getConnection().do_Patch(new URL(this.getConnection().getCampaignendpoint()+"/"+this.getCampaignId()),updatedCampaign.toString(),this.getConnection().getApikey());
		this.title = newTitle;
	}

	/**
	 * Change the from name of this campaign.
	 *
	 * @param newFrom the new from
	 * @throws Exception the exception
	 */
	public void changeFrom(String newFrom) throws Exception{
		JSONObject updatedCampaign = new JSONObject();
		JSONObject updatedSettings = new JSONObject();
		updatedSettings.put("from_name", newFrom);
		updatedCampaign.put("settings", updatedSettings);
		this.getConnection().do_Patch(new URL(this.getConnection().getCampaignendpoint()+"/"+this.getCampaignId()),updatedCampaign.toString(),this.getConnection().getApikey());
		this.from_name = newFrom;
	}

	/**
	 * Change the reply to email address of this campaign.
	 *
	 * @param newReplyToMail the new reply to mail
	 * @throws Exception the exception
	 */
	public void changeReplyTo(String newReplyToMail) throws Exception{
		if(EmailValidator.getInstance().validate(newReplyToMail)){
			JSONObject updatedCampaign = new JSONObject();
			JSONObject updatedSettings = new JSONObject();
			updatedSettings.put("reply_to", newReplyToMail);
			updatedCampaign.put("settings", updatedSettings);
			this.getConnection().do_Patch(new URL(this.getConnection().getCampaignendpoint()+"/"+this.getCampaignId()),updatedCampaign.toString(),this.getConnection().getApikey());
			this.reply_to = newReplyToMail;
		} else {
			throw new EmailException(newReplyToMail);
		}
	}

	/**
	 * The subject line for the campaign.
	 * @return the subject_line
	 */
	public String getSubject_line() {
		return subject_line;
	}

	/**
	 * The title of the campaign.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The campaign’s custom ‘To’ name. Typically the first name merge field.
	 * @return the to_name
	 */
	public String getTo_name() {
		return to_name;
	}

	/**
	 * The ‘from’ name on the campaign (not an email address).
	 * @return the from_name
	 */
	public String getFrom_name() {
		return from_name;
	}

	/**
	 * The reply-to email address for the campaign. Note: while this field is not required for campaign creation, it is required for sending.
	 * @return the reply_to
	 */
	public String getReply_to() {
		return reply_to;
	}

	/**
	 * The id of the template to use.
	 * @return the template_id
	 */
	public int getTemplate_id() {
		return template_id;
	}

	/**
	 * Automatically append MailChimp’s default footer to the campaign.
	 * @return the auto_footer
	 */
	public Boolean getAuto_footer() {
		return auto_footer;
	}

	/**
	 * Use MailChimp Conversation feature to manage out-of-office replies.
	 * @return the use_conversation
	 */
	public Boolean getUse_conversation() {
		return use_conversation;
	}

	/**
	 * Whether MailChimp authenticated the campaign. Defaults to true.
	 * @return the authenticate
	 */
	public Boolean getAuthenticate() {
		return authenticate;
	}

	/**
	 * Gets the timewarp.
	 *
	 * @return the timewarp
	 */
	public Boolean getTimewarp() {
		return timewarp;
	}

	/**
	 * Gets the auto tweet.
	 *
	 * @return the auto_tweet
	 */
	public Boolean getAuto_tweet() {
		return auto_tweet;
	}

	/**
	 * Allows Facebook comments on the campaign (also force-enables the Campaign Archive toolbar). Defaults to true.
	 * @return the fb_comments
	 */
	public Boolean getFb_comments() {
		return fb_comments;
	}

	/**
	 * Gets the drag and drop.
	 *
	 * @return the drag_and_drop
	 */
	public Boolean getDrag_and_drop() {
		return drag_and_drop;
	}

	/**
	 * Automatically inline the CSS included with the campaign content.
	 * @return the inline_css
	 */
	public Boolean getInline_css() {
		return inline_css;
	}

	/**
	 * If the campaign is listed in a folder, the id for that folder.
	 * @return the folder_id
	 */
	public String getFolder_id() {
		return folder_id;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public MailChimpConnection getConnection() {
		return this.connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection the new connection
	 */
	public void setConnection(MailChimpConnection connection) {
		this.connection = connection;
	}

	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 */
	public String getCampaignId() {
		return campaignId;
	}

	/**
	 * Sets the campaign id.
	 *
	 * @param campaignId the new campaign id
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * CampaignSettings builder pattern. 
	 *
	 */
	public static class Builder {
		
		/** The subject line. */
		private String subject_line;
		
		/** The title. */
		//private String preview_text; // The preview text for the campaign.
		private String title;
		
		/** The to name. */
		private String to_name;
		
		/** The from name. */
		private String from_name;
		
		/** The reply to. */
		private String reply_to;
		
		/** The template id. */
		private int template_id;
		
		/** The auto footer. */
		private Boolean auto_footer;
		
		/** The use conversation. */
		private Boolean use_conversation;
		
		/** The authenticate. */
		private Boolean authenticate;
		
		/** The timewarp. */
		private Boolean timewarp;
		
		/** The auto tweet. */
		private Boolean auto_tweet;
		
		/** The fb comments. */
		private Boolean fb_comments;
		
		/** The drag and drop. */
		private Boolean drag_and_drop;
		
		/** The inline css. */
		private Boolean inline_css;
		//private Boolean auto_tweet;  // Automatically tweet a link to the campaign archive page when the campaign is sent.
		/** The folder id. */
		//List<> auto_fb_post;  // An array of Facebook page ids to auto-post to.
		private String folder_id;
		
		/** The campaign id. */
		private String campaignId;
		
		/** The connection. */
		private MailChimpConnection connection;

		/**
		 * Instantiates a new builder.
		 *
		 * @param connection the connection
		 */
		public Builder (MailChimpConnection connection) {
			this.connection = connection;
		}
		
		/**
		 * Instantiates a new builder.
		 *
		 * @param settings the settings
		 */
		public Builder (CampaignSettings settings) {
			this.subject_line = settings.subject_line;
			this.title = settings.title;
			this.to_name = settings.to_name;
			this.from_name = settings.from_name;
			this.reply_to = settings.reply_to;
			this.template_id = settings.template_id;
			this.auto_footer = settings.auto_footer;
			this.use_conversation = settings.use_conversation;
			this.authenticate = settings.authenticate;
			this.timewarp = settings.timewarp;
			this.auto_tweet = settings.auto_tweet;
			this.fb_comments = settings.fb_comments;
			this.drag_and_drop = settings.drag_and_drop;
			this.inline_css = settings.inline_css;
			this.folder_id = settings.folder_id;
			this.campaignId = settings.campaignId;
			this.connection = settings.connection;
		}

		/**
		 * Instantiates a new builder.
		 */
		public Builder () {
			
		}
		
		/**
		 * Subject line.
		 *
		 * @param subject_line the subject line
		 * @return the builder
		 */
		public Builder subject_line(String subject_line) {
			this.subject_line = subject_line;
			return this;
		}

		/**
		 * Title.
		 *
		 * @param title the title
		 * @return the builder
		 */
		public Builder title(String title) {
			this.title = title;
			return this;
		}

		/**
		 * To name.
		 *
		 * @param to_name the to name
		 * @return the builder
		 */
		public Builder to_name(String to_name) {
			this.to_name = to_name;
			return this;
		}

		/**
		 * From name.
		 *
		 * @param from_name the from name
		 * @return the builder
		 */
		public Builder from_name(String from_name) {
			this.from_name = from_name;
			return this;
		}

		/**
		 * Reply to.
		 *
		 * @param reply_to the reply to
		 * @return the builder
		 */
		public Builder reply_to(String reply_to) {
			this.reply_to = reply_to;
			return this;
		}

		/**
		 * Template id.
		 *
		 * @param template_id the template id
		 * @return the builder
		 */
		public Builder template_id(int template_id) {
			this.template_id = template_id;
			return this;
		}

		/**
		 * Auto footer.
		 *
		 * @param auto_footer the auto footer
		 * @return the builder
		 */
		public Builder auto_footer(Boolean auto_footer) {
			this.auto_footer = auto_footer;
			return this;
		}
		
		/**
		 * Use conversation.
		 *
		 * @param use_conversation the use conversation
		 * @return the builder
		 */
		public Builder use_conversation(Boolean use_conversation) {
			this.use_conversation = use_conversation;
			return this;
		}
		
		/**
		 * Authenticate.
		 *
		 * @param authenticate the authenticate
		 * @return the builder
		 */
		public Builder authenticate(Boolean authenticate) {
			this.authenticate = authenticate;
			return this;
		}
		
		/**
		 * Timewarp.
		 *
		 * @param timewarp the timewarp
		 * @return the builder
		 */
		public Builder timewarp(Boolean timewarp) {
			this.timewarp = timewarp;
			return this;
		}
		
		/**
		 * Auto tweet.
		 *
		 * @param auto_tweet the auto tweet
		 * @return the builder
		 */
		public Builder auto_tweet(Boolean auto_tweet) {
			this.auto_tweet = auto_tweet;
			return this;
		}
		
		/**
		 * Fb comments.
		 *
		 * @param fb_comments the fb comments
		 * @return the builder
		 */
		public Builder fb_comments(Boolean fb_comments) {
			this.fb_comments = fb_comments;
			return this;
		}
		
		/**
		 * Drag and drop.
		 *
		 * @param drag_and_drop the drag and drop
		 * @return the builder
		 */
		public Builder drag_and_drop(Boolean drag_and_drop) {
			this.drag_and_drop = drag_and_drop;
			return this;
		}
		
		/**
		 * Inline css.
		 *
		 * @param inline_css the inline css
		 * @return the builder
		 */
		public Builder inline_css(Boolean inline_css) {
			this.inline_css = inline_css;
			return this;
		}
		
		/**
		 * Folder id.
		 *
		 * @param folder_id the folder id
		 * @return the builder
		 */
		public Builder folder_id(String folder_id) {
			this.folder_id = folder_id;
			return this;
		}
		
		/**
		 * Connection.
		 *
		 * @param campaignId the campaign id
		 * @return the builder
		 */
		public Builder connection(String campaignId) {
			this.campaignId = campaignId;
			return this;
		}

		/**
		 * Connection.
		 *
		 * @param connection the connection
		 * @return the builder
		 */
		public Builder connection(MailChimpConnection connection) {
			this.connection = connection;
			return this;
		}

		
		/**
		 * Builds the.
		 *
		 * @return the campaign settings
		 */
		public CampaignSettings build() {
			try {
				return new CampaignSettings(this);
			} catch (CampaignSettingsException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
