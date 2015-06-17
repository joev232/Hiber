package com.ejemplo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ejemplo.interfaz.IRecuperable;

public class EmpJPADAO implements IRecuperable{
	
	
			EntityManagerFactory emf =
	        Persistence.createEntityManagerFactory("UnidadPersonas");
	        EntityManager em = emf.createEntityManager();

	public Object leerEmpleado(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
