package main.java.com.techies.irecruiter.dataaccess;

import java.io.Serializable;
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

import main.java.com.techies.irecruiter.dataobject.ProviderAllDetailsDO;
import main.java.com.techies.irecruiter.dataobject.SeekerSearchDetailsDO;
import main.java.com.techies.irecruiter.domain.JobProviderContacts;
import main.java.com.techies.irecruiter.domain.JobProviderDetails;
import main.java.com.techies.irecruiter.domain.JobSeekerSkill;
import main.java.com.techies.irecruiter.domain.Requirment;
import main.java.com.techies.irecruiter.domain.RequirmentLocation;
import main.java.com.techies.irecruiter.domain.RequirmentQualification;
import main.java.com.techies.irecruiter.domain.RequirmentSkillset;

@Repository
public class ProviderDAO {
	@Autowired
	SessionFactory sessionFactory;

	public int createProviderDetails(JobProviderDetails providerDetails) {
		System.out.println("reached in createproviderdetailsDAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(providerDetails);
		tx.commit();
		Serializable id = session.getIdentifier(providerDetails);
		session.close();
		return (Integer) id;

	}

	public boolean createProviderContacts(JobProviderContacts providerContacts) {
		System.out.println("createprovidercontactsDAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(providerContacts);
		tx.commit();
		return true;

	}

	public ProviderAllDetailsDO getProviderdetails(int id) {
		ProviderAllDetailsDO providerAllDetailsDO = new ProviderAllDetailsDO();
		try {
			System.out.println("getProviderdetailsDAO");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getProviderDetails = new StringBuffer();
			getProviderDetails.append("SELECT ");
			getProviderDetails.append("d.provider_id,d.provider_name,d.provider_country,d.provider_website,d.user_id,");
			getProviderDetails.append(
					"c.contact_id,c.provider_registred_address,c.provider_street,c.provider_state,c.provider_district,c.provider_pincode,c.provider_email1,c.provider_email2,c.provider_phone1,c.provider_phone2");
			getProviderDetails.append(" FROM ");
			getProviderDetails.append("job_provider_details d,");
			getProviderDetails.append("job_provider_contact c");
			getProviderDetails.append(" WHERE ");
			getProviderDetails.append("d.provider_id=");
			getProviderDetails.append(id);
			getProviderDetails.append(" AND ");
			getProviderDetails.append("c.provider_id=");
			getProviderDetails.append(id);
			getProviderDetails.append(" AND ");
			getProviderDetails.append("c.provider_id=d.provider_id");
			SQLQuery query = session.createSQLQuery(getProviderDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			for (Object object : data) {
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				providerAllDetailsDO.setProviderID(Integer.parseInt(row.get("provider_id").toString()));
				providerAllDetailsDO.setName(row.get("provider_name").toString());
				providerAllDetailsDO.setUsername(row.get("user_id").toString());
				providerAllDetailsDO.setAddress(row.get("provider_registred_address").toString());
				providerAllDetailsDO.setStreet(row.get("provider_street").toString());
				providerAllDetailsDO.setState(row.get("provider_state").toString());
				providerAllDetailsDO.setDistrict(row.get("provider_district").toString());
				providerAllDetailsDO.setCountry(row.get("provider_country").toString());
				providerAllDetailsDO.setWebsiteaddr(row.get("provider_website").toString());
				providerAllDetailsDO.setEmail1(row.get("provider_email1").toString());
				providerAllDetailsDO.setEmail2(row.get("provider_email2").toString());
				providerAllDetailsDO.setPhone1(row.get("provider_phone1").toString());
				providerAllDetailsDO.setPhone2(row.get("provider_phone2").toString());
				providerAllDetailsDO.setPin(row.get("provider_pincode").toString());
				providerAllDetailsDO.setContactID(Integer.parseInt(row.get("contact_id").toString()));

			}
			tx.commit();

		} catch (Exception e) {
			System.out.println("error:" + e.toString());
		}
		return providerAllDetailsDO;
	}

	public void updateProviderDetails(JobProviderDetails providerDetails) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(providerDetails);
		tx.commit();
	}

	public void updateProviderContacts(JobProviderContacts providerContacts) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(providerContacts);
		tx.commit();

	}

	public int addRequirment(Requirment requirment) {
		System.out.println("reached in addRequirmentDAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(requirment);
		tx.commit();
		Serializable id = session.getIdentifier(requirment);
		session.close();
		return (Integer) id;

	}

	public void addRequirmentSkillset(RequirmentSkillset requirmentSkillset) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(requirmentSkillset);
		tx.commit();

	}

	public void addRequirmentLocation(RequirmentLocation requirmentLocation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(requirmentLocation);
		tx.commit();

	}

	public void addRequirmentQualification(RequirmentQualification requirmentQualification) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(requirmentQualification);
		tx.commit();

	}

