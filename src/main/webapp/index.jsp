<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.form-container {
	display: flex;
	justify-content: space-around;
	align-items: flex-start;
	flex-wrap: wrap;
}

.form {
	width: 45%;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

h2 {
	text-align: center;
	color: #333;
}

form {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

form:hover {
	background-color: #e5c3db;
	transition: background-color 1.6s
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

#btn3 {
	background-color: red;
}

button {
	width: 100%;
	padding: 10px;
	background-color: #4caf50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

body {
	background-color: #914fd9;
}

button:hover {
	background-color: #0b7b10;
	transition: background-color 0.6s
}

a.button-link {
	text-decoration: none;
	display: inline-block;
	width: 100%;
	text-align: center;
	margin-top: 10px;
	width: 95%;
	padding: 10px;
	background-color: blue;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}
</style>


</head>
<body>

	<div class="form-container">
		<div class="form">

			<h2>Employee Login</h2>
			<form action="MyServlet" method="post" align="center">
				<label for="login-username">Username:</label> <input type="text"
					id="login-username" name="username" placeholder="Username" required><br>
				<br> <label for="login-pass">Password:</label> <input
					type="password" placeholder="Password" id="login-pass" name="pass"
					required><br> <br>

				<button id="btn1" type="submit">Login</button>
				<br> <br> <a href="registration.jsp" class="button-link">Register</a>
				<br> <br>

				<button id="btn3" type="reset">Cancel</button>
			</form>
		</div>

	</div>
</body>
</html>