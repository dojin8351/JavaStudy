package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class J03_DBPractice_Answer {
	
	private static DBConnector connector = new DBConnector("petshop", "1234");
	
	public static void insertAnimalKind(String kor, String eng) {
		String sql = "INSERT INTO animal_kind(kind_id, kor_name, eng_name)"
				+ " VALUES(animal_kind_seq.nextval, ?, ?)";
		try (
			Connection conn = connector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, kor);
			pstmt.setString(2, eng);
			
			int row = pstmt.executeUpdate();
			System.out.printf("%d행 업데이트 되었습니다.\n", row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. 동물 종류 추가하기");
			System.out.println("2. 동물 맡기기");
			System.out.println("3. 동물 다시 데려가기");
			
			System.out.println("> ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
			case 1: 
				System.out.println("동물의 한글 이름은? ");
				String korName = sc.nextLine();
				System.out.println("동물의 영어 이름은? ");
				String engName = sc.nextLine();
				
				insertAnimalKind(korName, engName);
				break;
			case 2: break;
			case 3: break;	
			default: break;
			}
		}
		
//		insertAnimalKind("골든 리트리버", "Goden Ritriever");
	}

}
