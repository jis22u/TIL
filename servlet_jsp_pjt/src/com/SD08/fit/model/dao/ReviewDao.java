package com.SD08.fit.model.dao;

import java.util.List;

import com.SD08.fit.model.dto.Review;

public interface ReviewDao {
	List<Review> getReviewList(String id);
	void addReview(Review review);
}
