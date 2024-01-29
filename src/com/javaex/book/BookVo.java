package com.javaex.book;

public class BookVo {

	private int id;
	private String title;
	private String pubs;
	private String date;
	private int author;
	private int uId;
	private String name;
	private String desc;
	
	public BookVo() {
		
	}
	public BookVo(int id, String title, String pubs, String date, int author, int uId, String name, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.pubs = pubs;
		this.date = date;
		this.author = author;
		this.uId = uId;
		this.name = name;
		this.desc = desc;
	}
	

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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "BookVo [id=" + id + ", title=" + title + ", pubs=" + pubs + ", date=" + date + ", author=" + author
				+ ", uId=" + uId + ", name=" + name + ", desc=" + desc + "]";
	}

	
}