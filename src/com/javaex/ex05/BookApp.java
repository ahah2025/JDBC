package com.javaex.ex05;

public class BookApp {

	//web_db    web    web
	
	//Book 테이블만
	BookDAO bookDAO = new BookDAO();
	
	// BookVO
	/*
	BookDAO.authorInsert();
	BookDAO.bookUpdate();
	BookDAO.bookDelete();
	BookDAO.bookSelect();
	BookDAO.bookSelectOne();
	*/
	
	//BookAuthorVO
	bookDAO.bookSelect(); --> 전체
	
	
	
}
