<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#get').click(function(){
			$('#form1').attr('method','get');

		})
		$('#post').click(function(){
			$('#form1').attr('method','post');
		})
	})

	

</script>

</head>
<body>
	<%--파라미터 : client 서버로 요청을 보낼때 추가적으로 보낸 값 
				ex : 로그인 요청시 : 사용자 id, 비밀번호
				
		파라미터는 내부적으로 Map<String, String[]>객체로 관리를 한다
						파라미터 이름, 파라미터 값들
						==> 동일한 이름의 파라미터를 여러개 보낼 수 있다
		request 객체에 있는 파라미터 관련 메소드 4가지
		getParameter(String param) : param에 해당하는 파라미터 값을 조회한다
									파라미터 맵에서 첫번째 값을 반환
		String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환
		
		Map<String, String[]> getParameterMap() : request객체에 생성된 파라미터 맵을 반환

		Enumeration<String> getParameterNames() : request객체에 담신 보든 파라미터 이름을 반환					
	--%>
	<%--한글 파라미터 설정 
		get : server.xml <Connector URIEncoding="utf-8">
		post : request.setCharacterEncoding("utf-8");
			   request.getParameter()메소드를 호출하기 전에 설정을 해줘야 한다.
	--%>
	<%--action : 요청을 보낼 경로
		method : 요청 방식(form에서는 GET, POST 두가지만 가능하면 DEFAULT는 GET)
	 --%>
	<form id="form1" action="${pageContext.request.contextPath }/request/requestResponse.jsp" method="get">
		<label>user id : </label>
		<input type="text" name="userId" value="브라운"><br>
		
		<label>user id : </label>
		<input type="text" name="userId" value="셀리"><br>
		
		<label>password: </label>
		<input type="password" name="pass" value="pass1234"><br>
		<input type="submit" value="전송">
	</form>
	
	GET POST 두가지를 선택할수 있는 라디오 버튼을 만들어서<br>
	FORM전송시 사용자가 GET, POST 방식을 지정할 수 있도록<br>
	<input type="radio" name="method" value="GET" id="get">get방식<br>
	<input type="radio" name="method" value="POST" id="post">post방식
</body>
</html>