package kr.or.ddit.member.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberControllerTest extends WebTestConfig{
		
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Before
	public void setUp() { 
		
		String userid = "ddd";
		
		memberService.deleteMember(userid);
	}
	
	
	@Test
	public void listTest() throws Exception {
		mockMvc.perform(get("/member/list")).andExpect(status().isOk()).andExpect(view().name("tiles/member/memberListContent"));
	}
	
	@Test
	public void getmemberTest() throws Exception{
		mockMvc.perform(get("/member/member").param("userid", "brown")).andExpect(status().isOk())
				.andExpect(view().name("tiles/member/memberContent"));
		
	}

	@Test
	public void registViewTest() throws Exception {
		mockMvc.perform(get("/member/regist")).andExpect(status().isOk()).andExpect(view().name("tiles/member/memberRegistContent"));
	}
	
	@Test
	public void memberUpdateViewTest() throws Exception {
		mockMvc.perform(get("/member/update").param("userid", "brown")).andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memberUpdateContent"));

	}
	
	@Test
	public void memberRegistTest() throws Exception {
		InputStream is =  getClass().getResourceAsStream("/kr/or/ddit/upload/moon.png");
		MockMultipartFile file = new MockMultipartFile("realFilename2", "moon.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/regist")
				.file(file)
				.param("userid", "ddd")
				.param("usernm", "브라운")
				.param("alias", "별명")
				.param("pass", "1234")
				.param("addr1", "123")
				.param("addr2", "123")
				.param("zipcode", "123")
				).andExpect(status().is(302))
				.andExpect(view().name("redirect:/member/list"));
	}
	
	@Test
	public void memberUpdateTest() throws Exception {
		InputStream is =  getClass().getResourceAsStream("/kr/or/ddit/upload/moon.png");
		MockMultipartFile file = new MockMultipartFile("realFilename2", "moon.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/update")
				.file(file)
				.param("userid", "ddd")
				.param("usernm", "이름이야2")
				.param("alias", "별명")
				.param("pass", "1234")
				.param("addr1", "123")
				.param("addr2", "123")
				.param("zipcode", "123")
				).andExpect(status().is(302))
				.andExpect(view().name("redirect:/member/member?userid=ddd"));
	}
	
	
}
