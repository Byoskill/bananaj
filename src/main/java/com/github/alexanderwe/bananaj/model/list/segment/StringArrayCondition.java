package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.alexanderwe.bananaj.exceptions.ConditionException;
import com.github.alexanderwe.bananaj.model.list.segment.StringCondition.Builder;

// TODO: Auto-generated Javadoc
/**
 * Segment option condition condition_type uses a String array value.
 */
public class StringArrayCondition implements AbstractCondition {

	/** The condition type. */
	private ConditionType condition_type;
    
    /** The field. */
    private String field;
    
    /** The op. */
    private Operator op;
    
    /** The value. */
    private List<String> value = new ArrayList<String>();

    /**
     * Used when created a Condition locally with the Builder class.
     *
     * @param b the b
     * @throws ConditionException the condition exception
     * @see Builder
     */

    public StringArrayCondition(Builder b) throws ConditionException {
        if (b.condition_type == null) {
            throw new ConditionException("A condition need a condition_type.");
        } else {
            this.condition_type = b.condition_type;
        }

        if (b.operator == null) {
            throw new ConditionException("A condition need an operator.");
        } else {
            this.op = b.operator;
        }

        if (b.field == null) {
            throw new ConditionException("A condition need a field to operate on.");
        } else {
            this.field = b.field;
        }

        if (b.value == null || b.value.size() < 1) {
            throw new ConditionException("A condition need a value array to compare on.");
        } else {
            this.value = b.value;
        }
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
     * Gets the value.
     *
     * @return the value
     */
    public List<String> getValue() {
        return value;
    }

    /* (non-Javadoc)
     * @see com.github.alexanderwe.bananaj.model.list.segment.AbstractCondition#getJsonRepresentation()
     */
    @Override
    public JSONObject getJsonRepresentation(){
        JSONObject condition = new JSONObject();
        JSONArray valuearray = new JSONArray();
        
        Iterator<String> v = value.iterator();
        while (v.hasNext()) {
        	valuearray.put(v.next());
        }
        
        condition.put("condition_type", getConditionType());
        condition.put("op", getOp().value());
        condition.put("field", getField());
        condition.put("value", valuearray);

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
                "Value: " + getValue() + System.lineSeparator();
    }

    /**
     * The Class Builder.
     */
    public static class Builder {
    	
	    /** The condition type. */
	    private ConditionType condition_type;
        
        /** The field. */
        private String field;
        
        /** The operator. */
        private Operator operator;
        
        /** The value. */
        private List<String> value = new ArrayList<String>();

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
            this.operator = op;
            return this;
        }

        /**
         * Value.
         *
         * @param value the value
         * @return the builder
         */
        public Builder value(List<String> value) {
            this.value = value;
            return this;
        }

        /**
         * Builds the.
         *
         * @return the string array condition
         */
        public StringArrayCondition build() {
            try {
                return new StringArrayCondition(this);
            } catch (ConditionException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
