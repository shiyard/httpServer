package de.bit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
class RequestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String responseMessage = "Response Message!";
            httpExchange.sendResponseHeaders(200, responseMessage.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(responseMessage.getBytes());
            outputStream.close();
        }
}
