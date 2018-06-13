package main.java.com.techies.irecruiter.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.techies.irecruiter.dataaccess.ProviderDAO;
import main.java.com.techies.irecruiter.dataobject.ProviderAllDetailsDO;
import main.java.com.techies.irecruiter.domain.JobProviderContacts;
import main.java.com.techies.irecruiter.domain.JobProviderDetails;
import main.java.com.techies.irecruiter.domain.Requirment;
import main.java.com.techies.irecruiter.domain.RequirmentLocation;
import main.java.com.techies.irecruiter.domain.RequirmentQualification;
import main.java.com.techies.irecruiter.domain.RequirmentSkillset;
import main.java.com.techies.irecruiter.util.EmailUtil;
import main.java.com.techies.irecruiter.vo.LocationVO;
import main.java.com.techies.irecruiter.vo.ProviderVO;
import main.java.com.techies.irecruiter.vo.RequirmentQualificationVO;
import main.java.com.techies.irecruiter.vo.RequirmentResultVO;
import main.java.com.techies.irecruiter.vo.RequirmentVO;

@Service
public class ProviderService {

	@Autowired
	ProviderDAO providerRegistrationDAO;
	
	@Autowired
	private EmailUtil emailUtil;

	public int createProvider(ProviderVO providerVO) {
		System.out.println("reched providerRegistrationservice");
		JobProviderDetails providerDetails = convertVOToProviderDetails(providerVO);
		int providerId = providerRegistrationDAO.createProviderDetails(providerDetails);

		System.out.println("after createproviderdetails");
		JobProviderContacts providerContacts = convertVOToProviderContacts(providerVO, providerId);
		@SuppressWarnings("unused")
		boolean result = providerRegistrationDAO.createProviderContacts(providerContacts);

		return providerId;
	}

	private JobProviderContacts convertVOToProviderContacts(ProviderVO providerVO, int providerId) {
		System.out.println("reached in converttoprovidercontacts");
		JobProviderContacts providerContacts = new JobProviderContacts();
		providerContacts.setAddress(providerVO.getAddress());
		providerContacts.setProviderID(providerId);
		providerContacts.setDistrict(providerVO.getDistrict());
		providerContacts.setState(providerVO.getState());
		providerContacts.setStreet(providerVO.getStreet());
		providerContacts.setEmail1(providerVO.getEmail1());
		providerContacts.setEmail2(providerVO.getEmail2());
		providerContacts.setPhone1(providerVO.getPhone1());
		providerContacts.setPhone2(providerVO.getPhone2());
		providerContacts.setPin(providerVO.getPin());
		providerContacts.setContactID(providerVO.getContactID());
		return providerContacts;
	}

	private JobProviderDetails convertVOToProviderDetails(ProviderVO providerVO) {
		System.out.println("reached in cnvttoproviderdetails");
		JobProviderDetails providerDetails = new JobProviderDetails();
		providerDetails.setProviderID(providerVO.getProviderID());
		providerDetails.setName(providerVO.getName());
		providerDetails.setCountry(providerVO.getCountry());
		providerDetails.setWebsiteaddr(providerVO.getWebsiteaddr());
		providerDetails.setUsername(providerVO.getUsername());
		return providerDetails;
	}

	public ProviderVO getProviderProfile(int id) {
		System.out.println("reched getProviderProfile Service");
		ProviderAllDetailsDO providerAllDetailsDO = providerRegistrationDAO.getProviderdetails(id);
		ProviderVO providerVO = converDOToproviderVO(providerAllDetailsDO);

		System.out.println("after createproviderdetails");

		return providerVO;
	}

