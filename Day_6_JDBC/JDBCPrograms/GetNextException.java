package com.wiley.sql;

import java.sql.*;


class GetNextException{  
	 public static void main(String[] args) {
		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");  
		    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?characterEncoding=utf8","root","admin");
		        stmt = conn.createStatement();
		      try {
		      rs = stmt.executeQuery("Select * from no_table_exisits");
		    
		      } catch (SQLException seRs) {
		        String exMsg = "Message from MySQL Database";
		        String exSqlState = "Exception";
		        SQLException mySqlEx = new SQLException(exMsg, exSqlState);
		        seRs.setNextException(mySqlEx);
		        throw seRs;
		      }
		    } catch (SQLException se) {
		      int count = 1;
		      while (se != null) {
		        System.out.println("SQLException " + count);
		        System.out.println("Code: " + se.getErrorCode());
		        System.out.println("SqlState: " + se.getSQLState());
		        System.out.println("Error Message: " + se.getMessage());
		        se = se.getNextException();
		        count++;
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		}

