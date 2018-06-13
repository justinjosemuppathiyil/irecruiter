package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_qualification")
public class JobSeekerQualification {
	@Id
	@Column(name="qualification_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sqID;
	@Column(name="seeker_id")
	int seekerID;
	@Column(name="qualification")
	String courseName;
	@Column(name="specilization")
	String specilization;
	@Column(name="year_of_pass")
	String passYear;
	@Column(name="institute")
	String institute;
	@Column(name="gpa")
	String gpa;
	
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public int getSqID() {
		return sqID;
	}
	public void setSqID(int sqID) {
		this.sqID = sqID;
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
