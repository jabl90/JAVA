<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cuenta</title>
</head>
<body>

<h1>Editar cuenta</h1>

<div id="errormensaje" class="error">${mensajeerror}</div>
	<p></p>
<!-- En el gesrrvlet va al post porque qse lo estamos indicando en el formulario -->
	<form id="crearcuentaform" action="" method="POST" novalidate>

           <input type="hidden" name="cid" value="${nuevacuenta.cid}">

		<div> <label id="nombrecuenta">Nombre de cuenta</label> </br>
			<input type="text" placeholder=" Nombre de cuenta" name="nombrecuenta"
				id="nombrecuenta" value="${editarcuentas.nombre}" required/>
		</div>
		<p></p>
		
		<div> <label id="numerocuenta">Número de cuenta</label> </br>
			<input type="text" placeholder="Numero de cuenta" name="numerocuenta"
				id="numerocuenta" value="${editarcuentas.numero}"  required/>
		
		</div>
		<p></p>
		
		<div> <label id="saldo">Saldo</label> </br>
			<input type="number"  step="0.01" placeholder="Saldo" name="saldo"
				id="saldo" value="${editarcuentas.saldo}" required/>
	
	
		</div>
			<p></p>
			
			<button id="crearcuenta">Editar Cuenta</button>

		

		</form>

</body>
</html>