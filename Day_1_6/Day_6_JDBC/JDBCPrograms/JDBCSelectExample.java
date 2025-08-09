import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/employeedb2";
   static final String USER = "root";
   static final String PASS = "admin";
   static final String QUERY = "SELECT id, first, last, age FROM Registration";

   public static void main(String[] args) {
  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2?characterEncoding=utf8","root","admin");  
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);		      
         while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } 
   }
