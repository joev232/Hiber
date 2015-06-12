import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeeService  {
	
	EmployeesDAO employeesDAO=new EmployeesDAO();
	
	public boolean incrementarSalario(){
		//session.obtenerSesionNueva();
		
		boolean incremento = false;
		Session session=null;
		Transaction transaction=null;
		List<Employees> listaempleados=null;
		
	try {
		//SessionManager session = null;
		session =  SessionManager.obtenerSesionNueva();
		//empiezo mi transaccion(si algo sale mal hago un rollback en el try)
		transaction=session.beginTransaction();
		//voy empezar a trabajar con bd asigno una session a employeDAO //lee de superclase
		employeesDAO.setSession(session);
		//listaempleados de la base de datos
		listaempleados=employeesDAO.listarempleados();
		//Iterator<E> mejor hacerlo en un nuevo metodo
		
		//llamarlo 
		actualizarSalario(listaempleados);
		transaction.commit();
		incremento=true;
		
		//System.out.println();
		
				
	} catch (Exception e) {
		// TODO: handle exception
		transaction.rollback();
		e.printStackTrace();
		//falta usar el log
	}	finally{
		SessionManager.cerrarSession(session);
	}
		return incremento;
	}
	
	//ya tengo la lista
	private void actualizarSalario(List<Employees> lista_e){
		//recorrer la lista para poder actualizar con iterator o for
		
		// estado seria persistent 
		for (Employees emp : lista_e) {
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.20) ));
		}
	}

	public EmployeeService() {
	// TODO Auto-generated constructor stub
	this.employeesDAO=new EmployeesDAO();
	
}
	
	

}
