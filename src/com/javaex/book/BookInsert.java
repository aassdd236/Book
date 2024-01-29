package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL
			String query="insert into book "
					+ "values(null, ?, ?, ?, ?);";

			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "토지");
			pstmt.setString(2, "출판사");
			pstmt.setString(3, "2012-12-12");
			pstmt.setInt(4,  5);

			//실행
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록 되었습니다.");


		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

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
	}
}
