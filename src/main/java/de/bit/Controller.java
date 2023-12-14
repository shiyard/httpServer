package de.bit;

import com.sun.net.httpserver.HttpExchange;

import java.util.concurrent.Executor;

public interface Controller {

    HttpExchange getHandler();
    String getUlr();
    Executor getExecution();
}
