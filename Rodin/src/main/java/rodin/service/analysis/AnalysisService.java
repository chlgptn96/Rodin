package rodin.service.analysis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AnalysisService {

	private static String SAVE_PATH = "/upload";
	private static final Logger logger = LoggerFactory.getLogger(AnalysisService.class);
	
//	Save File 
	public String store(MultipartFile mFile) {
		//	실제 클라이언트에서의 파일 이름
		//	Need Rename
		//	Rename이 필요할 것 같음
		String savedFilename="";
		
		String originalFilename = mFile.getOriginalFilename();
		Long size = mFile.getSize();
		
		logger.debug("원본 파일명: " + originalFilename);
		logger.debug("파일의 사이즈: " + size);
		
		//	Multipart Resolver 6-5. Renaming(Duplicate Preventation)
		//	Multipart Resolver 6-5-1. Remane, Substring
		//	파일명 변경, 확장자 분리
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		logger.debug("파일의 확장자: " + extName);
		//	Multipart Resolver 6-5-2. Duplicate Preventation
		//	파일명 생성(시스템 날짜를 이용하여 중복방지)
		Calendar cal = Calendar.getInstance();
		savedFilename = String.valueOf(cal.getTimeInMillis()) + extName;
		logger.debug("새로 만든 파일명: " + savedFilename);
		
		try {
			//	Multipart Resolver 6-4. Save File Exception
			//	Multipart Resolver 6-5-3. Change Filename to Saved Filename
			//writeFile(mFile, originalFilename);
			writeFile(mFile, savedFilename);
		} catch (Exception e) {
			throw new RuntimeException(e);
			//	익셉션의 전환 : 커스텀 익셉션 만들어 처리할 것을 권장
		}
		//return originalFilename;
		return savedFilename;
	}
	
	//	6-3-2. Save File Method
	//	실제 저장을 위한 메서드
	private void writeFile(MultipartFile mFile, String saveFilename) throws IOException {
		byte[] fileData = mFile.getBytes();
		
		//	저장을 위해 FileOutputStream을 생성
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}
}
