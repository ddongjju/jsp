package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest extends ModelTestConfig{
   
   @Resource(name = "memberService")
   private MemberServiceI memberService;

   @Test
   public void insertMember_SUCCESS_Test() {
      /*** Given ***/
      MemberVo memberVo = new MemberVo("temp", "pass", "sucess", "우롱차","","","","","");
      
      /*** When ***/
      int insertCnt = memberService.insertMember(memberVo);

      /*** Then ***/
      assertEquals(1, insertCnt);
   }

//   @Test
//   public void insertMember_FAIL_Test() {
//      /*** Given ***/
//      MemberVo memberVo = new MemberVo("스누피", "pass", "FAILTEST", "우롱차","","","","","");
//      
//      /*** When ***/
//      int insertCnt = memberService.insertMember(memberVo);
//      
//      /*** Then ***/
//      assertEquals(1, insertCnt);
//   }
   
   @Test
   public void selectAllMemberTest() {
      /*** Given ***/
      
      /*** When ***/
      List<MemberVo> memberList = memberService.selectAllMember();

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
      Map<String, Object> map = memberService.selectPagemember(pageVo);
      
      /*** Then ***/
      assertEquals(map.size(), 3);
      assertEquals(map.get("pages"), 4);
      assertNotNull(map);
      
   }
   
  
   @Test
   public void deleteMemberTest() {
      /*** Given ***/
      String userid = "brown";
      
      /*** When ***/
      int deleteCnt = memberService.deleteMember(userid);
      
      /*** Then ***/
      assertEquals(deleteCnt, 1);
      
      
   }
   
   @Test
   public void updateMemberTest() {
      /*** Given ***/
      MemberVo memberVo = new MemberVo("brown", "pass", "", "", "", "", "", "", "");
      
      /*** When ***/
      int updateCnt = memberService.updateMember(memberVo);
      
      /*** Then ***/
      assertEquals(updateCnt, 1);
   }
   
   @Test
   public void getMemberTest() {
      /*** Given ***/
      String userid = "brown";
      
      /*** When ***/
      MemberVo memberVo = memberService.getMember(userid);
      
      /*** Then ***/
      assertEquals(memberVo.getUserid(), "brown");
   }
   
   
   
   

}