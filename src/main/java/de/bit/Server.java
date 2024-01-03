package de.bit;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private HttpServer httpServer;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    public Server(int port, int backlog, List<Controller> controllerList) {

        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), backlog);
            for (Controller controller : controllerList) {
                createContext(controller.getUlr(), controller.getHandler());
            }
            log.log(Level.INFO, "Server started on port {0}", String.valueOf(port));
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public void createContext(String path, HttpHandler handler) {
        httpServer.createContext(path, handler);
        log.log(Level.INFO, "Context created with the {0} ", path);
    }

    public void setExecutor(Executor executor) {
        httpServer.setExecutor(executor);
    }

    public void start (){
        httpServer.start();
        log.log(Level.INFO, "Server started!");
    }

    public void stop(int delay) {
        httpServer.stop(delay);
        log.log(Level.INFO, "Server stopped!");
    }


}
