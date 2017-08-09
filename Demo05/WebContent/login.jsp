<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="./Info/login" method="post">
		<div class="container">
			<div style="border-bottom:1px solid red">
				<div class="title">用户</div>
				<div class="input">
					<input type="text" name="name" style="width:50%"/>
				</div>
			</div>
			<div style="border-bottom:1px solid red">
				<div class="title">密码</div>
				<div class="input">
					<input name="intro" type="password"  rows="4" cols="50"></textarea>
				</div>
			</div>
			<div style="margin-top:30px;text-align:right">
				<input type="submit" value="登陆" />
				<input type="reset"  value="重置" />
			</div>
		</div>
	</form>
</body>
</html>