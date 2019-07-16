package br.com.institutointegra.api.spec.orders.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.spec.orders.dto.OrdersDto;
import br.com.institutointegra.api.spec.orders.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersResource {

	@Autowired
	private OrdersService ordersService;
	

	@GetMapping("/viewPortOrders")
	public Map<String, String> viewPortOrders(){
		return this.ordersService.viewPort();
	}
	
	@PostMapping("/")
	public OrdersDto save(@RequestBody OrdersDto ordersDto) {
		return this.ordersService.save(ordersDto);
	}
	
	@PostMapping("/feign")
	public OrdersDto saveFeign(@RequestBody OrdersDto ordersDto) {
		return this.ordersService.saveFeign(ordersDto);
	}
	
	@GetMapping("/all")
	public List<OrdersDto> productDto(){
		return this.ordersService.listOrders(); 
	}
		
}
