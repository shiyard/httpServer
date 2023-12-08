package de.bit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CalculateHandler implements HttpHandler {
    private static final int RESPONSE_CODE = 200;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void handle(HttpExchange httpExchange) {

        try {
            String query = httpExchange.getRequestURI().getQuery();
            Map<String, String> params = queryToMap(query);
            int sum = Integer.sum(Integer.parseInt(params.get("a")), Integer.parseInt(params.get("b")));
            String responseMessage = "sum = " + sum;
            httpExchange.sendResponseHeaders(RESPONSE_CODE, responseMessage.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(responseMessage.getBytes());
            outputStream.close();
        } catch (IOException e) {
            log.severe("Error handling  GET /Calculate");
        }
    }


    private Map<String, String> queryToMap(String query) {
        if (query == null) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            result.put(entry[0], entry[1]);
        }
        return result;
    }
}
