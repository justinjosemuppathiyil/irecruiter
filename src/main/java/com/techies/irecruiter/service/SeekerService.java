package main.java.com.techies.irecruiter.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import main.java.com.techies.irecruiter.dataaccess.SeekerDAO;
import main.java.com.techies.irecruiter.dataobject.SeekerAllDetailsDO;
import main.java.com.techies.irecruiter.domain.JobSeekerContact;
import main.java.com.techies.irecruiter.domain.JobSeekerDetails;
import main.java.com.techies.irecruiter.domain.JobSeekerExperience;
import main.java.com.techies.irecruiter.domain.JobSeekerQualification;
import main.java.com.techies.irecruiter.domain.JobSeekerResume;
import main.java.com.techies.irecruiter.domain.JobSeekerSkill;
import main.java.com.techies.irecruiter.vo.JobSeekerResumeVO;
import main.java.com.techies.irecruiter.vo.SeekerQualificationVO;
import main.java.com.techies.irecruiter.vo.SeekerVO;

@Service
public class SeekerService {
	@Autowired
	SeekerDAO seekerDAO;

	public int createSeekerProfile(SeekerVO seekerVO) {
		System.out.println("reched createSeekerProfile Service");
		
		JobSeekerDetails jobSeekerDetails = convertVOToSeekerDetails(seekerVO);
		int seekerId=seekerDAO.createseekerDetails(jobSeekerDetails);
		
		System.out.println("after createseekerdetails reached to service");
		
		JobSeekerContact jobSeekerContact = convertVOToSeekerContacts(seekerVO,seekerId);
		seekerDAO.createSeekerContacts(jobSeekerContact);
		
		return seekerId;
	}

	private JobSeekerContact convertVOToSeekerContacts(SeekerVO seekerVO,int seekerId) {
		
		System.out.println("reached in convertVOToSeekerContacts");
		JobSeekerContact seekerContact = new JobSeekerContact();
		
		seekerContact.setSeekerAddress(seekerVO.getSeekerAddress());
		seekerContact.setSeekerID(seekerId);
		seekerContact.setSeekerStreet(seekerVO.getSeekerStreet());
		seekerContact.setSeekerDistrict(seekerVO.getSeekerDistrict());
		seekerContact.setSeekerState(seekerVO.getSeekerState());
		seekerContact.setSeekerCountry(seekerVO.getSeekerCountry());
		seekerContact.setSeekerPIN(seekerVO.getSeekerPIN());
		seekerContact.setSeekerEmail1(seekerVO.getSeekerEmail1());
		seekerContact.setSeekerEmail2(seekerVO.getSeekerEmail2());
		seekerContact.setSeekerPhone1(seekerVO.getSeekerPhone1());
		seekerContact.setSeekerPhone2(seekerVO.getSeekerPhone2());
		seekerContact.setContactID(seekerVO.getContactID());
		
		return seekerContact;
	}

	private JobSeekerDetails convertVOToSeekerDetails(SeekerVO seekerVO) {
		
		System.out.println("reached in convertVOToSeekerDetails");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JobSeekerDetails seekerDetails = new JobSeekerDetails();
		seekerDetails.setSeekerID(seekerVO.getSeekerID());
		seekerDetails.setSeekerName(seekerVO.getSeekerName());
		try{
			Date date = df.parse(seekerVO.getSeekerDOB());
			seekerDetails.setSeekerDOB(date);
			System.out.println("Date @ Service "+seekerDetails.getSeekerDOB());
		}
		
		catch (Exception e) {
			System.out.println("error:"+e.toString());
		}
		seekerDetails.setSeekerGender(seekerVO.getSeekerGender());
		seekerDetails.setUsername(seekerVO.getUsername());
		
		return seekerDetails;
	}

	public void updateSeekerProfile(SeekerVO seekerVO) {
		int seekerId = seekerVO.getSeekerID();
		JobSeekerDetails seekerDetails = convertVOToSeekerDetails(seekerVO);
		seekerDAO.updateSeekerDetails(seekerDetails);
		
		System.out.println("after updateseekerDetails reached in service");
		
		JobSeekerContact seekerContact = convertVOToSeekerContacts(seekerVO,seekerId);
		seekerDAO.updateSeekerContacts(seekerContact);
	}

