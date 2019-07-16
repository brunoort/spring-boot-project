package br.com.institutointegra.api.spec.orders.service;

import java.util.List;
import java.util.Map;

import br.com.institutointegra.api.spec.orders.dto.OrdersDto;

public interface OrdersService {
	OrdersDto save(OrdersDto ordersDto);
	OrdersDto saveFeign(OrdersDto ordersDto);
	List<OrdersDto> listOrders();
	Map<String, String> viewPort();
}
