package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.SearchCondition;

public interface ProductService {
	//모든 상품 조회
	List<Product> getProductList();
	
	//상품 상세 조회
	Product detailProduct(int id);
	
	//상품 등록
	void registProduct(Product product);
	
	//상품 수정
	void modifyProduct(Product product);
	
	//상품 삭제
	void removeProduct(int id);
	
	//검색했다면 검색 기준에 따른 값을 가져와라 
	List<Product> search(SearchCondition condition);
	
	//상품 하나를 가져온다.
	Product getProduct(int id);
}
