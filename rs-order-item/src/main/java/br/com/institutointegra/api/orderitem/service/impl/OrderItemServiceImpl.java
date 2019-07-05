package br.com.institutointegra.api.orderitem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.institutointegra.api.orderitem.model.OrderItem;
import br.com.institutointegra.api.orderitem.repository.OrderItemRepository;
import br.com.institutointegra.api.orderitem.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public List<OrderItem> getAll() {
		return this.orderItemRepository.findAll();
	}

	@Override
	public OrderItem save(OrderItem p) {
		return this.orderItemRepository.save(p);
	}

	@Override
	public OrderItem findById(Long id) {
		return this.orderItemRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.orderItemRepository.deleteById(id);
	}

}
