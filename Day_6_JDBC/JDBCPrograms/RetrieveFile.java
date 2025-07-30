package com.wiley.sql;

import java.io.*;  
import java.sql.*;  
  
public class RetrieveFile {  
public static void main(String[] args) {  

try{  
	  final String DB_URL = "jdbc:mysql://localhost/employeedb2?characterEncoding=utf8";
	    final String USER = "root";
	    final String PASS = "admin";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);  
              
PreparedStatement ps=conn.prepareStatement("select * from filetable");  
ResultSet rs=ps.executeQuery();  
rs.next();//now on 1st row  
              
Clob c=rs.getClob(2);  
Reader r=c.getCharacterStream();              
              
FileWriter fw=new FileWriter("d:\\retrivefile.txt");  
              
int i;  
while((i=r.read())!=-1)  
fw.write((char)i);  
              
fw.close();  
conn.close();  
              
System.out.println("success");  
}catch (Exception e) {e.printStackTrace();  }  
}  
}  