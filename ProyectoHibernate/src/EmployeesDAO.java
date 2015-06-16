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
		listar=getSession().createSQLQuery("select * from EMPLOYEES").addEntity(Employees.class).list();
		return listar;
	}
	
	public List<Employees> listarempleadoordenadoID(){
		List<Employees> listarxid=null;
		listarxid=getSession().createSQLQuery("SELECT * FROM EMPLOYEES order by DEPARTMENT_ID").addEntity(Employees.class).list();
		return listarxid;
	}
	//	EmployeesDAO employeesDAO=new EmployeesDAO();
}
