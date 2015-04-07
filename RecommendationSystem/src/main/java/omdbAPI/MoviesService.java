package omdbAPI;

import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entity.MovieEntity;

@RestController
@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class MoviesService {

	@RequestMapping(value="/movies")
	public List<MovieEntity> getAllMovies() {
		
		DataProvider provider = new DataProvider();
		List<MovieEntity> movies = provider.getMovies(null, null);
		
		if (movies.isEmpty()) throw new ResourceNotFoundException();
		else return movies;
	}
	
	@RequestMapping(value="/movies/actor/{actor}")
	public List<MovieEntity> getMoviesByActor(@PathVariable(value="actor") String actor) {
		
		DataProvider provider = new DataProvider();
		List<MovieEntity> movies = provider.getMovies(actor, null);
		
		if (movies.isEmpty()) throw new ResourceNotFoundException();
		else return movies;
	}
	
	@RequestMapping(value="/movies/genre/{genre}")
	public List<MovieEntity> getMoviesByGenre(@PathVariable(value="genre") String genre) {
		
		DataProvider provider = new DataProvider();
		List<MovieEntity> movies = provider.getMovies(null, genre);
		
		if (movies.isEmpty()) throw new ResourceNotFoundException();
		else return movies;
	}
	
	@RequestMapping(value="/movies/{actor}/{genre}")
	public List<MovieEntity> getMoviesByActorGenre(@PathVariable(value="actor") String actor,
			@PathVariable(value="genre") String genre) {
		
		DataProvider provider = new DataProvider();
		List<MovieEntity> movies = provider.getMovies(actor, genre);
		
		if (movies.isEmpty()) throw new ResourceNotFoundException();
		else return movies;
	}
	
	 @RequestMapping(value="/image/{imageHash}")
	 public ResponseEntity<byte[]> proxyImage(@PathVariable(value="imageHash")String imageHash) {
	     String url = "http://ia.media-imdb.com/images/M/" + imageHash + ".jpg";
	     try {
	         final HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.IMAGE_JPEG);
	         return new ResponseEntity<byte[]>(IOUtils.toByteArray(new URL(url).openConnection().getInputStream()), headers, HttpStatus.CREATED);
	     } catch(Exception e) {
	         e.printStackTrace();
	         return null;
	     }
	 }
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	}
} 
 