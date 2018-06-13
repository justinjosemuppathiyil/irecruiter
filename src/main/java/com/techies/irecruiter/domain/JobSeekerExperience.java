package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_experience")
public class JobSeekerExperience {
	@Id
	@Column(name="experience_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int experienceID;
	@Column(name="seeker_id")
	int seekerID;
	@Column(name="experience")
	String experience;
	public int getExperienceID() {
		return experienceID;
	}
	public void setExperienceID(int experienceID) {
		this.experienceID = experienceID;
	}
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	

}
