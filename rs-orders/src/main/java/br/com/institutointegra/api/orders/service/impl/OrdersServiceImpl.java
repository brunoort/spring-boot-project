package br.com.institutointegra.api.orders.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.institutointegra.api.orders.service.OrdersService;
import br.com.institutointegra.api.orders.model.Orders;
import br.com.institutointegra.api.orders.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository orderRepository;
	
	@Override
	public List<Orders> getAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Orders save(Orders p) {
		return this.orderRepository.save(p);
	}

	@Override
	public Orders findById(Long id) {
		return this.orderRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.orderRepository.deleteById(id);
	}

}
