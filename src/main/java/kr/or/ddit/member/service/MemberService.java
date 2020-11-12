package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

@Transactional
@Service("memberService")
public class MemberService implements MemberServiceI {
	

	@Resource(name="memberDao")
//	@Autowired
	private MemberDaoI memberDao;
	
	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVo> selectAllMember() {
		return memberDao.selectAllMember();
	}

	@Override
	public Map<String, Object> selectPagemember(PageVo pageVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectPagemember(pageVo));

		int totalCnt = memberDao.selectMemberTotalCnt();
		int pages = (int) Math.ceil((double) totalCnt / pageVo.getPageSize());
		map.put("pages", pages);
		map.put("pageSize", pageVo.getPageSize());

		return map;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		return memberDao.insertMember(memberVo);
	}

	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(userId);
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		return memberDao.updateMember(memberVo);
	}


	
	
	

}
