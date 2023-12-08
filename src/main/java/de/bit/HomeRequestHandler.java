package de.bit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

class HomeRequestHandler implements HttpHandler {

    private static final int RESPONSE_CODE = 200;
    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Override
    public void handle(HttpExchange httpExchange) {
        try {
        String responseMessage = "Response Message!";
        httpExchange.sendResponseHeaders(RESPONSE_CODE, responseMessage.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(responseMessage.getBytes());
        outputStream.close();

        }catch (IOException e){
            log.severe("Error handling  GET /Home");
        }
    }
}
