package com.javaex.ex04;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDAO authorDAO = new AuthorDAO();
		
		//int c01 = authorDAO.authorInsert("김종국", "런닝맨1기");
	
		//int c02 = authorDAO.authorUpdate(17, "조세호", "유퀴즈");
	
		//int c03 = authorDAO.authorDelete(18);
		
		//authorDAO.authorSelect();
	
		List<AuthorVO> authorList = authorDAO.authorSelect();
		System.out.println(authorList);
		
		AuthorVO authorVO =  authorDAO.authorSelectOne(11, null, null);
		//										(int authorId,String authorName,String authorDesc)
		System.out.println(authorVO);
		
	}
}
