package br.com.institutointegra.api.product.service;

import java.util.List;

import br.com.institutointegra.api.product.model.Product;

public interface ProductService {
	List<Product> getAll();
	
	Product save(Product p);
	
	Product findById(Long id);
	
	void delete(Long id);
}


