package com.ejemplo.main;

import com.ejemplo.JDBC.EmpJDBCDAO;
import com.ejemplo.hibernate.EmpHibernateDAO;
import com.ejemplo.interfaz.IRecuperable;
import com.ejemplo.jpa.EmpJPADAO;
import com.ejemplo.service.*;

public class MainE {
	
	public static void main(String[] args) {
		
		EmpService es=new EmpService();
		
		IRecuperable i_hibernate=new EmpHibernateDAO();
		es.setObjeto_dao(i_hibernate);
		es.leerEmpleado(150);
		
		IRecuperable i_jpa=new EmpJPADAO();
		es.setObjeto_dao(i_jpa);
		es.leerEmpleado(100);
		
		IRecuperable i_JDBC=new EmpJDBCDAO();
		es.setObjeto_dao(i_JDBC);
		es.leerEmpleado(101);
		//es.setRecuperable(i_hibernate);
		
		//es.leerEmpleado(150)   object
		
		
	}

}
