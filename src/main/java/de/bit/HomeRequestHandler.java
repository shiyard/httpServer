package de.bit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class HomeRequestHandler implements HttpHandler {

    private static final int RESPONSE_CODE = 200;
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String responseMessage = "Response Message!";
        httpExchange.sendResponseHeaders(RESPONSE_CODE, responseMessage.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(responseMessage.getBytes());
        outputStream.close();
    }
}
