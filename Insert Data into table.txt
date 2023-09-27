import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    static final String DB_URL = "jdbc:mysql://localhost/students";
    static final String USER = "root";
    static final String PASS = "root";

    public void Insert() {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO StudentData VALUES (10, 'Zara')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO StudentData VALUES (11, 'Mahnaz')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO StudentData VALUES (12, 'Zaid')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO StudentData VALUES(13, 'Sumit')";
            stmt.executeUpdate(sql);
            System.out.println("Records inserted into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
