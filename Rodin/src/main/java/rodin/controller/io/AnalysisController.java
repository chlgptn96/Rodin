package rodin.controller.io;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import rodin.filetransfer.FileClient;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	
	@RequestMapping
	@ResponseBody
	public String imageClient() throws UnknownHostException, IOException {
		FileClient fc = new FileClient("localhost", 5000);
		return "Client!";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "analysis/form";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		return "analysis/form";
	}
		


}
