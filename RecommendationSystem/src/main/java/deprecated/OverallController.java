package deprecated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OverallController {
	private static final Logger logger = LoggerFactory.logger(OverallController.class);

	  private final SocialContext socialContext;

	  @Autowired
	  public OverallController(SocialContext socialContext) {
	    this.socialContext = socialContext;
	    
	  }
	  

	  @RequestMapping(value = "posts", method = RequestMethod.GET)
	  public void showPostsForUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  System.out.println(request.getHeaderNames());
	      socialContext.isSignedIn(request, response);
	      Facebook facebook = socialContext.getFacebook();
		  LikeOperations usOps = facebook.likeOperations();
		  System.out.println("ups");
	  }


}