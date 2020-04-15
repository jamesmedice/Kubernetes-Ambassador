package com.medici.app.shop.service;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medici.app.shop.domain.model.Product;
import com.medici.app.shop.domain.repository.ProductRepository;
import com.medici.app.shop.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public Product createProduct(ProductDto ProductDto) {
		Product product = mapper.map(ProductDto, Product.class);
		product.setTimestamp(Instant.now().toEpochMilli());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		Iterator<Product> iteratorToCollection = productRepository.findAll().iterator();
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iteratorToCollection, Spliterator.ORDERED), false).collect(Collectors.toList());
	}

	@Override
	public void deleteProduct(ProductDto ProductDto) {
		Product op = mapper.map(ProductDto, Product.class);
		productRepository.delete(op);
	}
}
