<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva habitacion</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>

<h1>Elige una nueva habitacion</h1>

<form action="" method="POST">
		<!-- Para proteger nuestros datos metods el método post, los encripta -->
		<div class="error">${mensajeerror}</div>

		<div>
		<label id="calle">Elige calle: </label>
			<input type="text" placeholder=" calle" name="calle"
				id="calle" value="${newroom.calle}" />
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet, con el value accedemos al objeto usuario y tras el puntoa las propiedades de las clase Usuario -->

		</div>
		<p></p>

		<div>
		<label id="metros">Elige metros: </label>
			<input type="text" placeholder="metros" name="metros" id="metros"
				value="${newroom.metros}" />
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet -->

		</div>
		
		<p></p>
		
		<div>
			<button>Crear nueva habitación</button>

		</div>
		
		</form>

</body>
</html>