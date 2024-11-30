<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="forum.ForumDAO" %>
<%@ page import="java.io.PrintWriter" %>
<jsp:useBean id="forum" class="forum.Forum" scope="page" />
<jsp:setProperty name="forum" property="forumTitle" />
<jsp:setProperty name="forum" property="forumContent" />
<!DOCTYPE html>
<html>
<head>>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="EUC-KR">
<title>LogIn Action</title>
</head>
<body>
	<% 
		String userEmail = null;
		if(session.getAttribute("userEmail") != null) {
			userEmail = (String) session.getAttribute("userEmail");
		}
		if(userEmail != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else {
			if (forum.getForumTitle() == null || forum.getForumContent() == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력 안 됨')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				ForumDAO forumDAO = new ForumDAO();
				int result = forumDAO.write(forum.getForumTitle(), forum.getUserEmail(), forum.getForumContent());
				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('작성 실패')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'forum.jsp'");
					script.println("</script>");
				}
			}
		}
	%>
</body>
</html>