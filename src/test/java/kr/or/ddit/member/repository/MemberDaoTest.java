package kr.or.ddit.member.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest extends ModelTestConfig{

	@Resource(name = "memberDao")
	private MemberDaoI memberDao;

	@Test
	public void insertMember_SUCCESS_Test() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("temp", "pass", "sucess", "우롱차", "", "", "", "", "");

		/*** When ***/
		int insertCnt = memberDao.insertMember(memberVo);

		/*** Then ***/
		assertEquals(1, insertCnt);
	}

	// @Test
	// public void insertMember_FAIL_Test() {
//	      /*** Given ***/
//	      MemberVo memberVo = new MemberVo("스누피", "pass", "FAILTEST", "우롱차","","","","","");
//	      
//	      /*** When ***/
//	      int insertCnt = memberService.insertMember(memberVo);
//	      
//	      /*** Then ***/
//	      assertEquals(1, insertCnt);
	// }

	@Test
	public void selectAllMemberTest() {
		/*** Given ***/

		/*** When ***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/*** Then ***/
		assertEquals(memberList.size(), 16);

	}

	@Test
	public void selectMemberPageListTest() {
		/*** Given ***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(5);

		/*** When ***/
		List<MemberVo> map = memberDao.selectPagemember(pageVo);

		/*** Then ***/
		assertNotNull(map);

	}

	@Test
	public void deleteMemberTest() {
		/*** Given ***/
		String userid = "brown";

		/*** When ***/
		int deleteCnt = memberDao.deleteMember(userid);

		/*** Then ***/
		assertEquals(deleteCnt, 1);

	}

	@Test
	public void updateMemberTest() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("brown", "pass", "", "", "", "", "", "", "");

		/*** When ***/
		int updateCnt = memberDao.updateMember(memberVo);

		/*** Then ***/
		assertEquals(updateCnt, 1);
	}

	@Test
	public void getMemberTest() {
		/*** Given ***/
		String userid = "brown";

		/*** When ***/
		MemberVo memberVo = memberDao.getMember(userid);

		/*** Then ***/
		assertEquals(memberVo.getUserid(), "brown");
	}

	@Test
	public void selectMemberTotalCntTest() {
		/*** Given ***/

		/*** When ***/
		int total = memberDao.selectMemberTotalCnt();

		/*** Then ***/
		assertEquals(total, 16);

	}
	
	

}
