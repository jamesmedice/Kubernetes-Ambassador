package com.medici.app.shop.service;

import java.util.List;

import com.medici.app.shop.domain.model.Product;
import com.medici.app.shop.dto.ProductDto;

public interface ProductService {

	Product createProduct(ProductDto dto);

	List<Product> getAllProducts();

	void deleteProduct(ProductDto operationDto);
}
