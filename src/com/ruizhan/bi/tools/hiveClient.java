package com.ruizhan.bi.tools;

import java.sql.*;

public class hiveClient {
	private static final String URLHIVE = "jdbc:hive://10.6.252.77:50000/default";  
    private static Connection connection = null; 

    public static Connection getHiveConnection() {  
        if (null == connection) {  
            synchronized (hiveClient.class) {  
                if (null == connection) {  
                    try {  
                        Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");  
                        connection = DriverManager.getConnection(URLHIVE, "", "");  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    } catch (ClassNotFoundException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
        return connection;  
    }  
    
    
	public static void main(String[] args) throws Exception {
		hiveClient client = new hiveClient();
		Statement stmt = client.getHiveConnection().createStatement(); 
		stmt.executeQuery("show tables;");

	}

}
