<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<String> list = (List<String>)request.getAttribute("rangers"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	dispatcherView.jsp
	
	<table>
		<tr>
			<td>이름</td>
		</tr>
		<%for(int i =0; i<list.size(); i++){%>
		<tr>
			<td><%=list.get(i) %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>