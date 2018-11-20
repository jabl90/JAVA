document.getElementById('validform').onclick=(function(evnt){
	
	evnt.preventDefault();   
    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('hide'); //Para que lo muestre los errores de inicio, luego en el else los mostrará si hay error.
    });

    let validarform = document.getElementById('registerform').checkValidity();
    
    if (validarform) {
        // enviar
        document.getElementById('registerform').submit();

    } else {

        if (!document.getElementById('nombre').checkValidity()) {
            document.getElementById('errornombre').classList.remove('hide');
        }
        if (!document.getElementById('email').checkValidity()) {
            document.getElementById('erroremail').classList.remove('hide');
        }
        if (!document.getElementById('password').checkValidity()) {
            document.getElementById('errorpassword').classList.remove('hide');
        }
        if (!document.getElementById('confirmarpassword').checkValidity()) {
            document.getElementById('errorconfirmar').classList.remove('hide');
        }
    }
});
	


