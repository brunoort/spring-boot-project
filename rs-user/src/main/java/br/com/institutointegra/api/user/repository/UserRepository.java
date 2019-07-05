package br.com.institutointegra.api.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.institutointegra.api.user.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
