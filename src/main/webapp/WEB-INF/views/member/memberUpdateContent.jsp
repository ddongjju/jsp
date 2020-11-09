<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/layout/commonLib.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	$('#zipcodeBtn').on('click',function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            console.log(data);
	            $('#addr1').val(data.roadAddress);
	            $('#zipcode').val(data.zonecode);
	            
	            
	        }
	    }).open();
	})

	$('#regBtn').on('click', function(){
		//client side - validation
		//server side - validation
		//validation 로직은 일단 생략
		$('#frm').submit();

	})
})

function initData(){
	$('#userid').val("ljw");
	$('#usernm').val("이진우");
	$('#alias').val("sem");
	$('#pass').val("pass1234");
	$('#addr1').val("대전 중구 중앙로 76");
	$('#addr2').val("영민빌딩 404호");
	$('#zipcode').val("34904");
	
}
</script>
memberUpdateContent.jsp

<form id="frm" class="form-horizontal" role="form" action="${cp}/member/update" method="post" enctype="multipart/form-data">
               <div class="form-group">
                  <label for="profile" class="col-sm-2 control-label">사용자 사진</label>
                  <div class="col-sm-10">
						<img src="${cp}/profileImg?userid=${memberVo.userid}">
				</div>
                  
                  <div class="col-sm-10">
                     <input type="file" name="realFilename2"/>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="userid" name="userid" placeholder="사용자 아이디" value="${memberVo.userid}" readonly>
                 
                  </div>
               </div>

               <div class="form-group">
                  <label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="usernm" name="usernm" placeholder="사용자 이름" value="${memberVo.usernm}">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="alias" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="alias" name="alias" placeholder="사용자 별명" value="${memberVo.alias}">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">Password</label>
                  <div class="col-sm-10">
                     <input type="password" class="form-control" id="pass" name="pass" placeholder="사용자 비밀번호" value="${memberVo.pass}">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="addr1" class="col-sm-2 control-label">주소</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소" READONLY value="${memberVo.addr1}">
                  	<button id="zipcodeBtn" type="button" class="btn btn-default">우편번호찾기</button>
                  </div>
               </div>
               <div class="form-group">
                  <label for="addr2" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소" value="${memberVo.addr2}">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="zipcode" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호"  READONLY value="${memberVo.zipcode}">
                  </div>
               </div>
               
               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button id="regBtn" type="button" class="btn btn-default">사용자 등록</button>
                  </div>
               </div>
            </form>
</html>