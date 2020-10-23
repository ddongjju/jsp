package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
   
   private MemberServiceI memberService;
   
   MemberVo memberVo;
   
   @Override
   public void init() throws ServletException {
      memberService = new MemberService();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");

		memberVo = memberService.getMember(userid);
		request.setAttribute("memberVo", memberVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberUpdate.jsp");
		dispatcher.forward(request, response);
	   
	}

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");

		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);

		Part profile = request.getPart("realFilename");
		logger.debug("file : {} ", profile.getHeader("Content-Disposition"));

		String fileName = "";
		String realFilename = "";
		String check = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		
		if(check.equals("") || check == null) {
			fileName = memberVo.getFilename();
			realFilename = memberVo.getRealFilename();
		} 
		if (profile.getSize() > 0) {
			realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String ext = FileUploadUtil.getExtension(realFilename);
			fileName = "D:\\profile\\" + UUID.randomUUID().toString() + "." + ext;
			profile.write(fileName);
		}

		// 사용자 정보 등록
		memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, fileName, realFilename);
		
		int cnt = memberService.updateMember(memberVo);

		if (cnt == 1) {
			String redirectUrl = request.getContextPath() + "/member?userid="+userid;
			response.sendRedirect(redirectUrl);
		} else {
			doGet(request, response);
		}
   }

}