//import com.ejemplo.bd.GenericDTO;


public interface InterfaceDAO {
//	
//	public abstract void create (GenericDTO ObjectDTO) throws Exception;
//	 
//	 public abstract void update (GenericDTO ObjectDTO) throws Exception;
//	 
//	 public abstract GenericDTO read (String Condicion) throws Exception;
//	 	 
//	 public abstract void delete (String Condicion) throws Exception;

	 Object create(Object o);
	 Object read(Object o);
	 boolean update(Object o);
	 boolean delete(Object o);
}
