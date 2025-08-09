import java.sql.*;  
class ScrollableRS{  
public static void main(String args[])throws Exception{  
  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from emp765");  
  
//getting the record of 3rd row  
while(rs.next())
System.out.println(rs.getString("id"));
con.close();  
}}


//insert into emp765 values(1,"Ajay",40000),(2,"Avinash",100000),(3,"Ramesh",30000
