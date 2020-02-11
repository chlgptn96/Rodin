package rodin.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import rodin.repository.mapper.PosterMapper;
import rodin.repository.vo.PosterVo;
import rodin.repository.vo.UserVo;
import rodin.util.Client;
import rodin.util.HandlerFile;

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
	public void sendFile(HttpSession session) {
		String fullPath = (String) session.getAttribute("fullPath");
		Client client = new Client(fullPath);
		String result = client.getResult();
		String js;
		ServletOutputStream out;
		
	}

}