<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>Insert title here</title>
	
	</head>
	<body onLoad="func()">

		<h1>
			管理员登录
		</h1>
		<form action="loginByAdmin.action">
			<label>
				管理员账号：
			</label>
			<input type="text" name="username" />
			<br>
			<label>
				管理员密码：
			</label>
			<input type="password" name="password" />
			<br>
			<input type="submit" value="登录" />
		</form>
	</body>
</html>