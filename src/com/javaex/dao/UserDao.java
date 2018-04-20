package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javaex.vo.UserVo;

public class UserDao {

	public void insert(UserVo vo) {

		// 0. import java.sql.*;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 메모리에 올림

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // ("jdbc:oracle:thin:@localhost:1521:xe", id,
																		// pw)

			// 3. SQL문 준비 / 바인딩(?처리) / 실행
			String query = "insert into users values (seq_user_no.nextval, ?, ?, ?, ?)";

			/********* 바인딩 *********/
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			/********** 실행 ********/
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 user 저장 완료");

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

	public UserVo getUser(String email, String password) {
		// 0. import java.sql.*;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo userVo = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 메모리에 올림

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // ("jdbc:oracle:thin:@localhost:1521:xe", id,
																		// pw)

			// 3. SQL문 준비 / 바인딩(?처리) / 실행
			String query = "select no, name from users where email = ? and password = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");

				userVo = new UserVo();
				userVo.setNo(no);
				userVo.setName(name);
			}

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
		return userVo;
	}
	
	
	public UserVo getUser(int no) {
		// 0. import java.sql.*;

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				UserVo userVo = null;
				try {
					// 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver"); // 메모리에 올림

					// 2. Connection 얻어오기
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "webdb"); // ("jdbc:oracle:thin:@localhost:1521:xe", id,
																				// pw)

					// 3. SQL문 준비 / 바인딩(?처리) / 실행
					String query = "select * from users where no = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, no);
					rs = pstmt.executeQuery();

					

					// 4.결과처리
					while (rs.next()) {
						String name = rs.getString("name");
						String email = rs.getString("email");
						String password = rs.getString("password");
						String gender = rs.getString("gender");

						userVo = new UserVo();
						userVo.setNo(no);
						userVo.setName(name);
						userVo.setEmail(email);
						userVo.setPassword(password);
						userVo.setGender(gender);
					}

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
		
		return userVo;
	}
	public void modify(UserVo vo) {
		// 0. import java.sql.*;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 메모리에 올림

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // ("jdbc:oracle:thin:@localhost:1521:xe", id,
																		// pw)

			// 3. SQL문 준비 / 바인딩(?처리) / 실행
			int no = vo.getNo();
			String query = "update users set name = ?, password = ?, gender = ? where no = "+ no;

			System.out.println(query);
			/********* 바인딩 *********/
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());

			/********** 실행 ********/
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 user 수정 완료");

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
