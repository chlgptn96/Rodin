package rodin.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rodin.repository.vo.UserVo;
import rodin.service.UserService;
import rodin.service.UserServiceImpl;

@Controller
//@ComponentScan("client")
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "user/memberForm";
	}
	
	//@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute UserVo uvo) {
		logger.debug("Sign up Form called in doPost: " + uvo.getUserno());
        boolean isSuccess = false;
        isSuccess = userService.setUser(uvo);
        logger.debug(uvo.toString());
        
        if (isSuccess) {
            logger.debug("Sign up Success");
            return "redirect:/";
        } else {
            logger.debug("Sign up failed");
            return "redirect:/user/memberForm";
        }
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "user/login";
	}
	
	//@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginActon(
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="password", required=false) String password,
			HttpSession session
			) {
		logger.debug("id : " + email);
		logger.debug("pw : " + password);
		if (email.length() == 0 || password.length() == 0) {
            System.err.println("로그인 할 수 없음");
            return "redirect:/user/login";
        }
        UserVo user = userService.getUserByEmailAndPasswordAtService(email, password);

        if (user == null) {
            logger.debug("Sign in Failed");
            return "redirect:/user/login";
        } else {
            logger.debug("Sign in Success!");
            logger.debug("User:" + user.getName());
            session.setAttribute("user", user);
            return "redirect:/";
        }
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutAction(HttpSession session) {
		session.invalidate();
		logger.debug("Logout");
		return "redirect:/";
	}
}
