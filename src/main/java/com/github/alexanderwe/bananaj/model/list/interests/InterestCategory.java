package com.github.alexanderwe.bananaj.model.list.interests;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.model.MailchimpObject;

// TODO: Auto-generated Javadoc
/**
 * The Class InterestCategory.
 */
public class InterestCategory extends MailchimpObject {
    
    /** The list id. */
    private String list_id;
    
    /** The title. */
    private String title;
    
    /** The display order. */
    private Integer display_order;
    
    /** The type. */
    private InterestCategoryType type;
    
    /** The connection. */
    private MailChimpConnection connection;

	/**
	 * Instantiates a new interest category.
	 *
	 * @param id the id
	 * @param list_id the list id
	 * @param title the title
	 * @param display_order the display order
	 * @param type the type
	 * @param connection the connection
	 * @param jsonRepresentation the json representation
	 */
	public InterestCategory(String id, String list_id, String title, Integer display_order,
			InterestCategoryType type, MailChimpConnection connection, JSONObject jsonRepresentation) {
		super(id, jsonRepresentation);
		this.list_id = list_id;
		this.title = title;
		this.display_order = display_order;
		this.type = type;
		this.connection = connection;
	}

    /**
     * Used when created a Segment locally with the Builder class.
     *
     * @param b the b
     * @see Builder
     */
    public InterestCategory(Builder b) {
		super(b.id, b.jsonRepresentation);
		this.list_id = b.list_id;
		this.title = b.title;
		this.display_order = b.display_order;
		this.type = b.type;
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the display order.
	 *
	 * @return the display order
	 */
	public Integer getDisplay_order() {
		return display_order;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public InterestCategoryType getType() {
		return type;
	}

	/**
	 * Builds the.
	 *
	 * @param connection the connection
	 * @param jsonRepresentation the json representation
	 * @return the interest category
	 */
	public static InterestCategory build(MailChimpConnection connection, JSONObject jsonRepresentation) {
		String id = jsonRepresentation.getString("id");
		String list_id = jsonRepresentation.getString("list_id");
		String title = jsonRepresentation.getString("title");
		Integer display_order = jsonRepresentation.getInt("display_order");
		InterestCategoryType type = InterestCategoryType.fromValue(jsonRepresentation.getString("type"));
		return new InterestCategory(id, list_id, title, display_order, type, connection, jsonRepresentation);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString(){
        return  "ID: " + this.getId() +  System.lineSeparator() +
                "Title: " + this.getTitle() +  System.lineSeparator() +
                "Type: " + this.getType() + System.lineSeparator() +
                "List ID: " + this.getList_id() + System.lineSeparator() +
                "Display Order: " +  this.getDisplay_order() + System.lineSeparator();
    }
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
	    
    	/** The list id. */
    	private String list_id;
	    
    	/** The id. */
    	private String id;
	    
    	/** The title. */
    	private String title;
	    
    	/** The display order. */
    	private Integer display_order;
	    
    	/** The type. */
    	private InterestCategoryType type;
        
        /** The json representation. */
        private JSONObject jsonRepresentation = new JSONObject();
		
        /**
         * List id.
         *
         * @param s the s
         * @return the builder
         */
        public Builder list_id(String s) {
            this.list_id = s;
            jsonRepresentation.put("list_id", s);
            return this;
        }
        
        /**
         * Id.
         *
         * @param s the s
         * @return the builder
         */
        public Builder id(String s) {
            this.id = s;
            jsonRepresentation.put("id", s);
            return this;
        }

        /**
         * Title.
         *
         * @param s the s
         * @return the builder
         */
        public Builder title(String s) {
            this.title = s;
            jsonRepresentation.put("title", s);
            return this;
        }
        
        /**
         * Display order.
         *
         * @param i the i
         * @return the builder
         */
        public Builder display_order(int i) {
            this.display_order = new Integer(i);
            jsonRepresentation.put("display_order", i);
            return this;
        }
        
        /**
         * Type.
         *
         * @param type the type
         * @return the builder
         */
        public Builder type(InterestCategoryType type) {
            this.type = type;
            jsonRepresentation.put("type", type.value());
            return this;
        }

        /**
         * Type.
         *
         * @param type the type
         * @return the builder
         */
        public Builder type(String type) {
            this.type = InterestCategoryType.fromValue(type);
            jsonRepresentation.put("type", this.type.value());
            return this;
        }
        
        /**
         * Builds the.
         *
         * @return the interest category
         */
        public InterestCategory build() {
            return new InterestCategory(this);
        }
	}
}
