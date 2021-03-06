<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#lang').val("${param.lang == null ? 'ko' : param.lang}");
	$("#lang").on('change',function(){
		document.location="/jstl/jstl_fmt.jsp?lang="+$("#lang").val();
	})
})

</script>
</head>
<body>
	<!-- 1. jquery 라이브러리 추가
		 2. select box 생성
		 	option 3가지를 언어 (ko, ja, en)선택가능
		 3. 페이지가 로딩이 되었을때 사용자가 요청한 언어로 
		 	option태그가 선택이 된 상태로 표현
		 4. 만약에 사용자가 언어 설정 파라미터를 보내지 않았을 경우 기본값으로 한국어가 설정되게끔
		 5. option 태그가 바뀌면 자동으로 jst_fmt.jsp로 재요청
	 -->
	 
	<select name="lang" id="lang">
		<option value="ko">ko</option>
		<option value="ja">ja</option>
		<option value="en">en</option>
	</select>
	
	<br><br>

	<!-- local 정보를 변경 -->
<%-- 	<% request.getParameter("lang");%> --%>
	<fmt:setLocale value="${param.lang }"/>
	<!-- 사용할 리소스 번들 설정(리소스번들명_로케일.properties) 
		kr.or.ddit.resource message_로케일.properties-->
	<%
		request.setAttribute("userId", "brown");
	%>
	<fmt:bundle basename="kr.or.ddit.resource.message">
		<fmt:message key="GREETING" var="greeting"/>[${greeting }]<br>
		<fmt:message key="LOGIN_MSG">
			<fmt:param value="${userId }"/>
		</fmt:message>
	</fmt:bundle> 
	
	<h3>setBundle</h3>
	<!-- set bundle : 번들 메세지를 변수에 저장하여 message태그에서 사용하게끔 하는 태그 -->
	<fmt:setBundle basename="kr.or.ddit.resource.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg}"/>



	
	
	
	
	
	
	
	
	
</body>
</html>