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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import rodin.repository.vo.PosterVo;
import rodin.repository.vo.UserVo;
import rodin.service.AnalysisService;
import rodin.util.Client;
import rodin.util.HandlerFile;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

	@Value("${access_key}")
	private String accessKey;
	
	@Value("${secret_key}")
	private String secretKey;
	
	@Value("${bucket_name}")
	private String bucketName;
	
	@Autowired
	AnalysisService analysisService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String analysis(Model model, HttpSession session) throws Exception {
		//model.addAttribute("serverTime");
		UserVo user = (UserVo) session.getAttribute("user");

		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		
		if (user == null) {
			return "redirect:/";
		} else {
			logger.debug("Get Image List");
			//List<PosterVo> posterList = analysisService.selectAllFile(user.getEmail());
			List<String> posterList = analysisService.selectAllFileNameS3(s3Client, bucketName, session);
			System.err.println("List : " + posterList.toString());
			model.addAttribute("posterList", posterList);			
			return "analysis/analysis";
		}
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String analysisAction(HttpSession session) {
		logger.debug("Send File to Server");
		logger.debug("Must be fixed! - Send Cropped Image to Server");
		analysisService.sendFile(session);
		return "redirect:/analysis";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadAction(
			MultipartHttpServletRequest multipartRequest,
			//HttpServletRequest request,
			//HttpServletResponse response,
			Model model,
			HttpSession session) {
		
		logger.debug("Upload Action");
		
		analysisService.uploadFile(multipartRequest, session);
		
		return "redirect:/analysis";
	}
	
	@RequestMapping(value="/s3upload", method=RequestMethod.POST)
	public String s3UploadAction(
			@RequestParam("file1") MultipartFile file,
			HttpSession session) throws Exception {
		
		System.err.println(accessKey);
		System.err.println(secretKey);
		
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		
		analysisService.uploadFileS3(s3Client, file, bucketName, session);
		
		return "redirect:/analysis";
	}
	
}
