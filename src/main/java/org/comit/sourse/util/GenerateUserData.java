package org.comit.sourse.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

public class GenerateUserData {
	
	static String genString() {
		Random r = new Random();
		int len = 3 + r.nextInt(4);
		StringBuilder sb = new StringBuilder(len);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int i = 0;
		while (i < len) {
			int index = (int) (alphabet.length() * Math.random());
			sb.append(alphabet.charAt(index));
			i++;
		}
		return sb.toString();
	}
	
	static String genPass() {
		Random r = new Random();
		int len = 5 + r.nextInt(7);
		StringBuilder sb = new StringBuilder(len);
		String digitLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i = 0;
		while (i < len) {
			int index = (int) (digitLetters.length() * Math.random());
			sb.append(digitLetters.charAt(index));
			i++;
		}
		return sb.toString();
	}
	
/*
	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/pobox";
		String dbUsername = "root";
		String dbPassword = "root";

		String sql = "INSERT INTO user(firstname,lastname,username,password,email)"
				+ " VALUES  (?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				PreparedStatement st = con.prepareStatement(sql);) {
			System.out.println("Connection was successful!");
			int i = 0;
			while (i < 100) {
				st.setString(1, genString()); 
				st.setString(2, genString());
				st.setString(3, genString());
				st.setString(4, genPass());
				st.setString(5, genString()+"@gmail.com");
				
				System.out.println(st);
				i++;
			}
			System.out.println("Rows Affected: " + (i - 1));

		} catch (SQLException e) {
			System.out.println("Some error happened.");
			e.printStackTrace();
		}

	}
	*/
}
