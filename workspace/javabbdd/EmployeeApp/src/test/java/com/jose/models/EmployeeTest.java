package com.jose.models;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {

	private static SessionFactory sf = null; // inicializamos el ssesionFactory

	@BeforeClass // Tiene que ser static porque es muy costoso y se tiene que poder utlizar mas
					// adelante
	public static void createSessionFactory() { // Nos permite crear las sesion. El factory nos permite crear objetos
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	@Test
	public void testSession() {
		Session session = sf.openSession();

		assertNotNull(session);

	}

	@Test
	public void testInsert() {

		Session session = sf.openSession(); // Abre la conexion con la base de datos

		Transaction t = session.beginTransaction();

		Employee newE = new Employee(1, "Pepe", "Pérez");

		int id = ((Integer) session.save(newE)).intValue();

		System.out.println("El id nuevo es: " + id);

		Employee newE2 = new Employee(0, "Maria", "laperra");
		session.save(newE2);

		Employee newE3 = new Employee(0, "Julia", "comerrabos");
		session.save(newE3);

		t.commit();

		session.close();

	}

	@Test
	public void testGet() {

		Session session = sf.openSession();

		Employee recE =
				
				session.get(Employee.class, 3);

		System.out.println("Empleado recibido: " + recE.getNombre() + " " + recE.getApellido());

		session.close();

	}

	@Test
	public void testLoad() {

		Session session = sf.openSession();

		List<Employee> empleados = session.createQuery("from Employee WHERE id>5", Employee.class).getResultList();
		
		for (Employee employee : empleados) {
			System.out.println("Empleados: " +employee.getId());
		}
		
		session.close();

	}
	
	@Test
	public void testDelete() {
		
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Employee deleteuser = new Employee(12, "","");
		
		session.delete(deleteuser);
		
		System.out.println("Empleado borrado: " +deleteuser.getId());
		
		t.commit();
		session.close();

	}
	
	@Test
	public void testUpdate() {
		
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Employee updateuser = session.load(Employee.class, 7);
		
		updateuser.setNombre("CABRONAZO");
		
	
		
		session.update(updateuser);
		
		t.commit();
		session.close();

	}
}
