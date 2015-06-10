import java.math.BigDecimal;
import java.util.List;
import java.util.Iterator;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainIncrementarSalario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Configuration configuration = new Configuration().configure();
	    	//Preparo a un objeto, que será el encargado de generarme el estado de comunicación con la base de datos
	    	//StandardServiceRegistryBuilder se preconfigura el entorno a emplear
		   	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	       	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	      	//Ahora ya con sesion, obtengo y manejo conexiones que me va dando SessionFactory
	    	Session session= factory.openSession();
	    	    	
	    	//Transaction transaction = null;
	    	Transaction transaction=null;
	    	
	    	try {
				
	    		transaction=session.beginTransaction();
				
				@SuppressWarnings("unchecked")
				//pasa a la lista de objetos no es necesario  //save update o merge
				List<Employees> list = session.createSQLQuery("select * from employees where DEPARTMENT_ID=80").addEntity(Employees.class).list();
	    		Iterator<Employees> it = list.iterator();
	    		Employees emp;
	    		while (it.hasNext())
	    		{
	    			emp = it.next();
	    			BigDecimal salario;
	    			salario=emp.getSalary();
	    			//System.out.println(salario);
	    			BigDecimal salarioincre;
	    			salarioincre=salario.multiply(new BigDecimal(1.20));
	    			emp.setSalary(salarioincre);
	    			//no es necesario jhacer el save merce ni nada		
	    			
	    			//System.out.println(salarioincre);
	    			//System.out.println(emp.toString());
	    		}
	    		transaction.commit();
	    		
	    		
			} catch (Exception e) {
				// TODO: handle exception
				transaction.rollback();
			}finally{
				session.close();
				factory.close();
			}
	    	
			
	    	}
	}
