package com.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";
    private static final String USER = "root";
    private static final String PASS = "kmch1125";
    
    public static Connection getConnection() {
    	Connection conn = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(URL, USER, PASS);
     	} catch (Exception e) {
     		e.printStackTrace();
     	}
    	
    	return conn;
    }
    
    public static void close(AutoCloseable... acs) {
    	for (AutoCloseable ac : acs) {
    		try {
    			if (ac != null) ac.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
}
