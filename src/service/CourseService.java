package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entity.Course;

@Transactional 
@Component(value = "courseService")
public class CourseService implements ICourseService{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Course course) {
		getSession().saveOrUpdate(course);
	}

	@Override
	public void delete(Course course) {
		getSession().delete(course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		String sql = "select * from t_course";
		Query query = getSession().createSQLQuery(sql).addEntity(Course.class);
		return query.list();
	}

	@Override
	public Course findById(int id) {
		String sql = "select * from t_course where id = ?";
		Query query = getSession().createSQLQuery(sql).addEntity(Course.class).setInteger(0, id);
		return (Course) query.uniqueResult();
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
}
