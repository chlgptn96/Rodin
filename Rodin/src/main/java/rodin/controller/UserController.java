package rodin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "user/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginActon() {
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "user/memberForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction() {
		return "user/memberForm";
	}
}
