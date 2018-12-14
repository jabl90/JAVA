package com.ricardo.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedidosTestService {

	@Test
	public void getPedidoValid() {
		PedidosService pserv=new PedidosService();
		
		assertTrue(pserv.getPedido(1, null)!=null);
		assertTrue(pserv.getPedido(7, null)==null);
	}

}
