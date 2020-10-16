package kr.or.ddit.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberDaoTest {
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");	

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(memberList.size(), 15);
		// assertEquals("brown", memberList.get(0).getUserid());
		
	}
	
	@Test
	public void selectPagemember() {
		/*** Given ***/
		MemberDao memberDao = new MemberDao();
		PageVo pageVo = new PageVo(1,5); 
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectPagemember(sqlSession,pageVo);
		
		/*** Then ***/
		assertEquals(5, memberList.size());
		assertNotNull(memberList);
	}
	
	@Test
	public void selectMemberTotalCnt() {
		/*** Given ***/
		MemberDao memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/*** When ***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/*** Then ***/
		assertEquals(15, totalCnt);
	}
	  
	

	
}
