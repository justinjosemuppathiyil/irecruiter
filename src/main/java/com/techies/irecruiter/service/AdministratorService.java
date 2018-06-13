package main.java.com.techies.irecruiter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.techies.irecruiter.dataaccess.AdministratorDAO;
import main.java.com.techies.irecruiter.dataobject.ProviderAllDetailsDO;
import main.java.com.techies.irecruiter.domain.OnlineTestOption;
import main.java.com.techies.irecruiter.domain.OnlineTestQuestion;
import main.java.com.techies.irecruiter.domain.Requirment;
import main.java.com.techies.irecruiter.domain.RequirmentLocation;
import main.java.com.techies.irecruiter.domain.RequirmentQualification;
import main.java.com.techies.irecruiter.domain.RequirmentSkillset;
import main.java.com.techies.irecruiter.vo.ProviderVO;

@Service
public class AdministratorService {
	@Autowired
	AdministratorDAO administratorDAO;

	public List<ProviderVO> getAllProviderDeatils() {

		System.out.println("reched getAllProviderDeatils Service");
		List<ProviderAllDetailsDO> providerDetailsDOList = administratorDAO.getProviderdetails();
		List<ProviderVO> providerVOList = converDOToproviderVO(providerDetailsDOList);

		System.out.println("after createproviderdetails");

		return providerVOList;
	}

	private List<ProviderVO> converDOToproviderVO(List<ProviderAllDetailsDO> providerDetailsDOList) {
		List<ProviderVO> providerVOList = new ArrayList<ProviderVO>();
		System.out.println("reched convertToVO");
		for (ProviderAllDetailsDO providerAllDetailsDO : providerDetailsDOList) {
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
			providerVOList.add(providerVO);

		}

		return providerVOList;

	}

	public ProviderVO getProviderProfile(int id) {
		System.out.println("reched getProviderProfile Service");
		ProviderAllDetailsDO providerAllDetailsDO = administratorDAO.getProviderdetails(id);
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

	public void deleteProviderProfile(int id) {
		List<OnlineTestOption> optionList = administratorDAO.getOptions(id);
		if (optionList.size() > 0) {
			administratorDAO.deleteonlinetestOptions(id);
		}
		List<OnlineTestQuestion> questionList = administratorDAO.getQuestions(id);
		if (questionList.size() > 0) {
			administratorDAO.deleteonlinetestQuestion(id);
		}

		List<RequirmentQualification> qualificationList = administratorDAO.getQualification(id);

		if (qualificationList.size() > 0) {
			administratorDAO.deleteProviderRequirmentQualification(id);
		}
		List<RequirmentLocation> locationList = administratorDAO.getlocation(id);
		if (locationList.size() > 0) {
			administratorDAO.deleteProviderRequirmentLocation(id);
		}
		List<RequirmentSkillset> skillList = administratorDAO.getskill(id);
		if (skillList.size() > 0) {
			administratorDAO.deleteProviderRequirmentSkillset(id);
		}
		List<Requirment> requirmentList = administratorDAO.getrequirment(id);
		if (requirmentList.size() > 0) {
			administratorDAO.deleteProviderRequirment(id);
		}
		ProviderAllDetailsDO providerAllDetailsDO = administratorDAO.getProviderdetails(id);
		ProviderVO providerVO = converDOToproviderVO(providerAllDetailsDO);
		System.out.println("username:" + providerVO.getUsername());
		String userId = providerVO.getUsername();
		administratorDAO.deleteProviderContacts(id);
		administratorDAO.deleteProviderDetails(id);
		administratorDAO.deleteProviderLogin(userId);
	}

}
