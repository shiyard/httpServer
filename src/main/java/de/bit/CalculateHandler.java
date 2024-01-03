package de.bit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class CalculateHandler implements Controller {
    private static final String URL = "/Home/Calculate";
    private static final int RESPONSE_CODE = 200;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    private final CalculateService calculateService;
    private final CalculatePresenter calculatePresenter;

    public CalculateHandler(CalculateService calculateService, CalculatePresenter calculatePresenter) {
        this.calculateService = calculateService;
        this.calculatePresenter = calculatePresenter;
    }


    @Override
    public HttpHandler getHandler() {
        return new Handler();
    }

    @Override
    public String getUlr() {
        return URL;
    }

    @Override
    public Executor getExecution() {
        return null;
    }


    class Handler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange){
            try {
                String query = httpExchange.getRequestURI().getQuery();
                Map<String, String> params = queryToMap(query);
                int sum = calculateService.calculate(Integer.parseInt(params.get("a")), Integer.parseInt(params.get("b")));
                String responseMessage = calculatePresenter.format(sum);
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

            Map<String, String> entries = new HashMap<>();
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                entries.put(entry[0], entry[1]);
            }
            return entries;
        }
    }
}
