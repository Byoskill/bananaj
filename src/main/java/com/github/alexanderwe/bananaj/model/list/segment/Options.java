package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 04.02.16.
 */
public class Options {

    /** The match type. */
    private MatchType matchType;
    
    /** The conditions. */
    private List<AbstractCondition> conditions;


    /**
     * Instantiates a new options.
     */
    public Options(){

    }

    /**
     * Instantiates a new options.
     *
     * @param matchType the match type
     * @param conditions the conditions
     */
    public Options (MatchType matchType, ArrayList<AbstractCondition> conditions){
        setMatchType(matchType);
        setConditions(conditions);
    }


    /**
     * Adds the condition.
     *
     * @param condition the condition
     */
    public void addCondition(AbstractCondition condition){
        this.conditions.add(condition);
    }

    /**
     * Gets the match type.
     *
     * @return the match type
     */
    public MatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the match type.
     *
     * @param matchType the new match type
     */
    public final void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    /**
     * Gets the conditions.
     *
     * @return the conditions
     */
    public List<AbstractCondition> getConditions() {
        return conditions;
    }

    /**
     * Sets the conditions.
     *
     * @param conditions the new conditions
     */
    public final void setConditions(ArrayList<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Gets the json representation.
     *
     * @return the json representation
     */
    public JSONObject getJsonRepresentation(){
        JSONObject options = new JSONObject();
        options.put("match", this.getMatchType().value());

        JSONArray conditions = new JSONArray();

        for(AbstractCondition condition: this.getConditions()){
            conditions.put(condition.getJsonRepresentation());
        }

        options.put("conditions",conditions);
        System.out.println(options);
        return options;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return "Match type: " + this.getMatchType().value() +  System.lineSeparator() +
                "Conditions: " + this.getConditions() + System.lineSeparator();
    }


}
