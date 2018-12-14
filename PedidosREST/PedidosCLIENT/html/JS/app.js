const API_URL = "http://localhost:8080/HelloREST/api";

//funcion anónima autoinvocada
(function () {
    $.ajax({
        url: API_URL + "/pedidos"
    })
        .done(function (pedidos) {
            console.log("Pedidos"+pedidos)

            let htmlPedidos = '<ul class="list-group">';

            pedidos.forEach(unPedido => {

                htmlPedidos += `<li class="list-group-item">
            <a href="#" class="detail" data-pid="${unPedido.pid}">
            ${unPedido.pid} - ${unPedido.descripcion} - ${unPedido.monto}
            </a>
            <span><button class="btn-secondary borrar" data-pid="${unPedido.pid}">Borrar</button></span>
            </li>`;

            });
            htmlPedidos += "</ul>";
            $("#listapedidos").html(htmlPedidos);
            asociarBorrarPedido();
            asociarDetallePedido();
        })
        .fail(function (error) {

            console.log("Error: ", error);

        });
})();

function asociarBorrarPedido() {

    $(".borrar").click(function (e) {
        console.log("borrar!", this);
        let pid = this.getAttribute("data-pid");

        $.ajax({
            url: API_URL+"/pedidos/"+pid,
            method: "DELETE"
        })
            .done(function (data) {
                console.log("Datos recibidos:", data);

                if (data) {
                    let hijo = document.getElementById('ped-' + pid);
                    hijo.parentElement.removeChild(hijo);

                } else {
                    alert("OOPPssssssssss")
                }
            })
            .fail(function (error) {
                console.log("Error recobido:", error);
            });
    });


}

function asociarDetallePedido() {

    $(".detail").click(function (e) {
        e.preventDefault();
        console.log("detail!", this);
        let pid = this.getAttribute("data-pid");

        $.ajax({
            url: API_URL + "/pedidos/" + pid,
            headers:{token:"xxx", Accept: "application/json"}

        })
            .done(function (pedido) {
                console.log("Datos recibidos:", pedido);

            })
            .fail(function (error) {
                if(error.status==403)
                console.log("Reenviar a login");
            });
    });
}