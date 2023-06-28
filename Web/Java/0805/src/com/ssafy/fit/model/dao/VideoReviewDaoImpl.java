package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;
public class VideoReviewDaoImpl implements VideoReviewDao{
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
	private VideoReviewDaoImpl() {
	}
	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}
	
	private int reviewNo;
	private Map<Integer,List<VideoReview>> videoReviewDb = new HashMap<>();
	
	
	public Map<Integer, List<VideoReview>> getVideoReviewDb() {
		return videoReviewDb;
	}
	public void setVideoReviewDb(Map<Integer, List<VideoReview>> videoReviewDb) {
		this.videoReviewDb = videoReviewDb;
	}
	
	@Override
	public int insertReview(VideoReview videoReview) {
		List<VideoReview> list = videoReviewDb.get(videoReview.getVideoNo());
		if(list == null) {
			List<VideoReview> list2 = new ArrayList<>();
			list2.add(videoReview);	
			videoReviewDb.put(videoReview.getVideoNo(), list2);
		} else {
			list.add(videoReview);
			videoReviewDb.put(videoReview.getVideoNo(), list);
		}
		return 1;
	}
	
	@Override
	public List<VideoReview> selectReview(int videoNo) {
		List<VideoReview> list = new ArrayList<>();
		if(videoReviewDb.get(videoNo)!=null)
			list = videoReviewDb.get(videoNo);
		return list;
	}
	
}
