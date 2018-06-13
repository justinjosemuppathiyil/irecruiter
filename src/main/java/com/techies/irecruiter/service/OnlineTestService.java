package main.java.com.techies.irecruiter.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.techies.irecruiter.dataaccess.OnlineTestDAO;
import main.java.com.techies.irecruiter.dataobject.QuestionsDO;
import main.java.com.techies.irecruiter.domain.JobSeekerContact;
import main.java.com.techies.irecruiter.domain.OnlineTestOption;
import main.java.com.techies.irecruiter.domain.OnlineTestQuestion;
import main.java.com.techies.irecruiter.vo.OnlineTestVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineTestService {
	@Autowired
	OnlineTestDAO onlineTestDAO;

	public List<OnlineTestVO> submitQuestion(OnlineTestVO onlineTestVO) {
		
		System.out.println("reached submitQuestion @ controller");
		
		OnlineTestQuestion onlineTestQuestion = convertVOToQuestion(onlineTestVO);
		int questionID = onlineTestDAO.submitOnlineTestQuestion(onlineTestQuestion);
		onlineTestVO.setQuestionID(questionID);
		OnlineTestOption onlineTestOption = convertVOToOptions(onlineTestVO);
		onlineTestDAO.submitOnlineTestOptions(onlineTestOption);
		
		List<QuestionsDO>questionList = onlineTestDAO.getAllQuestions(onlineTestVO.getProviderID());
		List<OnlineTestVO> questionVoList = convertQuestionsDOToVo(questionList);
		
		return questionVoList;
		
	}

	private List<OnlineTestVO> convertQuestionsDOToVo(List<QuestionsDO> questionList) {
		System.out.println("reached convertQuestionsDOToVo");
		
		List<OnlineTestVO> questionVoList = new ArrayList<OnlineTestVO>();
		for(QuestionsDO questionsDO:questionList){
			OnlineTestVO onlineTestVO = new OnlineTestVO();
			onlineTestVO.setProviderID(questionsDO.getProviderID());
			onlineTestVO.setQuestionID(questionsDO.getQuestionID());
			onlineTestVO.setQuestion(questionsDO.getQuestion());
			onlineTestVO.setOption1(questionsDO.getOption1());
			onlineTestVO.setOption2(questionsDO.getOption2());
			onlineTestVO.setOption3(questionsDO.getOption3());
			onlineTestVO.setOption4(questionsDO.getOption4());
			onlineTestVO.setAnswer(questionsDO.getAnswer());
			questionVoList.add(onlineTestVO);
		}
		return questionVoList;
	}

	private OnlineTestOption convertVOToOptions(OnlineTestVO onlineTestVO) {
		System.out.println("reached convertVOToOptions");
		
		OnlineTestOption onlineTestOption = new OnlineTestOption();
		
		onlineTestOption.setQuestionID(onlineTestVO.getQuestionID());
		onlineTestOption.setOption1(onlineTestVO.getOption1());
		onlineTestOption.setOption2(onlineTestVO.getOption2());
		onlineTestOption.setOption3(onlineTestVO.getOption3());
		onlineTestOption.setOption4(onlineTestVO.getOption4());
		onlineTestOption.setAnswer(onlineTestVO.getAnswer());
		
		return onlineTestOption;
	}

	private OnlineTestQuestion convertVOToQuestion(OnlineTestVO onlineTestVO) {
		System.out.println("reached convertVOToQuestion");
		
		OnlineTestQuestion onlineTestQuestion = new OnlineTestQuestion();
		
		onlineTestQuestion.setProviderID(onlineTestVO.getProviderID());
		onlineTestQuestion.setQuestion(onlineTestVO.getQuestion());
		onlineTestQuestion.setQuestionID(onlineTestVO.getQuestionID());
		
		return onlineTestQuestion;
	}

	public OnlineTestVO getQuestion(Integer queId) {
		QuestionsDO questionsDO = onlineTestDAO.getQuestion(queId);
		OnlineTestVO onlineTestVO = convertToOnlineTestVO(questionsDO);
		return onlineTestVO;
	}

	private OnlineTestVO convertToOnlineTestVO(QuestionsDO questionsDO) {
		OnlineTestVO onlineTestVO = new OnlineTestVO();
		onlineTestVO.setProviderID(questionsDO.getProviderID());
		onlineTestVO.setQuestionID(questionsDO.getQuestionID());
		onlineTestVO.setQuestion(questionsDO.getQuestion());
		onlineTestVO.setOption1(questionsDO.getOption1());
		onlineTestVO.setOption2(questionsDO.getOption2());
		onlineTestVO.setOption3(questionsDO.getOption3());
		onlineTestVO.setOption4(questionsDO.getOption4());
		onlineTestVO.setAnswer(questionsDO.getAnswer());
		return onlineTestVO;
	}

	public List<OnlineTestVO> updateQuestion(OnlineTestVO onlineTestVO) {
		OnlineTestQuestion onlineTestQuestion = convertVOToQuestion(onlineTestVO);
		 onlineTestDAO.updateOnlineTestQuestion(onlineTestQuestion);
		
		OnlineTestOption onlineTestOption = convertVOToOptions(onlineTestVO);
		onlineTestDAO.updateOnlineTestOptions(onlineTestOption);
		
		List<QuestionsDO>questionList = onlineTestDAO.getAllQuestions(onlineTestVO.getProviderID());
		List<OnlineTestVO> questionVoList = convertQuestionsDOToVo(questionList);
		
		return questionVoList;
	}

	public List<OnlineTestVO> getAllQuestions(int id) {
		List<QuestionsDO>questionList = onlineTestDAO.getAllQuestions(id);
		List<OnlineTestVO> questionVoList = convertQuestionsDOToVo(questionList);
		
		return questionVoList;
	}

	public void deleteQuestion(Integer queId) {
		onlineTestDAO.deleteOptions(queId);
		onlineTestDAO.deleteQuestion(queId);

	}

	public List<OnlineTestVO> getOnlineTestQuestions(Integer providerId) {
		List<QuestionsDO>questionList = onlineTestDAO.getOnlineTestQuestions(providerId);
		List<OnlineTestVO> questionVoList = convertQuestionsDOToVo(questionList);
		
		return questionVoList;
	}

	public SeekerVO getEmailAddress(Integer seekerID) {
		JobSeekerContact jobSeekerContact = onlineTestDAO.getEmailAddress(seekerID);
		SeekerVO seekerVO = convertEmailToVo(jobSeekerContact);
		System.out.println("email1:"+jobSeekerContact.getSeekerEmail1());
		return seekerVO;
	}

	private SeekerVO convertEmailToVo(JobSeekerContact jobSeekerContact) {
		System.out.println("reached in convertEmailToVo");
		SeekerVO seekerVO = new SeekerVO();
		seekerVO.setSeekerEmail1(jobSeekerContact.getSeekerEmail1());
		seekerVO.setSeekerEmail2(jobSeekerContact.getSeekerEmail2());
		
		return seekerVO;
	}

}
