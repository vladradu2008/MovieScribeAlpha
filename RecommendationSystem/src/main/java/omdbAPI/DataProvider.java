package omdbAPI;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import entity.MovieEntity;

public class DataProvider {

	private SessionFactory sessionFactory;
	private Session session;
	private Criteria criteria;
	
	public DataProvider() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public List<MovieEntity> getMovies(String actor, String genre) {
		Criteria criteria = session.createCriteria(MovieEntity.class);
		Criterion firstCriterion = null;
		Criterion secondCriterion = null;
		if(actor!=null)
				firstCriterion = Restrictions.like("actors", "%"+actor.toLowerCase().trim()+"%");
		if(genre!=null)
			    secondCriterion = Restrictions.like("genre", "%"+genre.toLowerCase().trim()+"%");
		if(firstCriterion != null && secondCriterion!=null)
			    criteria.add(Restrictions.and(firstCriterion,secondCriterion));
		else if(firstCriterion !=null)
			    criteria.add(firstCriterion);
			else if (secondCriterion != null) 
				criteria.add(secondCriterion);
		
		return criteria.list(); 
	}
}
