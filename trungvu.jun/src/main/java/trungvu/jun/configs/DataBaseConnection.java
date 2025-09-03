package trungvu.jun.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	private final String serverName = "localhost";
	private final String dbName = "LapTrinhWebBaiTap03";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "as";
	private final String passWord = "1";
	
	public Connection getConnection() throws Exception{
		String url;
		if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        }

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, passWord);
	}
}
