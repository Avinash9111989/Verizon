import java.sql.*;  
class Stmt1{  
public static void main(String args[])throws Exception{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
Statement stmt=con.createStatement();
//stmt.executeUpdate("insert into emp765 values(33,'Irfan',50000)");  
//int result=stmt.executeUpdate("update emp765 set name='Vimal',salary=10000 where id=33");  
int result=stmt.executeUpdate("delete from emp765 where id=33");  
System.out.println(result+" records affected");  
con.close();  
}}  


//create table emp765(id int,name varchar(30),salary int);
//insert into emp765 values(33,'Irfan',40000);