package br.com.institutointegra.api.spec.orders.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.institutointegra.api.spec.orders.ProxyRsOrders;
import br.com.institutointegra.api.spec.orders.dto.OrdersDto;
import br.com.institutointegra.api.spec.orders.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProxyRsOrders proxyRsOrders;
	

	@Override
	public Map<String, String> viewPort(){
		return this.proxyRsOrders.viewPort();
	}
	
	 @Override
	 public OrdersDto save(OrdersDto ordersDto) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			 
			HttpEntity<OrdersDto> request = 
					 new HttpEntity<>(ordersDto, headers);
			 
			ResponseEntity<OrdersDto> entity = restTemplate.postForEntity(
					 "http://localhost:8083/api/", 
					 request, 
					 OrdersDto.class);
			
			return entity.getBody();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 }

	@Override
	public OrdersDto saveFeign(OrdersDto ordersDto) {
		return this.proxyRsOrders.save(ordersDto);
	}
	
	@Override
	public List<OrdersDto> listOrders() {
		return this.proxyRsOrders.listOrders();
	}
	
}
