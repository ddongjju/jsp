package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{

	@Override
	public MemberVo getMember(String userId) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember",userId);
		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVo> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		List<MemberVo> memberList = sqlSession.selectList("member.selectAllMember");

		sqlSession.close();

		return memberList;
	}

	@Override
	public List<MemberVo> selectPagemember(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("member.pagecount", pageVo);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("member.insertMember", memberVo);
		} catch (Exception e) {

		}

		if (insertCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return insertCnt;
	}

	@Override
	public int deleteMember(String userId) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.insert("member.deleteMember", userId);

		if (deleteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.insert("member.updateMember", memberVo);

		if (updateCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return updateCnt;
	}


}