	public SeekerVO getSeekerProfile(int id) {
		
		System.out.println("reched getSeekerProfile Service");
		
		SeekerAllDetailsDO seekerAllDetailsDO = seekerDAO.getSeekerProfile(id);
		SeekerVO seekerVO = converDOToSeekerVO(seekerAllDetailsDO);
		
		return seekerVO;
	}

	private SeekerVO converDOToSeekerVO(SeekerAllDetailsDO seekerAllDetailsDO) {
		
		SeekerVO seekerVO = new SeekerVO();
		
		seekerVO.setSeekerID(seekerAllDetailsDO.getSeekerID());
		seekerVO.setContactID(seekerAllDetailsDO.getContactID());
		seekerVO.setSeekerName(seekerAllDetailsDO.getSeekerName());
		seekerVO.setSeekerAddress(seekerAllDetailsDO.getSeekerAddress());
		seekerVO.setSeekerCountry(seekerAllDetailsDO.getSeekerCountry());
		seekerVO.setSeekerState(seekerAllDetailsDO.getSeekerState());
		seekerVO.setSeekerDistrict(seekerAllDetailsDO.getSeekerDistrict());
		seekerVO.setSeekerStreet(seekerAllDetailsDO.getSeekerStreet());
		seekerVO.setSeekerEmail1(seekerAllDetailsDO.getSeekerEmail1());
		seekerVO.setSeekerEmail2(seekerAllDetailsDO.getSeekerEmail2());
		seekerVO.setUsername(seekerAllDetailsDO.getUsername());
		seekerVO.setSeekerPIN(seekerAllDetailsDO.getSeekerPIN());
		seekerVO.setSeekerPhone1(seekerAllDetailsDO.getSeekerPhone1());
		seekerVO.setSeekerPhone2(seekerAllDetailsDO.getSeekerPhone2());
		System.out.println("Date DO : "+seekerAllDetailsDO.getSeekerDOB());
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		seekerVO.setSeekerDOB((df.format(seekerAllDetailsDO.getSeekerDOB()).toString()));
		System.out.println("Date VO : "+seekerVO.getSeekerDOB());
		seekerVO.setSeekerGender(seekerAllDetailsDO.getSeekerGender());
		
		return seekerVO;
	}

	public boolean addQualification(SeekerQualificationVO seekerQualificationVO) {
		System.out.println("reched addQualification Service");
		
		JobSeekerQualification jobSeekerQualification = convertVOToseekerQualification(seekerQualificationVO);
		boolean result = seekerDAO.addQualification(jobSeekerQualification);
		JobSeekerExperience jobSeekerExperience = convertVOToseekerExperience(seekerQualificationVO);
		seekerDAO.addExperience(jobSeekerExperience);
		/*JobSeekerSkill jobSeekerSkill = convertVOToseekerSkill(seekerQualificationVO);
		seekerDAO.addSkill(jobSeekerSkill);*/
		for(String skill:seekerQualificationVO.getSkill())
		{
			JobSeekerSkill jobSeekerSkill = convertVOToSkill(seekerQualificationVO,skill);
			System.out.println("skill in sevice loop:"+jobSeekerSkill.getSkill());
			seekerDAO.addSkill(jobSeekerSkill);
		}
		
		System.out.println("after addQualification reached to service");
		return result;
		
		
	}

	private JobSeekerSkill convertVOToSkill(SeekerQualificationVO seekerQualificationVO, String skill) {
		System.out.println("skill in sevice convet:"+skill);
		JobSeekerSkill jobSeekerSkill = new JobSeekerSkill();
		boolean flag=skill.isEmpty();
		if(flag==false){
			try{
			jobSeekerSkill.setSkill(skill);
			jobSeekerSkill.setSeekerID(seekerQualificationVO.getSeekerID());
		}catch (Exception e) {
			System.out.println("error:"+e.toString());
		}
		}
		
		return jobSeekerSkill;
	}

