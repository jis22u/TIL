package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.SearchCondition;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	
	//Dao를 Autowired 주입하였따.
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public List<Product> getProductList() {
		System.out.println("상품 전체 리스트를 가져온다.");
		return productDao.selectAll();
	}

	@Transactional
	@Override
	public Product detailProduct(int id) {
		System.out.println(id+"번 상품 상세 조회합니다.");
		return productDao.selectOne(id);
	}

	@Transactional
	@Override
	public void registProduct(Product product) {
		System.out.println("상품을 등록합니다.");
		productDao.insertProduct(product);
	}

	@Transactional
	@Override
	public void modifyProduct(Product product) {
		System.out.println("상품 정보를 수정합니다.");
		productDao.updateProduct(product);
	}

	@Transactional
	@Override
	public void removeProduct(int id) {
		System.out.println("상품을 삭제합니다.");
		productDao.deleteProduct(id);
	}

	@Override
	public List<Product> search(SearchCondition condition) {
		return productDao.search(condition);
	}
	
	@Override
	public Product getProduct(int id) {
		return productDao.selectOne(id);
	}

}
