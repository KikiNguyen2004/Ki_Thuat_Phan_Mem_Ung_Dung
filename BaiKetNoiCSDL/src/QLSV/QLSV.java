package QLSV;
import java.sql.*;

public class QLSV {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. Load the JDBC driver
  		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  		    System.out.println("Driver loaded");
  		
  	    // 2. Connect to a database
  			String url= "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=false";
  			String username ="sa";
  			String password ="Phucthan@2004";
  		    Connection connection = DriverManager.getConnection(url, username, password);
  			System.out.println("Database connected");
  			
  		// 3. Create a statement
  			Statement statement = connection.createStatement();
  			
  		//lay ra danh sach sinh vien
  			// 4. Execute a statement
  			/*ResultSet resultSet1 = statement.executeQuery ("select * from Student");
  			
  		    // 5. Process resultSet
  			while (resultSet1.next())
  			 	System.out.println(resultSet1.getInt(1) + "\t" +
  			 			resultSet1.getString(2) + "\t" + resultSet1.getDate(3) +
  			 			"\t" + resultSet1.getString(4) + "\t" + resultSet1.getString(5));
  			
  		//lay ra danh sach cac mon
  			// 4. Execute a statement
  			ResultSet resultSet2 = statement.executeQuery ("select * from Subject");
  			
  		    // 5. Process resultSet
  			while (resultSet2.next())
  			 	System.out.println(resultSet2.getString(1) + "\t" +
  			 			resultSet2.getString(2) + "\t" + resultSet2.getInt(3) +
  			 			"\t" + resultSet2.getFloat(4) + "\t" + resultSet2.getFloat(5));*/
  		//cap nhat thong tin sinh vien
  			// 4. Execute a statement
  			statement.executeUpdate ("update Student set studentName = 'Vase Cong' where studentID = '20224018' ");
  			statement.executeUpdate ("update Student set studentID = '20223684' where studentID = '20224018'");
  			
  	

     }
}

