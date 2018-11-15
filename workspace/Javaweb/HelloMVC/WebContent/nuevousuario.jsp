<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>


	<h1>Nuevo Usuario</h1>

	<div class="error">${mensajeerror}</div>

	<form action="" method="POST">
		<!-- Para proteger nuestros datos metods el método post, los encripta -->

		<div>
			<input type="text" placeholder=" Nombre y apellido" name="nombre"
				id="nombre" value="${newusuario.name}" />
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet, con el value accedemos al objeto usuario y tras el puntoa las propiedades de las clase Usuario -->

		</div>

		<div>
			<input type="text" placeholder=" Email" name="email" id="email"
				value="${newusuario.email}" />
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet -->

		</div>

		<div>
			<input type="password" placeholder=" Password" name="password"
				maxlength="9" pattern="[a-zA-Z0-9]*" id="password" value="" />

		</div>

		<div>
			<input type="password" placeholder=" Confirmarpassword"
				name="confirmarpassword" maxlength="9" pattern="[a-zA-Z0-9]*"
				id="confirmarpassword" />

		</div>

		<p></p>
		<!-- Aqui iran las habitaciones, la plantilla tiene que recibir la lista de habitaciones de NuevoUsarioServlet -->
		<!--lashabitaciones es el atributo que he dejado en el servlet. unHab es solo una variable local-->
		<div>
			<label id="habitacion">Elige habitación: </label> <select
				name="habitacion" id="habitacion">
				<c:forEach var="unaHab" items="${lashabitaciones}">
					<option value="${unaHab.hid}">${unaHab.calle}</option>
				</c:forEach>
			</select>
		</div>


		<p></p>

		<div>
			<button>Darse de alta</button>

		</div>

	</form>

</body>
</html>