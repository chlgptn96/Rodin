package rodin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rodin.repository.vo.UserVo;

@Controller
@RequestMapping("/font")
public class AnalysisController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String analysis(HttpSession session) {
		
		UserVo user = (UserVo) session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		} else {
			return "font/font";
		}
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String analysisAction() {
		return "redirect:/font/font";
	}
}
