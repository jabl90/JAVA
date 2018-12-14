package com.ricardo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ricardo.models.Pedido;

public class PedidosEntityManager {
	
	private  static PedidosEntityManager instance=null;
	
	private static SessionFactory sfactory;
	
	public static PedidosEntityManager getInstance() {
		if (instance==null) instance = new PedidosEntityManager();
		return instance;
	}

	
	private PedidosEntityManager() {
		
		sfactory=new Configuration().configure("hibernate,cfg.xml").buildSessionFactory();
		
	}
	
	public static List<Pedido>getPedidos(){
		
		Session sess =sfactory.openSession();
		
		List<Pedido> listaPedidos=sess.createQuery("from Pedido").list();
		return null;
		
	}
}
