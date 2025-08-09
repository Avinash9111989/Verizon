import java.sql.*;
class DeletePrepared{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  

PreparedStatement stmt=con.prepareStatement("delete from emp765 where id=?");
stmt.setInt(1,101);

int i=stmt.executeUpdate();
System.out.println(i+" records deleted");

con.close();

}catch(Exception e){ System.out.println(e);}

}
}