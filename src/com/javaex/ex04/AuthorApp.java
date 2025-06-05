package com.javaex.ex04;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDAO authorDAO = new AuthorDAO();
		
		//int c01 = authorDAO.authorInsert("김종국", "런닝맨1기");
	
		//authorDAO.count();
		int c02 = authorDAO.authorUpdate(16,"이효리","제주도");
	
		//int c03 = authorDAO.authorDelete(2);
		
		//authorDAO.authorSelect();
	
		//List<AuthorVO> authorList = authorDAO.authorSelect();
	
	}
}
