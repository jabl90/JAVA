<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Nueva Cuenta</h1>

<div id="errormensaje" class="error">${mensajeerror}</div>
	<p></p>
<!-- En el gesrrvlet va al post porque qse lo estamos indicando en el formulario -->
	<form id="crearcuentaform" action="" method="POST" novalidate>

		<div> <label id="nombrecuenta">Nombre de cuenta</label> </br>
			<input type="text" placeholder=" Nombre de cuenta" name="nombrecuenta"
				id="nombrecuenta"  required/>
		</div>
		<p></p>
		
		<div> <label id="numerocuenta">Número de cuenta</label> </br>
			<input type="text" placeholder="Numero de cuenta" name="numerocuenta"
				id="numerocuenta"  required/>
		
		</div>
		<p></p>
		
		<div> <label id="saldo">Saldo</label> </br>
			<input type="number"  step="0.01" placeholder="Saldo" name="saldo"
				id="saldo" required/>
	
	
		</div>
			<p></p>
			
			<button id="crearcuenta">Crear Cuenta</button>

		

		</form>

</body>
</html>