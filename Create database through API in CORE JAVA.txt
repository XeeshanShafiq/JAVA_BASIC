import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreationAPI {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context for the "/createDatabase" endpoint
        server.createContext("/createDatabase", new CreateDatabaseHandler());

        // Start the server
        server.start();
        System.out.println("Server is listening on port " + port);
    }

    static class CreateDatabaseHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                try {
                    // Connect to MySQL
                    String url = "jdbc:mysql://localhost:8080/";
                    String username = "root";
                    String password = "root";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);

                    // Create a new database
                    String databaseName = "Employee";
                    Statement statement = connection.createStatement();
                    String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + databaseName;
                    statement.executeUpdate(createDatabaseSQL);

                    String response = "Database created or already exists.";
                    sendResponse(exchange, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                    sendResponse(exchange, "Error: " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                sendResponse(exchange, "Method not allowed.");
            }
        }
    }

    static void sendResponse(HttpExchange exchange, String responseText) throws IOException {
        exchange.sendResponseHeaders(200, responseText.length());
        OutputStream os = exchange.getResponseBody();
        os.write(responseText.getBytes());
        os.close();
    }
}
