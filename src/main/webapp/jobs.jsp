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

<%@ include file="/layout/commonLib.jsp" %>

</head>
<body>

<%@ include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">Jobs</h2>
						<div class="table-responsive">
							<table class="table table-striped">

								<tr>
									<th>이름</th>
									<th>제목</th>
								</tr>
								<%
									for (int i = 0; i < list.size(); i++) {
								%>
								<tr>
									<td><%=list.get(i).getJob_id()%></td>
									<td><%=list.get(i).getJob_title()%></td>
								</tr>
								<%}%>
							</table>
						</div>

						<a class="btn btn-default pull-right">등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
