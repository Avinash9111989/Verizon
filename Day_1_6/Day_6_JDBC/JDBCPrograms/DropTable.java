package com.wiley.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
   static final String DB_URL = "jdbc:mysql://localhost/students?characterEncoding=utf8";
   static final String USER = "root";
   static final String PASS = "admin";

   public static void main(String[] args) throws ClassNotFoundException {
      // Open a connection
	   Class.forName("com.mysql.jdbc.Driver");  
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "DROP TABLE REGISTRATION";
         stmt.executeUpdate(sql);
         System.out.println("Table deleted in given database...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}