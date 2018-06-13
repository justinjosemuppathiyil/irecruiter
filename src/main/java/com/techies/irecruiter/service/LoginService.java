package main.java.com.techies.irecruiter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.techies.irecruiter.dataaccess.LoginDAO;
import main.java.com.techies.irecruiter.dataobject.JobDO;
import main.java.com.techies.irecruiter.domain.JobProviderDetails;
import main.java.com.techies.irecruiter.domain.JobSeekerDetails;
import main.java.com.techies.irecruiter.domain.Login;
import main.java.com.techies.irecruiter.vo.JobVO;
import main.java.com.techies.irecruiter.vo.LoginVO;
import main.java.com.techies.irecruiter.vo.ProviderVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;

	public String validateLogin(LoginVO loginVO) { // for validate the login

		Login loginDetails = convertToLogin(loginVO);
		Login login = loginDAO.validateLogin(loginDetails);

		String role = null;

		if (login != null) {
			role = login.getRole();
		} else {
			role = "error";
		}

		return role;
	}

	public String registerUser(LoginVO loginVO) {
		Login registerUser = convertToLogin(loginVO);
		loginDAO.registerUser(registerUser);
		String role = loginVO.getRole();
		return role;
	}

	public int getProviderId(LoginVO loginVO) {
		int providerId = loginDAO.getProviderId(loginVO.getUsername());
		System.out.println("providerId: " + providerId);
		return providerId;
	}

	public int getSeekerId(LoginVO loginVO) {
		int seekerId = loginDAO.getSeekerId(loginVO.getUsername());
		System.out.println("seekerId: " + seekerId);
		return seekerId;
	}

	private Login convertToLogin(LoginVO loginVO) {
		Login login = new Login();
		login.setUsername(loginVO.getUsername());
		login.setPassword(loginVO.getPassword());
		login.setRole(loginVO.getRole());
		return login;
	}

	public String checkAvailable(String username) {
		Login login = loginDAO.checkAvailable(username);
		Login login2 = new Login();
		System.out.println("userId at service:" + login2.getUsername());
		String userId = "";
		if (login != null) {
			System.out.println("inside if @ service");
			userId = login.getUsername();
		}
		return userId;
	}

	public List<JobVO> getAllJobs() {
		List<JobDO> allJobList = loginDAO.getAllJobs();
		List<JobVO> jobList = convertDoToJobVo(allJobList);
		return jobList;
	}

	private List<JobVO> convertDoToJobVo(List<JobDO> allJobList) {
		List<JobVO> jobVOList = new ArrayList<JobVO>();
		System.out.println("reched convertDoToJobVo");
		for (JobDO jobDO : allJobList) {
			JobVO jobVO = new JobVO();

			jobVO.setName(jobDO.getName());
			jobVO.setJobTitle(jobDO.getJobTitle());
			jobVOList.add(jobVO);

		}

		return jobVOList;

	}

	public List<JobVO> getRecentJobs() {
		List<JobDO> allJobList = loginDAO.getRecentJobs();
		List<JobVO> recentJobList = convertDoToJobVo(allJobList);
		return recentJobList;
	}

	public SeekerVO getSeekerName(String username) {
		System.out.println("getSeekerName at service");
		JobSeekerDetails jobSeekerDetails = loginDAO.getSeekerName(username);
		SeekerVO seekerVO = convertToSeekerName(jobSeekerDetails);
		return seekerVO;

	}

	private SeekerVO convertToSeekerName(JobSeekerDetails jobSeekerDetails) {
		SeekerVO seekerVO = new SeekerVO();
		seekerVO.setSeekerName(jobSeekerDetails.getSeekerName());
		return seekerVO;
	}

	public SeekerVO getSeekerName(int seekerId) {
		System.out.println("getSeekerName at service");
		JobSeekerDetails jobSeekerDetails = loginDAO.getSeekerName(seekerId);
		SeekerVO seekerVO = convertToSeekerName(jobSeekerDetails);
		return seekerVO;
	}

	public ProviderVO getProviderName(int providerId) {
		System.out.println("getSeekerName at service");
		JobProviderDetails jobProviderDetails = loginDAO.getProviderName(providerId);
		ProviderVO providerVO = convertToProviderName(jobProviderDetails);
		return providerVO;
	}

	private ProviderVO convertToProviderName(JobProviderDetails jobProviderDetails) {
		ProviderVO providerVO = new ProviderVO();
		providerVO.setName(jobProviderDetails.getName());
		return providerVO;
	}

}
