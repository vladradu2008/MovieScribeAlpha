package omdbAPI;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class OmdbAPI {
	
	private OmdbAPI() {
	}
	
	public static Map<String, String> findById(int id){
		Map<String, String> map = null;
		try {
			String idS = String.valueOf(id);
			while(idS.length()<6) {
				idS="0"+idS;
			}
			InputStream input = new URL("http://www.omdbapi.com/?i=tt0" + 
			                             URLEncoder.encode(idS, "UTF-8") +
			                             "&plot=short&r=json").openStream();
			map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), 
									  new TypeToken<Map<String, 
									  String>>(){}.getType());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		for(int i=1;i<1000;i++) {
			Map<String, String> map = findById(i);
			if(map.get("imdbRating")!=null)
			if(!map.get("imdbRating").contains("N/A"))
			if(Double.parseDouble(map.get("imdbRating"))>7.0)
			     System.out.println(map);
		}
	}

}
