package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
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
							+ " left outer join author a on b.author_id=a.author_id";

					//바인딩
					pstmt = conn.prepareStatement(query);

					//실행
					rs = pstmt.executeQuery();
				
					// 4.결과처리
					while(rs.next()) {
						int id=rs.getInt("book_id");
						String title=rs.getString("title");
						String pubs=rs.getString("pubs");
						String date=rs.getString("pub_date");
						int author=rs.getInt("author_id");
						int uId=rs.getInt("author_id");
						String name=rs.getString("author_name");
						String desc=rs.getString("author_desc");
						System.out.println(id+" "+title+" "+pubs +" "+ date+" "+author+" "+uId+" "+ name+" "+desc);
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