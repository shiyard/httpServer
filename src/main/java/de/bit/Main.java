package de.bit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Controller> controllerList = new ArrayList<>();
        controllerList.add(new HomeRequestHandler());
        controllerList.add(new CalculateHandler());
        Server server = new Server(8080, 0, controllerList);

        server.setExecutor(null);
        server.start();
    }
}