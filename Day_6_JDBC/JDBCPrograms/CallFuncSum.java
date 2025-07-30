/*
delimiter //
create function sum4(n1 int,n2 int)
returns INT  
DETERMINISTIC  
begin
return (n1+n2);  
end //  
delimiter ; 
*/


import java.sql.*;  
  
public class CallFuncSum {  
public static void main(String[] args) throws Exception{  
  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
 
CallableStatement stmt=con.prepareCall("{?= call sum4(?,?)}");  
stmt.setInt(2,10);  
stmt.setInt(3,43);  
stmt.registerOutParameter(1,Types.INTEGER);  
stmt.execute();  
  
System.out.println(stmt.getInt(1));  
          
}  
}  