	private ProviderVO converDOToproviderVO(ProviderAllDetailsDO providerAllDetailsDO) {
		ProviderVO providerVO = new ProviderVO();
		providerVO.setProviderID(providerAllDetailsDO.getProviderID());
		providerVO.setName(providerAllDetailsDO.getName());
		providerVO.setAddress(providerAllDetailsDO.getAddress());
		providerVO.setCountry(providerAllDetailsDO.getCountry());
		providerVO.setState(providerAllDetailsDO.getState());
		providerVO.setDistrict(providerAllDetailsDO.getDistrict());
		providerVO.setStreet(providerAllDetailsDO.getStreet());
		providerVO.setEmail1(providerAllDetailsDO.getEmail1());
		providerVO.setEmail2(providerAllDetailsDO.getEmail2());
		providerVO.setUsername(providerAllDetailsDO.getUsername());
		providerVO.setPin(providerAllDetailsDO.getPin());
		providerVO.setPhone1(providerAllDetailsDO.getPhone1());
		providerVO.setPhone2(providerAllDetailsDO.getPhone2());
		providerVO.setWebsiteaddr(providerAllDetailsDO.getWebsiteaddr());
		providerVO.setContactID(providerAllDetailsDO.getContactID());
		return providerVO;
	}

	public void updateProviderProfile(ProviderVO providerVO) {
		int providerId = providerVO.getProviderID();
		JobProviderDetails providerDetails = convertVOToProviderDetails(providerVO);
		providerRegistrationDAO.updateProviderDetails(providerDetails);

		System.out.println("after updateProviderDetails");
		JobProviderContacts providerContacts = convertVOToProviderContacts(providerVO, providerId);
		providerRegistrationDAO.updateProviderContacts(providerContacts);

	}

	public int addRequirment(RequirmentVO requirmentVO) {
		Requirment requirment = convertToRequirment(requirmentVO);
		int requirmentID = providerRegistrationDAO.addRequirment(requirment);

		for (String skill : requirmentVO.getSkillList()) {
			RequirmentSkillset requirmentSkillset = convertToRequirmentSkillset(skill, requirmentVO, requirmentID);
			providerRegistrationDAO.addRequirmentSkillset(requirmentSkillset);
		}
		return requirmentID;

	}

	private RequirmentSkillset convertToRequirmentSkillset(String skill, RequirmentVO requirmentVO, int requirmentID) {
		RequirmentSkillset requirmentSkillset = new RequirmentSkillset();
		boolean flag = skill.isEmpty();
		if (flag == false) {
			try {
				requirmentSkillset.setRequirmentID(requirmentID);
				requirmentSkillset.setProviderID(requirmentVO.getProviderID());
				requirmentSkillset.setSkillList(skill);
			} catch (Exception e) {
				System.out.println("error:" + e.toString());
			}
		}
		return requirmentSkillset;
	}

	private Requirment convertToRequirment(RequirmentVO requirmentVO) {
		Requirment requirment = new Requirment();
		requirment.setRequirmentID(requirmentVO.getRequirmentID());
		requirment.setProviderID(requirmentVO.getProviderID());
		requirment.setJobCategory(requirmentVO.getJobCategory());
		requirment.setJobDescription(requirmentVO.getJobDescription());
		requirment.setJobTitle(requirmentVO.getJobTitle());
		requirment.setMaxExperience(requirmentVO.getMaxExperience());
		requirment.setMinExperience(requirmentVO.getMinExperience());
		return requirment;
	}

	public void addRequirmentLocation(LocationVO locationVO) {
		System.out.println("add requirmentlocation service");
		RequirmentLocation requirmentLocation = convertToRequirmentLocation(locationVO);
		providerRegistrationDAO.addRequirmentLocation(requirmentLocation);

	}

	private RequirmentLocation convertToRequirmentLocation(LocationVO locationVO) {

		RequirmentLocation requirmentLocation = new RequirmentLocation();
		requirmentLocation.setProviderID(locationVO.getProviderID());
		requirmentLocation.setRequirmentID(locationVO.getRequirmentID());
		requirmentLocation.setLocationID(locationVO.getLocationID());
		requirmentLocation.setJobCountry(locationVO.getJobCountry());
		requirmentLocation.setJobDistrict(locationVO.getJobDistrict());
		requirmentLocation.setJobPlace(locationVO.getJobPlace());
		requirmentLocation.setJobState(locationVO.getJobState());
		requirmentLocation.setPIN(locationVO.getPIN());

		return requirmentLocation;
	}

