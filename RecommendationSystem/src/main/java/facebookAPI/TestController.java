package facebookAPI;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public void greetingJson(HttpEntity<String> httpEntity) {
	    String json = httpEntity.getBody();
	    System.out.println(json);
	}
}
