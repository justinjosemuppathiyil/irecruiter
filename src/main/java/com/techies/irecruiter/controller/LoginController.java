package main.java.com.techies.irecruiter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.com.techies.irecruiter.service.AdministratorService;
import main.java.com.techies.irecruiter.service.LoginService;
import main.java.com.techies.irecruiter.service.SeekerService;
import main.java.com.techies.irecruiter.vo.JobVO;
import main.java.com.techies.irecruiter.vo.LoginVO;
import main.java.com.techies.irecruiter.vo.ProviderVO;
import main.java.com.techies.irecruiter.vo.SearchVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	AdministratorService administratorService;
	@Autowired
	SeekerService seekerService;

	String actionType = null;

	@RequestMapping(value = "/index", method = RequestMethod.GET) // to show the
																	// index
																	// page
	public String index(ModelMap model) {
		model.addAttribute("loginForm", new LoginVO());
		System.out.println("In Index");
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {

		model.addAttribute("loginForm", new LoginVO());
		return "index";
	}

	@RequestMapping(value = "/userRegistration") // to click signup btn go to
													// login regstn page
	public String userRegistration(ModelMap model) {

		model.addAttribute("registrationForm", new LoginVO());
		return "userregistration";

	}

	@RequestMapping(value = "/registerUser") // for new user sign up..
	public String registerUser(@ModelAttribute("registrationForm") LoginVO loginVO, ModelMap model,
			HttpSession session) {
		// model.addAttribute("loginVO",loginVO);
		String userId = loginService.checkAvailable(loginVO.getUsername());
		String page = null;
		System.out.println("userId:" + userId);
		if (userId.equalsIgnoreCase(loginVO.getUsername())) {
			String checkavailbility = "user already exist..try another name..";
			model.addAttribute("checkavailbility", checkavailbility);
			page = "userregistration";
		} else {

			System.out.println("inside register user");
			String role = loginService.registerUser(loginVO);
			System.out.println("role:" + role);
			actionType = "CREATE";
			session.setAttribute("actionType", actionType);
			if ("jobprovider".equalsIgnoreCase(role)) {

				model.addAttribute("manageProviderDetailsForm", new ProviderVO());
				// session.setAttribute("providerId",providerId);
				String username = loginVO.getUsername();
				model.addAttribute("username", username);
				page = "manageproviderdetails";

			} else if ("jobseeker".equalsIgnoreCase(role)) {

				model.addAttribute("manageSeekerForm", new SeekerVO());
				String username = loginVO.getUsername();
				model.addAttribute("username", username);
				session.setAttribute("username", username);
				/*
				 * SeekerVO seekerVO = loginService.getSeekerName(username);
				 * System.out.println("getSeekerName:"+seekerVO.getSeekerName())
				 * ; model.addAttribute("seekerVO",seekerVO); List<JobVO>
				 * allJobList = loginService.getAllJobs(); System.out.println(
				 * "reched controller");
				 * session.setAttribute("allJobList",allJobList); List<JobVO>
				 * recentJobList = loginService.getRecentJobs();
				 * session.setAttribute("recentJobList",recentJobList);
				 */
				page = "manageseekerdetails";
			}
		}

		return page;

	}

	@RequestMapping(value = "/submitLogin") // to login for already registered
											// user
	public String submitLogin(@ModelAttribute("loginForm") LoginVO loginVO, ModelMap model, HttpSession session) {

		String status = null;
		String role = loginService.validateLogin(loginVO);
		String page = null;
		if ("jobprovider".equalsIgnoreCase(role)) {

			int providerId = loginService.getProviderId(loginVO);
			actionType = "CREATE";
			session.setAttribute("actionType", actionType);
			model.addAttribute("providerId", providerId);
			session.setAttribute("providerId", providerId);
			ProviderVO providerVO = loginService.getProviderName(providerId);
			System.out.println("getSeekerName:" + providerVO.getName());
			model.addAttribute("providerVO", providerVO);
			model.addAttribute("manageProviderForm", new ProviderVO());
			page = "providerhome";
		} else if ("jobseeker".equalsIgnoreCase(role)) {

			int seekerId = loginService.getSeekerId(loginVO);
			System.out.println("SeekerID after login : " + seekerId);
			SeekerVO seekerVO = loginService.getSeekerName(seekerId);
			System.out.println("getSeekerName:" + seekerVO.getSeekerName());
			model.addAttribute("seekerVO", seekerVO);
			List<JobVO> allJobList = loginService.getAllJobs();
			System.out.println("reched controller");
			session.setAttribute("allJobList", allJobList);
			List<JobVO> recentJobList = loginService.getRecentJobs();
			session.setAttribute("recentJobList", recentJobList);
			String username = loginVO.getUsername();
			session.setAttribute("username", username);
			model.addAttribute("seekerID", seekerId);
			session.setAttribute("seekerID", seekerId);
			model.addAttribute("SearchRequirmentForm", new SearchVO());
			page = "seekerhome";
		} else if ("administrator".equalsIgnoreCase(role)) {
			List<ProviderVO> allProviderList = administratorService.getAllProviderDeatils();
			session.setAttribute("allProviderList", allProviderList);
			model.addAttribute("adminForm", new ProviderVO());

			page = "adminhome";
		} else {

			status = "Your username or password is incorrect.please try again...!";
			model.addAttribute("status", status);
			model.addAttribute("loginForm", new LoginVO());
			page = "index";
		}

		return page;
	}

}
