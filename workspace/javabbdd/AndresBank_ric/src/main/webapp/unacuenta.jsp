<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Mi Cuenta</h1>

<div class="error">${mensaje_error}</div>
<ul>

<li>Identificador de Cuenta: ${miCuenta.cid}</li>
<li>Nombre del Titular:${miCuenta.nombre}</li>
<li>Número de Cuenta: ${miCuenta.numero}</li>
<li>Saldo:${miCuenta.saldo}</li>
</ul>


</body>
</html>