package kr.or.ddit.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberDaoTest {
	
	/*
	 	테스트 메소드 실행 사이클:
	 	@BeforeClass(static)
	 		@Before => @Test => @After(테스트 메소드마다 이 순서로 실행)
	 	@AfterClass(static)
	 */
	MemberDao memberDao;
	
	@Before
	public void deleteMemberTest() {
		memberDao = new MemberDao();
		
		String userid = "ldj";
		
		memberDao.deleteMember(userid);
	}
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
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
		memberDao = new MemberDao();
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(memberList.size(), 15);
		// assertEquals("brown", memberList.get(0).getUserid());
		
	}
	
	@Test
	public void selectPagemember() {
		/*** Given ***/
		memberDao = new MemberDao();
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
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/*** When ***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/*** Then ***/
		assertEquals(15, totalCnt);
	}
	 
	@Test
	public void insertMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		MemberVo memberVo = new MemberVo("ldj", "123", "이동주", "dong", "주소", "상세주소", "12345", "d:\\profile\\sally.png", "sally.png");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	

	
}
