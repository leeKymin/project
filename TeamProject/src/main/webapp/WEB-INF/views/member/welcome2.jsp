<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome : Member로 Login함
	
	<sec:authorize access="isAuthenticated"> 
		<p>로그인 되었음
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated"> 
		<p>로그인 실패함
	</sec:authorize>
	<br>
	USER ID : <sec:authentication property="name" /> <br><br>
	<a href="/logout">로그 아웃</a>
</body>
</html>






