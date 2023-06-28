package com.ssafy.fit.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class VideoUi {
	Scanner sc = new Scanner(System.in);
	private VideoDao videoDao;
	private static VideoUi instance = new VideoUi();
	
	private VideoUi() {
	}

	public static VideoUi getInstance() {
		return instance;
	}

	public void service() throws FileNotFoundException {
		int sel;
		do{
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1. 영상목록");
			System.out.println("0. 이전으로");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			sel = sc.nextInt();
			if(sel==1) {
				listVideo();
			}
			else if(sel==0) {
				return;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		} while(sel==1||sel!=0);
	} //service

	private void listVideo() throws FileNotFoundException {
		List<Video> list = new ArrayList<>();
		int sel;
		do{
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("전체 8개");
			System.out.println("--------------------------------------------------------------------------------");
			list = VideoDaoImpl.getInstance().selectVideo();
			for(Video video: list) {
				System.out.println(video);
			}
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1. 영상상세");
			System.out.println("0. 이전으로");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 :");
			sel = sc.nextInt();
				if(sel==1) {
					detailVideo();
				}
				else if(sel==0) {
					return;
				}
				else
					System.out.println("잘못된 입력입니다.");
		}while(sel==1||sel!=0);
	} //listVideo

	private void detailVideo() throws FileNotFoundException {
		int sel;
		do {
			System.out.print("영상번호를 입력하세요 :");
			sel = sc.nextInt();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(VideoDaoImpl.getInstance().selectVideoByNo(sel-1).toString(sel));
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------");
			VideoReviewUi vrui = VideoReviewUi.getInstance(sel-1);
			if(VideoReviewDaoImpl.getInstance().getVideoReviewDb().get(sel-1) == null) {
				System.out.println("영상리뷰: 0개");
			} else {
				System.out.println("영상리뷰: "+ VideoReviewDaoImpl.getInstance().getVideoReviewDb().get(sel-1).size()+"개");
			}
			System.out.println("--------------------------------------------------------------------------------");
			vrui.listReview(sel-1);
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1. 리뷰등록");
			System.out.println("0. 이전으로");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			sel = sc.nextInt();
			
			if(sel==1) {
				vrui.registReview();
			} else if(sel==0) {
				return;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
		} while(sel==1||sel!=0);
	} //detailVideo

} // end class
