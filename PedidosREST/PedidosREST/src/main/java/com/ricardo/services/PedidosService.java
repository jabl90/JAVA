package com.ricardo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.netmind.DAO.DAOFactory;
import com.netmind.DAO.UsuarioDAO;
import com.ricardo.models.Pedido;
import com.ricardo.models.StatusMessage;
import com.ricardo.models.Usuario;

@Path("/pedidos")
public class PedidosService extends JSONService {

	private static final List<Pedido> pedidos = new ArrayList<Pedido>();

	static {
		pedidos.add(new Pedido(1, "Producto 1", 23));
		pedidos.add(new Pedido(2, "Producto 2", 24));
		pedidos.add(new Pedido(3, "Producto 3", 25));
		pedidos.add(new Pedido(4, "Producto 4", 26));
		pedidos.add(new Pedido(5, "Producto 5", 27));
	}

	@GET // va arespondeer en la ruta pedidos a las respuestas de tipo GET
	
	@Produces("application/json")
	public Response getPedido(@HeaderParam("token") String token) {
		//logger.log(Level.INFO, "token:" + token);
		
		String userEmail = null;

		userEmail = this.getUserEmailFromToken(token);

		if (userEmail == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.FORBIDDEN.getStatusCode());
			statusMessage.setMessage("Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}else {

		

		return Response.status(200).entity(pedidos).build(); //si no es nulo devolvemos los pedidos
		}
	}
	

	
//Conjunto de m�todos a trav�s de los cuales devolvemos los pedidos
	// Con el path confirmamos la ruta de acceso a ese recurso
	@Path("/{pid}")
	@GET // Esta escuchando en GET
	@Produces("application/json") // Transforma el pedido en un json
	public Response getPedido(@PathParam("pid") int pid, @HeaderParam("token") String token) { // Inyectamos ese valor
		// El pid del recurso es su numero a trav�s del cual accedemos                         // dentro del
		// parametro
		String userEmail = null;

		userEmail = this.getUserEmailFromToken(token);
		
		Response resp = null;

		if (userEmail!=null) { // se entiende q ue le usuario esta identificado en cabecera
			Pedido pedidoRet = null;
			for (Pedido pedido : pedidos) {

				if (pedido.getPid() == pid) {
					pedidoRet = pedido;
					break;
				}

			}

			if (pedidoRet == null) {
				resp = Response.status(404).entity(new StatusMessage(404,"El pedido no existe")).build();
			} else {
				resp = Response.status(200).entity(pedidoRet).build();
			}
		} else {
			resp = Response.status(403).entity(new StatusMessage(403, "Necesitas permisos")).build();

		}

		return resp;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPedido(Pedido pedidoNuevo, @HeaderParam("token") String token) {

		Response resp = null; // El objeto del tipo response nos permite ajustar con precision con respecto a
								// los datos que quiero devolver. No spermite recibir el c�dgio de respuesta en
								// funci��n de los ti`pos de datos

		if (token != null) {

			if (pedidoNuevo.validate()) {
				pedidoNuevo.setPid(pedidos.size() + 1);
				pedidos.add(pedidoNuevo);

				resp = Response.status(200).entity(pedidoNuevo).build();

			} else {
				resp = Response.status(400).entity(new StatusMessage(400, "Permiso incompleto")).build();
			}

		} else {
			resp = Response.status(403).entity(new StatusMessage(403, "Necesitas permisos")).build();
		}

		return resp;

	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json") // Transforma el pedido en un json

	public boolean deletePedido(@PathParam("id") int pid) {

		boolean OK = false;
		for (Pedido pedido : pedidos) {

			if (pedido.getPid() == pid) {

				pedidos.remove(pedido);
				OK = true;
				break;
			}

		}

		return OK;
	}

	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // Transforma el pedido en un json
	@Produces(MediaType.APPLICATION_JSON) // Transforma el pedido en un json
	public boolean actualizarPedido(@PathParam("id") int pid, Pedido unPedido) { // Tengo tambi�n que recibir los datos
																					// de ese pedido
		boolean OK = false;
		for (Pedido pedido : pedidos) {

			if (pedido.getPid() == pid) {
				pedidos.remove(pedido);
				pedidos.add(unPedido);
				OK = true;
				break;
			}

		}

		return OK;
	}
}
