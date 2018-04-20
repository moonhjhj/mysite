<%@page import="com.javaex.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserVo authUser = (UserVo) session.getAttribute("authUser");
%>
<div id="header">
	<h1>
		<a href="/mysite/main">MySite</a>
	</h1>
	<ul>
		<%
			if (authUser == null) {
		%>
		<!-- 로그인 전 -->
		<li><a href="/mysite/user?a=loginform">로그인</a></li>
		<li><a href="/mysite/user?a=joinform">회원가입</a></li>


		<%
			} else {
		%>
		<!-- 로그인 후 -->
		<li><a href="/mysite/user?a=modifyform">회원정보수정</a></li>
		<li><a href="/mysite/user?a=logout">로그아웃</a></li>
		<li>[<a href = "/mysite/main"><%=authUser.getName()%></a>]님이 입장하셨습니다</li>
		<%
			}
		%>




	</ul>
</div>
<!-- /header -->