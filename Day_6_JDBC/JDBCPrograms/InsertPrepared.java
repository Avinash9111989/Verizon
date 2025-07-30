import java.sql.*;
class InsertPrepared{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  


PreparedStatement stmt=con.prepareStatement("insert into emp765(id,name) values(?,?)");
stmt.setInt(1,101);//1 specifies the first parameter in the query
stmt.setString(2,"Ratan");
stmt.setInt(3,50000);

int i=stmt.executeUpdate();
System.out.println(i+" records inserted");

con.close();

}

catch(SQLException e){ 
System.out.println(e.getMessage());

}

}

}
