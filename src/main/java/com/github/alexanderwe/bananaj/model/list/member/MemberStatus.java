/**
 * @author alexanderweiss
 * @date 12.11.2015
 */
package com.github.alexanderwe.bananaj.model.list.member;

// TODO: Auto-generated Javadoc
/**
 * Possible status of a member of a list.
 *
 * @author alexanderweiss
 */
public enum MemberStatus {

    /** The pending. */
    PENDING("pending"),
    /** The subscribed. */
    SUBSCRIBED("subscribed"),
    /** The unsubscribed. */
    UNSUBSCRIBED("unsubscribed"),
    /** The cleaned. */
    CLEANED("cleaned"),
    /** The transactional. */
    TRANSACTIONAL("transactional");

    /** The string representation. */
    private String stringRepresentation;

    /**
     * Instantiates a new member status.
     *
     * @param stringRepresentation the string representation
     */
    MemberStatus(String stringRepresentation) {
        setStringRepresentation(stringRepresentation);
    }

    /**
     * Gets the string representation.
     *
     * @return the stringRepresentation
     */
    public String getStringRepresentation() {
        return stringRepresentation;
    }

    /**
     * Sets the string representation.
     *
     * @param stringRepresentation the stringRepresentation to set
     */
    private void setStringRepresentation(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

}
