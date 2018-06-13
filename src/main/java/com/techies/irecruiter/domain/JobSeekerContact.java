package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_contact")
public class JobSeekerContact {
	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int contactID;
	
	@Column(name="seeker_id")
	int seekerID;
	@Column(name="seeker_registred_address")
	String seekerAddress;
	@Column(name="seeker_street")
	String seekerStreet;
	@Column(name="seeker_district")
	String seekerDistrict;
	@Column(name="seeker_state")
	String seekerState;
	@Column(name="seeker_country")
	String seekerCountry;
	@Column(name="seeker_pincode")
	String seekerPIN;
	@Column(name="seeker_email1")
	String seekerEmail1;
	@Column(name="seeker_email2")
	String seekerEmail2;
	@Column(name="seeker_phone1")
	String seekerPhone1;
	@Column(name="seeker_phone2")
	String seekerPhone2;
	
	
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public String getSeekerAddress() {
		return seekerAddress;
	}
	public void setSeekerAddress(String seekerAddress) {
		this.seekerAddress = seekerAddress;
	}
	public String getSeekerStreet() {
		return seekerStreet;
	}
	public void setSeekerStreet(String seekerStreet) {
		this.seekerStreet = seekerStreet;
	}
	public String getSeekerDistrict() {
		return seekerDistrict;
	}
	public void setSeekerDistrict(String seekerDistrict) {
		this.seekerDistrict = seekerDistrict;
	}
	public String getSeekerState() {
		return seekerState;
	}
	public void setSeekerState(String seekerState) {
		this.seekerState = seekerState;
	}
	public String getSeekerCountry() {
		return seekerCountry;
	}
	public void setSeekerCountry(String seekerCountry) {
		this.seekerCountry = seekerCountry;
	}
	public String getSeekerPIN() {
		return seekerPIN;
	}
	public void setSeekerPIN(String seekerPIN) {
		this.seekerPIN = seekerPIN;
	}
	public String getSeekerEmail1() {
		return seekerEmail1;
	}
	public void setSeekerEmail1(String seekerEmail1) {
		this.seekerEmail1 = seekerEmail1;
	}
	public String getSeekerEmail2() {
		return seekerEmail2;
	}
	public void setSeekerEmail2(String seekerEmail2) {
		this.seekerEmail2 = seekerEmail2;
	}
	public String getSeekerPhone1() {
		return seekerPhone1;
	}
	public void setSeekerPhone1(String seekerPhone1) {
		this.seekerPhone1 = seekerPhone1;
	}
	public String getSeekerPhone2() {
		return seekerPhone2;
	}
	public void setSeekerPhone2(String seekerPhone2) {
		this.seekerPhone2 = seekerPhone2;
	}
	

}
