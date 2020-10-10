package br.com.estudo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private StandardServiceRegistry ssr;
	private Metadata meta;
	private SessionFactory factory;
	
	public HibernateUtil() {
		
		ssr= new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		
		meta = new MetadataSources(ssr).getMetadataBuilder().build();		
		factory =  meta.getSessionFactoryBuilder().build();		
		
	}

	
	Session session = factory.openSession();
	Transaction t =  session.beginTransaction();
	
	session.save(emp);
	
	t.commit();
	
	factory.close();
	session.close();
	
}
