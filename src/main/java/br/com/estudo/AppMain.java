package br.com.estudo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class AppMain {

	public static final String HIBERNATE_CFG_XML = "hibernate.cfg.xml";

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder()
				.configure(HIBERNATE_CFG_XML)
				.build();
		
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory =  meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t =  session.beginTransaction();

		session.save(new Empregado("José"));
		
		t.commit();
		System.out.println("foi");
		
		factory.close();
		session.close();
		
		
		
		
		
	}

}
