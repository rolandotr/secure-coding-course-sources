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
	public Client retrieveClient(String username) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			String hql = "from Client where username = :username";
			Query<Client> query = session.createQuery(hql);
			query.setParameter("username", username);
			List<Client> clients = query.getResultList();
			if (clients.isEmpty()) {
				throw new RuntimeException("Broken precondition: "
						+ "credentials should be have been verified earlier");
			}
			else if (clients.size() > 1) { 
				throw new RuntimeException("More than one client exists");
			}
			else {
				return clients.get(0);
			}
		}
		finally {
			session.close();
		}
	}

	public Client retrieveClientByID(int id) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			return session.get(Client.class, id);
		}
		finally {
			session.close();
		}
	}

	/* 
	 * 
	 * Returns true if the client exists in the database, false otherwise.
	 */
	public boolean existsClient(String username) {
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Client where username = :username"+
					" and password = :password";
			Query<Client> query = session.createQuery(hql);
			query.setParameter("username", username);
			//Obtain the query results
			List<Client> clients = query.getResultList();
			return !clients.isEmpty();
		}
		finally {
			session.close();
		}
	}
	
	/* 
	 * 
	 * Returns true if a client with the credentials passed as argument exists. 
	 */
	public boolean areCredentialsCorrect(String username, String password) {
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Client where username = :username"+
					" and password = :password";
			Query<Client> query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
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
