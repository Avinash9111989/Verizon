package com.wiley.sql;

import java.io.*;  
import java.sql.*;  
  
public class StoreFile {  
	  static final String DB_URL = "jdbc:mysql://localhost/employeedb2?characterEncoding=utf8";
	   static final String USER = "root";
	   static final String PASS = "admin";
public static void main(String[] args) {  
try{  
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);  
              
PreparedStatement ps=conn.prepareStatement(  
"insert into filetable values(?,?)");  
              
File f=new File("d:\\mytext.txt");  
FileReader fr=new FileReader(f);  
              
ps.setInt(1,101);  
ps.setCharacterStream(2,fr,(int)f.length());  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
              
conn.close();  
              
}catch (Exception e) {e.printStackTrace();}  
}  
}  

/*
CREATE TABLE  "FILETABLE"   
(    "ID" NUMBER,   
 "NAME" CLOB  
)  
*/