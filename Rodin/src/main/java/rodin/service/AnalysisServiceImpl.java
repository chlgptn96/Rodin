package rodin.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.services.s3.AmazonS3;

import rodin.repository.mapper.PosterMapper;
import rodin.repository.vo.PosterVo;
import rodin.repository.vo.UserVo;
import rodin.util.Client;
import rodin.util.HandlerFile;
import rodin.util.S3DownloadImage;
import rodin.util.S3UploadImage;

@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService {
	private static final Logger logger = LoggerFactory.getLogger(AnalysisServiceImpl.class);
	
	@Autowired
	PosterMapper posterMapper;
	
	@Override
	public void uploadFile(MultipartHttpServletRequest multipartRequest, HttpSession session) {
		UserVo user = (UserVo) session.getAttribute("user");
		
		String userEmail = user.getEmail();
		//String filePath = session.getServletContext().getRealPath("images/tmp");
		String filePath = "D:\\repository\\tmp\\" + user.getEmail();
		
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		logger.debug(filePath);
		HandlerFile handlerFile = new HandlerFile(multipartRequest, filePath, userEmail);
		
		Map<String, List<String>> fileNames = handlerFile.getUploadFileName();
		
		logger.debug("oldNames : " + fileNames.get("oldNames").get(0));
		logger.debug("saveNames : " + fileNames.get("saveNames").get(0));
			
		PosterVo poster = new PosterVo();
		poster.setOwner(user.getEmail());
		poster.setOriginName(fileNames.get("oldNames").get(0));
		poster.setSavedName(fileNames.get("saveNames").get(0));
		
		posterMapper.insertPoster(poster);
		
		System.err.println("filename : " + fileNames.toString());

		String fileName = handlerFile.getFileFullPath();
		
		session.setAttribute("fullPath", fileName);
		/*
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getOutputStream();
			
			if ("null".equals(result) || "fail".equals(result)) {
				js = "<script>history.back(); alert('Result : Error! Page Reload!');</script>";
			} else {
				js = "<script>alert('Result : " + result + "'); location.href='https://www.google.co.kr/search?q=" + result + "'</script>";
			}
			
			out.println(js);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public List<PosterVo> selectAllFile(String email) {
		List<PosterVo> list = posterMapper.selectAllPosterByEmail(email);
		return list;
	}
	
	@Override
	public List<String> selectAllFileNameS3(AmazonS3 s3Client, String bucketName, HttpSession session) throws Exception {
		UserVo user = (UserVo) session.getAttribute("user");
		String email = user.getEmail();
		List<String> posterList = S3DownloadImage.getImageList(s3Client, bucketName, email);
		return posterList;
	}

	@Override
	public void sendFile(HttpSession session) {
		String fullPath = (String) session.getAttribute("fullPath");
		Client client = new Client(fullPath);
		String result = client.getResult();
		String js;
		ServletOutputStream out;
		
	}
	

	@Override
	public void uploadFileS3(AmazonS3 s3Client, MultipartFile file, String bucketName, HttpSession session) throws Exception {
			UserVo user = (UserVo) session.getAttribute("user");
			String email = user.getEmail();
			
			Map<String, String> fileName = S3UploadImage.upload(s3Client, file, bucketName, email);
			
			PosterVo poster = new PosterVo();
			poster.setOwner(user.getEmail());
			poster.setOriginName(fileName.get("oldName"));
			poster.setSavedName(fileName.get("newName"));

			posterMapper.insertPoster(poster);
			
			// 삭제예정
			session.setAttribute("fileName", fileName);
			
			System.err.println("filename : " + fileName.toString());
			
	}

	@Override
	public void selectFileByFontName(JSONObject analysisResult) {
		System.err.println("Get Font Info");

		@SuppressWarnings("unchecked")
		List<List<Object>> res = (List<List<Object>>) analysisResult.get("result");				
		List<Map<String, List<Map<String, Object>>>> result = addResult(res);
				
		System.err.println("result : " + result);
	}
	
	public static List<Map<String, List<Map<String, Object>>>> stringListToMap(List<List<Object>> analysisResultList) {
		return addResult(analysisResultList);
	}
	
	public static List<Map<String, List<Map<String, Object>>>> addResult(List<List<Object>> analysisResult) {
		List<Map<String, List<Map<String, Object>>>> sortedList = new ArrayList<Map<String, List<Map<String, Object>>>>();
		Map<String, List<Map<String, Object>>> accuracyRanking = null;
		List<Map<String, Object>> fontInfo = null;
		
		List<String> rank = new ArrayList<String>();
		rank.add("accu_1st");
		rank.add("accu_2nd");
		// rank.add("accu_3rd");
		// rank.add("accu_4th");
		// rank.add("accu_5th");
		
		Map<String, Object> fontName = null;
		Map<String, Object> accuracy = null;
		
		for (int i = 0; i < analysisResult.size(); i++) {
			fontName = new HashMap<String, Object>();
			accuracy = new HashMap<String, Object>();
			fontName.put("font", (String) analysisResult.get(i).get(0));
			accuracy.put("accu", (Double) analysisResult.get(i).get(1));
			
			fontInfo = new ArrayList<Map<String, Object>>();
			fontInfo.add(fontName);
			fontInfo.add(accuracy);
			
			accuracyRanking = new HashMap<String, List<Map<String, Object>>>();
			accuracyRanking.put(rank.get(i), fontInfo);

			sortedList.add(accuracyRanking);
		}		
		return sortedList;
	}
}
