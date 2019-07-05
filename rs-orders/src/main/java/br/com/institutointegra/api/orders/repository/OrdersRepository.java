package br.com.institutointegra.api.orders.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.institutointegra.api.orders.model.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	
}
