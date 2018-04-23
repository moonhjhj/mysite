<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="/mysite/assets/css/main.css" rel="stylesheet" type="text/css">
	<title>Mysite</title>
</head>
<body>
	<div id="container">
		
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>

		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img style="width: 300px" id="profile" src="/mysite/assets/images/k.jpg">
					<h2> 픽미픽미픽미 </h2>
					<p>
					<br>
						나야나나야나
						<br>
						곤약시리얼 배안부르다
						<br>
						고기먹고싶다
						<br>
						<br>
						<br>
						<a href="/mysite/gb">방명록</a>에 글 남기기
						<br>
					</p>
				</div>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		
	</div>
</body>
</html>