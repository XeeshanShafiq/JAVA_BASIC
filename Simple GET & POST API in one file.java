import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

class StudentAPI implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Handle incoming HTTP GET requests to "/getStudent"
        if ("GET".equals(exchange.getRequestMethod())) {

          //  Add string below to show response
            String response = "GET API IS WORKING!!!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


        } else if ("POST".equals(exchange.getRequestMethod())) {
            try {
                // Read the JSON data from the request body
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                StringBuilder requestBody = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    requestBody.append(line);
                }
                reader.close();
                // Echo the JSON data in the response
                String responseData = "POST API IS WORKING!!!  Data fetched" + requestBody.toString();

                // Set the response headers and body
                exchange.sendResponseHeaders(200, responseData.length());
                OutputStream os = exchange.getResponseBody();
                os.write(responseData.getBytes());
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
                sendErrorResponse(exchange, "Error: " + e.getMessage());
            }
        } else {
            // Respond with a 405 Method Not Allowed for other HTTP methods
            exchange.sendResponseHeaders(405, -1);
        }
    }

    private void sendErrorResponse(HttpExchange exchange, String errorMessage) throws IOException {
        exchange.sendResponseHeaders(400, errorMessage.length());
        OutputStream os = exchange.getResponseBody();
        os.write(errorMessage.getBytes());
        os.close();
    }
}

