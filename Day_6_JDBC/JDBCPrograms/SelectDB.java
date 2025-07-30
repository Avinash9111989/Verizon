package com.wiley.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SelectDB {
   static final String DB_URL = "jdbc:mysql://localhost/students?characterEncoding=utf8";
   static final String USER = "root";
   static final String PASS = "admin";

   public static void main(String[] args) throws ClassNotFoundException {
	  Class.forName("com.mysql.jdbc.Driver"); 
      System.out.println("Connecting to a selected database...");
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {		      
         System.out.println("Connected database successfully...");  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
