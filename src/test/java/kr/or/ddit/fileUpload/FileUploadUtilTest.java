package kr.or.ddit.fileUpload;

import static org.junit.Assert.assertEquals;

public class FileUploadUtilTest {
	
	public void getFilenameTest() {
		
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);
		/***Then***/
		
		assertEquals(fileName, "sally.png");
	}

}
