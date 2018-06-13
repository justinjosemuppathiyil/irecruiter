package main.java.com.techies.irecruiter.dataaccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import main.java.com.techies.irecruiter.dataobject.QuestionsDO;
import main.java.com.techies.irecruiter.domain.JobSeekerContact;
import main.java.com.techies.irecruiter.domain.OnlineTestOption;
import main.java.com.techies.irecruiter.domain.OnlineTestQuestion;
@Repository
public class OnlineTestDAO {
	@Autowired
	SessionFactory sessionFactory;

	public int submitOnlineTestQuestion(OnlineTestQuestion onlineTestQuestion) {
		System.out.println("reached in submitOnlineTestQuestionDAO");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(onlineTestQuestion);
		tx.commit();
		Serializable id=session.getIdentifier(onlineTestQuestion);
		session.close();
		return (Integer) id;
	}

	public void submitOnlineTestOptions(OnlineTestOption onlineTestOption) {
		System.out.println("reached in submitOnlineTestOptions");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(onlineTestOption);
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<QuestionsDO> getAllQuestions(int id) {
		System.out.println("reached in getAllQuestionsDAO");
		List<QuestionsDO> questionList = new ArrayList<QuestionsDO>();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getAllQuestions = new StringBuffer();
			getAllQuestions.append("SELECT ");
			getAllQuestions.append("q.provider_id,q.question,q.question_id,");
			getAllQuestions.append("o.option1,o.option2,o.option3,o.option4,o.answer");
			getAllQuestions.append(" FROM ");
			getAllQuestions.append("online_test_question q,");
			getAllQuestions.append("online_test_options o");
			getAllQuestions.append(" WHERE ");
			getAllQuestions.append("q.question_id = o.question_id");
			getAllQuestions.append(" AND ");
			getAllQuestions.append("q.provider_id = ");
			getAllQuestions.append(id);
			SQLQuery query=session.createSQLQuery(getAllQuestions.toString());
			query.addEntity(QuestionsDO.class);
			questionList = query.list();
			tx.commit();
			}catch (Exception e) {
				System.out.println("error in getAllQuestions"+e.toString());
			}
			return questionList;
	
	}

	public QuestionsDO getQuestion(Integer queId) {
		System.out.println("reached in getQuestionDAO");
		QuestionsDO questionsDO = new QuestionsDO();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getAllQuestions = new StringBuffer();
			getAllQuestions.append("SELECT ");
			getAllQuestions.append("q.provider_id,q.question,q.question_id,");
			getAllQuestions.append("o.option1,o.option2,o.option3,o.option4,o.answer");
			getAllQuestions.append(" FROM ");
			getAllQuestions.append("online_test_question q,");
			getAllQuestions.append("online_test_options o");
			getAllQuestions.append(" WHERE ");
			getAllQuestions.append("q.question_id = ");
			getAllQuestions.append(queId);
			getAllQuestions.append(" AND ");
			getAllQuestions.append("q.question_id = o.question_id");
			SQLQuery query=session.createSQLQuery(getAllQuestions.toString());
			query.addEntity(QuestionsDO.class);
			questionsDO = (QuestionsDO) query.uniqueResult();
			tx.commit();
			}catch (Exception e) {
				System.out.println("error in getQuestion"+e.toString());
			}
			return questionsDO;
	}

	public void updateOnlineTestQuestion(OnlineTestQuestion onlineTestQuestion) {
		System.out.println("reached in updateOnlineTestQuestionDAO");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(onlineTestQuestion);
		tx.commit();
		
	}
	public void updateOnlineTestOptions(OnlineTestOption onlineTestOption) {
		System.out.println("reached in updateOnlineTestOptionDAO");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(onlineTestOption);
		tx.commit();
		
	}

	public void deleteOptions(Integer queId) {
	
			System.out.println("deleteOptionsDAO");
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			OnlineTestOption onlineTestOption = (OnlineTestOption) session.load(OnlineTestOption.class, queId);
			session.delete(onlineTestOption);
			tx.commit();	
		
	}

	public void deleteQuestion(Integer queId) {
		System.out.println("deleteQuestionDAO");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		OnlineTestQuestion onlineTestQuestion = (OnlineTestQuestion) session.load(OnlineTestQuestion.class, queId);
		session.delete(onlineTestQuestion);
		tx.commit();	
		
	}

	@SuppressWarnings("unchecked")
	public List<QuestionsDO> getOnlineTestQuestions(Integer providerId) {
		System.out.println("reached in getAllQuestionsDAO");
		List<QuestionsDO> questionList = new ArrayList<QuestionsDO>();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getAllQuestions = new StringBuffer();
			getAllQuestions.append("SELECT ");
			getAllQuestions.append("q.provider_id,q.question,q.question_id,");
			getAllQuestions.append("o.option1,o.option2,o.option3,o.option4,o.answer");
			getAllQuestions.append(" FROM ");
			getAllQuestions.append("online_test_question q,");
			getAllQuestions.append("online_test_options o");
			getAllQuestions.append(" WHERE ");
			getAllQuestions.append("q.question_id = o.question_id");
			getAllQuestions.append(" AND ");
			getAllQuestions.append("q.provider_id = ");
			getAllQuestions.append(providerId);
			getAllQuestions.append(" ORDER BY RAND() ");
			getAllQuestions.append("LIMIT 10");
			SQLQuery query=session.createSQLQuery(getAllQuestions.toString());
			query.addEntity(QuestionsDO.class);
			questionList = query.list();
			tx.commit();
			}catch (Exception e) {
				System.out.println("error in getAllQuestions"+e.toString());
			}
			return questionList;
	}

	public JobSeekerContact getEmailAddress(Integer seekerID) {
		System.out.println("reached in getEmailAddressDAO");
		JobSeekerContact jobSeekerContact = new JobSeekerContact();
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			StringBuffer getEmailAddress = new StringBuffer();
			getEmailAddress.append("SELECT *");
			//getEmailAddress.append("seeker_email1,seeker_email2");
			getEmailAddress.append(" FROM ");
			getEmailAddress.append("job_seeker_contact");
			getEmailAddress.append(" WHERE ");
			getEmailAddress.append("seeker_id = ");
			getEmailAddress.append(seekerID);
			SQLQuery query=session.createSQLQuery(getEmailAddress.toString());
			query.addEntity(JobSeekerContact.class);
			jobSeekerContact = (JobSeekerContact) query.uniqueResult();
			tx.commit();
			}catch (Exception e) {
				System.out.println("error in getEmailAddress"+e.toString());
			}
			return jobSeekerContact;
	}


}
