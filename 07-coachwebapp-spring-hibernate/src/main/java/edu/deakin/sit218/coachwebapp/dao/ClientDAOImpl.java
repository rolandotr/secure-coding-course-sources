package edu.deakin.sit218.coachwebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.coachwebapp.entity.Client;


public class ClientDAOImpl implements ClientDAO{
	
	SessionFactory factory;

	public ClientDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
	}
	
	
	public void updateClient(Client client) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(client);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	public void insertClient(Client client) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	/* 
	 * If the client exists in the database, this method returns
	 * the persistent client. Otherwise, it inserts a new client
	 * with the name and age provided as an argument. 
	 */
	public Client retrieveClient(Client client) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			String hql = "from Client where name = '"+
					client.getName()+"' and age = '"+
					client.getAge()+"'";
			Query<Client> query = session.createQuery(hql);
			//Obtain the query results
			List<Client> clients = query.getResultList();
			if (clients.isEmpty()) {
				throw new RuntimeException("There is no client: "+client.toString());
			}
			else if (clients.size() > 1) { 
				throw new RuntimeException("More than one client: "
						+ client.toString() +" exists");
			}
			else {
				return clients.get(0);
			}
		}
		finally {
			session.close();
		}
	}

	/* 
	 * If the client exists in the database, this method returns
	 * the persistent client. Otherwise, it inserts a new client
	 * with the name and age provided as an argument. 
	 */
	public boolean existsClient(Client client) {
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Client where name = '"+
					client.getName()+"' and age = '"+
					client.getAge()+"'";
			Query<Client> query = session.createQuery(hql);
			//Obtain the query results
			List<Client> clients = query.getResultList();
			return !clients.isEmpty();
		}
		finally {
			session.close();
		}
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		//Close session factory before destroying the object
		factory.close();
	}
	
}
