package br.com.institutointegra.api.client.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.institutointegra.api.client.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
