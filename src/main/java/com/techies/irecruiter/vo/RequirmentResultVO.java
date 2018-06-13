package main.java.com.techies.irecruiter.vo;

import java.util.List;

public class RequirmentResultVO {

	int requirmentID;
	String jobTitle;
	String jobCategory;
	String jobDescription;
	int minExperience;
	int maxExperience;
	int providerID;
	List<String> skill;
	int locationID;
	String jobPlace;
	String jobDistrict;
	String jobState;
	String jobCountry;
	String PIN;
	int qualificationID;
	String qualification;
	String qualificationSpecilization;
	int skillID;
	String skillstr;
	
	
	
	public String getSkillstr() {
		return skillstr;
	}
	public void setSkillstr(String skillstr) {
		this.skillstr = skillstr;
	}
	public int getSkillID() {
		return skillID;
	}
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> string) {
		this.skill = string;
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
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getJobPlace() {
		return jobPlace;
	}
	public void setJobPlace(String jobPlace) {
		this.jobPlace = jobPlace;
	}
	public String getJobDistrict() {
		return jobDistrict;
	}
	public void setJobDistrict(String jobDistrict) {
		this.jobDistrict = jobDistrict;
	}
	public String getJobState() {
		return jobState;
	}
	public void setJobState(String jobState) {
		this.jobState = jobState;
	}
	public String getJobCountry() {
		return jobCountry;
	}
	public void setJobCountry(String jobCountry) {
		this.jobCountry = jobCountry;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public int getQualificationID() {
		return qualificationID;
	}
	public void setQualificationID(int qualificationID) {
		this.qualificationID = qualificationID;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getQualificationSpecilization() {
		return qualificationSpecilization;
	}
	public void setQualificationSpecilization(String qualificationSpecilization) {
		this.qualificationSpecilization = qualificationSpecilization;
	}
	
}
