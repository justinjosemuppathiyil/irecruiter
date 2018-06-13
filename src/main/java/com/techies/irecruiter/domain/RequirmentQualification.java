package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_requirments_qualification")
public class RequirmentQualification {
	@Id
	@Column(name="qualification_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int qualificationID;
	@Column(name="requirment_id")
	int requirmentID;
	@Column(name="qualification")
	String qualification;
	@Column(name="specilization")
	String qualificationSpecilization;
	@Column(name="provider_id")
	int providerID;
	
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public int getQualificationID() {
		return qualificationID;
	}
	public void setQualificationID(int qualificationID) {
		this.qualificationID = qualificationID;
	}
	public int getRequirmentID() {
		return requirmentID;
	}
	public void setRequirmentID(int requirmentID) {
		this.requirmentID = requirmentID;
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
