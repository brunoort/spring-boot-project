package br.com.institutointegra.api.orderitem.service;

import java.util.List;

import br.com.institutointegra.api.orderitem.model.OrderItem;

public interface OrderItemService {
	List<OrderItem> getAll();
	
	OrderItem save(OrderItem p);
	
	OrderItem findById(Long id);
	
	void delete(Long id);
}


