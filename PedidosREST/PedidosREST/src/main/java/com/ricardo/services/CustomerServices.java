package com.ricardo.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ricardo.models.Customer;

@Path("/customer")
public class CustomerServices {
	
private static final List<Customer> customerpd = new ArrayList<Customer>();
	
	static {
		customerpd.add(new Customer(1, "Jorge Molina", "39600787D", "elgoleador@gmail.com"));
		customerpd.add(new Customer(2, "Jaime Mata",  "34500789T", "elmatador@gmail.com"));
		customerpd.add(new Customer(3, "Cata Diaz", "54600765K", "elduro@gmail.com"));
		customerpd.add(new Customer(4, "Dani Güiza", "45300765D", "elborracho@gmail.com"));
		customerpd.add(new Customer(5, "Adolf Hitler", "46555098S", "elnazi@gmail.com"));
	}
	
	@GET
	@Produces("application/json")
	public List<Customer> getCustomer(){
		return this.customerpd;
	}
@Path("/{cid}")
@GET //Esta escuchando en GET
@Produces("application/json")//Transforma el pedido en un json
 public  Customer getCustomer(@PathParam("cid") int cid) { //Inyectamos ese valor dentro del parametro
	 
	 Customer customerRet=null;
	 for (Customer customers : customerpd) {
		 
		 if(customers.getCid()==cid) {
			 customerRet=customers;
			 break;
		 }
		
	}
	 
	 return customerRet;
	 
 }

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public boolean addCustomer(Customer customerNuevo) {

	customerNuevo.setCid(customerpd.size() + 1);
	customerpd.add(customerNuevo);

	return true;

}

@Path("/{did}")
@DELETE
@Produces("application/json") // Transforma el pedido en un json

public boolean deleteCustomer(@PathParam("did") int cid) {

	boolean OK = false;
	for (Customer customer : customerpd) {

		if (customer.getCid() == cid) {

			customerpd.remove(customer);
			OK = true;
			break;
		}

	}

	return OK;
}

@Path("/{tid}")
@PUT
@Consumes(MediaType.APPLICATION_JSON) // Transforma el pedido en un json
@Produces(MediaType.APPLICATION_JSON) // Transforma el pedido en un json
public boolean actualizarCustomer(@PathParam("tid") int cid, Customer unCustomer) { 
																				
	boolean OK = false;
	for (Customer customer : customerpd) {

		if (customer.getCid() == cid) {
            customerpd.remove(customer);
			customerpd.add(unCustomer);
			OK = true;
			break;
		}

	}

	return OK;
}

}
