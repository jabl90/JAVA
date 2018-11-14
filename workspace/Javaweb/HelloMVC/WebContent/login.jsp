<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="./CSS/style.css" rel="stylesheet">

</head>
<body>

	<h1>Login</h1>
	
	<div class="error">${errormensaje}</div>

	<form action="" method="POST">
		<!-- Para proteger nuestros datos metods el método post, los encripta -->

		<div>
			<input type="text" placeholder="email" name="email" id="email" required /> <!-- el name es el nombre del parámetro que voy a recibir en el servlet -->

		</div>

		<div>
			<input type="password" placeholder="password" name="password"
				id="password" required />

		</div>

		<p></p>

		<div>
			<button>Entrar</button>

		</div>


	</form>


</body>
</html>