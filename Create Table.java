import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    static final String DB_URL = "jdbc:mysql://localhost/students";
    static final String USER = "root";
    static final String PASS = "root";

    public void CreateTable() {
        System.out.println("Entered string");
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            System.out.println("Entered String sql");
            String sql = "CREATE TABLE StudentData (\n" +
                    "    id INTEGER NOT NULL,\n" +
                    "    SName VARCHAR(255),\n" +
                    "    PRIMARY KEY (id)\n" +
                    ");";

            stmt.executeUpdate(sql);
            System.out.println("Created table \"StudentData\" in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
