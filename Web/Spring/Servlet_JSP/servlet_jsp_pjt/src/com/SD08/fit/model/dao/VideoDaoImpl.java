
package com.SD08.fit.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.SD08.fit.model.dto.Video;

public class VideoDaoImpl implements VideoDao {
	private ArrayList<Video> videoList = new ArrayList<>();
	
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	private VideoDaoImpl() {
		try {
			String path = VideoDaoImpl.class.getResource("").getPath();
			Reader reader = new FileReader(path+"video.json");
			Gson gson=new Gson();
			videoList = gson.fromJson(reader,new TypeToken<List<Video>>(){}.getType());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	
	
	public Video selectVideo(String id) {
		for(Video v : videoList) {
			System.out.println(v.getId());
			if(v.getId().equals(id)) return v;
		}
		return null;
	}
	
	
	@Override
	public List<Video> selectInterestViewFitVideo() {
		return videoList;
	}

	@Override
	public List<Video> selectPartFitVideo() {
		return null;
	}
	
}
