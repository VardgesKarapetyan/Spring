package am.basic.web.util;

import javax.persistence.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static Connection connection;
    public static final String host = "jdbc:mysql://localhost:3306/g?serverTimezone=UTC";
    public static final String username = "root";
    public static final String password = "";

    public static Connection getConnection() {

        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(host, username, password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
