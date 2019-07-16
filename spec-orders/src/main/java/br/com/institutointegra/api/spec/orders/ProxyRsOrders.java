package br.com.institutointegra.api.spec.orders;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.institutointegra.api.spec.orders.dto.OrdersDto;

@FeignClient(
		url="${store.url.rs-orders}",
		name="rs-orders"
		)
@RibbonClient(name = "rs-orders")
public interface ProxyRsOrders {
	
	@PostMapping("/api/")
	OrdersDto save(@RequestBody OrdersDto ordersDto);
	
	@GetMapping("/api/all")
	List<OrdersDto> listOrders();
	
	@GetMapping("/api/viewPort")
	Map<String, String> viewPort();
}
