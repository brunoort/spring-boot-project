package br.com.institutointegra.api.spec.product.service;

import java.util.List;
import java.util.Map;

import br.com.institutointegra.api.spec.product.dto.ProductDto;

public interface ProductService {
	ProductDto save(ProductDto productDto);
	ProductDto saveFeign(ProductDto productDto);
	List<ProductDto> listProduct();
	Map<String, String> viewPort();
}
