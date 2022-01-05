package edu.deakin.sit218.coachwebapp.dao;

import edu.deakin.sit218.coachwebapp.entity.Client;

public interface ClientDAO {
	
	public void updateClient(Client client);

	public void insertClient(Client client);

	public boolean areCredentialsCorrect(String username, String password);

	public boolean existsClient(String username);
	
	public Client retrieveClient(String username);

	public Client retrieveClientByID(int userId);

}
