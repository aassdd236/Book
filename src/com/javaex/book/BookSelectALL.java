package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.author.AuthorVo;

public class BookSelectALL {

	public static void main(String[] args) {
		List<BookVo> bookList=new ArrayList<BookVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL
			String query="select b.book_id,"
					+ " b.title,"
					+ " b.pubs,"
					+ " date_format(b.pub_date, '%Y년 %m월 %d일') pub_date,"
					+ " b.author_id,"
					+ " a.author_id,"
					+ " a.author_name,"
					+ " a.author_desc"
					+ " from book b"
					+ " left outer join author a on b.author_id=a.author_id"
					+ " order by b.title desc";

			//바인딩
			pstmt = conn.prepareStatement(query);

			//실행
			rs = pstmt.executeQuery();

			//검색결과에서 데이터 꺼내기
			while(rs.next()) {
				int id=rs.getInt("book_id");
				String title=rs.getString("title");
				String pubs=rs.getString("pubs");
				String date=rs.getString("pub_date");
				int author=rs.getInt("author_id");
				int uId=rs.getInt("author_id");
				String name=rs.getString("author_name");
				String desc=rs.getString("author_desc");
				
				// 묶기
				BookVo v01=new BookVo(id, title, pubs, date, author, uId, name, desc);

				//리스트에 추가
				bookList.add(v01);
			}

			// 4.결과처리
			for (int i=0; i<bookList.size(); i++) {
				int id=bookList.get(i).getId();
				String title=bookList.get(i).getTitle();
				String pubs=bookList.get(i).getPubs();
				String date=bookList.get(i).getDate();
				int author=bookList.get(i).getAuthor();
				int uId=bookList.get(i).getuId();
				String name=bookList.get(i).getName();;
				String desc=bookList.get(i).getDesc();;
				
				System.out.println(id+", "+title+", "+pubs+", "+date+", "+author+", "+uId+", "+name+", "+desc);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {            
				if (rs != null) {
					rs.close();
				}  

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
	}
}
