package omdb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataProvider {
	
	@RequestMapping("/movie")
	public String getMovieData(@RequestParam(value="title", defaultValue="Fury") String name) {
		
		StringBuffer jsonString = new StringBuffer();
		String line;
		
		try {
			    
			URL url = new URL("http://www.omdbapi.com/?t=" + name);   
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((line = reader.readLine()) != null) {
				jsonString.append(line);
			}
			
			connection.disconnect();
			
		} catch(Exception e) { 
			e.printStackTrace();
			System.out.println("Error");
		}
		
		return jsonString.toString();
	}
}
