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

import main.java.com.techies.irecruiter.dataobject.JobDO;
import main.java.com.techies.irecruiter.domain.JobProviderDetails;
import main.java.com.techies.irecruiter.domain.JobSeekerDetails;
import main.java.com.techies.irecruiter.domain.Login;

@Repository
public class LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Login validateLogin(Login loginDetails) {// for login validation
		Login login = new Login();
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unused")
			Transaction tx = session.beginTransaction();
			StringBuffer validateLogin = new StringBuffer();

			validateLogin.append("SELECT * FROM login ");
			validateLogin.append("WHERE user_id='");
			validateLogin.append(loginDetails.getUsername());
			validateLogin.append("'");
			validateLogin.append(" AND password='");
			validateLogin.append(loginDetails.getPassword());
			validateLogin.append("'");
			// validateLogin.append(" AND role='");
			// validateLogin.append(loginDetails.getRole());
			// validateLogin.append("'");

			SQLQuery query = session.createSQLQuery(validateLogin.toString());
			query.addEntity(Login.class);
			login = (Login) query.uniqueResult();

		} catch (Exception e) {
			System.out.println("error in validateLogin" + e.toString());
		}
		return login;
	}

	public void registerUser(Login registerUser) {// for new user signup

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(registerUser);
		tx.commit();

	}

	public int getProviderId(String username) { // to get the providerid

		JobProviderDetails jobProviderDetails = new JobProviderDetails();
		int providerId = 0;

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getProviderId = new StringBuffer();
			getProviderId.append("SELECT ");
			getProviderId.append("*");
			getProviderId.append(" FROM job_provider_details");
			getProviderId.append(" WHERE ");
			getProviderId.append("user_id='");
			getProviderId.append(username);
			getProviderId.append("'");
			SQLQuery query = session.createSQLQuery(getProviderId.toString());
			query.addEntity(JobProviderDetails.class);
			jobProviderDetails = (JobProviderDetails) query.uniqueResult();
			tx.commit();
			providerId = jobProviderDetails.getProviderID();

		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}

		return providerId;

	}

	public int getSeekerId(String username) {

		JobSeekerDetails jobSeekerDetails = new JobSeekerDetails();
		int seekerId = 0;

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSeekerId = new StringBuffer();
			getSeekerId.append("SELECT ");
			getSeekerId.append("*");
			getSeekerId.append(" FROM job_seeker_details");
			getSeekerId.append(" WHERE ");
			getSeekerId.append("user_id='");
			getSeekerId.append(username);
			getSeekerId.append("'");
			SQLQuery query = session.createSQLQuery(getSeekerId.toString());
			query.addEntity(JobSeekerDetails.class);
			jobSeekerDetails = (JobSeekerDetails) query.uniqueResult();
			tx.commit();
			seekerId = jobSeekerDetails.getSeekerID();

		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}
		return seekerId;

	}

	public Login checkAvailable(String username) {
		Login login = new Login();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getUsername = new StringBuffer();
			getUsername.append("SELECT ");
			getUsername.append("*");
			getUsername.append(" FROM login");
			getUsername.append(" WHERE ");
			getUsername.append("user_id='");
			getUsername.append(username);
			getUsername.append("'");
			SQLQuery query = session.createSQLQuery(getUsername.toString());
			query.addEntity(Login.class);
			login = (Login) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error" + e.toString());
		}
		return login;
	}

	public List<JobDO> getAllJobs() {
		List<JobDO> getAllJobsList = new ArrayList<JobDO>();
		try {
			System.out.println("getAllJobsDAO");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getAllJobs = new StringBuffer();
			getAllJobs.append("SELECT ");
			getAllJobs.append("d.provider_name,");
			getAllJobs.append("j.job_title");
			getAllJobs.append(" FROM ");
			getAllJobs.append("job_provider_details d,");
			getAllJobs.append("job_requirments j");
			getAllJobs.append(" WHERE ");
			getAllJobs.append("d.provider_id=j.provider_id");
			SQLQuery query = session.createSQLQuery(getAllJobs.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			System.out.println("Inside getalljobs @ DAO, List size : " + data.size());
			for (Object object : data) {
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				JobDO jobDO = new JobDO();
				jobDO.setName(row.get("provider_name").toString());
				jobDO.setJobTitle(row.get("job_title").toString());
				getAllJobsList.add(jobDO);

			}
			tx.commit();

		} catch (Exception e) {
			System.out.println("error:" + e.toString());
		}
		return getAllJobsList;
	}

	public List<JobDO> getRecentJobs() {
		List<JobDO> getRecentJobs = new ArrayList<JobDO>();
		try {
			System.out.println("getAllJobsDAO");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getAllJobs = new StringBuffer();
			getAllJobs.append("SELECT ");
			getAllJobs.append("d.provider_name,");
			getAllJobs.append("j.job_title");
			getAllJobs.append(" FROM ");
			getAllJobs.append("job_provider_details d,");
			getAllJobs.append("job_requirments j");
			getAllJobs.append(" WHERE ");
			getAllJobs.append("d.provider_id=j.provider_id");
			getAllJobs.append(" ORDER BY ");
			getAllJobs.append("j.requirment_id");
			getAllJobs.append(" DESC LIMIT 3");
			SQLQuery query = session.createSQLQuery(getAllJobs.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			System.out.println("Inside getallrecentjobs @ DAO, List size : " + data.size());
			for (Object object : data) {
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				JobDO jobDO = new JobDO();
				jobDO.setName(row.get("provider_name").toString());
				jobDO.setJobTitle(row.get("job_title").toString());
				getRecentJobs.add(jobDO);

			}
			tx.commit();

		} catch (Exception e) {
			System.out.println("error:" + e.toString());
		}
		return getRecentJobs;
	}

	public JobSeekerDetails getSeekerName(String username) {
		JobSeekerDetails jobSeekerDetails = new JobSeekerDetails();
		System.out.println("getSeekerName at DAO");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSeekerName = new StringBuffer();
			getSeekerName.append("SELECT * FROM ");
			getSeekerName.append("job_seeker_details");
			getSeekerName.append(" WHERE ");
			getSeekerName.append("user_id='");
			getSeekerName.append(username);
			getSeekerName.append("'");
			SQLQuery query = session.createSQLQuery(getSeekerName.toString());
			query.addEntity(JobSeekerDetails.class);
			jobSeekerDetails = (JobSeekerDetails) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getSeekerName" + e.toString());
		}
		return jobSeekerDetails;

	}

	public JobSeekerDetails getSeekerName(int seekerId) {
		JobSeekerDetails jobSeekerDetails = new JobSeekerDetails();
		System.out.println("getSeekerName at DAO");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getSeekerName = new StringBuffer();
			getSeekerName.append("SELECT * FROM ");
			getSeekerName.append("job_seeker_details");
			getSeekerName.append(" WHERE ");
			getSeekerName.append("seeker_id=");
			getSeekerName.append(seekerId);
			SQLQuery query = session.createSQLQuery(getSeekerName.toString());
			query.addEntity(JobSeekerDetails.class);
			jobSeekerDetails = (JobSeekerDetails) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getSeekerName" + e.toString());
		}
		return jobSeekerDetails;
	}

	public JobProviderDetails getProviderName(int providerId) {
		JobProviderDetails jobProviderDetails = new JobProviderDetails();
		System.out.println("getproviderName at DAO");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			StringBuffer getProviderName = new StringBuffer();
			getProviderName.append("SELECT * FROM ");
			getProviderName.append("job_provider_details");
			getProviderName.append(" WHERE ");
			getProviderName.append("provider_id=");
			getProviderName.append(providerId);
			SQLQuery query = session.createSQLQuery(getProviderName.toString());
			query.addEntity(JobProviderDetails.class);
			jobProviderDetails = (JobProviderDetails) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("error in getproviderName" + e.toString());
		}
		return jobProviderDetails;
	}
}
