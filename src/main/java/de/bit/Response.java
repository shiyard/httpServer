package de.bit;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class Response {
     Logger log = Logger.getLogger(this.getClass().getName());

    public void create(HttpExchange httpExchange, int responseCode, String responseMessage) {
        try {
            httpExchange.sendResponseHeaders(responseCode, responseMessage.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(responseMessage.getBytes());
            outputStream.close();

        } catch (IOException e) {
            log.severe("Error creating Response");
        }
    }

}
