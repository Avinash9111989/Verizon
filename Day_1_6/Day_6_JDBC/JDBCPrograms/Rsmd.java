import java.sql.*;  
class Rsmd{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  

PreparedStatement ps=con.prepareStatement("select * from emp765");  
ResultSet rs=ps.executeQuery();  
ResultSetMetaData rsmd=rs.getMetaData();  
  
System.out.println("Total columns: "+rsmd.getColumnCount());
int i=1;
while(rsmd.getColumnCount()+1-i!=0){ 
System.out.println("Column Name: "+rsmd.getColumnName(i));  
System.out.println("Column Type : "+rsmd.getColumnTypeName(i));  
i++;
}  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}