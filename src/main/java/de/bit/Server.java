package de.bit;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class CreateServer {
    private int port;
    private int backlog;
    private HttpServer httpServer;
    private Logger log;
    public CreateServer(int port, int backlog) {
        this.port = port;
        this.backlog = backlog;

    }
    public void create(){
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), backlog);
        } catch (IOException e) {
            //handle exception
        }

    }

    public void createContext(String path, HttpHandler handler) {
        httpServer.createContext(path, handler);
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }
}
