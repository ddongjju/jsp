<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.jobs.model.JobsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<JobsVo> list = (List<JobsVo>)request.getAttribute("JobsVo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="border: 1px solid pink; text-align: center">
			<tr>
				<td>이름</td>
				<td>제목</td>
			</tr>
			<%for(int i =0; i<list.size(); i++){%>
			<tr>
				<td><%=list.get(i).getJob_id() %></td>
				<td><%=list.get(i).getJob_title() %></td>
			</tr>
			<%}%>
		</table>
</body>
</html>