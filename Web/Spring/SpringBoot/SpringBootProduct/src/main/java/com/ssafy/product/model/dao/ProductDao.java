package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.SearchCondition;

public interface ProductDao {
	//모든 상품 조회
	public List<Product> selectAll();
	
	//ID에 해당하는 상품 상세 조회
	public Product selectOne(int id);
	
	//상품 등록
	public void insertProduct(Product product);
	
	//상품 수정
	public void updateProduct(Product product);

	//상품 삭제
	public void deleteProduct(int id);
	
	//검색기능
	public List<Product> search(SearchCondition condition);
	
}
