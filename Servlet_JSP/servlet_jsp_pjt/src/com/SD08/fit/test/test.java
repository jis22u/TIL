package com.SD08.fit.test;

import java.util.List;

import com.SD08.fit.model.dao.VideoDaoImpl;
import com.SD08.fit.model.dto.Video;

public class test {
	public static void main(String[] args) {
		VideoDaoImpl mg = VideoDaoImpl.getInstance();
		List<Video> list = mg.selectInterestViewFitVideo();
		System.out.println(list.get(1));
		
		for(Video v : list) System.out.println(v);
	}
}
