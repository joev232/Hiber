import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainPrueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session= factory.openSession();
		
		Transaction transaction=null;
		
		try {
			
			transaction=session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Regions> list = session.createSQLQuery("select * from regions").addEntity(Regions.class).list();
			Iterator<Regions> it= list.iterator();
			
			//Countries count;
			Regions reg = null;
			while(it.hasNext()){
				
				reg=it.next();
				//reg=count.getCountryId();
				System.out.println(reg.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}

	}

}
