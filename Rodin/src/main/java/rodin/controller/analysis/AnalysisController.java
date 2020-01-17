package rodin.controller.analysis;

import java.io.IOException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import rodin.filetransfer.FileClient;
import rodin.service.analysis.AnalysisService;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);
	
	@Autowired
	AnalysisService analysisService;
	
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
		logger.debug("MultipartFile: " + file);
		
		String uploadFilename = analysisService.store(file);
		
		//	Multipart Resolver 6-8. Upload Method with Model Object
		model.addAttribute("imageFilename", uploadFilename);
		
		//return "파일명: " + uploadFilename;
		
		return "analysis/result";
	}
		


}