	public void addRequirmentQualification(RequirmentQualificationVO requirmentQualificationVO) {
		String qualification = requirmentQualificationVO.getQualification();
		int requirmentID = requirmentQualificationVO.getRequirmentID();
		int providerId = requirmentQualificationVO.getProviderID();
		RequirmentQualification requirmentQualification = convertToRequirmentQualification(requirmentQualificationVO);
		providerRegistrationDAO.addRequirmentQualification(requirmentQualification);
		/*
		 * List<SeekerSearchDetailsDO> seekerList =
		 * providerRegistrationDAO.getSeekerQualification(qualification);
		 * Requirment requirment =
		 * providerRegistrationDAO.getJobRequirment(requirmentID,providerId);
		 * 
		 * for(int i=0;i<seekerList.size();i++) { SeekerSearchDetailsDO
		 * seekerSearchDetailsDO = (SeekerSearchDetailsDO)seekerList.get(i);
		 * EmailDO emailDO = new EmailDO();
		 * 
		 * emailDO.setUserName("joicekallar@gmail.com");
		 * emailDO.setPassword("joice123");
		 * emailDO.setFrom("joicekallar@gmail.com");
		 * emailDO.setTo(seekerSearchDetailsDO.getSeekerEmail1());
		 * emailDO.setSubject("iRecruiter:New job matches for your profile.");
		 * emailDO.setMessageContent("Job titile:"+requirment.getJobTitle()+
		 * "\n\nJob Description:"+requirment.getJobDescription()+
		 * "...plz visit iRecruiter for more details");
		 * emailUtil.sendEmail(emailDO); }
		 */

	}

	private RequirmentQualification convertToRequirmentQualification(
			RequirmentQualificationVO requirmentQualificationVO) {

		RequirmentQualification requirmentQualification = new RequirmentQualification();
		requirmentQualification.setProviderID(requirmentQualificationVO.getProviderID());
		requirmentQualification.setRequirmentID(requirmentQualificationVO.getRequirmentID());
		requirmentQualification.setQualificationID(requirmentQualificationVO.getQualificationID());
		requirmentQualification.setQualification(requirmentQualificationVO.getQualification());
		requirmentQualification
				.setQualificationSpecilization(requirmentQualificationVO.getQualificationSpecilization());

		return requirmentQualification;
	}

	public RequirmentVO getJobRequirment(int requirmentID, int providerId) {

		System.out.println("reched getJobRequirment Service");

		Requirment requirment = providerRegistrationDAO.getJobRequirment(requirmentID, providerId);
		System.out.println("jobtitle:" + requirment.getJobTitle());
		RequirmentVO requirmentVO = convertRequirmentToVO(requirment);

		return requirmentVO;
	}

	private RequirmentVO convertRequirmentToVO(Requirment requirment) {
		RequirmentVO requirmentVO = new RequirmentVO();
		System.out.println("reched convertRequirmentToVO Service");
		requirmentVO.setRequirmentID(requirment.getRequirmentID());
		requirmentVO.setProviderID(requirment.getProviderID());
		requirmentVO.setJobTitle(requirment.getJobTitle());
		requirmentVO.setJobCategory(requirment.getJobCategory());
		requirmentVO.setJobDescription(requirment.getJobDescription());
		requirmentVO.setMinExperience(requirment.getMinExperience());
		requirmentVO.setMaxExperience(requirment.getMaxExperience());

		return requirmentVO;
	}

	public List<String> getRequirmentSkill(int requirmentID) {
		List<RequirmentSkillset> requirmentSkillsets = providerRegistrationDAO.getRequirmentSkill(requirmentID);
		// SeekerQualificationVO seekerQualificationVO = new
		// SeekerQualificationVO();
		// seekerQualificationVO.setSkill(jobSeekerSkill);
		String skill = null;
		List<String> requirmentSkillsets2 = new ArrayList<String>();
		for (RequirmentSkillset requirmentSkillList : requirmentSkillsets) {
			skill = requirmentSkillList.getSkillList();
			requirmentSkillsets2.add(skill);
		}
		return requirmentSkillsets2;
	}

	public List<LocationVO> getRequirmentLocation(int requirmentID) {
		List<RequirmentLocation> locationList = providerRegistrationDAO.getRequirmentLocation(requirmentID);
		List<LocationVO> locationListVO = convertToVO(locationList);
		return locationListVO;
	}

