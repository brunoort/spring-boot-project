package br.com.institutointegra.api.orderitem.resource;

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

import br.com.institutointegra.api.orderitem.model.OrderItem;
import br.com.institutointegra.api.orderitem.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="OrderItem API", description = "Operations to Order Item")
public class OrderItemResource {

	@Autowired
	private OrderItemService orderItemService;

	@ApiOperation(value = "View list OrderItem")
	@GetMapping("/all")
	public List<OrderItem> getAll(){
		return this.orderItemService.getAll();
	}
	
	@PostMapping("/")
	public OrderItem save(@RequestBody OrderItem orderItem) {
		return this.orderItemService.save(orderItem);
	}
	
	@PutMapping("/{id}")
	public OrderItem update(
			@PathVariable(name = "id", required = false) Long idOrderItem, 
			@RequestBody OrderItem orderItem
			) {
		return this.orderItemService.save(orderItem);
	}
	
	@GetMapping("/{id}")
	public OrderItem findById(@PathVariable Long id) {
		return this.orderItemService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  delete(@PathVariable Long id) {
		this.orderItemService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}


