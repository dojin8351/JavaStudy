package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnector;

public class J05_CRUD {
	
	/*
	 
	 	(1) 모든 커피 목록을 리스트 형태로 반환하는 메서드
	 	
	 	(2) 커피 이름으로 검색한 결과를 리스트 형태로 반환하는 메서드 (LIKE)
	 	
	 	(3) 새로운 커피를 추가하는 메서드 (추가할 때는 시퀀스 사용)
	 	
	 	(4) 이미 존재하는 커피의 정보를 수정할 수 있는 메서드 (기본키는 수정 불가능)
	 	
	 	(5) 커피ID를 매개변수로 전달받으면 해당 커피를 삭제할 수 있는 메서드
	 
	 */
	
	private static DBConnector connector = new DBConnector("HR", "1234");
	
	// (1)
	public static List<Coffee> coffeeList() {
		List<Coffee> list = new ArrayList<>();
		
		String sql = "SELECT * FROM coffee";
		
		try (
			Connection conn = connector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				) {
			
			while (rs.next()) {
				Coffee coffee = new Coffee(rs);
				list.add(coffee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// (2)
	public static List<Coffee> searchCoffee (String coffeeName) {
		
		List<Coffee> list = new ArrayList<>();
		
		String sql = "SELECT * FROM coffee WHERE coffee_name LIKE ?";
		
		try (
			Connection conn = connector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, coffeeName);
			
			try (
				ResultSet rs = pstmt.executeQuery();
					) {
				
				while (rs.next()) {
					Coffee coffee = new Coffee(rs);
					list.add(coffee);
					System.out.println(rs.getString("coffee_name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// (3)
	public static void addCoffee (String coffeeName, int coffeePrice) {
		
		
		try (
			Connection conn = connector.getConnection();
				) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO coffee VALUES (coffee_seq.nextval, ?, ?)";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
					
					) {
				pstmt.setString(1, coffeeName);
				pstmt.setInt(2, coffeePrice);
				
				int row = pstmt.executeUpdate();
				System.out.printf("%d행 커피가 추가되었습니다. \n", row);
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
				return;
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// (4)
	public static void modifyCoffee (Coffee newCoffee, String coffeeName) {
		
		
		try (
			Connection conn = connector.getConnection();
				) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE coffee SET coffee_name = ?, coffee_price = ?"
					+ " WHERE coffee_name = ?";
			
			try (
					PreparedStatement pstmt = conn.prepareStatement(sql)
					) {
				pstmt.setString(1, newCoffee.getCoffee_name());
				pstmt.setInt(2, newCoffee.getCoffee_price());
				pstmt.setString(3, coffeeName);
				
				int row = pstmt.executeUpdate();
				System.out.printf("%d 행 커피 정보가 수정되었습니다. \n", row);
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
				return;
			}
			
			conn.commit();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	// (5)
	public static void deleteCoffee(int coffeeId) {
		
		
		try (
			Connection conn = connector.getConnection();
				) {
			
			conn.setAutoCommit(false);
			String sql = "DELETE FROM coffee WHERE coffee_id = ?";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
				pstmt.setInt(1, coffeeId);
				int row = pstmt.executeUpdate();
				System.out.printf("%d 행이 삭제되었습니다. \n", row);
				
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
				return ;
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		// 1.
		for (Coffee c : coffeeList()) {
			System.out.println(c);
		}
		// 2.
		for (Coffee c : searchCoffee("망떼")) {
			System.out.println(c);
		}		
		// 3.
		addCoffee("달팽이라떼", 1800);
		for (Coffee c : coffeeList()) {
			System.out.println(c);
		}
		// 4.
		for (Coffee c : coffeeList()) {
			System.out.println(c);
		}
		// 5.
		deleteCoffee(8);
		for (Coffee c : coffeeList()) {
			System.out.println(c);
		}
	}
}