	public Requirment getJobRequirment(int requirmentID, int providerId) {
		Requirment requirment = new Requirment();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getRequirment = new StringBuffer();
			getRequirment.append("SELECT * FROM ");
			getRequirment.append("job_requirments");
			getRequirment.append(" WHERE ");
			getRequirment.append("requirment_id=");
			getRequirment.append(requirmentID);
			getRequirment.append(" AND ");
			getRequirment.append("provider_id=");
			getRequirment.append(providerId);
			SQLQuery query = session.createSQLQuery(getRequirment.toString());
			query.addEntity(Requirment.class);
			requirment = (Requirment) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getJobRequirment" + e.toString());
		}
		return requirment;

	}

	@SuppressWarnings("unchecked")
	public List<RequirmentSkillset> getRequirmentSkill(int requirmentID) {
		List<RequirmentSkillset> requirmentSkillsets = new ArrayList<RequirmentSkillset>();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSkill = new StringBuffer();
			getSkill.append("SELECT * FROM ");
			getSkill.append("job_requirments_skillset");
			getSkill.append(" WHERE ");
			getSkill.append("requirment_id=");
			getSkill.append(requirmentID);
			SQLQuery query = session.createSQLQuery(getSkill.toString());
			query.addEntity(RequirmentSkillset.class);
			requirmentSkillsets = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getSeekerSkill" + e.toString());
		}
		return requirmentSkillsets;
	}

	@SuppressWarnings("unchecked")
	public List<RequirmentLocation> getRequirmentLocation(int requirmentID) {
		System.out.println("reached getRequirmentLocation");

		List<RequirmentLocation> locationList = new ArrayList<RequirmentLocation>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getLocation = new StringBuffer();
			getLocation.append("SELECT * FROM ");
			getLocation.append("job_requirments_location");
			getLocation.append(" WHERE ");
			getLocation.append("requirment_id = ");
			getLocation.append(requirmentID);
			SQLQuery query = session.createSQLQuery(getLocation.toString());
			query.addEntity(RequirmentLocation.class);
			locationList = query.list();
			tx.commit();
		} catch (Exception e) {

			System.out.println("error in getRequirmentLocation" + e.toString());
		}

		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<RequirmentQualification> getRequirmentQualification(int requirmentID) {
		System.out.println("reached getRequirmentQualificationDAO");

		List<RequirmentQualification> qualificationList = new ArrayList<RequirmentQualification>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getQualification = new StringBuffer();
			getQualification.append("SELECT * FROM ");
			getQualification.append("job_requirments_qualification");
			getQualification.append(" WHERE ");
			getQualification.append("requirment_id = ");
			getQualification.append(requirmentID);
			SQLQuery query = session.createSQLQuery(getQualification.toString());
			query.addEntity(RequirmentQualification.class);
			qualificationList = query.list();
			tx.commit();
		} catch (Exception e) {

			System.out.println("error in getRequirmentQualification" + e.toString());
		}

		return qualificationList;
	}

	@SuppressWarnings("unchecked")
	public List<Requirment> getAllRequirment(int id) {
		List<Requirment> requirmentList = new ArrayList<Requirment>();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getRequirment = new StringBuffer();
			getRequirment.append("SELECT * FROM ");
			getRequirment.append("job_requirments");
			getRequirment.append(" WHERE ");
			getRequirment.append("provider_id=");
			getRequirment.append(id);
			SQLQuery query = session.createSQLQuery(getRequirment.toString());
			query.addEntity(Requirment.class);
			requirmentList = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getAllRequirment" + e.toString());
		}
		return requirmentList;
	}

	@SuppressWarnings("unchecked")
	public List<RequirmentSkillset> getAllSkill(int id) {
		List<RequirmentSkillset> requirmentSkillsets = new ArrayList<RequirmentSkillset>();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSkill = new StringBuffer();
			getSkill.append("SELECT * FROM ");
			getSkill.append("job_requirments_skillset");
			getSkill.append(" WHERE ");
			getSkill.append("provider_id=");
			getSkill.append(id);
			SQLQuery query = session.createSQLQuery(getSkill.toString());
			query.addEntity(RequirmentSkillset.class);
			requirmentSkillsets = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getAllSkill" + e.toString());
		}
		return requirmentSkillsets;
	}

	@SuppressWarnings("unchecked")
	public List<RequirmentLocation> getAllLocation(int id) {
		List<RequirmentLocation> locationList = new ArrayList<RequirmentLocation>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getLocation = new StringBuffer();
			getLocation.append("SELECT * FROM ");
			getLocation.append("job_requirments_location");
			getLocation.append(" WHERE ");
			getLocation.append("provider_id = ");
			getLocation.append(id);
			SQLQuery query = session.createSQLQuery(getLocation.toString());
			query.addEntity(RequirmentLocation.class);
			locationList = query.list();
			tx.commit();
		} catch (Exception e) {

			System.out.println("error in getRequirmentLocation" + e.toString());
		}

		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<RequirmentQualification> getAllQualification(int id) {
		System.out.println("reached getAllQualificationDAO");

		List<RequirmentQualification> qualificationList = new ArrayList<RequirmentQualification>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getQualification = new StringBuffer();
			getQualification.append("SELECT * FROM ");
			getQualification.append("job_requirments_qualification");
			getQualification.append(" WHERE ");
			getQualification.append("provider_id = ");
			getQualification.append(id);
			SQLQuery query = session.createSQLQuery(getQualification.toString());
			query.addEntity(RequirmentQualification.class);
			qualificationList = query.list();
			tx.commit();
		} catch (Exception e) {

			System.out.println("error in getRequirmentQualification" + e.toString());
		}

		return qualificationList;
	}

	@SuppressWarnings("unchecked")
	public List<Requirment> getJobRequirments(int id) {
		List<Requirment> requirmentList = new ArrayList<Requirment>();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getRequirment = new StringBuffer();
			getRequirment.append("SELECT * FROM ");
			getRequirment.append("job_requirments");
			getRequirment.append(" WHERE ");
			getRequirment.append("provider_id=");
			getRequirment.append(id);
			SQLQuery query = session.createSQLQuery(getRequirment.toString());
			query.addEntity(Requirment.class);
			requirmentList = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getJobRequirments" + e.toString());
		}
		return requirmentList;
	}

	public void updateJobRequirment(Requirment requirment) {
		System.out.println("reached in updateJobRequirment");
		System.out.println("providerID: " + requirment.getProviderID());
		System.out.println("requirmentID: " + requirment.getRequirmentID());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(requirment);
		tx.commit();

	}

	public RequirmentSkillset validateSkill(RequirmentSkillset requirmentSkillset) {
		RequirmentSkillset requirmentSkillset1 = new RequirmentSkillset();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSkill = new StringBuffer();
			getSkill.append("SELECT * FROM ");
			getSkill.append("job_requirments_skillset");
			getSkill.append(" WHERE ");
			getSkill.append("requirment_id = ");
			getSkill.append(requirmentSkillset1.getRequirmentID());
			getSkill.append(" AND ");
			getSkill.append("skill = ");
			getSkill.append("'");
			getSkill.append(requirmentSkillset1.getSkillList());
			getSkill.append("'");
			SQLQuery query = session.createSQLQuery(getSkill.toString());
			query.addEntity(JobSeekerSkill.class);
			requirmentSkillset1 = (RequirmentSkillset) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getSeekerExperience" + e.toString());
		}
		return requirmentSkillset1;
	}

	public void updateRequirmentSkill(RequirmentSkillset requirmentSkillset) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(requirmentSkillset);
		tx.commit();

	}

	public RequirmentLocation getJobLocation(int locationID) {
		RequirmentLocation requirmentLocation = new RequirmentLocation();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getLocation = new StringBuffer();
			getLocation.append("SELECT * FROM ");
			getLocation.append("job_requirments_location");
			getLocation.append(" WHERE ");
			getLocation.append("location_id = ");
			getLocation.append(locationID);
			SQLQuery query = session.createSQLQuery(getLocation.toString());
			query.addEntity(RequirmentLocation.class);
			requirmentLocation = (RequirmentLocation) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getJobLocation" + e.toString());
		}
		return requirmentLocation;
	}

	public void updateRequirmentLocation(RequirmentLocation requirmentLocation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(requirmentLocation);
		tx.commit();

	}

	public RequirmentQualification getJobQualification(int qualificationID) {
		RequirmentQualification requirmentQualification = new RequirmentQualification();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getQualification = new StringBuffer();
			getQualification.append("SELECT * FROM ");
			getQualification.append("job_requirments_qualification");
			getQualification.append(" WHERE ");
			getQualification.append("qualification_id = ");
			getQualification.append(qualificationID);
			SQLQuery query = session.createSQLQuery(getQualification.toString());
			query.addEntity(RequirmentQualification.class);
			requirmentQualification = (RequirmentQualification) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getJobQualification" + e.toString());
		}
		return requirmentQualification;

	}

	public void updateRequirmentQualification(RequirmentQualification requirmentQualification) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(requirmentQualification);
		tx.commit();

	}

	public void deleteRequirmentQualification(int id) {
		try {
			System.out.println("deleteRequirmentQualificationdao");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteRequirmentQualification = new StringBuffer();

			deleteRequirmentQualification.append("DELETE ");
			// viewEmployee.append("*");
			deleteRequirmentQualification.append("FROM job_requirments_qualification");
			deleteRequirmentQualification.append(" WHERE ");
			deleteRequirmentQualification.append("requirment_id = ");
			deleteRequirmentQualification.append(id);

			SQLQuery query = session.createSQLQuery(deleteRequirmentQualification.toString());
			query.addEntity(RequirmentQualification.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteRequirmentQualification " + e.toString());
		}

	}

	public void deleteRequirmentLocation(int id) {
		try {
			System.out.println("deleteRequirmentLocation");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirmentLocation = new StringBuffer();

			deleteProviderRequirmentLocation.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirmentLocation.append("FROM job_requirments_location");
			deleteProviderRequirmentLocation.append(" WHERE ");
			deleteProviderRequirmentLocation.append("requirment_id = ");
			deleteProviderRequirmentLocation.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirmentLocation.toString());
			query.addEntity(RequirmentLocation.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteRequirmentLocation " + e.toString());
		}

	}

	public void deleteRequirmentSkillset(int id) {
		try {
			System.out.println("deleteRequirmentSkillset");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirmentSkillset = new StringBuffer();

			deleteProviderRequirmentSkillset.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirmentSkillset.append("FROM job_requirments_skillset");
			deleteProviderRequirmentSkillset.append(" WHERE ");
			deleteProviderRequirmentSkillset.append("requirment_id = ");
			deleteProviderRequirmentSkillset.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirmentSkillset.toString());
			query.addEntity(RequirmentSkillset.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteRequirmentSkillset " + e.toString());
		}

	}

	public void deleteProviderRequirment(int id) {
		try {
			System.out.println("deleteRequirment");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirment = new StringBuffer();

			deleteProviderRequirment.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirment.append("FROM job_requirments");
			deleteProviderRequirment.append(" WHERE ");
			deleteProviderRequirment.append("requirment_id = ");
			deleteProviderRequirment.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirment.toString());
			query.addEntity(Requirment.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteRequirment " + e.toString());
		}

	}

	public List<SeekerSearchDetailsDO> getSeekerQualification(String qualification) {
		List<SeekerSearchDetailsDO> seekerQualificationResult = new ArrayList<SeekerSearchDetailsDO>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSearchSeekerDetails = new StringBuffer();
			getSearchSeekerDetails.append("SELECT ");
			getSearchSeekerDetails.append("d.seeker_id,d.seeker_name,d.seeker_gender,");
			getSearchSeekerDetails.append(
					"c.seeker_registred_address,c.seeker_street,c.seeker_district,c.seeker_state,c.seeker_country,c.seeker_pincode,c.seeker_email1,c.seeker_email2,c.seeker_phone1,c.seeker_phone2,");
			getSearchSeekerDetails.append("s.skill,");
			getSearchSeekerDetails.append("q.qualification,q.specilization,q.year_of_pass,q.institute,q.gpa,");
			getSearchSeekerDetails.append("e.experience");
			getSearchSeekerDetails.append(" FROM ");
			getSearchSeekerDetails.append("job_seeker_details d,");
			getSearchSeekerDetails.append("job_seeker_contact c,");
			getSearchSeekerDetails.append("job_seeker_skillset s,");
			getSearchSeekerDetails.append("job_seeker_experience e,");
			getSearchSeekerDetails.append("job_seeker_qualification q");
			getSearchSeekerDetails.append(" WHERE ");
			getSearchSeekerDetails.append("d.seeker_id=c.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=q.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=s.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("d.seeker_id=e.seeker_id");
			getSearchSeekerDetails.append(" AND ");
			getSearchSeekerDetails.append("q.qualification");
			getSearchSeekerDetails.append("=");
			getSearchSeekerDetails.append("qualification");

			SQLQuery query = session.createSQLQuery(getSearchSeekerDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			System.out.println("Inside getSeekerQualification @ DAO, List size : " + data.size());
			for (Object object : data) {
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
				seekerQualificationResult.add(seekerSearchDetailsDO);
			}
			tx.commit();

		} catch (Exception e) {
			System.out.println("error in seekerQualificationResult" + e.toString());
		}
		return seekerQualificationResult;
	}

}
