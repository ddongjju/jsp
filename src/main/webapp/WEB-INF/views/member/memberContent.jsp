<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/layout/commonLib.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	$('#profileDownload').on('click',function(){
		document.location="/profileDownloadView?userid=${memberVo.userid}";
	});
});

</script>
memberContent.jsp

<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data" action="${cp}/member/update" method="get">
					<div class="form-group">
						<label for="profile" class="col-sm-2 control-label">사용자 프로필</label>
						<div class="col-sm-10">
							<img src="${cp}/profileImg?userid=${memberVo.userid}"><br>
							<button id="profileDownload" type="button" class="btn btn-default" >다운로드 : ${memberVo.realFilename }</button>
						</div>
					</div>


					<div class="form-group">
						<label  for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label id="label_userid" class="control-label">${memberVo.userid }</label>
							<input type="hidden" name="userid" value="${memberVo.userid }">
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.usernm }</label>
							<input type="hidden" name="usernm" value="${memberVo.usernm }">
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.alias }</label>
							<input type="hidden" name="alias" value="${memberVo.alias }">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label">********</label>
							<input type="hidden" name="pass" value="${memberVo.pass }">
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.addr1 }</label>
							<input type="hidden" name="addr1" value="${memberVo.addr1 }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.addr2 }</label>
							<input type="hidden" name="addr2" value="${memberVo.addr2 }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.zipcode }</label>
							<input type="hidden" name="zipcode" value="${memberVo.zipcode }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label">
							<fmt:formatDate value="${memberVo.reg_dt }" pattern="YYYY-MM-dd"/>
							<input type="hidden" name="reg_dt" value="${memberVo.reg_dt }">
							</label>
						</div>
					</div>
					
					
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="modBtn" type="submit" class="btn btn-default" >사용자 수정</button>
						</div>
					</div>
				</form>
</html>
