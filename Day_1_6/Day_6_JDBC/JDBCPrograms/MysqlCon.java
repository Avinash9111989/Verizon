import java.sql.*;

class MysqlCon{
public static void main(String args[]){
try{

Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");
Statement stmt = con.createStatement( );
String sql = "select * from emp765 where id=40"; 
ResultSet rs = stmt.executeQuery(sql); 
int id = rs.getInt(1); 
if( rs.wasNull( ) ) { 
System.out.println("Id is null");
}

}catch(Exception e){ System.out.println(e.printStackTrace());}

}
}