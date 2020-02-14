package rodin.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3DownloadImage {
	private static Logger logger = LoggerFactory.getLogger(S3DownloadImage.class);
	 
    public static List<String> getImageList(AmazonS3 s3Client, String bucketName, String email) throws Exception {
        
        List<String> posterList= new ArrayList<String>();
        
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        listObjectsRequest.setPrefix(email);
        
        ObjectListing objects = s3Client.listObjects(listObjectsRequest);
        
        do {
            objects = s3Client.listObjects(listObjectsRequest);
            
            for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                logger.info("keyname : " + objectSummary.getKey());
                posterList.add(objectSummary.getKey());
            }
            
            listObjectsRequest.setMarker(objects.getNextMarker());
        } while(objects.isTruncated());
        
        posterList.sort(Comparator.reverseOrder());
        
        return posterList;
    }
}
