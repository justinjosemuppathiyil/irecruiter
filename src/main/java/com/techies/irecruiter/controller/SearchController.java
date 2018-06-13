package main.java.com.techies.irecruiter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.com.techies.irecruiter.dataobject.EmailDO;
import main.java.com.techies.irecruiter.service.SearchService;
import main.java.com.techies.irecruiter.util.EmailUtil;
import main.java.com.techies.irecruiter.vo.RequirmentResultVO;
import main.java.com.techies.irecruiter.vo.SearchVO;
import main.java.com.techies.irecruiter.vo.SeekerAllDetailsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Autowired
	SearchService searchService;
	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping(value = "/searchRequirment")
	public String seekerSearch(@ModelAttribute("SearchRequirmentForm") SearchVO searchVO, ModelMap model,
			HttpSession session) {

		System.out.println("Inside seekerSearch @ controller");
		List<RequirmentResultVO> searchRequirmentList = searchService.searchRequirment(searchVO);
		session.setAttribute("searchRequirmentList", searchRequirmentList);
		return "seekersearchresult";
	}

	/*
	 * @RequestMapping(value="/viewSearchResultJob") public String
	 * viewSearchResultJob(@RequestParam("id")Integer reqID,ModelMap model){
	 * 
	 * System.out.println("Inside viewSearchResultJob @ controller");
	 * RequirmentResultVO jobDetails= searchService.getJobDetails(reqID);
	 * model.addAttribute("searchList",searchList); return "seekersearchresult";
	 * }
	 */

	@RequestMapping(value = "/viewSearchSeeker")
	public String viewSearchSeeker(ModelMap model) {
		model.addAttribute("SearchSeekerForm", new SearchVO());
		return "providersearch";

	}

	@RequestMapping(value = "/searchSeeker")
	public String searchSeeker(@ModelAttribute("SearchSeekerForm") SearchVO searchVO, ModelMap model,
			HttpSession session) {

		System.out.println("Inside seekerSearch @ controller");
		List<SeekerAllDetailsVO> searchSeekerDetailsList = searchService.searchSeeker(searchVO);
		session.setAttribute("searchSeekerDetailsList", searchSeekerDetailsList);
		// model.addAttribute("searchSeekerDetailsList",searchSeekerDetailsList);
		return "providersearchseekerresult";
	}

	@RequestMapping(value = "/sendMail")
	public String applyJob(@RequestParam("id") String email, ModelMap model, HttpSession session) {
		EmailDO emailDO = new EmailDO();

		emailDO.setUserName("joicekallar@gmail.com");
		emailDO.setPassword("joice123");
		emailDO.setFrom("joicekallar@gmail.com");
		emailDO.setTo("justinjosemuppathiyil@gmail.com");
		emailDO.setSubject("Call Letter From iRecruiter");
		emailDO.setMessageContent("You are shortlisted for Technical Interview at Techies Network Bangalore...");
		emailUtil.sendEmail(emailDO);

		String status = "Email has been send to " + emailDO.getTo();
		model.addAttribute("status", status);
		return "applystatus";

	}

}
