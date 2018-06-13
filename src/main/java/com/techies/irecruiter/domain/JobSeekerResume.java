package main.java.com.techies.irecruiter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_resume")
public class JobSeekerResume {
	@Id
	@Column(name="resume_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int resumeID;
	@Column(name="seeker_id")
	int seekerID;
	@Column(name="content")
	byte[] content;
	@Column(name="filename")
	String filename;
	@Column(name="content_type")
	String contentType;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getResumeID() {
		return resumeID;
	}
	public void setResumeID(int resumeID) {
		this.resumeID = resumeID;
	}
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
	

}
