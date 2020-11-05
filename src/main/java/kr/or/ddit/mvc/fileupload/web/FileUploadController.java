package kr.or.ddit.mvc.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	//localhost/fileupload/view요청시 화면 요청 처리 메소드
	//jsp로 응답 생성
	//jsp에서는 파일을 선택 할 수 있는 input태그 1개
	//userid파라미터를 보낼수있는 input 태그 1개
	//전송을 담당하는 submit input 태그 1개를 작성
	//jsp : /WEB-INF/views/fileupload/fileupload.jsp
	//테스트 코드까지 작성

	@RequestMapping(path = "/view") 
	public String fileUploadView() {
		logger.debug("FileUploadController.fileUploadView()");
		
		return "fileupload/fileupload";
	}
	
	@RequestMapping(path = "/upload")
	public String upload(String userid,
			@RequestPart("file") MultipartFile file) {
		
		logger.debug("userid : {}",userid);
		logger.debug("name : {} / filename : {} / size : {}",
				file.getName(), file.getOriginalFilename(), file.getSize());
		
		File uploadfile = new File("d:\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(uploadfile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "fileupload/fileupload";
	}
}