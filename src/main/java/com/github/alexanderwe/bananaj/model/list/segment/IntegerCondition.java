package com.github.alexanderwe.bananaj.model.list.segment;

import javax.annotation.Nullable;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.exceptions.ConditionException;
import com.github.alexanderwe.bananaj.model.list.segment.StringCondition.Builder;

// TODO: Auto-generated Javadoc
/**
 * Segment option condition condition_type uses an integer value.
 */
public class IntegerCondition implements AbstractCondition {

	/** The condition type. */
	private ConditionType condition_type;
    
    /** The field. */
    private String field;
    
    /** The operator. */
    private Operator operator;
    
    /** The extra. */
    private Integer extra;
    
    /** The value. */
    private Integer value;

    /**
     * Used when created a Condition locally with the Builder class.
     *
     * @param b the b
     * @throws ConditionException the condition exception
     * @see Builder
     */

    public IntegerCondition(Builder b) throws ConditionException {
        if (b.condition_type == null) {
            throw new ConditionException("A condition need a condition_type.");
        } else {
            this.condition_type = b.condition_type;
        }

        if (b.operator == null) {
            throw new ConditionException("A condition need an operator.");
        } else {
            this.operator = b.operator;
        }

        if (b.field == null) {
            throw new ConditionException("A condition need a field to operate on.");
        } else {
            this.field = b.field;
        }

        this.extra = b.extra;
        
        if (b.value == null) {
            throw new ConditionException("A condition need a value to compare on.");
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
        return operator;
    }

    /**
     * Gets the extra.
     *
     * @return the extra
     */
    public Integer getExtra() {
        return extra;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Integer getValue() {
        return value;
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
        if (getExtra() != null) {
        	condition.put("extra", getExtra());
        }
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
                getExtra() != null ? "Extra: " + getExtra() + System.lineSeparator() : "" +
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
        
        /** The extra. */
        private Integer extra;
        
        /** The value. */
        private Integer value;

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
         * Extra.
         *
         * @param extra the extra
         * @return the builder
         */
        public Builder extra(Integer extra) {
            this.extra = extra;
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
         * Builds the.
         *
         * @return the integer condition
         */
       @Nullable
        public IntegerCondition build() {
            try {
                return new IntegerCondition(this);
            } catch (ConditionException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
