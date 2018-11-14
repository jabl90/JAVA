<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Lista canciones</h1>

	<ul>
		<li>


			<div>Id:${lacancion.id}</div>
			<div>Autor:${lacancion.titulo}</div>
		

		</li>

	</ul>


	<a href="./listacanciones?id=${elUsuario.id}">Acceder a canción</a>
</body>
</html>