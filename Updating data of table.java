import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    static final String DB_URL = "jdbc:mysql://localhost/students";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT id, SName FROM StudentData";
    public void Update() {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE StudentData " +
                    "SET id = 50 WHERE id in (10)";
            System.out.println("Updating record id 50 where id now is 10");
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("SName: " + rs.getString("SName"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
