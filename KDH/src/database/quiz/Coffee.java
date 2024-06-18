package database.quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coffee {
	int coffee_id;
	String coffee_name;
	int coffee_price;
	
	public Coffee(ResultSet rs) throws SQLException {
		coffee_id = rs.getInt("coffee_id");
		coffee_name = rs.getString("coffee_name");
		coffee_price = rs.getInt("coffee_price");
		
	}
	
	public Coffee(Integer coffee_id, String coffee_name, Integer coffee_price) {
		this.coffee_id = coffee_id;
		this.coffee_name = coffee_name;
		this.coffee_price = coffee_price;
		
	}

	public int getCoffee_id() {
		return coffee_id;
	}
	public void setCoffee_id(int coffee_id) {
		this.coffee_id = coffee_id;
	}
	public String getCoffee_name() {
		return coffee_name;
	}
	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}
	public int getCoffee_price() {
		return coffee_price;
	}
	public void setCoffee_price(int coffee_price) {
		this.coffee_price = coffee_price;
	}
	
	
	@Override
	public String toString() {
		return "Coffee [coffee_id=" + coffee_id + ", coffee_name=" + coffee_name + ", coffee_price=" + coffee_price
				+ "]";
	}
}
