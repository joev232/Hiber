import java.util.List;


public class EmployeesDAO extends SuperClaseDAO  implements InterfaceDAO{

	public Object create(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object read(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Employees> listarempleados(){
		
		List<Employees> listar=null;
		
		listar=getSession().createSQLQuery("select * from employess").addEntity(Employees.class).list();
		
		return listar;
		
	}
	
//	EmployeesDAO employeesDAO=new EmployeesDAO();
	
	
}
