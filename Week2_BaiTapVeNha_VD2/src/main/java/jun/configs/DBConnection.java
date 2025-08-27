package jun.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final String serverName = "localhost"; // hoặc IP
	private final String dbName = "LTWBuoi4";
	private final String portNumber = "1433";
	private final String instance = ""; // nếu có instance: "SQLEXPRESS"
	private final String userID = "sa";
	private final String password = "1";

	public Connection getConnection() throws Exception {
		String url;
		if (instance == null || instance.trim().isEmpty()) {
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=false;trustServerCertificate=true";
		} else {
			url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=false;trustServerCertificate=true";
		}

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
}
