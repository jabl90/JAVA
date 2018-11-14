<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Usuario</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>
   <!-- Tenemos que conectar el servlet con esta plantilla, vamos autiliar el request en el servlet
   El $ indica que el  -->
   
   <jsp:include page="./header.jsp"></jsp:include>
   
      <h1>Datos de usuario</h1>
        
      <ul>
      <li>
     
      
         <div>Id:${elUsuario.id} </div> 
         <div>Nombre:${elUsuario.name} </div>
         <div>Email:${elUsuario.email} </div>
         <div>Habitación:${elUsuario.room.hid} </div>
         
                
         </li>
         
         
         
     </ul>  
     
      <a href="./room?hid=${elUsuario.room.hid}">Acceso a habitacion: ${elUsuario.room.hid}</a>
     
   
    
     
      
   
</body>
</html>