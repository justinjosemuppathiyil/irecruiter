package main.java.com.techies.irecruiter.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.techies.irecruiter.dataaccess.SearchDAO;
import main.java.com.techies.irecruiter.dataobject.RequirementResultDO;
import main.java.com.techies.irecruiter.dataobject.SearchDO;
import main.java.com.techies.irecruiter.dataobject.SeekerSearchDetailsDO;
import main.java.com.techies.irecruiter.vo.RequirmentResultVO;
import main.java.com.techies.irecruiter.vo.SearchVO;
import main.java.com.techies.irecruiter.vo.SeekerAllDetailsVO;
@Service
public class SearchService {
	@Autowired
	SearchDAO searchDAO;
	public List<RequirmentResultVO> searchRequirment(SearchVO searchVO) {
		System.out.println("Inside seekerSearch @ service");
		SearchDO searchDO = convertToSearchDO(searchVO);
		List<RequirementResultDO> searchListDO = searchDAO.searchRequirment(searchDO); 
		for(RequirementResultDO requirementResultDO : searchListDO)
		{
			System.out.println("Qualif : "+requirementResultDO.getRequirmentID()+requirementResultDO.getQualification());
		}
		System.out.println("back from DAO");
		List<RequirmentResultVO>searchResultListVO = convertRequirmentDOToVO(searchListDO);
		RequirmentResultVO requirmentResultVO = new RequirmentResultVO();
		System.out.println("*****QualifVO : "+requirmentResultVO.getRequirmentID()+requirmentResultVO.getQualification());

		return searchResultListVO;
	}

	private List<RequirmentResultVO> convertRequirmentDOToVO(List<RequirementResultDO> searchListDO) {
		
		System.out.println("Inside seekerSearch @ service convert func");
		
		List<RequirmentResultVO> searchResultListVO = new ArrayList<RequirmentResultVO>();
		Map<Integer,RequirmentResultVO> requirmentMap = new HashMap<Integer, RequirmentResultVO>();
		Map<Integer, List<String>>skillMap = new HashMap<Integer, List<String>>();
		Map<Integer, List<String>>locationMap = new HashMap<Integer, List<String>>();
		Map<Integer, List<String>>qualificationMap = new HashMap<Integer, List<String>>();
		List<Integer> requirmentIDList = new ArrayList<Integer>();
		if(searchListDO!=null&&searchListDO.size()>0)
		{
			for(RequirementResultDO requirementResultDO:searchListDO)
			{
				int requirmentID=requirementResultDO.getRequirmentID();
				String skill = requirementResultDO.getSkill();
				String location = requirementResultDO.getJobPlace();
				String qualification = requirementResultDO.getQualification();
				System.out.println("qualification***"+qualification);
				if(! requirmentIDList.contains(requirmentID))
				{
					RequirmentResultVO requirmentResultVO = new RequirmentResultVO();
					requirmentResultVO.setRequirmentID(requirementResultDO.getRequirmentID());
					requirmentResultVO.setProviderID(requirementResultDO.getProviderID());
					requirmentResultVO.setJobTitle(requirementResultDO.getJobTitle());
					requirmentResultVO.setJobCategory(requirementResultDO.getJobCategory());
					requirmentResultVO.setJobDescription(requirementResultDO.getJobDescription());
					requirmentResultVO.setMinExperience(requirementResultDO.getMinExperience());
					requirmentResultVO.setMaxExperience(requirementResultDO.getMaxExperience());
					requirmentMap.put(requirmentID, requirmentResultVO);
					requirmentIDList.add(requirmentID);
				}
				if(skillMap.get(requirmentID)!=null)
				{
					List<String>skillList = skillMap.get(requirmentID);
					if(!skillList.contains(skill))
					{
						skillList.add(skill);
						skillMap.put(requirmentID, skillList);
					}
				}
				else{
					List<String>skillList = new ArrayList<String>();
					skillList.add(skill);
					skillMap.put(requirmentID, skillList);
				}
				
				if(locationMap.get(requirmentID)!=null)
				{
					List<String>locationList = locationMap.get(requirmentID);
					if(!locationList.contains(location)){
						locationList.add(location);
						locationMap.put(requirmentID, locationList);
				
					}
				}
				else{
					List<String>locationList = new ArrayList<String>();
					locationList.add(location);
					locationMap.put(requirmentID, locationList);
				}
				if(qualificationMap.get(requirmentID)!=null)
				{
					List<String> qualificationList = qualificationMap.get(requirmentID);
					if(!qualificationList.contains(qualification))
					{
						System.out.println("qualificationMap inside ! if");
						qualificationList.add(qualification);
						qualificationMap.put(requirmentID, qualificationList);
					}
						
				}
				else{
					System.out.println("qualificationMap inside else");
					List<String>qualificationList = new ArrayList<String>();
					qualificationList.add(qualification);
					qualificationMap.put(requirmentID, qualificationList);
				}
				
			}
			for(Integer reqID:requirmentIDList)
			{
				RequirmentResultVO requirmentResultVO = requirmentMap.get(reqID);
				List<String> skillList=new ArrayList<String>();
				List<String> locationList=new ArrayList<String>();
				List<String> qualificationList=new ArrayList<String>();
				StringBuffer skills = new StringBuffer();
				StringBuffer locations = new StringBuffer();
				StringBuffer qualifications = new StringBuffer();
				
				skillList = skillMap.get(reqID);
				for(String skill:skillList)
				{
					skills.append(skill);
					skills.append(",");
					
				}
				requirmentResultVO.setSkillstr(skills.toString());
				System.out.println("skill:"+requirmentResultVO.getSkillstr());
				
				locationList = locationMap.get(reqID);
				for(String location:locationList)
				{
					locations.append(location);
					locations.append(",");
				}
				requirmentResultVO.setJobPlace(locations.toString());
				
				qualificationList = qualificationMap.get(reqID);
				for(String qualification:qualificationList)
				{
					qualifications.append(qualification);
					qualifications.append(",");
				}
				requirmentResultVO.setQualification(qualifications.toString());
				searchResultListVO.add(requirmentResultVO);	
			}
		}
		return searchResultListVO;
	}

