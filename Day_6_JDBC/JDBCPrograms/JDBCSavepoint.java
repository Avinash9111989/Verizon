
package com.wiley.A;

import java.io.*;
import java.sql.*;
  
class JDBCSavepoint {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        final String DB_URL = "jdbc:mysql://localhost/students?characterEncoding=utf8";
 	    final String USER = "root";
 	    final String PASS = "admin";
        // create a connection to db
 	   Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
            DB_URL, USER, PASS);
  
        // construct a query
        Statement stmt = connection.createStatement();
        String deleteQuery
            = "DELETE FROM REGISTRATION WHERE AGE > 29";
  
        // Disable auto commit to connection
        connection.setAutoCommit(false);
  
        System.out.println("Fetching records in ...");
        ResultSet rs = stmt.executeQuery("SELECT id, first, last, age FROM Registration");
        while(rs.next()){
           //Display values
           System.out.print("ID: " + rs.getInt("id"));
           System.out.print(", Age: " + rs.getInt("age"));
           System.out.print(", First: " + rs.getString("first"));
           System.out.println(", Last: " + rs.getString("last"));
        }
  
        // Create a savepoint object before executing the
        // deleteQuery
        Savepoint beforeDeleteSavepoint
            = connection.setSavepoint();
  
        // Executing the deleteQuery
        int res
            = stmt.executeUpdate(deleteQuery);
  
        System.out.println("Fetching records after delete ...");
         rs = stmt.executeQuery("SELECT id, first, last, age FROM Registration");
        while(rs.next()){
           //Display values
           System.out.print("ID: " + rs.getInt("id"));
           System.out.print(", Age: " + rs.getInt("age"));
           System.out.print(", First: " + rs.getString("first"));
           System.out.println(", Last: " + rs.getString("last"));
        }
        // Rollback to our beforeDeleteSavepoint
        connection.rollback(beforeDeleteSavepoint);
        connection.commit();
        System.out.println("Fetching records in ...");
         rs = stmt.executeQuery("SELECT id, first, last, age FROM Registration");
        while(rs.next()){
           //Display values
           System.out.print("ID: " + rs.getInt("id"));
           System.out.print(", Age: " + rs.getInt("age"));
           System.out.print(", First: " + rs.getString("first"));
           System.out.println(", Last: " + rs.getString("last"));
        }
 
    }
}
