<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<style>
* {
	box-sizing: border-box;
	margin: 0%;
	padding: 0%;
	font-family: Arial, Helvetica, sans-serif;
}

.head {
	border: 1px solid rgb(175, 175, 231);
	font-weight: bold;
	background-color: #EBF1F7;
}

.head h3 {
	margin: 15px 0 15px 10px;
	color: #00154f;
}

.main .container {
	background-color: #f5f8fb;
}

.main .container .rowform {
	display: flex;
	padding-top: 20px;
	padding-bottom: 5px;
	align-items: center;
}

.labels {
	flex: 1;
	padding-left: 20px;
	padding-right: 20px;
}

.textsfields {
	flex: 4;
}

.textsfields input {
	padding: 1px;
}

.required-field::before {
	content: "*";
	color: red;
	float: right;
}

.main .container .rowform a {
	font-size: 13px;
}

.foot {
	border: 1px solid rgb(175, 175, 231);
	font-weight: bold;
	background-color: #EBF1F7;
	padding: 10px 5px 10px 0px;
	display: flex;
	justify-content: flex-end;
}

.foot button {
	width: 80px;
	border: 1px solid blue;
}
</style>

<body>

	<div>
		<form action="login" method="post">
			<div class="head">
				<h3>Login</h3>
			</div>
			<div class="main">
				<div class="container">
					<div class="rowform">
						<div class="labels">
							<label for="username">Username: <span
								class="required-field"></span></label>
						</div>
						<div class="textsfields">
							<input type="text" name="username" size="30">
						</div>
					</div>
					<div class="rowform">
						<div class="labels">
							<label for="username">Password: <span
								class="required-field"></span></label>
						</div>
						<div class="textsfields">
							<input type="password" name="password" size="30">
						</div>
					</div>

				</div>
			</div>
			<div class="foot">
				<button type="submit">Login &#187;</button>
			</div>
		</form>
	</div>
</body>
</html>