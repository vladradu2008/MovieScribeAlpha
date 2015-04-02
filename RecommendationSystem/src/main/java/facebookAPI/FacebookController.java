package facebookAPI;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FacebookController {

	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	@ResponseBody
	public void facebookLikes(HttpEntity<String> httpEntity) {
	    String json = httpEntity.getBody();
	    System.out.println(json);
	}
}