	private SearchDO convertToSearchDO(SearchVO searchVO) {
		SearchDO searchDO = new SearchDO();
		searchDO.setJobCategory(searchVO.getJobCategory());
		searchDO.setCity(searchVO.getCity());
		searchDO.setSkill(searchVO.getSkill());
		searchDO.setQualification(searchVO.getQualification());
		searchDO.setQualificationSpecilization(searchVO.getQualificationSpecilization());
		searchDO.setExperience(searchVO.getExperience());
		
		return searchDO;
	}

	public List<SeekerAllDetailsVO> searchSeeker(SearchVO searchVO) {
		System.out.println("Inside searchSeeker @ service");
		SearchDO searchDO = convertToSearchDO(searchVO);
		List<SeekerSearchDetailsDO> seekerSearchListDO = searchDAO.searchSeeker(searchDO);
		List<SeekerAllDetailsVO> seekerSearchListVO = convertSeekerDOToVO(seekerSearchListDO);
		return seekerSearchListVO;
	}

	private List<SeekerAllDetailsVO> convertSeekerDOToVO(List<SeekerSearchDetailsDO> seekerSearchListDO) {
		System.out.println("Inside SearchSeeker @ service convert func");
		Map<Integer, SeekerAllDetailsVO> seekerDetailsMap = new HashMap<Integer, SeekerAllDetailsVO>();
		Map<Integer, List<String>> skillMap = new HashMap<Integer, List<String>>();
		List<SeekerAllDetailsVO> seekerSearchListVO = new ArrayList<SeekerAllDetailsVO>();
		List<Integer> seekerIDList = new ArrayList<Integer>();
		if(seekerSearchListDO!=null&&seekerSearchListDO.size()>0)
		{
			for(SeekerSearchDetailsDO seekerSearchDetailsDO:seekerSearchListDO)
			{
				int seekerID = seekerSearchDetailsDO.getSeekerID();
				String skill = seekerSearchDetailsDO.getSkill();
				if(!seekerIDList.contains(seekerID))
				{
					SeekerAllDetailsVO seekerAllDetailsVO = new SeekerAllDetailsVO();
					seekerAllDetailsVO.setSeekerID(seekerSearchDetailsDO.getSeekerID());
					seekerAllDetailsVO.setSeekerName(seekerSearchDetailsDO.getSeekerName());
					seekerAllDetailsVO.setSeekerAddress(seekerSearchDetailsDO.getSeekerAddress());
					seekerAllDetailsVO.setSeekerCountry(seekerSearchDetailsDO.getSeekerCountry());
					seekerAllDetailsVO.setSeekerState(seekerSearchDetailsDO.getSeekerState());
					seekerAllDetailsVO.setSeekerDistrict(seekerSearchDetailsDO.getSeekerDistrict());
					seekerAllDetailsVO.setSeekerStreet(seekerSearchDetailsDO.getSeekerStreet());
					seekerAllDetailsVO.setSeekerEmail1(seekerSearchDetailsDO.getSeekerEmail1());
					seekerAllDetailsVO.setSeekerEmail2(seekerSearchDetailsDO.getSeekerEmail2());
					seekerAllDetailsVO.setSeekerPIN(seekerSearchDetailsDO.getSeekerPIN());
					seekerAllDetailsVO.setSeekerPhone1(seekerSearchDetailsDO.getSeekerPhone1());
					seekerAllDetailsVO.setSeekerPhone2(seekerSearchDetailsDO.getSeekerPhone2());
					seekerAllDetailsVO.setSeekerGender(seekerSearchDetailsDO.getSeekerGender());
					seekerAllDetailsVO.setCourseName(seekerSearchDetailsDO.getCourseName());
					seekerAllDetailsVO.setSpecilization(seekerSearchDetailsDO.getSpecilization());
					seekerAllDetailsVO.setPassYear(seekerSearchDetailsDO.getPassYear());
					seekerAllDetailsVO.setGpa(seekerSearchDetailsDO.getGpa());
					seekerAllDetailsVO.setInstitute(seekerSearchDetailsDO.getInstitute());
					seekerAllDetailsVO.setExperience(seekerSearchDetailsDO.getExperience());
					seekerDetailsMap.put(seekerID, seekerAllDetailsVO);
					seekerIDList.add(seekerID);
				}
				if(skillMap.get(seekerID)!=null)
				{
					List<String>skillList = skillMap.get(seekerID);
					if(!skillList.contains(skill))
					{
						skillList.add(skill);
						skillMap.put(seekerID, skillList);
					}
				}
				else{
					List<String>skillList = new ArrayList<String>();
					skillList.add(skill);
					skillMap.put(seekerID, skillList);
				}
			}
			
			for(Integer seekerID:seekerIDList)
			{
				SeekerAllDetailsVO seekerAllDetailsVO = seekerDetailsMap.get(seekerID);
				List<String> skillList = new ArrayList<String>();
				skillList = skillMap.get(seekerID);
				StringBuffer skills = new StringBuffer();
				
				for(String skill:skillList)
				{
					skills.append(skill);
					skills.append(",");
				}
				seekerAllDetailsVO.setSkill(skills.toString());
				seekerSearchListVO.add(seekerAllDetailsVO);
				skillList=new ArrayList<String>();
			}
			
		}
		
		return seekerSearchListVO;
	}

}
