package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVo getMember(String userId) {
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember",userId);
		
		return memberVo;
	}

	@Override
	public List<MemberVo> selectAllMember() {

		List<MemberVo> memberList = sqlSession.selectList("member.selectAllMember");

		return memberList;
	}

	@Override
	public List<MemberVo> selectPagemember(PageVo pageVo) {
		return sqlSession.selectList("member.pagecount", pageVo);
	}

	@Override
	public int selectMemberTotalCnt() {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("member.insertMember", memberVo);
		} catch (Exception e) {

		}

		if (insertCnt == 1) {
//			sqlSession.commit();
		} else {
//			sqlSession.rollback();
		}
//		sqlSession.close();

		return insertCnt;
	}

	@Override
	public int deleteMember(String userId) {
		int deleteCnt = sqlSession.insert("member.deleteMember", userId);

		if (deleteCnt == 1) {
//			sqlSession.commit();
		} else {
//			sqlSession.rollback();
		}
//		sqlSession.close();

		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		int updateCnt = sqlSession.insert("member.updateMember", memberVo);

		if (updateCnt == 1) {
//			sqlSession.commit();
		} else {
//			sqlSession.rollback();
		}
//		sqlSession.close();

		return updateCnt;
	}


}
