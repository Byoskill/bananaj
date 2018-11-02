/**
 * @author alexanderweiss
 * @date 19.11.2015
 */
package com.github.alexanderwe.bananaj.model.template;

// TODO: Auto-generated Javadoc
/**
 * The Enum TemplateType.
 */
public enum TemplateType {


		/** The user. */
		USER("user"),/** The base. */
BASE("base"),/** The gallery. */
GALLERY("gallery");
		
		/** The string representation. */
		private String stringRepresentation;
		
		/**
		 * Instantiates a new template type.
		 *
		 * @param stringRepresentation the string representation
		 */
		TemplateType(String stringRepresentation ){
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
