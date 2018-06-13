package main.java.com.techies.irecruiter.vo;

public class LocationVO {
	int locationID;
	String jobPlace;
	String jobDistrict;
	String jobState;
	String jobCountry;
	String PIN;
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
	

}
