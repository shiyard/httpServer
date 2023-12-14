package de.bit;

import com.sun.net.httpserver.HttpHandler;

import java.util.concurrent.Executor;

public interface Controller {

    HttpHandler getHandler();
    String getUlr();
    Executor getExecution();
}
