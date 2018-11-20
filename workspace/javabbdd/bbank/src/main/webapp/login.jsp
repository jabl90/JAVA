<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

<div id="errormensaje" class="error">${mensajeerror}</div>
	<p></p>
<!-- En el gesrrvlet va al post porque qse lo estamos indicando en el formulario -->
	<form id="amigosform" action="" method="POST" novalidate>

		<div>
			<input type="text" placeholder=" Nombre y apellido" name="nombre"
				id="nombre" value="${newamigo.name}" required/>
		</div>
		<p></p>
		
		<div>
			<input type="password" placeholder=" Password" name="password"  pattern="[a-zA-Z0-9]*" id="password" value="" required/>
		</div>
		
		<p></p>
		
		<div>
			<button id="crearamigo">Acceder a cuenta</button>

		</div>

		</form>
</body>
</html>