package kr.or.ddit.mvc.member.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1")int page,
			@RequestParam(name = "pageSize",required = false, defaultValue = "5")int pageSize,
			Model model) {
		
		PageVo pageVo = new PageVo(page,pageSize);
		
		Map<String, Object> map = memberService.selectPagemember(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("pageSize", map.get("pageSize"));
		
		
		return "member/memberList";	
	}
	
	@RequestMapping("/member")
	public String getmember(String userid, Model model) {
		
		MemberVo memberVo = memberService.getMember(userid);
		
		model.addAttribute("memberVo", memberVo);
		
		return "member/member";	
	}
	
	
	@RequestMapping(path = "/regist", method = RequestMethod.GET)
	public String registView() {
		return "member/memberRegist";	
	}

	
	@RequestMapping(path = "/regist", method = RequestMethod.POST)
	public String memberRegist(MemberVo memberVo, @RequestPart("realFilename2") MultipartFile profile) {

		String realFileName = profile.getOriginalFilename();
		String ext = FileUploadUtil.getExtension(realFileName);
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		if (profile.getSize() > 0) {
			filePath = "D:\\profile\\" + fileName + "." + ext;
			File file = new File("D:\\profile\\" + realFileName);
			try {
				profile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		memberVo.setFilename(filePath);
		memberVo.setRealFilename(realFileName);

		int cnt = memberService.insertMember(memberVo);

		if (cnt == 1) {
			return "redirect:/member/list";
		} else {
			return "member/memberRegist";
		}
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public String memberUpdateView(String userid, Model model) {

		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberUpdate";
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String memberUpdate(String userid, MemberVo memberVo, @RequestPart("realFilename2") MultipartFile profile) {
		
		MemberVo memberVo2 = memberService.getMember(userid);
		
		String realFileName = profile.getOriginalFilename();
		String ext = FileUploadUtil.getExtension(realFileName);
		String fileName = "";
		String fileName2 = "";
		if (profile.getSize() > 0) {
			fileName = "D:\\profile\\" + UUID.randomUUID().toString() + "." + ext;
			File file = new File("D:\\profile\\" + realFileName);
			try {
				profile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			memberVo.setFilename(fileName);
			memberVo.setRealFilename(realFileName);

		} else {
			fileName = memberVo2.getFilename();
			fileName2 = memberVo2.getRealFilename();

			memberVo.setFilename(fileName);
			memberVo.setRealFilename(fileName2);
		}

		memberService.updateMember(memberVo);
		
		return "redirect:/member/member?userid=" + memberVo.getUserid();
	}
	
	
	 
}
