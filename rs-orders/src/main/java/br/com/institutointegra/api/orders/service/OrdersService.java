package br.com.institutointegra.api.orders.service;

import java.util.List;

import br.com.institutointegra.api.orders.model.Orders;

public interface OrdersService {
	List<Orders> getAll();
	
	Orders save(Orders p);
	
	Orders findById(Long id);
	
	void delete(Long id);
}


