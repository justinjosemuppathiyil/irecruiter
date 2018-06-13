package main.java.com.techies.irecruiter.vo;

public class RequirmentQualificationVO {
	int qualificationID;
	String qualification;
	String qualificationSpecilization;
	int requirmentID;
	int providerID;
	
	
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public int getRequirmentID() {
		return requirmentID;
	}
	public void setRequirmentID(int requirmentID) {
		this.requirmentID = requirmentID;
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
