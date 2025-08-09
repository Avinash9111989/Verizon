package com.wiley.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB{
   static final String DB_URL = "jdbc:mysql://localhost/?characterEncoding=utf8";
   static final String USER = "root";
   static final String PASS = "admin";

   public static void main(String[] args) throws ClassNotFoundException {
      Class.forName("com.mysql.jdbc.Driver");  
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE DATABASE STUDENTS";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}