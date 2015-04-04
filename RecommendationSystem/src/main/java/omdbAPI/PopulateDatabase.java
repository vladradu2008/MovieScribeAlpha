package omdbAPI;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.MovieEntity;

public class PopulateDatabase {

	public static void main(String[] args) {

		String baseUrl = "http://www.omdbapi.com/?i={id}&plot=short&r=json";
		String id = null;
		Map<String, String> params = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		MovieEntity movie = null;

		try {
			
			SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			for (int i = 125000; i <= 125100; i++) {
				
				if (i < 1000000) {
					id = "tt0" + Integer.toString(i);
				} else {
					id = "tt" + Integer.toString(i);
				}
				params.put("id", id);
			
				RestTemplate restTemplate = new RestTemplate();
			    String result = restTemplate.getForObject(baseUrl, String.class, params);
			    params.clear();
			    
			    if (! result.equals("{\"Response\":\"False\",\"Error\":\"Error getting data\"}")) {
			    	 movie = mapper.readValue(result, MovieEntity.class);
			    }

			    session.save(movie);
			    
			}
			
			session.getTransaction().commit();
			session.close();
																																			
		} catch (Exception e) {
			System.out.println("ID= " + id);
			e.printStackTrace();
		}			
		
	} 
}