	private JobSeekerExperience convertVOToseekerExperience(SeekerQualificationVO seekerQualificationVO) {
		
		JobSeekerExperience jobSeekerExperience = new JobSeekerExperience();
		jobSeekerExperience.setExperienceID(seekerQualificationVO.getExperienceID());
		jobSeekerExperience.setExperience(seekerQualificationVO.getExperience());
		jobSeekerExperience.setSeekerID(seekerQualificationVO.getSeekerID());
		
		return jobSeekerExperience;
	}


	private JobSeekerQualification convertVOToseekerQualification(SeekerQualificationVO seekerQualificationVO) {
		
		System.out.println("reached in convertVOToseekerQualification");
		
		JobSeekerQualification jobSeekerQualification = new JobSeekerQualification();
		jobSeekerQualification.setCourseName(seekerQualificationVO.getCourseName());
		jobSeekerQualification.setSpecilization(seekerQualificationVO.getSpecilization());
		jobSeekerQualification.setPassYear(seekerQualificationVO.getPassYear());
		jobSeekerQualification.setGpa(seekerQualificationVO.getGpa());
		jobSeekerQualification.setSqID(seekerQualificationVO.getSqID());
		jobSeekerQualification.setInstitute(seekerQualificationVO.getInstitute());
		jobSeekerQualification.setSeekerID(seekerQualificationVO.getSeekerID());
		
		return jobSeekerQualification;
	}

	public void updateSeekerQualification(SeekerQualificationVO seekerQualificationVO) {
		
		
		JobSeekerQualification jobSeekerQualification = convertVOToseekerQualification(seekerQualificationVO);
		seekerDAO.updateSeekerQualification(jobSeekerQualification);
		JobSeekerExperience jobSeekerExperience = convertVOToseekerExperience(seekerQualificationVO);
		seekerDAO.updateSeekerExperience(jobSeekerExperience);
		/*JobSeekerSkill jobSeekerSkill = convertVOToseekerSkill(seekerQualificationVO);*/
		System.out.println("update skill null:"+seekerQualificationVO.getSkill());
		@SuppressWarnings("rawtypes")
		List flag = seekerQualificationVO.getSkill();
		System.out.println("update skill:"+flag);
		if(flag!=null){
		for(String skill:seekerQualificationVO.getSkill())
		{
			System.out.println("update skill null in loop:"+skill);
			JobSeekerSkill jobSeekerSkill = convertVOToSkill(seekerQualificationVO,skill);
			JobSeekerSkill jobSkill = seekerDAO.validateSkill(jobSeekerSkill);
			if(jobSkill==null){
			seekerDAO.updateSeekerSkill(jobSeekerSkill);
			}
		}
		}
		
	}

	public SeekerQualificationVO getSeekerQualification(int id) {
		System.out.println("reched getSeekerQualification Service");
		
		JobSeekerQualification jobSeekerQualification = seekerDAO.getSeekerQualification(id);
		SeekerQualificationVO seekerQualificationVO = converSeekerQualificationToVO(jobSeekerQualification);
		return seekerQualificationVO;
	}

	private SeekerQualificationVO converSeekerQualificationToVO(JobSeekerQualification jobSeekerQualification) {
		
		SeekerQualificationVO seekerQualificationVO = new SeekerQualificationVO();
		seekerQualificationVO.setSqID(jobSeekerQualification.getSqID());
		seekerQualificationVO.setSeekerID(jobSeekerQualification.getSeekerID());
		seekerQualificationVO.setCourseName(jobSeekerQualification.getCourseName());
		seekerQualificationVO.setSpecilization(jobSeekerQualification.getSpecilization());
		seekerQualificationVO.setPassYear(jobSeekerQualification.getPassYear());
		seekerQualificationVO.setInstitute(jobSeekerQualification.getInstitute());
		seekerQualificationVO.setGpa(jobSeekerQualification.getGpa());
		
		return seekerQualificationVO;
	}
	

	public SeekerQualificationVO getSeekerExperience(int id) {
		JobSeekerExperience jobSeekerExperience = seekerDAO.getSeekerExperience(id);
		SeekerQualificationVO seekerQualificationVO = converSeekerExperienceToVO(jobSeekerExperience);
		return seekerQualificationVO;
	}

