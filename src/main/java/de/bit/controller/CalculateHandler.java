package de.bit.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.bit.Response;
import de.bit.service.CalculatePresenter;
import de.bit.service.CalculateService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class CalculateHandler implements Controller {
    private static final String URL = "/Home/Calculate";
    private static final int RESPONSE_CODE = 200;
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
        public void handle(HttpExchange httpExchange) {

            String query = httpExchange.getRequestURI().getQuery();
            Map<String, String> params = queryToMap(query);
            int sum = calculateService.calculate(Integer.parseInt(params.get("a")), Integer.parseInt(params.get("b")));
            String responseMessage = calculatePresenter.format(sum);
            Response response = new Response();
            response.create(httpExchange, RESPONSE_CODE, responseMessage);
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
