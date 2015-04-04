package omdbAPI;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import entity.MovieEntity;

public class DataProvider {

	private SessionFactory sessionFactory;
	Session session;
	Criteria criteria;
	
	public DataProvider() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public List<MovieEntity> getMovies(String actor) {

		criteria = session.createCriteria(MovieEntity.class);
		criteria.add(Restrictions.like("actors", "%"+actor+"%"));
		return criteria.list();
	}
}