	private List<LocationVO> convertToVO(List<RequirmentLocation> locationList) {
		List<LocationVO> locationListVO = new ArrayList<LocationVO>();
		System.out.println("reched convertToVO");
		for (RequirmentLocation requirmentLocation : locationList) {
			LocationVO locationVO = new LocationVO();
			locationVO.setProviderID(requirmentLocation.getProviderID());
			locationVO.setRequirmentID(requirmentLocation.getRequirmentID());
			locationVO.setLocationID(requirmentLocation.getLocationID());
			locationVO.setJobPlace(requirmentLocation.getJobPlace());
			locationVO.setJobDistrict(requirmentLocation.getJobDistrict());
			locationVO.setJobState(requirmentLocation.getJobState());
			locationVO.setJobCountry(requirmentLocation.getJobCountry());
			locationVO.setPIN(requirmentLocation.getPIN());
			locationListVO.add(locationVO);
		}
		return locationListVO;

	}

	public List<RequirmentQualificationVO> getRequirmentQualification(int requirmentID) {
		List<RequirmentQualification> qualificationList = providerRegistrationDAO
				.getRequirmentQualification(requirmentID);
		List<RequirmentQualificationVO> qualificationListVO = convertRequirmentQualificationToVO(qualificationList);
		return qualificationListVO;
	}

	private List<RequirmentQualificationVO> convertRequirmentQualificationToVO(
			List<RequirmentQualification> qualificationList) {
		List<RequirmentQualificationVO> qualificationListVO = new ArrayList<RequirmentQualificationVO>();
		System.out.println("reched convertRequirmentQualificationToVO");
		for (RequirmentQualification requirmentQualification : qualificationList) {
			RequirmentQualificationVO qualificationVO = new RequirmentQualificationVO();
			qualificationVO.setProviderID(requirmentQualification.getProviderID());
			qualificationVO.setRequirmentID(requirmentQualification.getRequirmentID());
			qualificationVO.setQualificationID(requirmentQualification.getQualificationID());
			qualificationVO.setQualification(requirmentQualification.getQualification());
			qualificationVO.setQualificationSpecilization(requirmentQualification.getQualificationSpecilization());
			qualificationListVO.add(qualificationVO);
		}
		return qualificationListVO;
	}

	public List<RequirmentResultVO> getAllRequirmentDetails(int id) {
		System.out.println("reched getAllRequirmentDetails Service");
		List<Requirment> requirementList = providerRegistrationDAO.getAllRequirment(id);
		List<RequirmentSkillset> skillList = providerRegistrationDAO.getAllSkill(id);
		String skill = null;
		List<String> requirmentSkillsets2 = new ArrayList<String>();
		for (RequirmentSkillset requirmentSkillList : skillList) {
			skill = requirmentSkillList.getSkillList();
			System.out.println("skill:" + skill);
			requirmentSkillsets2.add(skill);
		}

		List<RequirmentLocation> locationList = providerRegistrationDAO.getAllLocation(id);
		List<RequirmentQualification> qualificationList = providerRegistrationDAO.getAllQualification(id);

		List<RequirmentResultVO> requirmentResultList = convertAllRequirementToVO(requirementList, requirmentSkillsets2,
				locationList, qualificationList);

		return requirmentResultList;
	}

