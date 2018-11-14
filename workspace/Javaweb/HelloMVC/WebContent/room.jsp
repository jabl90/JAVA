<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="./header.jsp"></jsp:include>

<h1>Informacion de la habitacion</h1>
      
      <ul>
         <li>Habitación:${lahabitacion.hid} </li>
         <li>Calle:${lahabitacion.calle} </li>
         <li>Metros cuadrados:${lahabitacion.metros} </li>
         
      </ul>
      
     

</body>
</html>