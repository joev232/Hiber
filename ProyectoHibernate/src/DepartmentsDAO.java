import java.util.List;


public class DepartmentsDAO extends SuperClaseDAO implements InterfaceDAO{

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
	
	public List<Departments> listarDepartamentos(){
		
		List<Departments> listar = getSession().createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		return listar;
	}

}
