<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeamProject</title>
</head>
<body>
<table border="1" width="400">
	<tr><td>
	<br>
		<span style="color:green; font-weight : bold;">관리자 로그인</span>
		
		<!-- 로그인창 -->
		<form action ="admin_login.do" method = "post">
		<br>
		-관리자 아이디- <input type = "text" name="admin_id" placeholder="  ID를 입력하세요 "><br><br>
		-관리자 비밀번호- <input type = "password" name="admin_pass" placeholder="  비밀번호를 입력하세요 "><br><br>
		<button type = "submit" name = "submit" >로그인</button>
		<br><br>
		
		<div class = "row">
		    <div class="col-xs-8">
		        <div class="checkbox icheck">
		        <label>
		            <input type = "checkbox" name = "useCookie"> 로그인유지
		        </label>
		        </div>
		    </div>
		</div>
		</form>
	</td></tr>
</table>
</body>
</html>