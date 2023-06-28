package com.ssafy.fit.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private static List<Video> list;
	private static VideoDaoImpl instance = new VideoDaoImpl();
	private VideoDaoImpl() {
	}
	
	public static VideoDaoImpl getInstance() throws FileNotFoundException {
		Reader reader = new FileReader("..\\java_pjt\\src\\com\\ssafy\\fit\\model\\dao\\video.json");
		Gson gson = new Gson();
		list = gson.fromJson(reader,  new TypeToken<List<Video>>(){}.getType());
		return instance;
	}
	
	
	@Override
	public List<Video> selectVideo(){
		return list;
	}
	
	@Override
	public Video selectVideoByNo(int no) {
		return list.get(no);
	}

} //end class

