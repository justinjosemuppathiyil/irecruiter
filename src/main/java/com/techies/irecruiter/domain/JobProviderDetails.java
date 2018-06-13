package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_provider_details")
public class JobProviderDetails {
	@Id
	@Column(name="provider_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int providerID;
	@Column(name="provider_name")
	String name;
	@Column(name="provider_country")
	String country;
	@Column(name="provider_website")
	String websiteaddr;
	@Column(name="user_id")
	String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebsiteaddr() {
		return websiteaddr;
	}
	public void setWebsiteaddr(String websiteaddr) {
		this.websiteaddr = websiteaddr;
	}

}
