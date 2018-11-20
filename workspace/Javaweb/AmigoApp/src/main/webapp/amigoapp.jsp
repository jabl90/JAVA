<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amigo App</title>
</head>
<body>
<h1>hola amijos</h1>

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
			<input type="text" placeholder=" Mote" name="mote"
				id="mote" value="${newamigo.mote}" required/>
		
		</div>
		<p></p>
		
		<div>
			<input type="number" placeholder=" Edad" name="edad"
				id="edad" value="${newamigo.edad}" required/>
		
		</div>
		<p></p>

		<div>
			<input type="text" placeholder=" Email" name="email" id="email"
				value="${newamigo.email}" required/>
		</div>
		
		<p></p>

		<div>
			<input type="password" placeholder=" Password" name="password"  pattern="[a-zA-Z0-9]*" id="password" value="" required/>
		</div>
		
		<p></p>
		
		<div>
			<button id="crearamigo">Este es mi colega</button>

		</div>

		</form>
		<!-- son necesarios los setter and getters -->
		<!-- El if lo podemos meter por el jstl -->
		<c:if test="${newamigo!=null}">
		<h2>Datos Amigo</h2>
		<ul>
		<li>Nombre: ${newamigo.name}</li>
		<li>Mote: ${newamigo.mote}</li>
		<li>Edad: ${newamigo.edad}</li>
		<li>Email:${newamigo.email}</li>
		
		</ul>
		</c:if>

</body>
</html>