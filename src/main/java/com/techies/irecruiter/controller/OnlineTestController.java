package main.java.com.techies.irecruiter.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.com.techies.irecruiter.dataobject.EmailDO;
import main.java.com.techies.irecruiter.dataobject.OnlineTestStatusDO;
import main.java.com.techies.irecruiter.service.OnlineTestService;
import main.java.com.techies.irecruiter.util.EmailUtil;
import main.java.com.techies.irecruiter.vo.OnlineTestVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OnlineTestController {
	@Autowired
	OnlineTestService onlineTestService;
	@Autowired
	private EmailUtil emailUtil;

	String actionType = null;

	@RequestMapping(value = "/viewOnlineTestQuestionPage")
	public String viewOnlineTestQuestionPage(HttpSession session, ModelMap model) {
		actionType = "CREATE";
		session.setAttribute("actionType", actionType);
		int providerID = (Integer) session.getAttribute("providerId");
		model.addAttribute("providerID", providerID);
		model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
		return "manageonlinetestquestions";
	}

	@RequestMapping(value = "/submitQuestion")
	public String manageQuestion(@ModelAttribute("manageOnlineTestForm") OnlineTestVO onlineTestVO, ModelMap model,
			HttpSession session) {
		actionType = onlineTestVO.getActionType();
		String page = null;
		if ("CREATE".equalsIgnoreCase(actionType)) {
			System.out.println("providerID :" + onlineTestVO.getProviderID());
			List<OnlineTestVO> questionList = onlineTestService.submitQuestion(onlineTestVO);
			model.addAttribute("questionList", questionList);
			int providerID = (Integer) session.getAttribute("providerId");
			model.addAttribute("providerID", providerID);
			model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
			page = "manageonlinetestquestions";
		} else if ("UPDATE".equalsIgnoreCase(actionType)) {
			List<OnlineTestVO> questionList = onlineTestService.updateQuestion(onlineTestVO);
			actionType = "CREATE";
			model.addAttribute("questionList", questionList);
			model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
			session.setAttribute("actionType", actionType);
			page = "manageonlinetestquestions";

		}
		return page;
	}

	@RequestMapping(value = "/editQuestion")
	public String editQuestion(@RequestParam("id") Integer queId, ModelMap model, HttpSession session) {
		OnlineTestVO onlineTestVO = onlineTestService.getQuestion(queId);
		model.addAttribute("onlineTestVO", onlineTestVO);
		actionType = "UPDATE";
		session.setAttribute("actionType", actionType);
		model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
		int providerID = (Integer) session.getAttribute("providerId");
		model.addAttribute("providerID", providerID);
		return "manageonlinetestquestions";

	}

	@RequestMapping(value = "/listAllQuestions")
	public String listAllQuestions(ModelMap model, HttpSession session) {
		int id = (Integer) session.getAttribute("providerId");
		List<OnlineTestVO> questionList = onlineTestService.getAllQuestions(id);
		model.addAttribute("questionList", questionList);
		int providerID = (Integer) session.getAttribute("providerId");
		model.addAttribute("providerID", providerID);
		model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
		return "manageonlinetestquestions";

	}

	@RequestMapping(value = "/deleteQuestion")
	public String deleteQuestion(@RequestParam("id") Integer queId, ModelMap model, HttpSession session) {
		onlineTestService.deleteQuestion(queId);
		int id = (Integer) session.getAttribute("providerId");
		List<OnlineTestVO> questionList = onlineTestService.getAllQuestions(id);
		model.addAttribute("questionList", questionList);
		model.addAttribute("manageOnlineTestForm", new OnlineTestVO());
		model.addAttribute("providerID", id);
		return "manageonlinetestquestions";
	}

	@RequestMapping(value = "/conductTest")
	public String conductTest(@RequestParam("id") Integer providerId, ModelMap model, HttpSession session) {
		List<OnlineTestVO> questionList = onlineTestService.getOnlineTestQuestions(providerId);

		OnlineTestVO onlineTestVO = new OnlineTestVO();
		if (questionList != null && questionList.size() > 0) {
			Date startTime = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(startTime);
			cal.add(Calendar.MINUTE, 10);
			Date endTime = cal.getTime();

			session.setAttribute("questionList", questionList);
			onlineTestVO = questionList.get(0);
			OnlineTestStatusDO onlineTestStatusDO = new OnlineTestStatusDO();
			onlineTestStatusDO.setTotalQuestions(questionList.size());
			onlineTestStatusDO.setStartTime(new Date());
			onlineTestStatusDO.setEndTime(endTime);
			onlineTestStatusDO.setQuestionNo(1);
			onlineTestStatusDO.setMaxScore(10);
			session.setAttribute("testStatus", onlineTestStatusDO);

		}
		String timeLeft = getTimeFormat(600);
		onlineTestVO.setTimeLeft(timeLeft);
		onlineTestVO.setTotalScore(String.valueOf(10));
		onlineTestVO.setCurrentScore(String.valueOf(0));
		onlineTestVO.setQuestionNo(1);
		model.addAttribute("onlineTestForm", onlineTestVO);
		model.addAttribute("conductOnlineTestForm", new OnlineTestVO());
		return "onlinetest";

	}

	private String getTimeFormat(int seconds) {
		int rem = seconds % 3600;
		int mn = rem / 60;
		int sec = rem % 60;
		String mnStr = (mn < 10 ? "0" : "") + mn;
		String secStr = (sec < 10 ? "0" : "") + sec;
		String timeFormate = mnStr + ":" + secStr;

		return timeFormate;
	}

	@RequestMapping(value = "submitOnlineTest")
	public String submitOnlineTest(@ModelAttribute("conductOnlineTestForm") OnlineTestVO onlineTestResultVO,
			HttpSession session, ModelMap model) {
		long score = 0;
		long noOfFail = 0;
		long noOfSuccess = 0;
		long noOfSkip = 0;
		boolean isSkip = false;
		String page = null;
		long currentQuestionNo = onlineTestResultVO.getQuestionNo();
		OnlineTestStatusDO onlineTestStatusDO = (OnlineTestStatusDO) session.getAttribute("testStatus");
		@SuppressWarnings("unchecked")
		List<OnlineTestVO> questionList = (List<OnlineTestVO>) session.getAttribute("questionList");
		score = onlineTestStatusDO.getScore();
		System.out.println("score:" + score);
		noOfFail = onlineTestStatusDO.getNoOfFail();
		System.out.println("noOfFail:" + noOfFail);
		noOfSuccess = onlineTestStatusDO.getNoOfPass();
		System.out.println("noOfSuccess:" + noOfSuccess);
		noOfSkip = onlineTestStatusDO.getNoOfSkip();
		System.out.println("noOfSkip:" + noOfSkip);
		isSkip = onlineTestStatusDO.isSkip();
		Date currentTime = new Date();
		long duration = onlineTestStatusDO.getEndTime().getTime() - currentTime.getTime();
		if (duration <= 0) {
			String status = "TIME EXPIRED ..Test over..!";
			model.addAttribute("status", status);
			model.addAttribute("onlineTestStatusDO", onlineTestStatusDO);
			page = "onlinetestresult";

		} else {
			duration = duration / 1000;
			String timeLeft = getTimeFormat((int) duration);
			if (questionList != null && questionList.size() > 0) {
				OnlineTestVO onlineTestVO = questionList.get((int) currentQuestionNo - 1);
				if (onlineTestResultVO.getResult() == null) {
					if (onlineTestStatusDO.isSkip() == true) {
						noOfSkip = noOfSkip + 1;
						System.out.println("noOfSkip.....:" + noOfSkip);
					} else {
						noOfSkip = noOfSkip + 1;
						System.out.println("noOfSkip.....:" + noOfSkip);
						OnlineTestVO skipedQuestion = questionList.get((int) (currentQuestionNo - 1));
						onlineTestStatusDO.getSkipedQuestionList().add(skipedQuestion);
						System.out.println("inside result is null,skipedQuestionList size"
								+ onlineTestStatusDO.getSkipedQuestionList().size());
					}
				} else if (onlineTestResultVO.getResult().equalsIgnoreCase(onlineTestVO.getAnswer())) {
					score = score + 1;
					System.out.println("score....:" + score);
					noOfSuccess = noOfSuccess + 1;
					System.out.println("noOfSuccess....:" + noOfSuccess);
				} else {
					noOfFail = noOfFail + 1;
					System.out.println("noOfFail....:" + noOfFail);
				}

				if (currentQuestionNo < questionList.size()) {
					OnlineTestVO onlineTestVO2 = questionList.get((int) currentQuestionNo);
					onlineTestVO2.setTimeLeft(timeLeft);
					onlineTestVO2.setTotalScore(String.valueOf(10));
					onlineTestVO2.setCurrentScore(String.valueOf(score));
					onlineTestVO2.setQuestionNo(currentQuestionNo + 1);
					model.addAttribute("onlineTestForm", onlineTestVO2);

					onlineTestStatusDO.setQuestionNo(currentQuestionNo + 1);
					onlineTestStatusDO.setNoOfPass(noOfSuccess);
					onlineTestStatusDO.setNoOfFail(noOfFail);
					onlineTestStatusDO.setScore(score);
					onlineTestStatusDO.setNoOfSkip(noOfSkip);
					onlineTestStatusDO.setSkipQuesNo(onlineTestVO2.getSkipQuesNo());

					session.removeAttribute("testStatus");
					session.setAttribute("testStatus", onlineTestStatusDO);
					page = "onlinetest";
				} else if (onlineTestStatusDO.getSkipedQuestionList().size() > 0) {
					System.out.println("inside the skipedquestionlist");
					List<OnlineTestVO> skipedQuestions = onlineTestStatusDO.getSkipedQuestionList();
					List<OnlineTestVO> skipedQuestionsList = new ArrayList<OnlineTestVO>();
					for (OnlineTestVO skipedQuestion : skipedQuestions) {
						OnlineTestVO onlineTestVO2 = new OnlineTestVO();
						onlineTestVO2.setQuestion(skipedQuestion.getQuestion());
						onlineTestVO2.setQuestionNo(skipedQuestion.getQuestionNo());
						onlineTestVO2.setOption1(skipedQuestion.getOption1());
						onlineTestVO2.setOption2(skipedQuestion.getOption2());
						onlineTestVO2.setOption3(skipedQuestion.getOption3());
						onlineTestVO2.setOption4(skipedQuestion.getOption4());
						onlineTestVO2.setAnswer(skipedQuestion.getAnswer());
						onlineTestVO2.setSkipQuesNo(skipedQuestion.getQuestionNo());
						skipedQuestionsList.add(onlineTestVO2);
					}
					System.out.println("size of skipedQuestionsList:" + skipedQuestionsList.size());
					session.removeAttribute("questionList");
					session.setAttribute("questionList", skipedQuestionsList);

					OnlineTestVO onlineTestVO2 = skipedQuestionsList.get(0);
					onlineTestVO2.setTimeLeft(timeLeft);
					onlineTestVO2.setTotalScore(String.valueOf(10));
					onlineTestVO2.setCurrentScore(String.valueOf(score));
					onlineTestVO2.setQuestionNo(1);
					model.addAttribute("onlineTestForm", onlineTestVO2);

					onlineTestStatusDO.setQuestionNo(1);
					onlineTestStatusDO.setNoOfPass(noOfSuccess);
					onlineTestStatusDO.setNoOfFail(noOfFail);
					onlineTestStatusDO.setScore(score);
					onlineTestStatusDO.setSkip(true);
					onlineTestStatusDO.setSkipQuesNo(onlineTestVO2.getSkipQuesNo());

					session.removeAttribute("testStatus");
					session.setAttribute("testStatus", onlineTestStatusDO);
					String skipStatus = "skiped Question";
					model.addAttribute("skipStatus", skipStatus);
					skipedQuestions.clear();
					System.out.println("size of skipedQuestions after clear:" + skipedQuestions.size());

					page = "onlinetest";
				} else {

					/*
					 * OnlineTestVO onlineTestVO2 = questionList.get((int)
					 * currentQuestionNo-1);
					 * if(onlineTestResultVO.getResult().equalsIgnoreCase(
					 * onlineTestVO2.getAnswer())){ score = score+1;
					 * System.out.println(" else  score....:"+score);
					 * noOfSuccess=noOfSuccess+1; System.out.println(
					 * " else  noOfSuccess....:"+noOfSuccess); } else { noOfFail
					 * = noOfFail+1; System.out.println(" else noOfFail....:"
					 * +noOfFail); }
					 */

					// onlineTestStatusDO.setQuestionNo(currentQuestionNo+1);
					onlineTestStatusDO.setNoOfPass(noOfSuccess);
					onlineTestStatusDO.setNoOfFail(noOfFail);
					onlineTestStatusDO.setScore(score);

					int mark = (int) onlineTestStatusDO.getScore();
					if (mark >= 5) {
						String status = "test completed....You are eligible to apply job";
						model.addAttribute("status", status);
						noOfSuccess = onlineTestStatusDO.getNoOfPass();
						System.out.println("noOfpass***:" + noOfSuccess);
						noOfFail = onlineTestStatusDO.getNoOfFail();
						System.out.println("noOfFail***:" + noOfFail);
						long total = onlineTestStatusDO.getMaxScore();
						noOfSkip = total - (noOfSuccess + noOfFail);
						onlineTestStatusDO.setNoOfSkip(noOfSkip);

						model.addAttribute("onlineTestStatusDO", onlineTestStatusDO);
						page = "applyjob";
					} else {
						String status = "test completed....You are not eligible to apply job";
						model.addAttribute("status", status);
						noOfSuccess = onlineTestStatusDO.getNoOfPass();
						noOfFail = onlineTestStatusDO.getNoOfFail();
						long total = onlineTestStatusDO.getMaxScore();
						noOfSkip = total - (noOfSuccess + noOfFail);
						onlineTestStatusDO.setNoOfSkip(noOfSkip);
						model.addAttribute("onlineTestStatusDO", onlineTestStatusDO);
						page = "onlinetestresult";
					}

					session.removeAttribute("testStatus");
					session.removeAttribute("questionList");
					return page;
				}

			}
		}
		model.addAttribute("conductOnlineTestForm", new OnlineTestVO());
		return page;

	}

	@RequestMapping(value = "/applyJob")
	public String applyJob(@RequestParam("id") Integer seekerID, ModelMap model, HttpSession session) {
		SeekerVO seekerVO = onlineTestService.getEmailAddress(seekerID);
		EmailDO emailDO = new EmailDO();

		emailDO.setUserName("joicekallar@gmail.com");
		emailDO.setPassword("joice123");
		emailDO.setFrom("joicekallar@gmail.com");
		emailDO.setTo("justinjosemuppathiyil@gmail.com");
		emailDO.setSubject("Job Application Confirmation");
		emailDO.setMessageContent("your job application successfully submitted we will contact soon......");
		emailUtil.sendEmail(emailDO);

		String status = "you have successfully applies for the post...email has been send to " + emailDO.getTo();
		model.addAttribute("status", status);
		return "applystatus";

	}

}
