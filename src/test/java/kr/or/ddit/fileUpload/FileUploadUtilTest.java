package kr.or.ddit.fileUpload;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);
	
	public void getFilenameTest() {
		
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);
		/***Then***/
		
		assertEquals(fileName, "sally.png");
	}
	
	@Test
	public void UUIDtest() {
		/***Given***/
		

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);
		/***Then***/
	}

}
