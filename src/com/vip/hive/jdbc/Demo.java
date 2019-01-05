package com.vip.hive.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {
	public static void main(String[] args) throws Exception {
		
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection connection = DriverManager.getConnection("jdbc:hive2://192.168.154.129:10000/park", "root", "123456");
		PreparedStatement pStatement = connection.prepareStatement("select * from tab1");
		ResultSet rSet = pStatement.executeQuery();
		while(rSet.next()) {
			System.out.println(rSet.getString("name"));
		}
		rSet.close();
		pStatement.close();
		connection.close();
	}
}