	private SeekerQualificationVO converSeekerExperienceToVO(JobSeekerExperience jobSeekerExperience) {
		SeekerQualificationVO seekerQualificationVO = new SeekerQualificationVO();
		
		seekerQualificationVO.setSeekerID(jobSeekerExperience.getSeekerID());
		seekerQualificationVO.setExperienceID(jobSeekerExperience.getExperienceID());
		seekerQualificationVO.setExperience(jobSeekerExperience.getExperience());
		
		return seekerQualificationVO;
	}


	public List<String> getSeekerSkill(int id) {
		List<JobSeekerSkill> jobSeekerSkillList = seekerDAO.getSeekerSkill(id);
		//SeekerQualificationVO seekerQualificationVO = new SeekerQualificationVO();
		//seekerQualificationVO.setSkill(jobSeekerSkill);
		String skill = null;
		List<String> jobSeekerList2 = new ArrayList<String>();
		for(JobSeekerSkill jobSeekerSkill:jobSeekerSkillList)
		{
			skill = jobSeekerSkill.getSkill();
			jobSeekerList2.add(skill);
		}
		return jobSeekerList2;
	}

	public void uploadSeekerResume(JobSeekerResumeVO jobSeekerResumeVO,MultipartFile file) {
		System.out.println("seekerid:"+jobSeekerResumeVO.getSeekerID()+"filename:"+jobSeekerResumeVO.getFilename());
		JobSeekerResume jobSeekerResume = convertTojobSeekerResume(jobSeekerResumeVO,file);
		seekerDAO.uploadSeekerResume(jobSeekerResume);
		
		
	}

	private JobSeekerResume convertTojobSeekerResume(JobSeekerResumeVO jobSeekerResumeVO, MultipartFile file) {
		
		JobSeekerResume jobSeekerResume = new JobSeekerResume();
		boolean flag=file.isEmpty();
		if(flag==false)
		{
		try{
			jobSeekerResume.setContent(file.getBytes());
			jobSeekerResume.setContentType(file.getContentType());
			jobSeekerResume.setFilename(file.getOriginalFilename());
		}catch (Exception e) {
			System.out.println("error:"+e.toString());
		}
		}
			jobSeekerResume.setSeekerID(jobSeekerResumeVO.getSeekerID());
			jobSeekerResume.setResumeID(jobSeekerResumeVO.getResumeID());
			System.out.println("seekerid in resume:"+jobSeekerResumeVO.getSeekerID());
			System.out.println("resumeID:"+jobSeekerResumeVO.getResumeID());
			System.out.println("resume name:"+jobSeekerResume.getFilename());
			
		return jobSeekerResume;
	}

	public JobSeekerResumeVO getSeekerResumeDetails(int seekerID) {
		JobSeekerResume jobSeekerResume = seekerDAO.getSeekerResumeDetails(seekerID);
		JobSeekerResumeVO jobSeekerResumeVO = convertJobSeekerResumeTOVO(jobSeekerResume);
		System.out.println("filename"+jobSeekerResumeVO.getFilename());
		System.out.println("filename"+jobSeekerResumeVO.getSeekerID());
		return jobSeekerResumeVO;
	}

	private JobSeekerResumeVO convertJobSeekerResumeTOVO(JobSeekerResume jobSeekerResume) {
		System.out.println("in convertJobSeekerResumeTOVO");
		
		JobSeekerResumeVO jobSeekerResumeVO = new JobSeekerResumeVO();
		jobSeekerResumeVO.setSeekerID(jobSeekerResume.getSeekerID());
		jobSeekerResumeVO.setResumeID(jobSeekerResume.getResumeID());
		InputStream is = new ByteArrayInputStream(jobSeekerResume.getContent());
		jobSeekerResumeVO.setContent(is);
		jobSeekerResumeVO.setContentType(jobSeekerResume.getContentType());
		jobSeekerResumeVO.setFilename(jobSeekerResume.getFilename());
		return jobSeekerResumeVO;
	}

	public void updateSeekerResume(JobSeekerResumeVO jobSeekerResumeVO,MultipartFile file) {
		JobSeekerResume jobSeekerResume = convertTojobSeekerResume(jobSeekerResumeVO,file);
		seekerDAO.updateSeekerResume(jobSeekerResume);
		
	}

	

	

}
