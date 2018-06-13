package main.java.com.techies.irecruiter.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.techies.irecruiter.vo.OnlineTestVO;

public class OnlineTestStatusDO {
	
	long totalQuestions;
	long questionNo;
	Date startTime;
	Date endTime;
	long noOfPass;
	long noOfFail;
	long maxScore;
	long score;
	long noOfSkip;
	boolean isSkip;
	
	List<OnlineTestVO> skipedQuestionList = new ArrayList<OnlineTestVO>();
	 long skipQuesNo;
	 
	
	
	
	public long getSkipQuesNo() {
		return skipQuesNo;
	}
	public void setSkipQuesNo(long skipQuesNo) {
		this.skipQuesNo = skipQuesNo;
	}
	public boolean isSkip() {
		return isSkip;
	}
	public void setSkip(boolean isSkip) {
		this.isSkip = isSkip;
	}
	public List<OnlineTestVO> getSkipedQuestionList() {
		return skipedQuestionList;
	}
	public long getNoOfSkip() {
		return noOfSkip;
	}
	public void setNoOfSkip(long noOfSkip) {
		this.noOfSkip = noOfSkip;
	}
	public long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public long getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(long questionNo) {
		this.questionNo = questionNo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public long getNoOfPass() {
		return noOfPass;
	}
	public void setNoOfPass(long noOfPass) {
		this.noOfPass = noOfPass;
	}
	public long getNoOfFail() {
		return noOfFail;
	}
	public void setNoOfFail(long noOfFail) {
		this.noOfFail = noOfFail;
	}
	public long getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(long maxScore) {
		this.maxScore = maxScore;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	

}
