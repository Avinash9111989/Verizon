
import java.sql.*;  
import java.io.*;  
class InsertPreparedN{  
public static void main(String args[])throws Exception{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  

PreparedStatement ps=con.prepareStatement("insert into emp765 values(?,?,?)");  
  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
do{  
System.out.println("enter id:");  
int id=Integer.parseInt(br.readLine());  
System.out.println("enter name:");  
String name=br.readLine();  
System.out.println("enter salary:");  
int salary=Integer.parseInt(br.readLine());  
  
ps.setInt(1,id);  
ps.setString(2,name);  
ps.setInt(3,salary);  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
  
System.out.println("Do you want to continue: y/n");  
String s=br.readLine();  
if(s.startsWith("n")){  
break;  
}  
}while(true);  
  
con.close();  
}}