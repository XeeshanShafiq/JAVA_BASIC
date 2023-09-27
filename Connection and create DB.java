import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.*;
//import org.apache.log4j.Logger;
public class ConnectionDB {
//    private static final Logger logger = Logger.getLogger(ConnectionDB.class.getName());
//    logger.info("This is an INFO message.");
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "root";

    public void Connection() {
        // Open a connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "CREATE DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database \"Students\" created successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}