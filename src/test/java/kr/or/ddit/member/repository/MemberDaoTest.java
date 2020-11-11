package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

//repository + service : root-context.xml
//sqlSessionTemplate : datasource-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/kr/or/ddit/config/spring/root-context.xml",
									"classpath:/kr/or/ddit/config/spring/datasource-context.xml"})
public class MemberDaoTest {
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;

	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertTrue(memberList.size() > 13);
	}

}
