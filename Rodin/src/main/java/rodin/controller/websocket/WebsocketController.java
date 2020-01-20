package rodin.controller.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebsocketController {
	private static final Logger logger = LoggerFactory.getLogger(WebsocketController.class);

	@RequestMapping(value="/analysis", method=RequestMethod.GET)
	public ModelAndView getMessage(ModelAndView mv) {
		
		mv.setViewName("analysis");
		
		// User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// logger.debug("user name: " + user.getUsername());
		
		logger.debug("normal chat page");
		
		// mv.addObject("userid", user.getUsername());
		return mv;
	}
}
