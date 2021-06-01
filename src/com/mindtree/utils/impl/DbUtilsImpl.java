package com.mindtree.utils.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mindtree.utils.DbUtils;

public class DbUtilsImpl implements DbUtils {

	@Override
	public Connection makeConnection(Connection con) {
		final String USERNAME = "root";
		final String PASSWORD = "087722";
		final String URL = "jdbc:mysql://localhost:3306/practicedb";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Database connection is failed");
		}
		return con;
	}

}
