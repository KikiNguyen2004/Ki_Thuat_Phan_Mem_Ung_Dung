package QuanLyPhongKham;
import java.sql.*;

public class QuanLyPhongKham {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. Load the JDBC driver
  		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  		    System.out.println("Driver loaded");
  		
  	    // 2. Connect to a database
  			String url= "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=false";
  			String username ="sa";
  			String password ="Phucthan@2004";
  		    Connection connection = DriverManager.getConnection(url, username, password);
  			System.out.println("Database connected");
  			
  		// 3. Create a statement
  			Statement statement = connection.createStatement();
  			
  		// 4. Execute a statement
  			ResultSet resultSet1 = statement.executeQuery ("select * from Patient");
  			
  		    // 5. Process resultSet
  			while (resultSet1.next())
  			 	System.out.println(resultSet1.getString(1) + "\t" +
  			 			resultSet1.getString(2) + "\t" + resultSet1.getDate(3) +
  			 			"\t" + resultSet1.getString(4) + "\t" + resultSet1.getString(5) + resultSet1.getString(6) + "\t" + resultSet1.getString(7) + "\t" + resultSet1.getString(8));
}
}
