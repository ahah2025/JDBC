package com.javaex.ex05;

public class BookApp {

	//web_db    web    web
	
	//Book 테이블만
	BookDAO bookDAO = new BookDAO();
	
	// BookVO
	bookDAO.bookInsert();
	bookDAO.bookUpdate();
	bookDAO.bookDelete();
	bookDAO.bookSelect();
	bookDAO.bookSelectOne();
	
	
	//BookAuthorVO
	bookDAO.bookSelectList() --> 전체
	
	
	
}
