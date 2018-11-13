package com.github.alexanderwe.bananaj.model.list.segment;

import javax.annotation.Nullable;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.exceptions.ConditionException;
import com.github.alexanderwe.bananaj.model.list.segment.StringCondition.Builder;

// TODO: Auto-generated Javadoc
/**
 * Segment option condition condition_type for "IPGeoIn".
 */
public class IPGeoInCondition implements AbstractCondition {

	/** The condition type. */
	private ConditionType condition_type;
    
    /** The op. */
    private Operator op;
    
    /** The field. */
    private String field;
    
    /** The lng. */
    private String lng;
    
    /** The lat. */
    private String lat;
    
    /** The value. */
    private Integer value;
    
    /** The addr. */
    private String addr;

    /**
     * Used when created a Condition locally with the Builder class.
     *
     * @param b the b
     * @throws ConditionException the condition exception
     * @see Builder
     */

    public IPGeoInCondition(Builder b) throws ConditionException {
        if (b.condition_type == null) {
            throw new ConditionException("A condition need a condition_type.");
        } else {
            this.condition_type = b.condition_type;
        }

        if (b.op == null) {
            throw new ConditionException("A condition need an operator.");
        } else {
        	this.op = b.op;
        }

        if (b.field == null) {
            throw new ConditionException("A condition need a field to operate on.");
        } else {
            this.field = b.field;
        }

        if (b.value == null) {
            throw new ConditionException("A condition need a value to compare on.");
        } else {
            this.value = b.value;
        }

    	this.lng = b.lng;
    	this.lat = b.lat;
    	this.addr = b.addr;
    }

	/**
	 * Gets the condition type.
	 *
	 * @return the condition type
	 */
	public ConditionType getConditionType() {
		return condition_type;
	}

    /**
     * Gets the field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Gets the op.
     *
     * @return the op
     */
    public Operator getOp() {
        return op;
    }

    /**
     * Gets the lng.
     *
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * Gets the addr.
	 *
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/* (non-Javadoc)
	 * @see com.github.alexanderwe.bananaj.model.list.segment.AbstractCondition#getJsonRepresentation()
	 */
	@Override
    public JSONObject getJsonRepresentation(){
        JSONObject condition = new JSONObject();
        condition.put("condition_type", getConditionType());
        condition.put("op", getOp().value());
        condition.put("field", getField());
        condition.put("value", getValue());

        return condition;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return "ConditionType: " + getConditionType() + System.lineSeparator() +
        		"Field: " + getField() + System.lineSeparator() +
                "Operator: " + getOp().value() +  System.lineSeparator() +
                "Lat: " + getLat() + System.lineSeparator() +
                "Lng: " + getLng() + System.lineSeparator() +
                "Value: " + getValue() + System.lineSeparator() +
                "Addr: " + getAddr() + System.lineSeparator();
    }

    /**
     * The Class Builder.
     */
    public static class Builder {
    	
	    /** The condition type. */
	    private ConditionType condition_type;
        
        /** The op. */
        private Operator op;
        
        /** The field. */
        private String field;
        
        /** The lng. */
        private String lng;
        
        /** The lat. */
        private String lat;
        
        /** The value. */
        private Integer value;
        
        /** The addr. */
        private String addr;

        /**
         * Condition type.
         *
         * @param condition_type the condition type
         * @return the builder
         */
        public Builder conditionType(ConditionType condition_type) {
            this.condition_type = condition_type;
            return this;
        }

        /**
         * Field.
         *
         * @param field the field
         * @return the builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }

        /**
         * Operator.
         *
         * @param op the op
         * @return the builder
         */
        public Builder operator(Operator op) {
            this.op = op;
            return this;
        }

        /**
         * Lng.
         *
         * @param lng the lng
         * @return the builder
         */
        public Builder lng(String lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Lat.
         *
         * @param lat the lat
         * @return the builder
         */
        public Builder lat(String lat) {
            this.lat = lat;
            return this;
        }

       /**
        * Value.
        *
        * @param value the value
        * @return the builder
        */
       public Builder value(Integer value) {
            this.value = value;
            return this;
        }

       /**
        * Addr.
        *
        * @param addr the addr
        * @return the builder
        */
       public Builder addr(String addr) {
           this.addr = addr;
           return this;
       }

        /**
         * Builds the.
         *
         * @return the IP geo in condition
         */
       @Nullable
        public IPGeoInCondition build() {
            try {
                return new IPGeoInCondition(this);
            } catch (ConditionException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
