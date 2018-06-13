package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_requirments_skillset")
public class RequirmentSkillset {
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int skillID;
	@Column(name="requirment_id")
	int requirmentID;
	@Column(name="skill")
	String skillList;
	@Column(name="provider_id")
	int providerID;
	
	
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public int getSkillID() {
		return skillID;
	}
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	public int getRequirmentID() {
		return requirmentID;
	}
	public void setRequirmentID(int requirmentID) {
		this.requirmentID = requirmentID;
	}
	public String getSkillList() {
		return skillList;
	}
	public void setSkillList(String skillList) {
		this.skillList = skillList;
	}
	

}
