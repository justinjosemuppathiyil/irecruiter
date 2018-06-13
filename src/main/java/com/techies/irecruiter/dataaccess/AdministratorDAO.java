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

import main.java.com.techies.irecruiter.dataobject.ProviderAllDetailsDO;
import main.java.com.techies.irecruiter.domain.JobProviderContacts;
import main.java.com.techies.irecruiter.domain.JobProviderDetails;
import main.java.com.techies.irecruiter.domain.Login;
import main.java.com.techies.irecruiter.domain.OnlineTestOption;
import main.java.com.techies.irecruiter.domain.OnlineTestQuestion;
import main.java.com.techies.irecruiter.domain.Requirment;
import main.java.com.techies.irecruiter.domain.RequirmentLocation;
import main.java.com.techies.irecruiter.domain.RequirmentQualification;
import main.java.com.techies.irecruiter.domain.RequirmentSkillset;

@Repository
public class AdministratorDAO {
	@Autowired
	SessionFactory sessionFactory;

	public List<ProviderAllDetailsDO> getProviderdetails() {
		List<ProviderAllDetailsDO> providerAllDetailsDOList = new ArrayList<ProviderAllDetailsDO>();
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
			getProviderDetails.append("d.provider_id=c.provider_id");
			SQLQuery query = session.createSQLQuery(getProviderDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			System.out.println("Inside seekerSearch @ DAO, List size : " + data.size());
			for (Object object : data) {
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				ProviderAllDetailsDO providerAllDetailsDO = new ProviderAllDetailsDO();
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
				providerAllDetailsDOList.add(providerAllDetailsDO);

			}
			tx.commit();

		} catch (Exception e) {
			System.out.println("error:" + e.toString());
		}
		return providerAllDetailsDOList;
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

	public void deleteProviderRequirmentQualification(int id) {
		try {
			System.out.println("deleteProviderRequirmentQualificationdao");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteRequirmentQualification = new StringBuffer();

			deleteRequirmentQualification.append("DELETE ");
			// viewEmployee.append("*");
			deleteRequirmentQualification.append("FROM job_requirments_qualification");
			deleteRequirmentQualification.append(" WHERE ");
			deleteRequirmentQualification.append("provider_id = ");
			deleteRequirmentQualification.append(id);

			SQLQuery query = session.createSQLQuery(deleteRequirmentQualification.toString());
			query.addEntity(RequirmentQualification.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteRequirmentQualification " + e.toString());
		}

	}

	public void deleteProviderRequirmentLocation(int id) {
		try {
			System.out.println("deleteProviderRequirmentLocation");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirmentLocation = new StringBuffer();

			deleteProviderRequirmentLocation.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirmentLocation.append("FROM job_requirments_location");
			deleteProviderRequirmentLocation.append(" WHERE ");
			deleteProviderRequirmentLocation.append("provider_id = ");
			deleteProviderRequirmentLocation.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirmentLocation.toString());
			query.addEntity(RequirmentLocation.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderRequirmentLocation " + e.toString());
		}

	}

	public void deleteProviderRequirmentSkillset(int id) {
		try {
			System.out.println("deleteProviderRequirmentSkillset");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirmentSkillset = new StringBuffer();

			deleteProviderRequirmentSkillset.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirmentSkillset.append("FROM job_requirments_skillset");
			deleteProviderRequirmentSkillset.append(" WHERE ");
			deleteProviderRequirmentSkillset.append("provider_id = ");
			deleteProviderRequirmentSkillset.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirmentSkillset.toString());
			query.addEntity(RequirmentSkillset.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderRequirmentSkillset " + e.toString());
		}

	}

	public void deleteProviderRequirment(int id) {
		try {
			System.out.println("deleteProviderRequirment");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderRequirment = new StringBuffer();

			deleteProviderRequirment.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderRequirment.append("FROM job_requirments");
			deleteProviderRequirment.append(" WHERE ");
			deleteProviderRequirment.append("provider_id = ");
			deleteProviderRequirment.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderRequirment.toString());
			query.addEntity(Requirment.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderRequirment " + e.toString());
		}

	}

	public void deleteProviderContacts(int id) {
		try {
			System.out.println("deleteProviderContacts");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderContacts = new StringBuffer();

			deleteProviderContacts.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderContacts.append("FROM job_provider_contact");
			deleteProviderContacts.append(" WHERE ");
			deleteProviderContacts.append("provider_id = ");
			deleteProviderContacts.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderContacts.toString());
			query.addEntity(JobProviderContacts.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderContacts " + e.toString());
		}

	}

	public void deleteProviderDetails(int id) {
		try {
			System.out.println("deleteProviderDetailsdao");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderDetails = new StringBuffer();

			deleteProviderDetails.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderDetails.append("FROM job_provider_details");
			deleteProviderDetails.append(" WHERE ");
			deleteProviderDetails.append("provider_id = ");
			deleteProviderDetails.append(id);

			SQLQuery query = session.createSQLQuery(deleteProviderDetails.toString());
			query.addEntity(JobProviderDetails.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderDetails " + e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	public List<RequirmentQualification> getQualification(int id) {
		System.out.println("reached getRequirmentQualificationDAO");

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
	public List<RequirmentLocation> getlocation(int id) {
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
	public List<RequirmentSkillset> getskill(int id) {
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
	public List<Requirment> getrequirment(int id) {
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

	public void deleteProviderLogin(String userId) {
		try {
			System.out.println("deleteProviderLogin");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteProviderLogin = new StringBuffer();

			deleteProviderLogin.append("DELETE ");
			// viewEmployee.append("*");
			deleteProviderLogin.append("FROM login");
			deleteProviderLogin.append(" WHERE ");
			deleteProviderLogin.append("user_id = '");
			deleteProviderLogin.append(userId);
			deleteProviderLogin.append("'");
			SQLQuery query = session.createSQLQuery(deleteProviderLogin.toString());
			query.addEntity(Login.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteProviderLogin " + e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	public List<OnlineTestOption> getOptions(int id) {
		List<OnlineTestOption> optionList = new ArrayList<OnlineTestOption>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getOption = new StringBuffer();
			getOption.append("SELECT * FROM ");
			getOption.append("online_test_options");
			getOption.append(" WHERE ");
			getOption.append("provider_id=");
			getOption.append(id);
			SQLQuery query = session.createSQLQuery(getOption.toString());
			query.addEntity(OnlineTestOption.class);
			optionList = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getOptions" + e.toString());
		}
		return optionList;
	}

	public void deleteonlinetestOptions(int id) {
		try {
			System.out.println("deleteonlinetestOptions");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteonlinetestOptions = new StringBuffer();
			deleteonlinetestOptions.append("DELETE ");
			deleteonlinetestOptions.append("FROM ");
			deleteonlinetestOptions.append("online_test_options");
			deleteonlinetestOptions.append(" WHERE ");
			deleteonlinetestOptions.append("provider_id=");
			deleteonlinetestOptions.append(id);
			SQLQuery query = session.createSQLQuery(deleteonlinetestOptions.toString());
			query.addEntity(OnlineTestOption.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteonlinetestOptions " + e.toString());
		}
	}

	@SuppressWarnings("unchecked")
	public List<OnlineTestQuestion> getQuestions(int id) {
		List<OnlineTestQuestion> questionList = new ArrayList<OnlineTestQuestion>();

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getQuestions = new StringBuffer();
			getQuestions.append("SELECT * FROM ");
			getQuestions.append("online_test_question");
			getQuestions.append(" WHERE ");
			getQuestions.append("provider_id=");
			getQuestions.append(id);
			SQLQuery query = session.createSQLQuery(getQuestions.toString());
			query.addEntity(OnlineTestQuestion.class);
			questionList = query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getQuestions" + e.toString());
		}
		return questionList;
	}

	public void deleteonlinetestQuestion(int id) {
		try {
			System.out.println("deleteonlinetestQuestion");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer deleteonlinetestQuestion = new StringBuffer();

			deleteonlinetestQuestion.append("DELETE ");
			// viewEmployee.append("*");
			deleteonlinetestQuestion.append("FROM ");
			deleteonlinetestQuestion.append("online_test_question");
			deleteonlinetestQuestion.append(" WHERE ");
			deleteonlinetestQuestion.append("provider_id=");
			deleteonlinetestQuestion.append(id);
			SQLQuery query = session.createSQLQuery(deleteonlinetestQuestion.toString());
			query.addEntity(OnlineTestQuestion.class);
			query.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("error deleteonlinetestQuestion " + e.toString());
		}
	}

}
