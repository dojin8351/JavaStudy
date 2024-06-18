package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DBConnector;

public class J05_Repository {
	
	// (1) 도시 이름을 매개변수로 전달하면 해당 도시에서 근무하는 사원들의
	//	   모든 사원 정보와 부서 정보를 리스트 형태로 반환하는 메서드
	//		(employees와 departments를 JOIN한 모든 정보)
	
	// (2) 부서명을 매개변수로 전달하면 해당 부서의 
	//	   모든 사원 정보와 직책 정보가 조회되는 메서드
	//	   (employees와 jobs를 JOIN한 모든 정보)
	
	
	static DBConnector connector = new DBConnector("HR", "1234");
	
	// 1.
	static List showByLocation (String name) {
		List<String> empList = new ArrayList<>();
		
		try (
				Connection conn = connector.getConnection();
					) {
				
				String sql = "SELECT * FROM employees INNER JOIN departments USING(department_id)"
						+ " INNER JOIN locations USING(location_id) WHERE city = ?";
				
				try (
					PreparedStatement pstmt = conn.prepareStatement(sql);						
					
						) {
					pstmt.setString(1, name);
					
					try (
						ResultSet rs = pstmt.executeQuery();
							) {
						
						while (rs.next()) {
							int location_id = rs.getInt(1);
							int department_id = rs.getInt(2);
							int employee_id = rs.getInt(3);
							String first_name = rs.getString(4);
							String last_name = rs.getString(5);
							String email = rs.getString(6);
							String phone_number = rs.getString(7);
							Date hire_date = rs.getDate(8);
							String job_id = rs.getString(9);
							Double salary = rs.getDouble(10);
							Double commission_pct = rs.getDouble(11);
							Integer manager_id = rs.getInt(12);
							String department_name = rs.getString(13);
							Integer manager_id1 = rs.getInt(14);
							String street_address = rs.getString(15);
							String postal_code = rs.getString(16);
							String city = rs.getString(17);
							String state_province = rs.getString(18);
							String county_id = rs.getString(19);
							
//							System.out.printf("%d/%d/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s \n",
//									department_id, employee_id, first_name, last_name, email,
//									phone_number, hire_date, job_id, salary, commission_pct,
//									manager_id, department_name, manager_id1, location_id);
							
							empList.add(String.format("%d/%d/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s/%s \n",
									department_id, employee_id, first_name, last_name, email,
									phone_number, hire_date, job_id, salary, commission_pct,
									manager_id, department_name, manager_id1, location_id));
						
					}
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return empList;
	}
	
	// 2.
	static List showByDept (String name) {
		List<String> empList = new ArrayList<>();
		
		try (
				Connection conn = connector.getConnection();
					) {
				
				String sql = "SELECT * FROM employees INNER JOIN jobs USING (job_id)"
						+ " INNER JOIN departments USING (department_id) WHERE department_name = ?";
				
				try (
					PreparedStatement pstmt = conn.prepareStatement(sql);						
					
						) {
					pstmt.setString(1, name);
					
					try (
						ResultSet rs = pstmt.executeQuery();
							) {
						
						while (rs.next()) {
							int department_id = rs.getInt(1);
							String job_id = rs.getString(2);
							int employee_id = rs.getInt(3);
							String first_name = rs.getString(4);
							String last_name = rs.getString(5);
							String email = rs.getString(6);
							String phone_number = rs.getString(7);
							Date hire_date = rs.getDate(8);
							Double salary = rs.getDouble(9);
							Double commission_pct = rs.getDouble(10);
							int manager_id = rs.getInt(11);
							String job_title = rs.getString(12);
							int min_salary = rs.getInt(13);
							int max_salary = rs.getInt(14);
							String department_name = rs.getString(15);
							int manager_id_1 = rs.getInt(16);
							int location_id = rs.getInt(17);

							
							empList.add(String.format("%s / %s / %s / %s / %s / %s / %s / %s / %s / %s"
									+ " / %s / %s / %s / %s \n",
									job_id, employee_id, first_name, last_name, email, phone_number,
									hire_date, salary, commission_pct, manager_id, department_id,
									job_title, min_salary, max_salary));
						
					}
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return empList;
	}
	
	public static void main(String[] args) {
		
		System.out.println(showByLocation("Toronto"));
		System.out.println();
		System.out.println(showByLocation("Seattle"));
		System.out.println();
		System.out.println(showByDept("Marketing"));
		System.out.println();
		System.out.println(showByDept("IT"));
	}
}
