package main.java.com.techies.irecruiter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.com.techies.irecruiter.service.LoginService;
import main.java.com.techies.irecruiter.service.SeekerService;
import main.java.com.techies.irecruiter.vo.JobSeekerResumeVO;
import main.java.com.techies.irecruiter.vo.JobVO;
import main.java.com.techies.irecruiter.vo.SearchVO;
import main.java.com.techies.irecruiter.vo.SeekerQualificationVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SeekerController {
	@Autowired
	SeekerService seekerService;
	@Autowired
	LoginService loginService;

	String actionType;
	String page = null;

	@RequestMapping(value = "/manageSeekerDetails") // for create and update the
													// seeker profile
	public String manageSeekerDetails(@ModelAttribute("manageSeekerForm") SeekerVO seekerVO, ModelMap model,
			HttpSession session) {
		System.out.println("reched seeker creation");
		System.out.println("username:" + seekerVO.getUsername());
		actionType = seekerVO.getActionType();
		System.out.println("actionType: " + actionType);
		int seekerId = 0;

		if ("CREATE".equalsIgnoreCase(actionType)) {
			seekerId = seekerService.createSeekerProfile(seekerVO);
			actionType = "CREATE";
			session.setAttribute("actionType", actionType);
			System.out.println("after createprovider controller");
			String status = null;
			if (seekerId > 0) {
				status = "Profile updated successfully";
				model.addAttribute("seekerID", seekerId);
				model.addAttribute("seekerVO", seekerVO);
				model.addAttribute("SeekerQualificationForm", new SeekerQualificationVO());
				page = "manageseekerqualification";
			} else {
				status = "error";
				model.addAttribute("status", status);
				page = "manageseekerdetails";
			}

		} else if ("UPDATE".equalsIgnoreCase(actionType)) {

			System.out.println("Date @ controller " + seekerVO.getSeekerDOB());
			seekerService.updateSeekerProfile(seekerVO);
			int id = seekerVO.getSeekerID();
			actionType = "UPDATE";
			session.setAttribute("actionType", actionType);

			SeekerQualificationVO seekerQualification = seekerService.getSeekerQualification(id);
			model.addAttribute("seekerQualificationVO", seekerQualification);
			SeekerQualificationVO seekerExperience = seekerService.getSeekerExperience(id);
			model.addAttribute("seekerExperienceVO", seekerExperience);

			List<String> seekerSkillset = seekerService.getSeekerSkill(id);

			model.addAttribute("seekerSkillset", seekerSkillset);
			session.setAttribute("seekerSkillset", seekerSkillset);
			model.addAttribute("seekerID", id);
			actionType = "UPDATE";
			session.setAttribute("actionType", actionType);
			model.addAttribute("SeekerQualificationForm", new SeekerQualificationVO());
			page = "manageseekerqualification";
		}
		session.setAttribute("seekerID", seekerId);
		return page;
	}

	@RequestMapping(value = "/getSeekerProfile") // for edit the seeker profile
													// and qualification details
	public String getSeekerProfile(@RequestParam("id") String id, ModelMap model, HttpSession session) {

		System.out.println("Reached getSeekerProfile and seekerId: " + id);
		if (Integer.parseInt(id) == 0) {
			actionType = "CREATE";
			session.setAttribute("actionType", actionType);
			model.addAttribute("manageSeekerForm", new SeekerVO());
			page = "manageseekerdetails";

		} else {

			SeekerVO seekerVO = seekerService.getSeekerProfile(Integer.parseInt(id));
			model.addAttribute("seekerVO", seekerVO);

			System.out.println("seekerId: " + seekerVO.getSeekerID() + " Username : " + seekerVO.getUsername());

			String username = seekerVO.getUsername();
			model.addAttribute("username", username);
			model.addAttribute("manageSeekerForm", new SeekerVO());
			actionType = "UPDATE";
			session.setAttribute("actionType", actionType);
			page = "manageseekerdetails";
		}

		return page;

	}

	@RequestMapping(value = "/viewSeekerProfile") // for view all details of job
													// seeker
	public String viewSeekerProfile(@RequestParam("id") String id, ModelMap model, HttpSession session) {
		actionType = "VIEW";
		session.setAttribute("actionType", actionType);

		SeekerVO seekerVO = seekerService.getSeekerProfile(Integer.parseInt(id));
		model.addAttribute("seekerVO", seekerVO);
		SeekerQualificationVO seekerQualification = seekerService.getSeekerQualification(Integer.parseInt(id));
		model.addAttribute("seekerQualificationVO", seekerQualification);
		List<String> seekerSkillset = seekerService.getSeekerSkill(Integer.parseInt(id));
		model.addAttribute("seekerSkillset", seekerSkillset);
		session.setAttribute("seekerSkillset", seekerSkillset);
		SeekerQualificationVO seekerExperience = seekerService.getSeekerExperience(Integer.parseInt(id));
		model.addAttribute("seekerExperienceVO", seekerExperience);
		return "viewseekerprofile";

	}

	@RequestMapping(value = "/manageSeekerQualification") // for create and
															// update the seeker
															// qualifications
	public String manageQualification(
			@ModelAttribute("SeekerQualificationForm") SeekerQualificationVO seekerQualificationVO, ModelMap model,
			HttpSession session) {

		System.out.println("specialization:" + seekerQualificationVO.getSpecilization());
		System.out.println("intitute:" + seekerQualificationVO.getInstitute());

		if ("CREATE".equalsIgnoreCase(actionType)) {
			boolean result = seekerService.addQualification(seekerQualificationVO);
			actionType = "CREATE";
			session.setAttribute("actionType", actionType);
			System.out.println("after addQualification controller");

			if (result) {

				model.addAttribute("SeekerResumeForm", new JobSeekerResumeVO());
				int seekerID = seekerQualificationVO.getSeekerID();
				model.addAttribute("seekerID", seekerID);
				page = "manageseekerresume";
			} else {

				page = "manageseekerqualification";
			}

		} else if ("UPDATE".equalsIgnoreCase(actionType)) {

			seekerService.updateSeekerQualification(seekerQualificationVO);
			int seekerID = seekerQualificationVO.getSeekerID();
			model.addAttribute("seekerID", seekerID);
			actionType = "UPDATE";
			session.setAttribute("actionType", actionType);
			model.addAttribute("SeekerResumeForm", new JobSeekerResumeVO());
			JobSeekerResumeVO jobSeekerResumeVO = seekerService.getSeekerResumeDetails(seekerID);
			model.addAttribute("jobSeekerResumeVO", jobSeekerResumeVO);
			page = "manageseekerresume";
		}
		return page;

	}

	@RequestMapping(value = "/manageSeekerResume", method = RequestMethod.POST) // for
																				// upload
																				// seeker
																				// resume
	public String manageSeekerResume(@ModelAttribute("SeekerResumeForm") JobSeekerResumeVO jobSeekerResumeVO,
			ModelMap model, HttpSession session, @RequestParam("file") MultipartFile file) {

		System.out.println("in manageSeekerResume controller");
		int seekerID = 0;

		if ("CREATE".equalsIgnoreCase(actionType)) {
			actionType = "CREATE";
			seekerID = jobSeekerResumeVO.getSeekerID();
			System.out.println("create seekerid " + seekerID);
			session.setAttribute("actionType", actionType);
			System.out.println("in manageSeekerResume controller " + actionType);
			try {
				seekerService.uploadSeekerResume(jobSeekerResumeVO, file);
			} catch (Exception e) {
				System.out.println("error:" + e.toString());
			}
			seekerID = jobSeekerResumeVO.getSeekerID();
			System.out.println("seekerID in jobSeekerResumeVO :" + seekerID);
			model.addAttribute("seekerID", seekerID);

			// page="seekerhome";
		} else if ("UPDATE".equalsIgnoreCase(actionType)) {
			System.out.println("in manageSeekerResume controller update ");
			String filename = jobSeekerResumeVO.getFilename();
			System.out.println("filename in updatejobSeekerResumeVO :" + filename);
			if (filename != null) {
				// try{
				seekerService.updateSeekerResume(jobSeekerResumeVO, file);
				// }catch (Exception e) {
				// System.out.println("error:"+e.toString());
				// }
			}
			seekerID = jobSeekerResumeVO.getSeekerID();
			model.addAttribute("seekerID", seekerID);
			actionType = "UPDATE";
			session.setAttribute("actionType", actionType);
			// page="seekerhome";

		}
		SeekerVO seekerVO = seekerService.getSeekerProfile(seekerID);
		model.addAttribute("seekerVO", seekerVO);
		SeekerQualificationVO seekerQualification = seekerService.getSeekerQualification(seekerID);
		model.addAttribute("seekerQualificationVO", seekerQualification);
		List<String> seekerSkillset = seekerService.getSeekerSkill(seekerID);
		model.addAttribute("seekerSkillset", seekerSkillset);
		session.setAttribute("seekerSkillset", seekerSkillset);
		SeekerQualificationVO seekerExperience = seekerService.getSeekerExperience(seekerID);
		model.addAttribute("seekerExperienceVO", seekerExperience);
		model.addAttribute("SeekerForm", new SeekerVO());
		return "viewseekerprofile";

	}

	@RequestMapping(value = "/showSeekerDetails") // for on click finish go
													// seekerhome
	public String finish(@ModelAttribute("SeekerForm") SeekerVO seekerVO, ModelMap model, HttpSession session) {
		int seekerID = seekerVO.getSeekerID();
		model.addAttribute("seekerID", seekerID);
		String username = (String) session.getAttribute("username");
		System.out.println("userName:" + username);
		SeekerVO seekerVO1 = loginService.getSeekerName(username);
		System.out.println("getSeekerName:" + seekerVO1.getSeekerName());
		model.addAttribute("seekerVO", seekerVO1);
		List<JobVO> allJobList = loginService.getAllJobs();
		System.out.println("reched controller");
		session.setAttribute("allJobList", allJobList);
		List<JobVO> recentJobList = loginService.getRecentJobs();
		session.setAttribute("recentJobList", recentJobList);
		model.addAttribute("SearchRequirmentForm", new SearchVO());
		return "seekerhome";

	}

	@RequestMapping(value = "/seekerHome")
	public String seekerHome(ModelMap model, HttpSession session) {
		int seekerID = (Integer) session.getAttribute("seekerID");
		SeekerVO seekerVO1 = seekerService.getSeekerProfile(seekerID);
		model.addAttribute("seekerVO", seekerVO1);
		model.addAttribute("SearchRequirmentForm", new SearchVO());
		return "seekerhome";
	}

	@RequestMapping(value = "/seekerLogout")
	public String providerLogout(ModelMap model, HttpSession session) {
		session.removeAttribute("seekerId");
		session.invalidate();
		return "index";
	}

}
