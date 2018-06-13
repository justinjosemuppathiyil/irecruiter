package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_requirments")
public class Requirment {
		@Id
		@Column(name="requirment_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int requirmentID;
		@Column(name="provider_id")
		int providerID;
		@Column(name="job_title")
		String jobTitle;
		@Column(name="job_catogory")
		String jobCategory;
		@Column(name="job_description")
		String jobDescription;
		@Column(name="min_experience")
		int minExperience;
		@Column(name="max_experience")
		int maxExperience;
		
		public int getRequirmentID() {
			return requirmentID;
		}
		public void setRequirmentID(int requirmentID) {
			this.requirmentID = requirmentID;
		}
		public int getProviderID() {
			return providerID;
		}
		public void setProviderID(int providerID) {
			this.providerID = providerID;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public String getJobCategory() {
			return jobCategory;
		}
		public void setJobCategory(String jobCategory) {
			this.jobCategory = jobCategory;
		}
		public String getJobDescription() {
			return jobDescription;
		}
		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}
		public int getMinExperience() {
			return minExperience;
		}
		public void setMinExperience(int minExperience) {
			this.minExperience = minExperience;
		}
		public int getMaxExperience() {
			return maxExperience;
		}
		public void setMaxExperience(int maxExperience) {
			this.maxExperience = maxExperience;
		}
		

}
