package rodin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import rodin.repository.vo.PosterVo;
import rodin.repository.vo.UserVo;
import rodin.service.AnalysisService;
import rodin.util.Client;
import rodin.util.HandlerFile;

@Controller
@RequestMapping("/merged")
public class TempController {
	private static final Logger logger = LoggerFactory.getLogger(TempController.class);
	
	@Autowired
	AnalysisService analysisService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String analysis(Model model, HttpSession session) {
		//model.addAttribute("serverTime");
		UserVo user = (UserVo) session.getAttribute("user");

		if (user == null) {
			return "redirect:/";
		} else {
			logger.debug("Get Image List");
			List<PosterVo> posterList = analysisService.selectAllFile(user.getEmail());
			System.err.println("List : " + posterList.toString());			
			model.addAttribute("posterList", posterList);			
			return "merged/merged";
		}
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String uploadAction(HttpSession session) {
		logger.debug("Send File to Server");
		logger.debug("Must be fixed! - Send Cropped Image to Server");
		analysisService.sendFile(session);
		return "redirect:/merged";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String analysisAction(
			MultipartHttpServletRequest multipartRequest,
			//HttpServletRequest request,
			//HttpServletResponse response,
			Model model,
			HttpSession session) {
		
		logger.debug("Upload Action");
		
		analysisService.uploadFile(multipartRequest, session);
		
		return "redirect:/merged";
	}
	
}