	private List<RequirmentResultVO> convertAllRequirementToVO(List<Requirment> requirementList,
			List<String> requirmentSkillsets2, List<RequirmentLocation> locationList,
			List<RequirmentQualification> qualificationList) {
		List<RequirmentResultVO> listAllRequirments = new ArrayList<RequirmentResultVO>();
		System.out.println("reached in convertAllRequirementToVO");

		for (Requirment requirment : requirementList) {
			for (RequirmentLocation requirmentLocation : locationList) {
				for (RequirmentQualification requirmentQualification : qualificationList) {
					System.out.println(
							"requirment:" + requirment.getRequirmentID() + requirmentQualification.getRequirmentID());
					if (requirment.getRequirmentID() == requirmentQualification.getRequirmentID()
							&& requirment.getRequirmentID() == requirmentLocation.getRequirmentID()) {
						RequirmentResultVO requirmentVO = new RequirmentResultVO();
						requirmentVO.setProviderID(requirment.getProviderID());
						requirmentVO.setRequirmentID(requirment.getRequirmentID());
						requirmentVO.setJobCategory(requirment.getJobCategory());
						System.out.println("jobcategory:" + requirmentVO.getJobCategory());
						requirmentVO.setJobDescription(requirment.getJobDescription());
						requirmentVO.setJobTitle(requirment.getJobTitle());
						requirmentVO.setMaxExperience(requirment.getMaxExperience());
						requirmentVO.setMinExperience(requirment.getMinExperience());
						requirmentVO.setSkill(requirmentSkillsets2);
						requirmentVO.setLocationID(requirmentLocation.getLocationID());
						requirmentVO.setJobPlace(requirmentLocation.getJobPlace());
						requirmentVO.setJobDistrict(requirmentLocation.getJobDistrict());
						requirmentVO.setJobState(requirmentLocation.getJobState());
						requirmentVO.setJobCountry(requirmentLocation.getJobCountry());
						requirmentVO.setQualificationID(requirmentQualification.getQualificationID());
						requirmentVO.setQualification(requirmentQualification.getQualification());
						requirmentVO
								.setQualificationSpecilization(requirmentQualification.getQualificationSpecilization());
						listAllRequirments.add(requirmentVO);
					}

				}

			}

		}
		return listAllRequirments;

	}

	public List<RequirmentVO> getJobRequirments(int id) {
		System.out.println("reched getJobRequirments Service");
		List<Requirment> requirmentList = providerRegistrationDAO.getJobRequirments(id);
		List<RequirmentVO> requirmentListVo = convertRequirementToVO(requirmentList);
		return requirmentListVo;
	}

	private List<RequirmentVO> convertRequirementToVO(List<Requirment> requirmentList) {
		ArrayList<RequirmentVO> requirmentListVo = new ArrayList<RequirmentVO>();
		for (Requirment requirment : requirmentList) {
			RequirmentVO requirmentVO = new RequirmentVO();
			requirmentVO.setRequirmentID(requirment.getRequirmentID());
			requirmentVO.setProviderID(requirment.getProviderID());
			requirmentVO.setJobTitle(requirment.getJobTitle());
			requirmentVO.setJobCategory(requirment.getJobCategory());
			requirmentVO.setJobDescription(requirment.getJobDescription());
			requirmentVO.setMinExperience(requirment.getMinExperience());
			requirmentVO.setMaxExperience(requirment.getMaxExperience());
			requirmentListVo.add(requirmentVO);
		}
		return requirmentListVo;
	}

	public void updateJobRequirment(RequirmentVO requirmentVO) {
		Requirment requirment = convertVOTorequirment(requirmentVO);
		providerRegistrationDAO.updateJobRequirment(requirment);
		System.out.println("update skill null:" + requirmentVO.getSkillList());
		@SuppressWarnings("rawtypes")
		List flag = requirmentVO.getSkillList();
		System.out.println("update skill:" + flag);
		if (flag != null) {
			for (String skill : requirmentVO.getSkillList()) {
				System.out.println("update skill null in loop:" + skill);
				RequirmentSkillset requirmentSkillset = convertVOToSkill(requirmentVO, skill);
				RequirmentSkillset requirmentSkill = providerRegistrationDAO.validateSkill(requirmentSkillset);
				if (requirmentSkill == null) {
					providerRegistrationDAO.updateRequirmentSkill(requirmentSkillset);
				}
			}
		}

	}

	private RequirmentSkillset convertVOToSkill(RequirmentVO requirmentVO, String skill) {
		System.out.println("skill in sevice convet:" + skill);
		RequirmentSkillset requirmentSkillset = new RequirmentSkillset();
		boolean flag = skill.isEmpty();
		if (flag == false) {
			try {
				requirmentSkillset.setSkillList(skill);
				requirmentSkillset.setProviderID(requirmentVO.getProviderID());
				requirmentSkillset.setRequirmentID(requirmentVO.getRequirmentID());
			} catch (Exception e) {
				System.out.println("error:" + e.toString());
			}
		}

		return requirmentSkillset;
	}

