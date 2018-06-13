package main.java.com.techies.irecruiter.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_details")
public class JobSeekerDetails {
	@Id
	@Column(name="seeker_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int seekerID;
	@Column(name="seeker_name")
	String seekerName;
	@Column(name="seeker_bod")
	Date seekerDOB;
	@Column(name="seeker_gender")
	String seekerGender;
	@Column(name="user_id")
	String username;
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public String getSeekerName() {
		return seekerName;
	}
	public void setSeekerName(String seekerName) {
		this.seekerName = seekerName;
	}
	public Date getSeekerDOB() {
		return seekerDOB;
	}
	public void setSeekerDOB(Date seekerDOB) {
		this.seekerDOB = seekerDOB;
	}
	public String getSeekerGender() {
		return seekerGender;
	}
	public void setSeekerGender(String seekerGender) {
		this.seekerGender = seekerGender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
