package com.ssafy.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService ps;
	
	
	/**
	 * 모든 리스트 반환
	 */
	@GetMapping("/product")
	@ApiOperation(value = "등록된 모든 상품 정보를 반환한다.", response = Product.class)
	public ResponseEntity<List<Product>> selectAll() {
		return new ResponseEntity<List<Product>>(ps.getProductList(), HttpStatus.OK);
	}
	
	
	// select(READ)
	@GetMapping("/product/{id}")
	@ApiOperation(value = "{id}에 해당하는 product를 반환한다.", response = Product.class)
	public ResponseEntity<Product> selectProduct(@PathVariable int id) {
		Product product = ps.detailProduct(id);
		return new ResponseEntity<>(product , HttpStatus.OK);
	}
	
	// insert(CREATE)
	@PostMapping("/product")
	@ApiOperation(value = "product 객체를 저장한다.", response = String.class)
	public ResponseEntity<String> insert(Product product) throws IllegalStateException, IOException {
		ps.registProduct(product);
		return new ResponseEntity<>("등록 완료" , HttpStatus.OK);
	}

	
	
	
	// delete(DELETE)
	@DeleteMapping("/product/{id}")
	@ApiOperation(value = "product 객체를 삭제한다.", response = String.class)
	public ResponseEntity<String> delete(@PathVariable int id) {
		ps.removeProduct(id);
		return new ResponseEntity<>("삭제 완료" , HttpStatus.OK);
	}
	
	
//	// search(READ)
//	@GetMapping("/product/{p_name}")
//	@ApiOperation(value = "{p_name}에 해당하는 영화 정보를 반환한다.", response = Product.class)
//	public ResponseEntity<List<Product>> select(@PathVariable String p_name) {
//		List<Product> list = ps.search(p_name);
//		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
//	}
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
