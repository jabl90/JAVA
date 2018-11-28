<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>

	<h1>Employee</h1>

	<div class="error">${mensaje_error}</div>

	<ul name="id">

		<li>Id: ${unEmpleado.id}</li>
		<li>Nombre: ${unEmpleado.nombre}</li>
		<li>Apellido: ${unEmpleado.apellido}</li>

	</ul>



</body>
</html>