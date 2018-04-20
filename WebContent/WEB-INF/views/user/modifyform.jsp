<%@page import="com.javaex.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 	UserVo authUser = new UserVo();
// 	UserVo authUser = (UserVo)session.getAttribute("authUser");
	UserVo userInfo = (UserVo)request.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>

		<div id="wrapper">
			<div id="content">
				<div id="user">

					<form id="join-form" name="joinform" method="post" action="/mysite/user">
					<input type = "text" name = "a" value = "modify">
					<input type = "hidden" name = "no" value = "<%=userInfo.getNo() %>">
						<label class="block-label" for="name">이름</label> <input id="name" name="name" type="text" value="<%=userInfo.getName() %>" /> 
						<label class="block-label" for="email">이메일</label> <input type = "text" name = "email" value = "<%=userInfo.getEmail()%>" readonly = "readonly"><strong></strong> 
						<label class="block-label">패스워드</label> <input name="password" type="password" value="<%=userInfo.getPassword() %>" />

						<fieldset>
							<legend>성별</legend>

							<label>여</label> <input type="radio" name="gender" value="female">
							<label>남</label> <input type="radio" name="gender" value="male"
								checked="checked">

						</fieldset>

						<input type="submit" value="수정완료">

					</form>
				</div>
				<!-- /user -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>
