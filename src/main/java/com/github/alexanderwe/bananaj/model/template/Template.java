/**
 * @author alexanderweiss
 * @date 19.11.2015
 */
package com.github.alexanderwe.bananaj.model.template;

import java.net.URL;
import java.time.LocalDateTime;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.utils.DateConverter;

/**
 * The Class Template.
 */
public class Template extends MailchimpObject  {

	/** The template name. */
	private String templateName;
	
	/** The template type. */
	private TemplateType templateType;
	
	/** The share url. */
	private String shareUrl;
	
	/** The date created. */
	private LocalDateTime dateCreated;
	
	/** The folder id. */
	private String folder_id;
	
	/** The connection. */
	private MailChimpConnection connection;
	
	/** The html. */
	private String html;
	
	/**
	 * Instantiates a new template.
	 *
	 * @param id the id
	 * @param templateName the template name
	 * @param templateType the template type
	 * @param shareUrl the share url
	 * @param dateCreated the date created
	 * @param folderId the folder id
	 * @param connection the connection
	 * @param jsonRepresentation the json representation
	 */
	public Template(int id, String templateName, TemplateType templateType, String shareUrl, LocalDateTime dateCreated, String folderId, MailChimpConnection connection, JSONObject jsonRepresentation) {
		super(String.valueOf(id),jsonRepresentation);
		this.templateName = templateName;
		this.templateType = templateType;
		this.shareUrl = shareUrl;
		this.dateCreated = dateCreated;
		this.folder_id = folderId;
		this.connection = connection;
	}

	/**
	 * Instantiates a new template.
	 *
	 * @param connection the connection
	 * @param jsonTemplate the json template
	 */
	public Template(MailChimpConnection connection, JSONObject jsonTemplate) {
		super(String.valueOf(jsonTemplate.getInt("id")), jsonTemplate);
		this.templateName = jsonTemplate.getString("name");
		this.templateType = TemplateType.valueOf(jsonTemplate.getString("type").toUpperCase());
		this.shareUrl = jsonTemplate.getString("share_url");
		this.dateCreated = DateConverter.getInstance().createDateFromISO8601(jsonTemplate.getString("date_created"));
		this.folder_id = jsonTemplate.has("folder_id") ? jsonTemplate.getString("folder_id") : null;
		this.connection = connection;
	}
	
	/**
	 * Instantiates a new template.
	 *
	 * @param b the b
	 */
	public Template(Builder b){
		this.templateName = b.templateName;
		this.folder_id = b.folder_id;
		this.html = b.html;
	}


	/**
	 * Change the name of this template.
	 *
	 * @param name the name
	 * @throws Exception the exception
	 */
	public void changeName(String name) throws Exception{
		JSONObject changedTemplate = new JSONObject();
		changedTemplate.put("name",name);
		this.getConnection().do_Patch(new URL(this.getConnection().getTemplateendpoint()+"/"+this.getId()), changedTemplate.toString(),this.getConnection().getApikey() );
		this.templateName = name;
	}

	/**
	 * Change the html content of this template.
	 *
	 * @param html the html
	 * @throws Exception the exception
	 */
	public void changeHTML(String html) throws Exception{
		JSONObject changedTemplate = new JSONObject();
		changedTemplate.put("html",html);
		this.getConnection().do_Patch(new URL(this.getConnection().getTemplateendpoint()+"/"+this.getId()), changedTemplate.toString(),this.getConnection().getApikey() );
	}

	/**
	 * Change the folder of this template.
	 *
	 * @param folder_id the folder id
	 * @throws Exception the exception
	 */
	public void changeFolder(String folder_id) throws Exception{
		JSONObject changedTemplate = new JSONObject();
		changedTemplate.put("folder_id",folder_id);
		this.getConnection().do_Patch(new URL(this.getConnection().getTemplateendpoint()+"/"+this.getId()), changedTemplate.toString(),this.getConnection().getApikey() );
		this.folder_id = folder_id;
	}

	/**
	 * Overwrite this template with a new one
	 * Sets new name, content, and folder.
	 *
	 * @param template the template
	 * @throws Exception the exception
	 */
	public void overwrite(Template template) throws Exception{
		JSONObject changedTemplate = new JSONObject();
		changedTemplate.put("name",template.getTemplateName() != null ? template.getTemplateName(): "");
		changedTemplate.put("folder_id",template.getFolder_id() != null ? template.getFolder_id() : "");
		changedTemplate.put("html",template.getHtml() != null ? template.getHtml(): "");
		this.getConnection().do_Patch(new URL(this.getConnection().getTemplateendpoint()+"/"+this.getId()), changedTemplate.toString(),this.getConnection().getApikey() );
		this.templateName = template.getTemplateName();
		this.folder_id = template.getFolder_id();
		this.html = template.getHtml();
	}

	/**
	 * Gets the template type.
	 *
	 * @return the templateType
	 */
	public TemplateType getTemplateType() {
		return templateType;
	}

	/**
	 * Gets the template name.
	 *
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * Gets the share url.
	 *
	 * @return the shareUrl
	 */
	public String getShareUrl() {
		return shareUrl;
	}

	/**
	 * Gets the date created.
	 *
	 * @return the dateCreated
	 */
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * Gets the folder id.
	 *
	 * @return the folder ID the template is currently in
	 */
	public String getFolder_id() {
		return folder_id;
	}

	/**
	 * Gets the html.
	 *
	 * @return the html content of this template. Is not set, when template is received from MailChimp servers
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the com.github.alexanderwe.bananaj.connection to MailChimp
	 */
	public MailChimpConnection getConnection() {
		return connection;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Name: " + this.getId() + "-" + this.getTemplateName() + System.lineSeparator() +
				"Type: " + this.getTemplateType().getStringRepresentation() + System.lineSeparator() +
				"Share url: "+  this.getShareUrl() +  System.lineSeparator()+
				"Date created: " + this.getDateCreated() + System.lineSeparator();
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The template name. */
		private String templateName;
		
		/** The folder id. */
		private String folder_id;
		
		/** The html. */
		private String html;

		/**
		 * With name.
		 *
		 * @param name the name
		 * @return the template. builder
		 */
		public Template.Builder withName(String name) {
			this.templateName = name;
			return this;
		}

		/**
		 * In folder.
		 *
		 * @param folder_id the folder id
		 * @return the template. builder
		 */
		public Template.Builder inFolder(String folder_id) {
			this.folder_id = folder_id;
			return this;
		}

		/**
		 * With HTML.
		 *
		 * @param html the html
		 * @return the template. builder
		 */
		public Template.Builder withHTML(String html) {
			this.html = html;
			return this;
		}


		/**
		 * Builds the.
		 *
		 * @return the template
		 */
		public Template build() {
			return new Template(this);
		}
	}
}
