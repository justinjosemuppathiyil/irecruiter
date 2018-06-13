package main.java.com.techies.irecruiter.dataobject;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequirementResultDO {
	@Id
	@Column(name="requirment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int requirmentID;
	@Column(name="job_title")
	String jobTitle;
	@Column(name="job_catogory")
	String jobCategory;
	@Column(name="job_description")
	String jobDescription;
	@Column(name="min_experience")
	int minExperience;
	@Column(name="max_experience")
	int maxExperience;
	@Column(name="provider_id")
	int providerID;
	@Column(name="skill")
	String skill;
	@Column(name="place")
	String jobPlace;
	@Column(name="district")
	String jobDistrict;
	@Column(name="state")
	String jobState;
	@Column(name="country")
	String jobCountry;
	@Column(name="PIN")
	String PIN;
	@Column(name="qualification")
	String qualification;
	@Column(name="specilization")
	String qualificationSpecilization;
	
	
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
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
