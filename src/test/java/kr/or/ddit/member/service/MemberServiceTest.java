package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	@Test
	public void getMemberTest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/*** When ***/
		MemberVo memberVo = memberService.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());

//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		
		/*** When ***/
		List<MemberVo> memberList = memberService.selectAllmember();
		
		/*** Then ***/
		assertNotNull(memberList);
	}
	
	@Test
	public void selectPagemember() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		PageVo pageVo = new PageVo(1,5); 
		/*** When ***/
		//memberList 확인
		Map<String, Object> map = memberService.selectPagemember(pageVo);
		List<MemberVo> memberList = (List<MemberVo>) map.get("memberList");
		
		//생성해야할 page수
//		int pages = (Integer)map.get("pages");
		/*** Then ***/
		assertEquals(5, memberList.size());
//		assertEquals(3, pages);
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug("{}", locale);
		}
		
	}

}
