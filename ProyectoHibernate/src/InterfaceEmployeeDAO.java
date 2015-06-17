import java.util.List;


public interface InterfaceEmployeeDAO extends InterfaceDAO {

	
	public List<Employees> listadoPorDepartamento(Object dpto);
}
