package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnector;

public class J05_CRUD_Answer {
	
	
	static DBConnector connector = new DBConnector("HR", "1234");
	
	// 4.
	public static boolean updateCoffee(Coffee coffee) {
		// 전달받은 coffee의 id값으로 update
		
		String sql = "UPDATE coffee SET coffee_price = ?, coffee_name = ?"
				+ " WHERE coffee_id = ?";
		
		
		// update를 실행했는데 변한 행이 0이라면 수정 실패, 1이면 성공
		try (
				Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);				
				) {
			pstmt.setInt(1,  coffee.getCoffee_price());
			pstmt.setString(2,  coffee.getCoffee_name());
			pstmt.setInt(3, coffee.getCoffee_id());
			
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		boolean result = updateCoffee(new Coffee(1, "Americano", 2200));
		
		System.out.println("수정 성공? " + result);
	}
	
}
