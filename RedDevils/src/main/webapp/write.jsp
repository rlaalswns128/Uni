<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- bootstrap 5 적용 --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Main</title>
</head>
<body>
	<%
		String userEmail = null;
		if(session.getAttribute("userEmail") != null) {
			userEmail = (String) session.getAttribute("userEmail");
		}
	%>
	<%-- 메뉴 바 구성 --%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="main.jsp">Red Devils Korea</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="main.jsp">메인</a></li>
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="forum.jsp">게시판</a></li>
				</ul>
			</div>
	<%
		if(userEmail == null) {
	%>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							접속하기</a>
						<%-- dropdown-menu-end를 안하면 오른쪽에 있을 때 dropdown-menu 가 짤리게 된다. --%>
						<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item active" href="login.jsp">로그인</a></li>
							<li><a class="dropdown-item active" href="join.jsp">회원가입</a></li>
						</ul>
					</li>
				</ul>
	<%
		} else {
	%>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							회원관리<span class="caret"></span></a>
						<%-- dropdown-menu-end를 안하면 오른쪽에 있을 때 dropdown-menu 가 짤리게 된다. --%>
						<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item active" href="logoutAction.jsp">로그아웃</a></li>
						</ul>
					</li>
				</ul>
	<%
		}
	%>
		</div>
	</nav>
	
 	<%-- 로그인 화면 구성 --%>
	<div class="container">
	
	<%-- 화면의 동적 움직임을 자연스럽게 하기위해 lg, md, sm값 조정 / mx-auto를 넣어줘야 div 가 중앙으로 정렬됨 --%>
		<div class="row-lg-6 row-md-6 row-sm-6 mx-auto"></div>
		<div class="row-lg-6 row-md-6 row-sm-6 mx-auto">
		
	<%-- bootstrap 5 버전 부터는 jumbotron을 지원해주지 않아서 p-5 text-center bg-light을 통해 만듬 --%>
			<form method="post" action="writeAction.jsp">
				<table class="table table-stripped" style="text-align: center; border: 1px solid #dddddd">
					<thread>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align:center;">게시판 글쓰기 양식</th>
						</tr>
					</thread>
					<tbody>
						<tr>
							<td><input type="text" class= form-control placeholder="글 제목" name="forumTitle" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea type="text" class= form-control placeholder="글 내" name="forumContent" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
					<input type="submit" class="btn btn-primary pull-right" value="글 쓰기">
			</form>
		</div>
	</div>
	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>