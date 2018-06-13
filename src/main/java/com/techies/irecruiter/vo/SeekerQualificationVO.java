package main.java.com.techies.irecruiter.vo;

import java.util.List;

public class SeekerQualificationVO {
	int sqID;
	int seekerID;
	String courseName;
	String specilization;
	String passYear;
	String institute;
	String gpa;
	String actionType;
	List<String> skill;
	int skillID;
	int experienceID;
	String experience;
	/*String skill1;
	String skill2;
	String skill3;
	

	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}*/
	public int getExperienceID() {
		return experienceID;
	}
	public void setExperienceID(int experienceID) {
		this.experienceID = experienceID;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
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
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public int getSqID() {
		return sqID;
	}
	public void setSqID(int sqID) {
		this.sqID = sqID;
	}
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	public String getPassYear() {
		return passYear;
	}
	public void setPassYear(String passYear) {
		this.passYear = passYear;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
}
