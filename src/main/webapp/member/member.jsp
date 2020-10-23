<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp"%>


</head>

<body>
<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data" action="${cp}/memberUpdate" method="get">
					<div class="form-group">
						<label for="profile" class="col-sm-2 control-label">사용자 프로필</label>
						<div class="col-sm-10">
							<img src="${cp}/profileImg?userid=${memberVo.userid}">
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
			</div>
		</div>
	</div>
</body>
</html>
