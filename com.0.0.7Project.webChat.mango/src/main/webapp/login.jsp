<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="/login.css">
</head>
<body>

	<div id="main">
		<div id="topBack">
			<div id="topleft">
				<img id="topmango" src="mango.png">
				<div id="topleftText">MangoChat Main Page</div>
			</div>
			<div id="topright"></div>
		</div>
		<div id="midBack">
			<div id="midleft">
				<img id="mango"
					src="https://cdn.pixabay.com/photo/2016/03/31/20/02/fresh-1295471_1280.png">
				<div id="mangotext">Mango Chat 0.0.6v</div>
			</div>
			<div id="midright">
				<div id="midrighttop">
					<div id="midPatch">
						<수정사항 및 변경사항> 0.0.6v
					</div>
				</div>
				<div id="midrightbot">
					<div id="login">
					<form action="/chat/login_proc" method="get">
						아이디:<input name="id"><br> 비밀번호:<input name="pw"><br>
						<input type="submit" value="로그인">
					</form>
						<a href="/chat/signUp"><input type="submit" value="회원가입"></a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>