	private Requirment convertVOTorequirment(RequirmentVO requirmentVO) {
		System.out.println("reached in convertVOTorequirment");

		Requirment requirment = new Requirment();
		requirment.setJobTitle(requirmentVO.getJobTitle());
		requirment.setJobCategory(requirmentVO.getJobCategory());
		requirment.setJobDescription(requirmentVO.getJobDescription());
		requirment.setMinExperience(requirmentVO.getMaxExperience());
		requirment.setMaxExperience(requirmentVO.getMinExperience());
		requirment.setRequirmentID(requirmentVO.getRequirmentID());
		requirment.setProviderID(requirmentVO.getProviderID());

		return requirment;
	}

	public LocationVO getJobLocation(int locationID) {
		System.out.println("getJobLocation:");
		RequirmentLocation requirmentLocation = providerRegistrationDAO.getJobLocation(locationID);
		LocationVO locationVO = convertLocationToVO(requirmentLocation);
		return locationVO;
	}

	private LocationVO convertLocationToVO(RequirmentLocation requirmentLocation) {
		LocationVO locationVO = new LocationVO();
		System.out.println("reched convertLocationToVO Service");
		locationVO.setRequirmentID(requirmentLocation.getRequirmentID());
		locationVO.setProviderID(requirmentLocation.getProviderID());
		locationVO.setJobPlace(requirmentLocation.getJobPlace());
		locationVO.setJobState(requirmentLocation.getJobState());
		locationVO.setJobCountry(requirmentLocation.getJobCountry());
		locationVO.setJobDistrict(requirmentLocation.getJobDistrict());
		locationVO.setLocationID(requirmentLocation.getLocationID());
		locationVO.setPIN(requirmentLocation.getPIN());

		return locationVO;
	}

	public void updateRequirmentLocation(LocationVO locationVO) {
		RequirmentLocation requirmentLocation = convertVOTorequirmentLocation(locationVO);
		providerRegistrationDAO.updateRequirmentLocation(requirmentLocation);

	}

	private RequirmentLocation convertVOTorequirmentLocation(LocationVO locationVO) {
		System.out.println("reached in convertVOTorequirmentLocation");

		RequirmentLocation requirmentLocation = new RequirmentLocation();
		requirmentLocation.setJobPlace(locationVO.getJobPlace());
		requirmentLocation.setJobDistrict(locationVO.getJobDistrict());
		requirmentLocation.setJobState(locationVO.getJobState());
		requirmentLocation.setJobCountry(locationVO.getJobCountry());
		requirmentLocation.setPIN(locationVO.getPIN());
		requirmentLocation.setRequirmentID(locationVO.getRequirmentID());
		requirmentLocation.setProviderID(locationVO.getProviderID());
		requirmentLocation.setLocationID(locationVO.getLocationID());

		return requirmentLocation;
	}

	public RequirmentQualificationVO getJobQualification(int qualificationID) {
		System.out.println("getJobQualification:");
		RequirmentQualification requirmentQualification = providerRegistrationDAO.getJobQualification(qualificationID);
		RequirmentQualificationVO requirmentQualificationVO = convertQualificationToVO(requirmentQualification);
		return requirmentQualificationVO;
	}

	private RequirmentQualificationVO convertQualificationToVO(RequirmentQualification requirmentQualification) {
		RequirmentQualificationVO requirmentQualificationVO = new RequirmentQualificationVO();

		System.out.println("reched convertQualificationToVO Service");
		requirmentQualificationVO.setQualificationID(requirmentQualification.getQualificationID());
		requirmentQualificationVO.setRequirmentID(requirmentQualification.getRequirmentID());
		requirmentQualificationVO.setProviderID(requirmentQualification.getProviderID());
		requirmentQualificationVO.setQualificationID(requirmentQualification.getQualificationID());
		requirmentQualificationVO.setQualification(requirmentQualification.getQualification());
		requirmentQualificationVO
				.setQualificationSpecilization(requirmentQualification.getQualificationSpecilization());

		return requirmentQualificationVO;
	}

	public void updateRequirmentQualification(RequirmentQualificationVO requirmentQualificationVO) {
		RequirmentQualification requirmentQualification = convertVOTorequirmentqualification(requirmentQualificationVO);
		providerRegistrationDAO.updateRequirmentQualification(requirmentQualification);

	}

