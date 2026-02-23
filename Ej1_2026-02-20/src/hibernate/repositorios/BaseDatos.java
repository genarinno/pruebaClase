package hibernate.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BaseDatos 
{
	// Constructor
	// -----------
	public BaseDatos()
	{
		this.sf = new Configuration()
						.configure()
						.buildSessionFactory(new StandardServiceRegistryBuilder()
												.configure()
												.build()
											 );
	}
	
	// Campos
	// ------
	public SessionFactory sf;
	public Session session;
	public Transaction tx;
	
	public Query q;
	public String sql;
	public int cantidad;
	
	// Métodos
	// -------
	public void conectar()
	{
		this.session = this.sf.openSession();
	}
	public void desconectar()
	{
		this.session.close();
	}
}
