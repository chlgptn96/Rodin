package rodin.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3ObjectOperation {
	private static final Logger logger = LoggerFactory.getLogger(S3ObjectOperation.class);
	
	/*
	
	private static S3Client s3;
	
	public S3ObjectOperation(String bucket, String key) throws IOException {
		
		logger.debug("Upload to S3");
		
		Region region = Region.AP_NORTHEAST_2;
		
		s3 = S3Client.builder().region(region).build();
		System.err.println("Region : " + region.toString());
		System.err.println("Bucket : " + bucket);
		System.err.println("Key : " + key);
		
		s3.putObject(
				PutObjectRequest.builder().bucket(bucket).key(key).build(),
				RequestBody.fromByteBuffer(getRandomByteBuffer(10_000))
				);
		String multipartKey = "multipartKey";
		multipartUpload(bucket, multipartKey);
		
		ListObjectsV2Request listObjectsRequestManual = ListObjectsV2Request.builder().bucket(bucket).maxKeys(1).build();
		
		boolean done = false;
		while(!done) {
			ListObjectsV2Response listObjectsResponse = s3.listObjectsV2(listObjectsRequestManual);
			for (S3Object content: listObjectsResponse.contents()) {
				System.out.println(content.key());
			}
			
			if (listObjectsResponse.nextContinuationToken() == null) {
				done = true;
			}
			
			listObjectsRequestManual = listObjectsRequestManual
					.toBuilder().continuationToken(listObjectsResponse.nextContinuationToken()).build();
		}
		
		ListObjectsV2Request listRequest = ListObjectsV2Request.builder().bucket(bucket).maxKeys(1).build();
		
		ListObjectsV2Iterable listResponse = s3.listObjectsV2Paginator(listRequest);
		
		listResponse.stream()
			.flatMap(r -> r.contents().stream())
			.forEach(content -> System.out.println(" Key: " + content.key() + " size = " + content.size()));
		
		listResponse.contents().stream()
			.forEach(content -> System.out.println(" Key: " + content.key() + " size = " + content.size()));
		
		for (S3Object content: listResponse.contents()) {
			System.out.println(" Key: " + content.key() + " size = " + content.size());
		}
		
		s3.getObject(
				GetObjectRequest.builder().bucket(bucket).key(key).build(),
				ResponseTransformer.toFile(Paths.get("multipartKey"))
				);
		
		logger.debug("Finish");
		
	}
	
	private static void multipartUpload(String bucketName, String key) throws IOException {
		int MB = 1024 * 1024;
		
		CreateMultipartUploadRequest createMultipartUploadRequest = CreateMultipartUploadRequest
				.builder().bucket(bucketName).key(key).build();
		CreateMultipartUploadResponse response = s3.createMultipartUpload(createMultipartUploadRequest);
		String uploadId = response.uploadId();
		System.err.println(uploadId);
		
		UploadPartRequest uploadPartRequest1 = UploadPartRequest
				.builder().bucket(bucketName).key(key).uploadId(uploadId).partNumber(1).build();
		String etag1 = s3.uploadPart(uploadPartRequest1, RequestBody.fromByteBuffer(getRandomByteBuffer(5 * MB))).eTag();
		CompletedPart part1 = CompletedPart.builder().partNumber(1).eTag(etag1).build();
		
		UploadPartRequest uploadPartRequest2 = UploadPartRequest
				.builder().bucket(bucketName).key(key).uploadId(uploadId).partNumber(2).build();
		String etag2 = s3.uploadPart(uploadPartRequest2, RequestBody.fromByteBuffer(getRandomByteBuffer(3 * MB))).eTag();
		CompletedPart part2 = CompletedPart.builder().partNumber(2).eTag(etag2).build();
		
		CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder().parts(part1, part2).build();
		CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest
				.builder().bucket(bucketName).key(key).uploadId(uploadId).multipartUpload(completedMultipartUpload).build();

		s3.completeMultipartUpload(completeMultipartUploadRequest);
	}
	
	private static ByteBuffer getRandomByteBuffer(int size) {
		byte[] b = new byte[size];
		new Random().nextBytes(b);
		return ByteBuffer.wrap(b);
	}
	*/
	
}