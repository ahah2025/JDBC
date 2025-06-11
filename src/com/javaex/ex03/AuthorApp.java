package com.javaex.ex03;

//메인프로그램
public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDAO authorDao = new AuthorDAO();
		
		
		authorDao.authorInsert("박경리", "토지작가");
		authorDao.authorInsert("김영하", "알쓸신잡 출연");
		authorDao.authorInsert("기안84", "방송대상 수장");
		
		
		
		//authorDao.authorDelete(3);
		
		//authorDao.authorUpdate(3, "강호동", "운동선수");
		
		//authorDao.authorList();
		
	}

}
