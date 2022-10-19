package com.SD08.fit.model.dto;

public class Video {
	
	private String title;
	private String part;
	private String id;
	private String channelName;
	private String url;
	private int viewCnt;
	
	public Video() {
	
	}

	public Video(String title, String part, String id, String channelName, String url, int viewCnt) {
		super();
		this.title = title;
		this.part = part;
		this.id = id;
		this.channelName = channelName;
		this.url = url;
		this.viewCnt = viewCnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Video [title=" + title + ", part=" + part + ", id=" + id + ", channelName=" + channelName + ", url="
				+ url + ", viewCnt=" + viewCnt + "]";
	}

	
}
