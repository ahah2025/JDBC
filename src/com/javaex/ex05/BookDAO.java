package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/web_db";
	private String id = "web";
	private String pw = "web";

	//생성자
	public BookDAO() {}	
	
	//메소드gs
	
	//메소드일반
	
	//DB연결 메소드-공통
	private void connect() { // 메인에서는 사용 못함

		try {
			// 1. JDBC 드라이버 (MySQL) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			this.conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 자원정리 메소드-공통
	private void close() {
		// 5. 자원정리
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// book 등록
	public int authorInsert(String name, String desc) {
		int count = -1;

		// 0. import java.sql.*;
		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " insert into book ";
			query += " values(null, ?, ?, ?, ?) ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id); // 메소드의 파라미터
			pstmt.setString(2, title); // 메소드의 파라미터
			pstmt.setString(3, pubs); // 메소드의 파라미터
			pstmt.setString(4, pubDate); // 메소드의 파라미터
			pstmt.setString(5, authorId); // 메소드의 파라미터
			
			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		// 5. 자원정리
		this.close();

		return count;
	}

	// book 수정
	public int BookUpdate(int bookId, String title, String pubs, 
						  String pubDate,int authorId ) {
		int count = -1;

		// 0. import java.sql.*;
		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " update book ";
			query += " set book_id = ?, ";
			query += " 	   title = ?, ";
			query += " 	   pubs = ?, ";
			query += " 	   pub_date = ?, ";
			query += " 	   author_id = ? ";
			query += " where book_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id); // 메소드의 파라미터
			pstmt.setString(2, title); // 메소드의 파라미터
			pstmt.setString(3, pubs); // 메소드의 파라미터
			pstmt.setString(4, pubDate); // 메소드의 파라미터
			pstmt.setString(5, authorId); // 메소드의 파라미터
			
			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return count;
	}

	// book 삭제
	public int bookDelete(int bookId) {
		int count = -1;

		// 1. 2. DB connect
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id); // 메소드의 파라미터
			pstmt.setString(2, title); // 메소드의 파라미터
			pstmt.setString(3, pubs); // 메소드의 파라미터
			pstmt.setString(4, pubDate); // 메소드의 파라미터
			pstmt.setString(5, authorId); // 메소드의 파라미터

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return count;
	}

	// book 리스트
	public List<BookVO> bookSelect() {

		// 리스트
		List<BookVO> bookList = new ArrayList<BookVO>();

		// 0. import java.sql.*;

		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select book_id, ";
			query += "        title, ";
			query += "        pubs, ";
			query += "        pub_date, ";
			query += "        author_id ";
			query += " from book ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리 (java 리스트로 만든다)
			while (rs.next()) {

				int bookId = rs.getInt("book_id");
				String booktitle = rs.getString("title");
				String bookpubs = rs.getString("pubs");
				String bookPubDate = rs.getString("pub_date");
				String authorId = rs.getString("author_id");

				// 데이터 객체로 만들기(묶기)
				BookVO bookVO = new BookVO(bookId, bookTitle, bookPubs, 
										   bookPubDate , authorId);

				// 묶은 데이터를 리스트에 달기
				bookList.add(bookVO);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return bookList;

	}

	// 데이터 1개 가져오기
	public int bookSelectOne(int bookId, String title, String pubs, 
							 String pubDate,int authorId ) {
		int count = -1;

		// 리스트
		List<BookVO> BookList = new ArrayList<BookVO>();

		// 0. import java.sql.*;

		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select book_id, ";
			query += "        title, ";
			query += "        pubs, ";
			query += "        pub_date, ";
			query += "        author_id ";
			query += " from book ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리 (java 리스트로 만든다)
			while (rs.next()) {

				int bookId = rs.getInt("book_id");
				String booktitle = rs.getString("title");
				String bookpubs = rs.getString("pubs");
				String bookPubDate = rs.getString("pub_date");
				String author_id = rs.getString("author_id");

				// 데이터 객체로 만들기(묶기)
				BookVO bookVO = new BookVO(bookId, bookTitle, bookPubs, bookPubDate , authorId);

				// 묶은 데이터를 리스트에 달기
				bookList.add(bookVO);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return bookList;
	}

}

	
}
