package de.bit.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.bit.service.HomePresenter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class HomeRequestHandler implements Controller {
    private static final String URL = "/Home";
    private static final int RESPONSE_CODE = 200;
    private final Logger log = Logger.getLogger(this.getClass().getName());

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
            try {
                String responseMessage = homePresenter.format();
                httpExchange.sendResponseHeaders(RESPONSE_CODE, responseMessage.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(responseMessage.getBytes());
                outputStream.close();

            } catch (IOException e) {
                log.severe("Error handling  GET /App");
            }
        }
    }
}
