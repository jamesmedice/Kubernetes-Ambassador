package com.medici.app.shop.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medici.app.shop.domain.model.Product;
import com.medici.app.shop.dto.ProductDto;
import com.medici.app.shop.request.CreateProductRequest;
import com.medici.app.shop.service.ProductService;

@RestController
@RequestMapping("/bootstorage")
public class ShopController {

	@Autowired
	ProductService productService;

	@Autowired
	ModelMapper mapper;

	@CrossOrigin
	@GetMapping(value = "/")
	public List<ProductDto> getAllProducts() {
		List<Product> allOperations = productService.getAllProducts();
		if (allOperations != null && !allOperations.isEmpty()) {
			return allOperations.stream().map(account -> mapper.map(account, ProductDto.class)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@CrossOrigin
	@GetMapping(value = "/products")
	public List<String> getAllProductsInStringForm() {
		List<Product> allProducts = productService.getAllProducts();
		if (allProducts != null && !allProducts.isEmpty()) {
			return allProducts.stream().sorted(Comparator.comparing(Product::getTimestamp).reversed()).map(Object::toString).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@PostMapping(value = "/create")
	public ProductDto createOperation(@RequestBody @Valid CreateProductRequest createOperationRequest) {
		ProductDto dto = mapper.map(createOperationRequest, ProductDto.class);
		Product model = productService.createProduct(dto);
		if (model != null) {
			return mapper.map(model, ProductDto.class);
		}
		return null;
	}

	@GetMapping(value = "/deletelru")
	public ResponseEntity deleteOperation() {
		List<Product> allProducts = productService.getAllProducts();

		if (allProducts != null && !allProducts.isEmpty()) {
			List<Product> sortedProducts = allProducts.stream().sorted(Comparator.comparing(Product::getTimestamp)).collect(Collectors.toList());
			productService.deleteProduct(mapper.map(sortedProducts.get(0), ProductDto.class));
			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/healthz")
	public ResponseEntity healthz() {
		return new ResponseEntity(HttpStatus.OK);
	}
}
