package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_requirments_location")
public class RequirmentLocation {
	@Id
	@Column(name="location_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int locationID;
	@Column(name="requirment_id")
	int requirmentID;
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
	@Column(name="provider_id")
	int providerID;
	
	
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public int getRequirmentID() {
		return requirmentID;
	}
	public void setRequirmentID(int requirmentID) {
		this.requirmentID = requirmentID;
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
	
	

}
