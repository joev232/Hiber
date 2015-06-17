package com.ejemplo.service;

import com.ejemplo.hibernate.EmpHibernateDAO;
import com.ejemplo.interfaz.IRecuperable;

public class EmpService {
	
	private IRecuperable objeto_dao;
	
	public void setObjeto_dao(IRecuperable objeto_dao) {
		this.objeto_dao = objeto_dao;
	}
 		
	public Object leerEmpleado(int n){
		Object empleado=null;
		
		empleado=this.objeto_dao.leerEmpleado(n);
		
			
		return empleado;
	}
	
	
}