	private RequirmentQualification convertVOTorequirmentqualification(
			RequirmentQualificationVO requirmentQualificationVO) {
		System.out.println("reached in convertVOTorequirment");

		RequirmentQualification requirmentQualification = new RequirmentQualification();
		requirmentQualification.setQualification(requirmentQualificationVO.getQualification());
		requirmentQualification
				.setQualificationSpecilization(requirmentQualificationVO.getQualificationSpecilization());
		requirmentQualification.setRequirmentID(requirmentQualificationVO.getRequirmentID());
		requirmentQualification.setProviderID(requirmentQualificationVO.getProviderID());
		requirmentQualification.setQualificationID(requirmentQualificationVO.getQualificationID());

		return requirmentQualification;
	}

	public void deleteRequirmentDetails(int id) {
		List<RequirmentQualification> qualificationList = providerRegistrationDAO.getRequirmentQualification(id);

		if (qualificationList.size() > 0) {
			providerRegistrationDAO.deleteRequirmentQualification(id);
		}
		List<RequirmentLocation> locationList = providerRegistrationDAO.getRequirmentLocation(id);
		if (locationList.size() > 0) {
			providerRegistrationDAO.deleteRequirmentLocation(id);
		}
		List<RequirmentSkillset> skillList = providerRegistrationDAO.getRequirmentSkill(id);
		if (skillList.size() > 0) {
			providerRegistrationDAO.deleteRequirmentSkillset(id);
		}

		providerRegistrationDAO.deleteProviderRequirment(id);

	}

	/*
	 * public List<RequirmentResultVO> getAllRequirmentDetails(int id) {
	 * System.out.println("reched getAllRequirmentDetails Service");
	 * List<RequirementResultDO> requirementResultDO =
	 * providerRegistrationDAO.getAllRequirmentDetails(id);
	 * List<RequirmentResultVO> requirmentResultListVO =
	 * convertRequirementResultDOToVO(requirementResultDO); return
	 * requirmentResultListVO; }
	 * 
	 * private List<RequirmentResultVO>
	 * convertRequirementResultDOToVO(List<RequirementResultDO>
	 * requirementResultDO) { ArrayList<RequirmentResultVO>
	 * requirmentResultListVO = new ArrayList<RequirmentResultVO>();
	 * for(RequirementResultDO requirmentResult:requirementResultDO) {
	 * RequirmentResultVO requirmentResultVO = new RequirmentResultVO();
	 * requirmentResultVO.setRequirmentID(requirmentResult.getRequirmentID());
	 * requirmentResultVO.setProviderID(requirmentResult.getProviderID());
	 * requirmentResultVO.setJobTitle(requirmentResult.getJobTitle());
	 * requirmentResultVO.setJobCategory(requirmentResult.getJobCategory());
	 * requirmentResultVO.setJobDescription(requirmentResult.getJobDescription()
	 * );
	 * requirmentResultVO.setMinExperience(requirmentResult.getMinExperience());
	 * requirmentResultVO.setMaxExperience(requirmentResult.getMaxExperience());
	 * for(RequirementResultDO requirementSkill:requirementResultDO){
	 * requirmentResultVO.setSkill(requirementSkill.getSkill());
	 * requirmentResultListVO.add(requirmentResultVO); } System.out.println(
	 * "skill in convert:"+requirmentResultVO.getSkill());
	 * requirmentResultVO.setJobPlace(requirmentResult.getJobPlace());
	 * System.out.println("jobplace in convert:"
	 * +requirmentResultVO.getJobPlace());
	 * requirmentResultVO.setJobDistrict(requirmentResult.getJobDistrict());
	 * requirmentResultVO.setJobState(requirmentResult.getJobState());
	 * requirmentResultVO.setJobCountry(requirmentResult.getJobCountry());
	 * requirmentResultVO.setPIN(requirmentResult.getPIN());
	 * requirmentResultVO.setQualificationID(requirmentResult.getQualificationID
	 * ());
	 * requirmentResultVO.setQualification(requirmentResult.getQualification());
	 * System.out.println("qualification in convert:"
	 * +requirmentResultVO.getQualification());
	 * requirmentResultVO.setQualificationSpecilization(requirmentResult.
	 * getQualificationSpecilization());
	 * requirmentResultListVO.add(requirmentResultVO); } return
	 * requirmentResultListVO; }
	 */

}
