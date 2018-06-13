package main.java.com.techies.irecruiter.vo;

import java.io.InputStream;

public class JobSeekerResumeVO {
	int seekerID;
	int resumeID;
	String contentType;
	InputStream content;
	String filename;
	String actionType;
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public int getSeekerID() {
		return seekerID;
	}
	public void setSeekerID(int seekerID) {
		this.seekerID = seekerID;
	}
	public int getResumeID() {
		return resumeID;
	}
	public void setResumeID(int resumeID) {
		this.resumeID = resumeID;
	}
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public InputStream getContent() {
		return content;
	}
	public void setContent(InputStream content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
