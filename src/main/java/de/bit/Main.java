package de.bit;

public class Main {
    public static void main(String[] args){

        Server server = new Server(8080, 0);
        server.createContext("/App", new HomeRequestHandler());
        server.createContext("/App/Calculate", new CalculateHandler());
        server.setExecutor(null);
        server.start();


    }
}