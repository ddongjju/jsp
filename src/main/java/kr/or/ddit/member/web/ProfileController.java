package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@Controller
public class ProfileController {
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	
	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model)throws IOException{
		//응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream객체에 쓰는것
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());
		
		return "profileImgView";
	}
	
	
	@RequestMapping("/profileDownloadView")
	public String profileDownloadView(String userid, Model model, HttpServletResponse response)throws IOException{
		
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());

		return "profileDownloadView";
	}
	
	
	

	@RequestMapping("/profileImg")
	public void profileImg(String userid, HttpServletResponse response) throws IOException {
		response.setContentType("image/png");

		MemberVo memberVo = memberService.getMember(userid);

		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();
		sos.flush();
		sos.close();
	}
	
	
	

}
