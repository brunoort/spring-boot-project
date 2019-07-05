package br.com.institutointegra.api.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.institutointegra.api.product.model.Product;
import br.com.institutointegra.api.product.repository.ProductRepository;
import br.com.institutointegra.api.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product save(Product p) {
		return this.productRepository.save(p);
	}

	@Override
	public Product findById(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.productRepository.deleteById(id);
	}

}
