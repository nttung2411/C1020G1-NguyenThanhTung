package Model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "895672";

    public BaseRepo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
