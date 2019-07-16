package br.com.institutointegra.api.spec.product;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.institutointegra.api.spec.product.dto.ProductDto;

@FeignClient(
		url="${store.url.rs-product}",
		name="rs-product"
		)
@RibbonClient(name = "rs-product")
public interface ProxyRsProduct {
	
	@PostMapping("/api/")
	ProductDto save(@RequestBody ProductDto productDto);
	
	@GetMapping("/api/all")
	List<ProductDto> listProduct();
	
	@GetMapping("/api/viewPort")
	Map<String, String> viewPort();
}
