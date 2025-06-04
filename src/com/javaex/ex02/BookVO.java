package com.javaex.ex02;

//Vo Value Object
public class BookVO {
	
	//필드
	private int id;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	//생성자
	public BookVO() {
	}

	public BookVO(int id, String title, String pubs, String pubDate, int authorId, String authorName,
			String authorDesc) {
		this.id = id;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	//메소드gs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	//메소드 일반
	@Override
	public String toString() {
		return "BookVO [id=" + id + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate + ", authorId="
				+ authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
}
