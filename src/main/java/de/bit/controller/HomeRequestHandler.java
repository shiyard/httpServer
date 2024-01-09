package de.bit.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.bit.Response;

import java.util.concurrent.Executor;

public class HomeRequestHandler implements Controller {
    private static final String URL = "/Home";
    private static final int RESPONSE_CODE = 200;
    private final HomePresenter homePresenter;

    public HomeRequestHandler(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
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
            String responseMessage = homePresenter.format();
            Response response = new Response();
            response.create(httpExchange, RESPONSE_CODE, responseMessage);

        }
    }
}
