
import java.sql.*;
class RetrievePrepared{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  


PreparedStatement stmt=con.prepareStatement("select * from emp765");
ResultSet rs=stmt.executeQuery();
while(rs.next()){
System.out.println(rs.getInt(1)+" "+rs.getString(2));
}

con.close();

}catch(Exception e){ System.out.println(e);}

}
}