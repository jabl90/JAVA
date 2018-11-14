<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Los Usuarios</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>
	<!-- Tenemos que conectar el servlet con esta plantilla, vamos autiliar el request en el servlet
   El $ indica que el  -->
<jsp:include page="./header.jsp"></jsp:include>

	<h1>Usuarios</h1>

	<ul>
<!-- Hemos incorpaorado la libreria jsp para incorporar tag en plantillas que pueden iterar sobre una 
    variable y repetir para todos los usuarios un trozo de código html  -->
		<c:forEach var="unUsuario" items="${losUsuarios}">  
		
     <li>
     <a href="./usuario?id=${unUsuario.id}"> <!-- Para mostras con una misma plantilla la informacion de un usuario en concreto -->
     
      <div id="id">( ${unUsuario.id} )</div>
      <div id="nombre">${unUsuario.name}</div>
     </a>
     </li>	
		</c:forEach>

	</ul>



</body>
</html>