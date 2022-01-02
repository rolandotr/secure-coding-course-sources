package edu.deakin.sit218.coachwebapp.dao;

import edu.deakin.sit218.coachwebapp.entity.Client;

public interface ClientDAO {
	
	public void updateClient(Client client);

	public void insertClient(Client client);

	public Client retrieveClient(Client client);

	public boolean existsClient(Client client);
	
}
