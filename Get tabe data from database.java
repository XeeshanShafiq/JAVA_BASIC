import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveDataFromDB {
    // Database connection parameters
    String jdbcUrl = "jdbc:mysql://localhost/";
    String username = "root";
    String password = "root";

    public StudentModel showTableData() {

        StudentModel std = new StudentModel();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a SQL statement
            Statement statement = connection.createStatement();

            // SQL query to retrieve data from a table
            String query = "SELECT * FROM students.studentdata";

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {

                // Retrieve data from each row
                std.setId(resultSet.getInt("id"));
                std.setSName(resultSet.getString("SName"));

                // Process the retrieved data
//                    System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return std;
    }

}