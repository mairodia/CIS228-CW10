// File: CustomerInserter.java
// Written by: Jennifer King
// Date: 11/19/2018

import java.util.Scanner;
import java.sql.*;

public class CustomerInserter
{
	public static void main(String[] args)
	{
		String number = "105";
		String name;
		String address;
		String city;
		String state;
		String zip;
		
		final String DB_URL = "jdbc:derby:CoffeeDB";
		Scanner keyboard = new Scanner(System.in);
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.print("Enter your name: ");
			name = keyboard.nextLine();
			System.out.print("Enter your address: ");
			address = keyboard.nextLine();
			System.out.print("Enter your city: ");
			city = keyboard.nextLine();
			System.out.print("Enter your state: ");
			state = keyboard.nextLine();
			System.out.print("Enter your zip: ");
			zip = keyboard.nextLine();
			
			Statement stmt = conn.createStatement();
			String sqlStatement = "INSERT INTO Customer "  
						+ "VALUES ('" + 
						number + "', '" + 
						name + "', '" + 
						address + "', '" + 
						city + "', '" + 
						state + "', '" + 
						zip + "')";
			
			int rows = stmt.executeUpdate(sqlStatement);
			System.out.println(rows + " row(s) added to the table.");
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
		keyboard.close();
	}
}
