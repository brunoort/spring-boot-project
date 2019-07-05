package br.com.institutointegra.api.client.service;

import java.util.List;

import br.com.institutointegra.api.client.model.Client;

public interface ClientService {
	List<Client> getAll();
	
	Client save(Client p);
	
	Client update(Client p);
	
	Client findById(Long id);
	
	void delete(Long id);
}


