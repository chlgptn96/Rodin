package rodin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.services.s3.AmazonS3;

import rodin.repository.vo.PosterVo;
import rodin.util.HandlerFile;

public interface AnalysisService {
	public void uploadFile(MultipartHttpServletRequest multipartRequest, HttpSession session);
	public List<PosterVo> selectAllFile(String email);
	public List<String> selectAllFileNameS3(AmazonS3 s3Client, String bucketName, HttpSession session) throws Exception;
	public void sendFile(HttpSession session);
	public void uploadFileS3(AmazonS3 s3Client, MultipartFile file, String bucketName, HttpSession session) throws Exception;
}
