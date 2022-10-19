package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.VideoReview;

public interface VideoReviewDao {
	int insertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
}
