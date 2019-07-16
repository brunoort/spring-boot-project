package br.com.institutointegra.api.spec.product.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.spec.product.dto.ProductDto;
import br.com.institutointegra.api.spec.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductResource {

	@Autowired
	private ProductService productService;
	

	@GetMapping("/viewPortProduct")
	public Map<String, String> viewPortProduct(){
		return this.productService.viewPort();
	}
	
	@PostMapping("/")
	public ProductDto save(@RequestBody ProductDto productDto) {
		return this.productService.save(productDto);
	}
	
	@PostMapping("/feign")
	public ProductDto saveFeign(@RequestBody ProductDto productDto) {
		return this.productService.saveFeign(productDto);
	}
	
	@GetMapping("/all")
	public List<ProductDto> productDto(){
		return this.productService.listProduct(); 
	}
		
}
