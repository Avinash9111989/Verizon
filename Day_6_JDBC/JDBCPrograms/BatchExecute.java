import java.sql.*;  
class BatchExecute{  
public static void main(String args[])throws Exception{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
con.setAutoCommit(false);  
  
Statement stmt=con.createStatement();  
stmt.addBatch("insert into emp765 values(190,'abhi',40000)");  
stmt.addBatch("insert into emp765 values(191,'umesh',50000)");  
  
stmt.executeBatch();//executing the batch  
  
con.commit();  
con.close();  
}}