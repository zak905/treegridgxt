package com.opencode.components;

public class Concept {
	
	private String conceptName;
	private String conceptType;
	private String conceptOwner;
	
	
	
	public Concept(String conceptName, String conceptType, String conceptOwner){
		this.conceptName = conceptName;
		this.conceptType = conceptType;
		this.conceptOwner = conceptOwner;
	}
	/**
	 * @return the conceptName
	 */
	public String getConceptName() {
		return conceptName;
	}
	/**
	 * @param conceptName the conceptName to set
	 */
	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	/**
	 * @return the conceptType
	 */
	public String getConceptType() {
		return conceptType;
	}
	/**
	 * @param conceptType the conceptType to set
	 */
	public void setConceptType(String conceptType) {
		this.conceptType = conceptType;
	}
	/**
	 * @return the conceptOwner
	 */
	public String getConceptOwner() {
		return conceptOwner;
	}
	/**
	 * @param conceptOwner the conceptOwner to set
	 */
	public void setConceptOwner(String conceptOwner) {
		this.conceptOwner = conceptOwner;
	} 

}
