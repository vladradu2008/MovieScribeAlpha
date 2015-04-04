package omdbAPI;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.MovieEntity;

@RestController
@RequestMapping("/api")
public class Service {

	@ResponseBody
	@RequestMapping("/movies/{actor}")
	public List<MovieEntity> getData(@PathVariable(value="actor") String actor) {
		DataProvider provider = new DataProvider();
		return provider.getMovies(actor);
	}
} 
