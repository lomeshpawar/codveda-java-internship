import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = System.getenv().getOrDefault(
            "LIBRARY_DB_URL", "jdbc:mysql://localhost:3306/library_db");
    private static final String USER = System.getenv().getOrDefault("LIBRARY_DB_USER", "root");
    private static final String PASSWORD = System.getenv("LIBRARY_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new SQLException("LIBRARY_DB_PASSWORD environment variable is not set.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
