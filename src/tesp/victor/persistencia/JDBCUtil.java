package tesp.victor.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static Connection con;

    public static Connection getConnector() throws Exception {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibh", "unibh", "12345");
        }
        return con;
    }

    public static void closeConnection() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
