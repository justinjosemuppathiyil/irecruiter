package main.java.com.techies.irecruiter.dataaccess;

import java.io.Serializable;
import java.sql.Date;
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


import main.java.com.techies.irecruiter.dataobject.SeekerAllDetailsDO;
import main.java.com.techies.irecruiter.domain.JobSeekerContact;
import main.java.com.techies.irecruiter.domain.JobSeekerDetails;
import main.java.com.techies.irecruiter.domain.JobSeekerExperience;
import main.java.com.techies.irecruiter.domain.JobSeekerQualification;
import main.java.com.techies.irecruiter.domain.JobSeekerResume;
import main.java.com.techies.irecruiter.domain.JobSeekerSkill;

@Repository
public class SeekerDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
		public int createseekerDetails(JobSeekerDetails jobSeekerDetails) {
		System.out.println("reached in createseekerdetailsDAO");
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(jobSeekerDetails);
		tx.commit();
		Serializable id=session.getIdentifier(jobSeekerDetails);
		session.close();
		return (Integer) id;
		}

		public void createSeekerContacts(JobSeekerContact jobSeekerContact) {
			
			System.out.println("createseekercontactsDAO");
			
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(jobSeekerContact);
			tx.commit();
			
		}

		public void updateSeekerDetails(JobSeekerDetails seekerDetails) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(seekerDetails);
			tx.commit();
			
		}

		public void updateSeekerContacts(JobSeekerContact seekerContact) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(seekerContact);
			tx.commit();
			
		}

		public SeekerAllDetailsDO getSeekerProfile(int id) {
			
			SeekerAllDetailsDO seekerAllDetailsDO = new SeekerAllDetailsDO();
			
			try{
			System.out.println("getSeekerProfileDAO");
			
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getSeekerDetails = new StringBuffer();
			getSeekerDetails.append("SELECT ");
			getSeekerDetails.append("d.seeker_id,d.seeker_name,d.seeker_bod,d.seeker_gender,d.user_id,");
			getSeekerDetails.append("c.contact_id,c.seeker_registred_address,c.seeker_street,c.seeker_district,c.seeker_state,c.seeker_country,c.seeker_pincode,c.seeker_email1,c.seeker_email2,c.seeker_phone1,c.seeker_phone2");
			//getSeekerDetails.append("q.qualification_id,q.qualification,q.specilization,q.year_of_pass,q.institute,q.gpa");
			getSeekerDetails.append(" FROM ");
			getSeekerDetails.append("job_seeker_details d,");
			getSeekerDetails.append("job_seeker_contact c");
			//getSeekerDetails.append("job_seeker_qualification q");
			getSeekerDetails.append(" WHERE ");
			getSeekerDetails.append("d.seeker_id=");
			getSeekerDetails.append(id);
			getSeekerDetails.append(" AND ");
			getSeekerDetails.append("c.seeker_id=");
			getSeekerDetails.append(id);
			getSeekerDetails.append(" AND ");
			getSeekerDetails.append("c.seeker_id=d.seeker_id");
			//getSeekerDetails.append(" AND ");
			//getSeekerDetails.append("q.seeker_id=");
			//getSeekerDetails.append(id);
			//getSeekerDetails.append(" AND ");
			//getSeekerDetails.append("q.seeker_id=d.seeker_id");
			//getSeekerDetails.append(" AND ");
			//getSeekerDetails.append("q.seeker_id=c.seeker_id");
			SQLQuery query=session.createSQLQuery(getSeekerDetails.toString());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			@SuppressWarnings("rawtypes")
			List data = query.list();
			for(Object object:data){
				@SuppressWarnings("rawtypes")
				Map row = (Map) object;
				seekerAllDetailsDO.setSeekerID(Integer.parseInt(row.get("seeker_id").toString()));
				seekerAllDetailsDO.setContactID(Integer.parseInt(row.get("contact_id").toString()));
				seekerAllDetailsDO.setSeekerName(row.get("seeker_name").toString());
				seekerAllDetailsDO.setUsername(row.get("user_id").toString());
				seekerAllDetailsDO.setSeekerAddress(row.get("seeker_registred_address").toString());
				seekerAllDetailsDO.setSeekerStreet(row.get("seeker_street").toString());
				seekerAllDetailsDO.setSeekerState(row.get("seeker_state").toString());
				seekerAllDetailsDO.setSeekerDistrict(row.get("seeker_district").toString());
				seekerAllDetailsDO.setSeekerCountry(row.get("seeker_country").toString());
				seekerAllDetailsDO.setSeekerDOB((Date)row.get("seeker_bod"));
				seekerAllDetailsDO.setSeekerEmail1(row.get("seeker_email1").toString());
				seekerAllDetailsDO.setSeekerEmail2(row.get("seeker_email2").toString());
				seekerAllDetailsDO.setSeekerPhone1(row.get("seeker_phone1").toString());
				seekerAllDetailsDO.setSeekerPhone2(row.get("seeker_phone2").toString());
				seekerAllDetailsDO.setSeekerPIN(row.get("seeker_pincode").toString());	
				seekerAllDetailsDO.setSeekerGender(row.get("seeker_gender").toString());
			}
			tx.commit();
			
			}
			catch (Exception e) {
				System.out.println("error:"+e.toString());
			}
			return seekerAllDetailsDO;
		}

		public boolean addQualification(JobSeekerQualification jobSeekerQualification) {
			System.out.println("addQualificationDAO");
			
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(jobSeekerQualification);
			tx.commit();
			return true;
			
		}

		public void updateSeekerQualification(JobSeekerQualification jobSeekerQualification) {
			System.out.println("reached in updateSeekerQualificationDAO");
			System.out.println("seekerID: "+jobSeekerQualification.getSeekerID());
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(jobSeekerQualification);
			tx.commit();
			
		}

		public JobSeekerQualification getSeekerQualification(int id) {
			
			JobSeekerQualification jobSeekerQualification = new JobSeekerQualification();
	
			try{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				StringBuffer getQualification=new StringBuffer();
				getQualification.append("SELECT * FROM ");
				getQualification.append("job_seeker_qualification");
				getQualification.append(" WHERE ");
				getQualification.append("seeker_id = ");
				getQualification.append(id);
				SQLQuery query=session.createSQLQuery(getQualification.toString());
				query.addEntity(JobSeekerQualification.class);
				jobSeekerQualification = (JobSeekerQualification) query.uniqueResult();
				tx.commit();
				}catch (Exception e) {
					System.out.println("error in getSeekerQualification"+e.toString());
				}
		return jobSeekerQualification;

		
		}

		public void addSkill(JobSeekerSkill jobSeekerSkill) {
			
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(jobSeekerSkill);
			tx.commit();
		}

		@SuppressWarnings("unchecked")
		public List<JobSeekerSkill> getSeekerSkill(int id) {
			List<JobSeekerSkill> seekerSkillList = new ArrayList<JobSeekerSkill>();
			
			try{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				StringBuffer getSkill=new StringBuffer();
				getSkill.append("SELECT * FROM ");
				getSkill.append("job_seeker_skillset");
				getSkill.append(" WHERE ");
				getSkill.append("seeker_id = ");
				getSkill.append(id);
				SQLQuery query=session.createSQLQuery(getSkill.toString());
				query.addEntity(JobSeekerSkill.class);
				seekerSkillList = query.list();
				tx.commit();
				}catch (Exception e) {
					System.out.println("error in getSeekerSkill"+e.toString());
				}
		return seekerSkillList;
		}

		public void addExperience(JobSeekerExperience jobSeekerExperience) {
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(jobSeekerExperience);
			tx.commit();
		}

		public JobSeekerExperience getSeekerExperience(int id) {
			JobSeekerExperience jobSeekerExperience = new JobSeekerExperience();
			
			try{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				StringBuffer getExperience=new StringBuffer();
				getExperience.append("SELECT * FROM ");
				getExperience.append("job_seeker_experience");
				getExperience.append(" WHERE ");
				getExperience.append("seeker_id = ");
				getExperience.append(id);
				SQLQuery query=session.createSQLQuery(getExperience.toString());
				query.addEntity(JobSeekerExperience.class);
				jobSeekerExperience = (JobSeekerExperience) query.uniqueResult();
				tx.commit();
				}catch (Exception e) {
					System.out.println("error in getSeekerExperience"+e.toString());
				}
		return jobSeekerExperience;
		}

		public void updateSeekerExperience(JobSeekerExperience jobSeekerExperience) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(jobSeekerExperience);
			tx.commit();
			
		}

		public void updateSeekerSkill(JobSeekerSkill jobSeekerSkill) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(jobSeekerSkill);
			tx.commit();
			
		}

		public void uploadSeekerResume(JobSeekerResume jobSeekerResume) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(jobSeekerResume);
			tx.commit();
			
		}

		public JobSeekerResume getSeekerResumeDetails(int seekerID) {
			JobSeekerResume jobSeekerResume = new JobSeekerResume();
			
			try{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				StringBuffer getResume=new StringBuffer();
				getResume.append("SELECT * FROM ");
				getResume.append("job_seeker_resume");
				getResume.append(" WHERE ");
				getResume.append("seeker_id = ");
				getResume.append(seekerID);
				SQLQuery query=session.createSQLQuery(getResume.toString());
				query.addEntity(JobSeekerResume.class);
				jobSeekerResume = (JobSeekerResume) query.uniqueResult();
				tx.commit();
				}catch (Exception e) {
					System.out.println("error in getSeekerResumeDetails"+e.toString());
				}
			return jobSeekerResume;
		}

		public void updateSeekerResume(JobSeekerResume jobSeekerResume) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(jobSeekerResume);
			tx.commit();
			
		}

		public JobSeekerSkill validateSkill(JobSeekerSkill jobSeekerSkill) {
			JobSeekerSkill jobSeekerSkill1 = new JobSeekerSkill();
			
			try{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				StringBuffer getSkill=new StringBuffer();
				getSkill.append("SELECT * FROM ");
				getSkill.append("job_seeker_skillset");
				getSkill.append(" WHERE ");
				getSkill.append("seeker_id = ");
				getSkill.append(jobSeekerSkill.getSeekerID());
				getSkill.append(" AND ");
				getSkill.append("skill = ");
				getSkill.append("'");
				getSkill.append(jobSeekerSkill.getSkill());
				getSkill.append("'");
				SQLQuery query=session.createSQLQuery(getSkill.toString());
				query.addEntity(JobSeekerSkill.class);
				jobSeekerSkill1 = (JobSeekerSkill) query.uniqueResult();
				tx.commit();
				}catch (Exception e) {
					System.out.println("error in getSeekerExperience"+e.toString());
				}
		return jobSeekerSkill1;
		}

		
}


