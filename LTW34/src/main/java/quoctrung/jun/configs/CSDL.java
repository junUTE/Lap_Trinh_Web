package quoctrung.jun.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import quoctrung.DBMS;

public class CSDL {
	private final String serverName = "localhost"; // hoặc IP
    private final String dbName = "LTWBuoi4";
    private final String portNumber = "1433";
    private final String instance = ""; // nếu có instance: "SQLEXPRESS"
    private final String userID = "sa";
    private final String password = "1";

    public Connection getConnection() throws Exception {
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
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
            String sqlInsert = "INSERT INTO Users VALUES(?, ?, ?)";
            String selectAll = "SELECT * FROM Users";

            try {
                // connect to database
                Connection conn = new DBMS().getConnection();

                // create statement to insert
                PreparedStatement stmt = conn.prepareStatement(sqlInsert);
                stmt.setInt(1, 1);
                stmt.setString(2, "Trungh");
                stmt.setString(3, "HCM");
                stmt.execute();

                // select all
                stmt = conn.prepareStatement(selectAll);

                // get data from table
                ResultSet rs = stmt.executeQuery();

                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }

                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
