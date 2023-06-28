package com.SD08.fit.model.dao;

import java.util.*;

import com.SD08.fit.model.dto.Review;

public class ReviewDaoImpl implements ReviewDao{
	/**
	 * Integer : 영상 id
	 * List<Review> : 리뷰 배열
	 */
	Map<String, List<Review>> list = new HashMap<>();
	
	private static ReviewDaoImpl instance = new ReviewDaoImpl();
	private ReviewDaoImpl() {
	}
	public static ReviewDaoImpl getInstance() {
		return instance;
	}


	@Override
	public List<Review> getReviewList(String id) {
		return list.get(id);
	}
	
	public void addReview(Review review) {
		if(list.get(review.getId()) == null) {
			List<Review> review_list = new ArrayList<>();
			list.put(review.getId(), review_list);
		}
		
		list.get(review.getId()).add(review);

	}
	
	
	public void deleteReview(Review review) {
		
		
	}
	
	
	
}
