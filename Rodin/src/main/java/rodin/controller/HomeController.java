package rodin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rodin.repository.vo.UserVo;
import rodin.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	// @ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/autologin", method=RequestMethod.GET)
	public String AutoLogin(HttpSession session) {

        UserVo user = userService.getUserByEmailAndPasswordAtService("tester", "1234");
        session.setAttribute("user", user);
		return "redirect:/merged";
	}
	
	@RequestMapping("/bgp")
	public String analysis() {
		return "BgParallelism";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board/board";
	}
	
	@RequestMapping("/font")
	public String font() {
		return "font/font";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage/mypage";
	}
	
	@RequestMapping("/poster")
	public String poster() {
		return "poster/poster";
	}
	
	@RequestMapping("/statics")
	public String statics() {
		return "statics/statics";
	}
	
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	
	@RequestMapping("/cropper")
	public String cropper() {
		return "cropper/cropper";
	}
	
	@RequestMapping("/merged")
	public String merged() {
		return "merged/merged";
	}

}
