package com.SD08.fit.model.dao;

import java.util.List;

import com.SD08.fit.model.dto.Video;

public interface VideoDao {
	
     Video selectVideo(String id);
	 List<Video> selectInterestViewFitVideo();
	 List<Video> selectPartFitVideo();
}
