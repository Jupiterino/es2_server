package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Server in avvio!");

            ServerSocket server = new ServerSocket(3000);

            do {
                Socket s = server.accept();
                MioThread m = new MioThread(s);
                m.start();
            } while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
