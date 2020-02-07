package rodin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	// @ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping("/bgp")
	public String analysis() {
		return "BgParallelism";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board/board";
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

}
