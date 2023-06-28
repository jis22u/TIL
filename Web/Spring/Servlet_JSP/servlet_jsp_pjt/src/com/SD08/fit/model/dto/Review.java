package com.SD08.fit.model.dto;


public class Review {

	private String id;
	private String title;
	private String writer;
	private String content;
	
	public Review() {
		super();
	}
	
	public Review(String id, String title, String writer, String content) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
}

