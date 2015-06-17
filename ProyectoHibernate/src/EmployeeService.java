import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeeService  {
	
	EmployeesDAO employeesDAO=new EmployeesDAO();
	DepartmentsDAO departmentsDAO=new DepartmentsDAO();
	
	public EmployeeService() {
	// TODO Auto-generated constructor stub
	this.employeesDAO=new EmployeesDAO();
	this.departmentsDAO=new DepartmentsDAO();
	
}
	
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
	
	
	//hacer un metodo para mostrar el empleado con mayor salario de cada departamento
		public List<Employees> mejorPagadoxDepartamento(){
		
			Transaction transaction = null;	 
	 		Session session = null; 
	 		List<Employees> listamaspagado = new ArrayList<Employees>();
	 		List<Departments> listadepartamento = new ArrayList<Departments>();  
	 		try 
	 		{ 
	 			session= SessionManager.obtenerSesionNueva();
	 			employeesDAO.setSession(session);
	 			transaction=employeesDAO.getSession().beginTransaction();
	 			listadepartamento=leerDepartamento();
	 			
	 			for(Departments departamento:listadepartamento){
	 				listamaspagado.add(obtenerMasGana(departamento));
	 			}
	 		} 
	 		catch (Exception e) 
			{ 
	 			e.printStackTrace(); 
	 			transaction.rollback(); 
	 		} 
	 		finally 
	 		{ 
	 			SessionManager.cerrarSession(session);
	 			 
	 		} 
	 		 return listamaspagado; 
	 	} 
		private Employees obtenerMasGana(Departments dpto){
			Employees empleadomasgana = null;
			BigDecimal mayor = new BigDecimal (0);
			List<Employees> listaremp = new ArrayList<Employees>();
			listaremp = employeesDAO.listadoPorDepartamento(dpto); 
			for (Employees emp : listaremp) 
			{
				//salario mayor por departamento
				if (emp.getSalary().intValue() >  mayor.intValue())
				{
					mayor = emp.getSalary();
					empleadomasgana = emp;
				}
			}
			return empleadomasgana;
			
		}
		//recupero la lista de departamentos
		private List<Departments> leerDepartamento(){
			List<Departments> departa=departmentsDAO.listarDepartamentos();
			return departa;
		}
		
		public List<Employees> obtenerEmpleadosPorDepartamento(Object dpto)
		{
			List <Employees> listempdepartamento = new ArrayList<Employees>();
			Transaction transaction = null;	
			Session session = null;
			try
			{
				session = SessionManager.obtenerSesionNueva();
				employeesDAO.setSession(session);
				transaction = employeesDAO.getSession().beginTransaction();
				listempdepartamento = employeesDAO.listadoPorDepartamento(dpto);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				transaction.rollback();//si algo ha ido mal, deshago la transacción
			}
			finally
			{
				session.close();
			}
			return listempdepartamento;
		}
		
}

