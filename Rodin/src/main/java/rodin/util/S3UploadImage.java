package rodin.util;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import rodin.repository.vo.UserVo;

public class S3UploadImage {
	private static Logger logger = LoggerFactory.getLogger(S3UploadImage.class);
	 
    public static void upload(AmazonS3 s3client, MultipartFile file, String bucketName, String email) {
    	
        ObjectMetadata omd = new ObjectMetadata();
        
        //UserVo user = (UserVo) session.getAttribute("user");
        
        String folderName = email;
        
        try {            
            omd.setContentType(file.getContentType());
            omd.setContentLength(file.getSize());
            omd.setHeader("filename", file.getOriginalFilename());
            
            PutObjectRequest putObjectRequest = 
                    new PutObjectRequest(bucketName, folderName  + "/" + System.currentTimeMillis(), file.getInputStream(), omd);
            
            putObjectRequest.setCannedAcl(CannedAccessControlList.Private);
            s3client.putObject(putObjectRequest);
            logger.info("======== Upload completed !!!! =======");

 
        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
