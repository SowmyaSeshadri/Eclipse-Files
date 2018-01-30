package com.zilker.rssFeed.bean;

public class News {
	private String title;
	private String link;
	private String date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public News(String title, String link, String date) {
		super();
		this.title = title;
		this.link = link;
		this.date = date;
	}
	
}
