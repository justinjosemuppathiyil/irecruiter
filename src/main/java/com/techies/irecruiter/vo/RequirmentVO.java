package main.java.com.techies.irecruiter.vo;

import java.util.List;

public class RequirmentVO {
	int requirmentID;
	String jobTitle;
	String jobCategory;
	String jobDescription;
	int minExperience;
	int maxExperience;
	int providerID;
	List<LocationVO> locationList;
	List <RequirmentQualificationVO> qualificationList;
	List<String> skillList;
	String actionType;
	
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public List<LocationVO> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<LocationVO> locationList) {
		this.locationList = locationList;
	}
	public List<RequirmentQualificationVO> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(List<RequirmentQualificationVO> qualificationList) {
		this.qualificationList = qualificationList;
	}
	public List<String> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<String> skillList) {
		this.skillList = skillList;
	}
	public int getRequirmentID() {
		return requirmentID;
	}
	public void setRequirmentID(int requirmentID) {
		this.requirmentID = requirmentID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getMinExperience() {
		return minExperience;
	}
	public void setMinExperience(int minExperience) {
		this.minExperience = minExperience;
	}
	public int getMaxExperience() {
		return maxExperience;
	}
	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	
	

}
