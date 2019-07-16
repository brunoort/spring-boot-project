package br.com.institutointegra.api.spec.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.institutointegra.api.spec.product.ProxyRsProduct;
import br.com.institutointegra.api.spec.product.dto.ProductDto;
import br.com.institutointegra.api.spec.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProxyRsProduct proxyRsProduct;
	

	@Override
	public Map<String, String> viewPort(){
		return this.proxyRsProduct.viewPort();
	}
	
	 @Override
	 public ProductDto save(ProductDto productDto) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			 
			HttpEntity<ProductDto> request = 
					 new HttpEntity<>(productDto, headers);
			 
			ResponseEntity<ProductDto> entity = restTemplate.postForEntity(
					 "http://localhost:8082/api/", 
					 request, 
					 ProductDto.class);
			
			return entity.getBody();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 }

	@Override
	public ProductDto saveFeign(ProductDto productDto) {
		return this.proxyRsProduct.save(productDto);
	}
	
	@Override
	public List<ProductDto> listProduct() {
		return this.proxyRsProduct.listProduct();
	}
	
}
