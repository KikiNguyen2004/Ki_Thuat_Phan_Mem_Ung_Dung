package husc.edu.vn.model;

import java.sql.SQLException;

public class Database {
    private static final String DB_ServerName = "DESKTOP-S85B3SC";
    private static final String DB_login = "sa";
    private static final String DB_password = "Phucthan@2004";
    private static final String DB_databaseName = "QuanLyPhongKham";
    
    public static Connection getConnection() {
    try {
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	String DB_URL = "jdbc:sqlserver://" + DB_ServerName + ":1433" + ";databaseName=" + DB_databaseName + "; encrypt = true;trustServerCertificate = true";
        
    	return DriverManager.getConnection(DB_URL, DB_login, DB_password);
    }
    catch (ClassNotFoundException e) {
    	e.printStackTrace();
    }
    catch (SQLException e) {
    	e.printStackTrace();
    }
    
    	return null;
    }
    
    
}
