package com.ssafy.fit.model.dao;


import java.io.FileNotFoundException;
import java.util.List;

import com.ssafy.fit.model.Video;

public interface VideoDao {
	List<Video> selectVideo() throws FileNotFoundException;
	Video selectVideoByNo(int no);
}
