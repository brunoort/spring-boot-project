package br.com.institutointegra.api.product.resource;

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

import br.com.institutointegra.api.product.model.Product;
import br.com.institutointegra.api.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Product API", description = "Operations to Product")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "View list Product")
	@GetMapping("/all")
	public List<Product> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/")
	public Product save(@RequestBody Product Product) {
		return this.productService.save(Product);
	}
	
	@PutMapping("/{id}")
	public Product update(
			@PathVariable(name = "id", required = false) Long idProduct, 
			@RequestBody Product Product
			) {
		return this.productService.save(Product);
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return this.productService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  delete(@PathVariable Long id) {
		this.productService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}


