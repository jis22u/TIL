package com.ssafy.fit.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssafy.fit.model.Member;
import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.MemberDao;
import com.ssafy.fit.model.dao.MemberDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class VideoReviewUi {
	Scanner sc = new Scanner(System.in);
	private VideoReviewDao videoReviewDao = VideoReviewDaoImpl.getInstance();
	
	private int videoNo;
	
	private static VideoReviewUi instance;
	
	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
	}
	
	public static VideoReviewUi getInstance(int videoNo) {
		VideoReviewUi instance = new VideoReviewUi(videoNo);
		return instance;
	}
	
	public void service() {
	}
	
	void listReview(int a) throws FileNotFoundException{
		if(videoReviewDao.selectReview(a)!=null) {
			List<VideoReview> list = videoReviewDao.selectReview(a);
			for(VideoReview i :list) {
				System.out.println(i);
			}
		} else {
			registReview();
		}
	} //listReview
	
	void registReview() throws FileNotFoundException {
		VideoReview videoreview = new VideoReview();
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		
		boolean a = false;
        for(Member member : MemberDaoImpl.getInstance().getList()) {
            if(member.getId().equals(id)) {
            	MemberDaoImpl.getInstance().cntplus(member);
                a = true;
                break;
            }
        }
        MemberUi mui = MemberUi.getInstance();
        if(!a) {
            System.err.println("회원정보가 없습니다. 회원가입을 해주세요.");
            mui.registMember();
        }
        
		videoreview.setId(id);
		System.out.print("내용을 입력하세요 : ");
		String content = sc.nextLine();
		videoreview.setContent(content);
		videoreview.setVideoNo(videoNo);
		int cnt = videoReviewDao.selectReview(videoNo).size();
		videoreview.setReviewNo(cnt+1);
		videoReviewDao.insertReview(videoreview);
		MainUi mainui= new MainUi();
		mainui.service();
	} //registReview
	
} //end class
