package database.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J03_DBPractice {
	
	/*
	 
	 	(1) DB에 새 계정을 추가한다
	 	
	 	(2) 새 계정에 권한을 부여한다
	 	
	 	(3) 해당 계정에 새 테이블을 추가한다
	 		(기본키로 시퀀스를 사용해야 하고, 제약 조건을 종류별로 모두 사용해야 한다)
	 		
	 	(4) 프로그램에서 스캐너로 입력하면 DB에 행이 추가되어야 한다
	 	
	 	(5) 콘솔에서 여태까지 추가된 모든 행을 조회 할 수 있어야 한다
	 	
	 */
	
	public static void main(String[] args) {
		
		String driverPath = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "newuser1";
		String password = "1230";
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName(driverPath);
			System.out.println("드라이버 로드 성공...");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 못 찾음");
		}
		
		// 4.
		
		String sql1 = "INSERT INTO icecream VALUES (ice_sq.nextval, ?, ?, ?)";
		
		try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql1);
				) {
			System.out.println("색상을 입력해 주세요");
			pstmt.setString(1, sc.next());
			System.out.println("맛을 입력해 주세요");
			pstmt.setString(2, sc.next());
			System.out.println("가격을 입력해 주세요");
			pstmt.setInt(3, sc.nextInt());
			
			int row = pstmt.executeUpdate();
			System.out.printf("%d행이 추가되었습니다. \n", row);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 5. 
		
		String sql2 = "SELECT * FROM icecream";
		
		try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql2);
				) {
			
			try (
				ResultSet rs = pstmt.executeQuery();
					) {
				System.out.println("ice_id / colour / taste / price");
				while (rs.next()) {
					System.out.printf("%d\t%s\t%s\t%d\n",
							rs.getInt("ice_id"),
							rs.getString("colour"),
							rs.getString("taste"),
							rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
