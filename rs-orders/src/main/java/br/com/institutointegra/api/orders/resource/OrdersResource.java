package br.com.institutointegra.api.orders.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.orders.model.Orders;
import br.com.institutointegra.api.orders.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Orders API", description = "Operations to Orders")
public class OrdersResource {

	@Autowired
	private OrdersService ordersService;

	@ApiOperation(value = "View list Orders")
	@GetMapping("/all")
	public List<Orders> getAll(){
		return this.ordersService.getAll();
	}
	
	@PostMapping("/")
	public Orders save(@RequestBody Orders Product) {
		return this.ordersService.save(Product);
	}
	
	@PutMapping("/{id}")
	public Orders update(
			@PathVariable(name = "id", required = false) Long idOrder, 
			@RequestBody Orders order
			) {
		return this.ordersService.save(order);
	}
	
	@GetMapping("/{id}")
	public Orders findById(@PathVariable Long id) {
		return this.ordersService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  delete(@PathVariable Long id) {
		this.ordersService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}


