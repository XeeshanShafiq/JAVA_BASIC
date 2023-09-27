import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Dblist {
    public static void main(String args[]) throws Exception {
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
        System.out.println("Connection established......");
        //Creating a Statement object
        Statement stmt = con.createStatement();
        ResultSet resultSet = con.getMetaData().getCatalogs();

        while (resultSet.next()) {

            // Get the database name, which is at position 1

            String databaseName = resultSet.getString(1);

            System.out.println(databaseName);
        }
    }
}
