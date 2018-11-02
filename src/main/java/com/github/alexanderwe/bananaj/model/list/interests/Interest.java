package com.github.alexanderwe.bananaj.model.list.interests;

import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Interest.
 */
public class Interest {
	
	/** The category id. */
	private String category_id;
    
    /** The list id. */
    private String list_id;
    
    /** The id. */
    private String id;
    
    /** The name. */
    private String name;
    
    /** The subscriber count. */
    private String subscriber_count;
    
    /** The display order. */
    private Integer display_order;

	/**
	 * Instantiates a new interest.
	 *
	 * @param id the id
	 * @param list_id the list id
	 * @param category_id the category id
	 * @param name the name
	 * @param subscriber_count the subscriber count
	 * @param display_order the display order
	 */
	public Interest(String id, String list_id, String category_id, String name, String subscriber_count, Integer display_order) {
		this.category_id = category_id;
		this.list_id = list_id;
		this.id = id;
		this.name = name;
		this.subscriber_count = subscriber_count;
		this.display_order = display_order;
	}

    /**
     * Used when created a Segment locally with the Builder class.
     *
     * @param b the b
     * @see Builder
     */
    public Interest(Builder b) {
		this.category_id = b.category_id;
		this.list_id = b.list_id;
		this.id = b.id;
		this.name = b.name;
		this.subscriber_count = b.subscriber_count;
		this.display_order = b.display_order;
    }
    

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategory_id() {
		return category_id;
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
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
	 * Gets the subscriber count.
	 *
	 * @return the subscriber count
	 */
	public String getSubscriber_count() {
		return subscriber_count;
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
	 * Builds the.
	 *
	 * @param jsonRepresentation the json representation
	 * @return the interest
	 */
	public static Interest build(JSONObject jsonRepresentation) {
		String id = jsonRepresentation.getString("id");
		String list_id = jsonRepresentation.getString("list_id");
		String category_id = jsonRepresentation.getString("category_id");
		String name = jsonRepresentation.getString("name");
		String subscriber_count = jsonRepresentation.getString("subscriber_count");
		Integer display_order = jsonRepresentation.getInt("display_order");
		return new Interest(id, list_id, category_id, name, subscriber_count, display_order);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString(){
        return  "ID: " + this.getId() +  System.lineSeparator() +
                "List ID: " + this.getList_id() + System.lineSeparator() +
                "Category Id: " + this.getCategory_id() + System.lineSeparator() +
                "Name: " + this.getName() +  System.lineSeparator() +
                "Subscriber Count: " + this.getSubscriber_count() + System.lineSeparator() +
                "Display Order: " +  this.getDisplay_order() + System.lineSeparator();
    }
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The category id. */
		private String category_id;
	    
    	/** The list id. */
    	private String list_id;
	    
    	/** The id. */
    	private String id;
	    
    	/** The name. */
    	private String name;
	    
    	/** The subscriber count. */
    	private String subscriber_count;
	    
    	/** The display order. */
    	private Integer display_order;
		
        /**
         * Category id.
         *
         * @param s the s
         * @return the builder
         */
        public Builder category_id(String s) {
            this.category_id = s;
            return this;
        }
        
        /**
         * List id.
         *
         * @param s the s
         * @return the builder
         */
        public Builder list_id(String s) {
            this.list_id = s;
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
            return this;
        }

        /**
         * Name.
         *
         * @param s the s
         * @return the builder
         */
        public Builder name(String s) {
            this.name = s;
            return this;
        }
        
        /**
         * Subscriber count.
         *
         * @param s the s
         * @return the builder
         */
        public Builder subscriber_count(String s) {
            this.subscriber_count = s;
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
            return this;
        }

        /**
         * Builds the.
         *
         * @return the interest
         */
        public Interest build() {
            return new Interest(this);
        }
	}
}
