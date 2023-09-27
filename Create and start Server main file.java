import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleJavaAPI {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        // Creating Server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context for the "/student" endpoint
        server.createContext("/getStudent", new StudentGetApi());
        server.createContext("/postStudent", new StudentPostApi());

        // Start the server
        server.start();
        System.out.println("Server is listening on port " + port);
    }

}

