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
	
	public static void findByTitle(String title){
		
		try {
			title = title.replace("\\s+", "+");
			InputStream input = new URL("http://www.omdbapi.com/?t=" + 
			                             URLEncoder.encode(title, "UTF-8")).openStream();
			Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), 
										                  new TypeToken<Map<String, 
										                  String>>(){}.getType());
			
			System.out.println(map.get("Plot"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		OmdbAPI.findByTitle("Inception");
	}

}
