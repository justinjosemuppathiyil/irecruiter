package main.java.com.techies.irecruiter.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.techies.irecruiter.dataobject.RequirementResultDO;
import main.java.com.techies.irecruiter.dataobject.SearchDO;
import main.java.com.techies.irecruiter.dataobject.SeekerSearchDetailsDO;

@Repository
public class SearchDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes" })
	public List<RequirementResultDO> searchRequirment(SearchDO searchDO) {
		List<RequirementResultDO> searchResultList = new ArrayList<RequirementResultDO>();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getSearchDetails = new StringBuffer();
			getSearchDetails.append("SELECT ");
			getSearchDetails.append("r.provider_id,r.requirment_id,r.job_title,r.job_catogory,r.job_description,r.min_experience,r.max_experience,");
			getSearchDetails.append("l.place,l.district,l.state,l.country,l.PIN,");
			getSearchDetails.append("s.skill,");
			getSearchDetails.append("q.qualification_id,q.qualification,q.specilization");
			getSearchDetails.append(" FROM ");
			getSearchDetails.append("job_requirments r,");
			getSearchDetails.append("job_requirments_location l,");
			getSearchDetails.append("job_requirments_skillset s,");
			getSearchDetails.append("job_requirments_qualification q");
			
			StringBuffer selectCondition = new StringBuffer();
			if(searchDO.getCity()!=null&&searchDO.getCity().trim().length()>0){
				selectCondition.append(" l.place = '");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("' OR ");
				selectCondition.append("l.district='");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("' OR ");
				selectCondition.append("l.state='");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0)
			{
				getSearchDetails.append(" WHERE ");
				getSearchDetails.append(selectCondition.toString());
				selectCondition = new StringBuffer();
			}
			if(searchDO.getJobCategory()!=null&&searchDO.getJobCategory().trim().length()>0){
				selectCondition.append(" r.job_catogory = '");
				selectCondition.append(searchDO.getJobCategory());
				selectCondition.append("' OR ");
				selectCondition.append("r.job_title='");
				selectCondition.append(searchDO.getJobCategory());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchDetails.toString().indexOf("WHERE")>0){
					getSearchDetails.append(" AND ");
					getSearchDetails.append(selectCondition.toString());
				}else{
					getSearchDetails.append(" WHERE ");
					getSearchDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			if(searchDO.getQualification()!=null&&searchDO.getQualification().trim().length()>0){
				selectCondition.append(" q.qualification = '");
				selectCondition.append(searchDO.getQualification());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchDetails.toString().indexOf("WHERE")>0){
					getSearchDetails.append(" AND ");
					getSearchDetails.append(selectCondition.toString());
				}else{
					getSearchDetails.append(" WHERE ");
					getSearchDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			if(searchDO.getQualificationSpecilization()!=null&&searchDO.getQualificationSpecilization().trim().length()>0){
				selectCondition.append(" q.specilization = '");
				selectCondition.append(searchDO.getQualificationSpecilization());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchDetails.toString().indexOf("WHERE")>0){
					getSearchDetails.append(" AND ");
					getSearchDetails.append(selectCondition.toString());
				}else{
					getSearchDetails.append(" WHERE ");
					getSearchDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			if(searchDO.getSkill()!=null&&searchDO.getSkill().trim().length()>0){
				selectCondition.append(" s.skill = '");
				selectCondition.append(searchDO.getSkill());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchDetails.toString().indexOf("WHERE")>0){
					getSearchDetails.append(" AND ");
					getSearchDetails.append(selectCondition.toString());
				}else{
					getSearchDetails.append(" WHERE ");
					getSearchDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			getSearchDetails.append(" AND ");
			getSearchDetails.append("r.requirment_id=l.requirment_id");
			getSearchDetails.append(" AND ");
			getSearchDetails.append("l.requirment_id=s.requirment_id");
			getSearchDetails.append(" AND ");
			getSearchDetails.append("s.requirment_id=q.requirment_id");
			getSearchDetails.append(" AND ");
			getSearchDetails.append("r.requirment_id=s.requirment_id");
			getSearchDetails.append(" AND ");
			getSearchDetails.append("r.requirment_id=q.requirment_id");
			getSearchDetails.append(" AND ");
			getSearchDetails.append("l.requirment_id=q.requirment_id");
			
			SQLQuery query=session.createSQLQuery(getSearchDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data = query.list();
			System.out.println("Inside seekerSearch @ DAO, List size : "+data.size());
			for(Object object:data)
			{
				Map row = (Map) object;
				RequirementResultDO requirementResultDO = new RequirementResultDO();
				requirementResultDO.setRequirmentID((Integer.parseInt(row.get("requirment_id").toString())));
				requirementResultDO.setProviderID((Integer.parseInt(row.get("provider_id").toString())));
				requirementResultDO.setJobCategory(row.get("job_catogory").toString());
				requirementResultDO.setJobCountry(row.get("country").toString());
				requirementResultDO.setJobDescription(row.get("job_description").toString());
				requirementResultDO.setJobDistrict(row.get("district").toString());
				requirementResultDO.setJobPlace(row.get("place").toString());
				requirementResultDO.setJobState(row.get("state").toString());
				requirementResultDO.setJobTitle(row.get("job_title").toString());
				requirementResultDO.setMaxExperience(Integer.parseInt(row.get("max_experience").toString()));
				requirementResultDO.setMinExperience(Integer.parseInt(row.get("min_experience").toString()));
				requirementResultDO.setPIN(row.get("PIN").toString());
				requirementResultDO.setQualification(row.get("qualification").toString());
				requirementResultDO.setQualificationSpecilization(row.get("specilization").toString());
				requirementResultDO.setSkill(row.get("skill").toString());
				searchResultList.add(requirementResultDO);
			}
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("error in searchRequirment"+e.toString());
		}
		return searchResultList;
	}

	public List<SeekerSearchDetailsDO> searchSeeker(SearchDO searchDO) {
		List<SeekerSearchDetailsDO> searchSeekerResult = new ArrayList<SeekerSearchDetailsDO>();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getSearchSeekerDetails = new StringBuffer();
			getSearchSeekerDetails.append("SELECT ");
			getSearchSeekerDetails.append("d.seeker_id,d.seeker_name,d.seeker_gender,");
			getSearchSeekerDetails.append("c.seeker_registred_address,c.seeker_street,c.seeker_district,c.seeker_state,c.seeker_country,c.seeker_pincode,c.seeker_email1,c.seeker_email2,c.seeker_phone1,c.seeker_phone2,");
			getSearchSeekerDetails.append("s.skill,");
			getSearchSeekerDetails.append("q.qualification,q.specilization,q.year_of_pass,q.institute,q.gpa,");
			getSearchSeekerDetails.append("e.experience");
			getSearchSeekerDetails.append(" FROM ");
			getSearchSeekerDetails.append("job_seeker_details d,");
			getSearchSeekerDetails.append("job_seeker_contact c,");
			getSearchSeekerDetails.append("job_seeker_skillset s,");
			getSearchSeekerDetails.append("job_seeker_experience e,");
			getSearchSeekerDetails.append("job_seeker_qualification q");
			StringBuffer selectCondition = new StringBuffer();
			if(searchDO.getCity()!=null&&searchDO.getCity().trim().length()>0){
				selectCondition.append(" c.seeker_street= '");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("' OR ");
				selectCondition.append("c.seeker_district='");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("' OR ");
				selectCondition.append("c.seeker_state='");
				selectCondition.append(searchDO.getCity());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0)
			{
				getSearchSeekerDetails.append(" WHERE ");
				getSearchSeekerDetails.append(selectCondition.toString());
				selectCondition = new StringBuffer();
			}
			if(searchDO.getExperience()!=null&&searchDO.getExperience().trim().length()>0){
				selectCondition.append(" e.experience = '");
				selectCondition.append(searchDO.getExperience());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchSeekerDetails.toString().indexOf("WHERE")>0){
					getSearchSeekerDetails.append(" AND ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}else{
					getSearchSeekerDetails.append(" WHERE ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			if(searchDO.getQualification()!=null&&searchDO.getQualification().trim().length()>0){
				selectCondition.append(" q.qualification = '");
				selectCondition.append(searchDO.getQualification());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchSeekerDetails.toString().indexOf("WHERE")>0){
					getSearchSeekerDetails.append(" AND ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}else{
					getSearchSeekerDetails.append(" WHERE ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			if(searchDO.getSkill()!=null&&searchDO.getSkill().trim().length()>0){
				selectCondition.append(" s.skill = '");
				selectCondition.append(searchDO.getSkill());
				selectCondition.append("'");
			}
			if(selectCondition.toString().trim().length()>0){
				if(getSearchSeekerDetails.toString().indexOf("WHERE")>0){
					getSearchSeekerDetails.append(" AND ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}else{
					getSearchSeekerDetails.append(" WHERE ");
					getSearchSeekerDetails.append(selectCondition.toString());
				}
				selectCondition = new StringBuffer();
			}
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=c.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=q.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=s.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=e.seeker_id");
			
			SQLQuery query=session.createSQLQuery(getSearchSeekerDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			System.out.println("Inside seekerSearch @ DAO, List size : "+data.size());
			for(Object object:data)
			{
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				SeekerSearchDetailsDO seekerSearchDetailsDO = new SeekerSearchDetailsDO();
				seekerSearchDetailsDO.setSeekerID((Integer.parseInt(row.get("seeker_id").toString())));
				seekerSearchDetailsDO.setSeekerAddress(row.get("seeker_registred_address").toString());
				seekerSearchDetailsDO.setSeekerCountry(row.get("seeker_country").toString());
				seekerSearchDetailsDO.setSeekerDistrict(row.get("seeker_district").toString());
				seekerSearchDetailsDO.setSeekerEmail1(row.get("seeker_email1").toString());
				seekerSearchDetailsDO.setSeekerEmail2(row.get("seeker_email2").toString());
				seekerSearchDetailsDO.setSeekerGender(row.get("seeker_gender").toString());
				seekerSearchDetailsDO.setSeekerName(row.get("seeker_name").toString());
				seekerSearchDetailsDO.setSeekerPhone1(row.get("seeker_phone1").toString());
				seekerSearchDetailsDO.setSeekerPhone2(row.get("seeker_phone2").toString());
				seekerSearchDetailsDO.setSeekerPIN(row.get("seeker_pincode").toString());
				seekerSearchDetailsDO.setSeekerState(row.get("seeker_state").toString());
				seekerSearchDetailsDO.setSeekerStreet(row.get("seeker_street").toString());
				seekerSearchDetailsDO.setCourseName(row.get("qualification").toString());
				seekerSearchDetailsDO.setExperience(row.get("experience").toString());
				seekerSearchDetailsDO.setGpa(row.get("gpa").toString());
				seekerSearchDetailsDO.setInstitute(row.get("institute").toString());
				seekerSearchDetailsDO.setPassYear(row.get("year_of_pass").toString());
				seekerSearchDetailsDO.setSkill(row.get("skill").toString());
				searchSeekerResult.add(seekerSearchDetailsDO);
			}
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("error in searchRequirment"+e.toString());
		}
		return searchSeekerResult;
			
	}

}
