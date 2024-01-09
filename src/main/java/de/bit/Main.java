package de.bit;

import de.bit.controller.CalculateHandler;
import de.bit.controller.Controller;
import de.bit.controller.HomeRequestHandler;
import de.bit.controller.CalculatePresenterImpl;
import de.bit.controller.HomePresenterImpl;
import de.bit.service.VectorCalculateService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Controller> controllerList = new ArrayList<>();
        controllerList.add(new HomeRequestHandler(new HomePresenterImpl()));
//        controllerList.add(new CalculateHandler(new LinearCalculateService(), new CalculatePresenterImpl()));
        controllerList.add(new CalculateHandler(new VectorCalculateService(), new CalculatePresenterImpl()));


        Server server = new Server(8080, 0, controllerList);

        server.setExecutor(null);
        server.start();
    }
}
