/*
delimiter //
create procedure INSERTR(IN id int,IN name varchar(30)) 
begin  
insert into emp765(id,name) values(id,name);  
end //  
delimiter ;
*/

import java.sql.*;  
public class CallStoredProc {  
public static void main(String[] args) throws Exception{  
  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
 
  
CallableStatement stmt=con.prepareCall("{call insertR(?,?)}");  
stmt.setInt(1,1011);  
stmt.setString(2,"Amit");  
stmt.execute();  
  
System.out.println("success");  
}  
}   