import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleJavaAPI {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        // Creating Server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context for the "/hello" endpoint
        server.createContext("/hello", new HelloHandler());

        // Start the server
        server.start();
        System.out.println("Server is listening on port " + port);


    }
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Handle incoming HTTP GET requests to "/hello"
            if ("GET".equals(exchange.getRequestMethod())) {
                int valueToSend = 50;
                String response = Integer.toString(valueToSend);
                exchange.sendResponseHeaders(200,response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                // Respond with a 405 Method Not Allowed for other HTTP methods
                exchange.sendResponseHeaders(405, -1);
            }
        }


    }
}

