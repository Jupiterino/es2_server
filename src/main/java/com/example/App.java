package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {      
            System.out.println("Server in avvio!");

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("Un client si è collegato");

            Random random = new Random();
            int numero = random.nextInt(100)+1;

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            

            int risposta = 0;
            int i = 0;
            do {
               
                String stringaRicevuta = in.readLine();
                int numeroRicevuto = Integer.parseInt(stringaRicevuta);

                System.out.println("Numero ricevuto: " + numeroRicevuto);
                i++;

                if(numeroRicevuto>numero){
                    out.writeBytes("2\n");
                    risposta = 2;
                }
                if(numeroRicevuto<numero){
                    out.writeBytes("1\n");
                    risposta = 1;
                }    
                if(numeroRicevuto==numero){
                    out.writeBytes("3\n");
                    risposta = 3;
                    out.writeBytes(Integer.toString(i)+"\n");
                }

                

            } while (risposta != 3);

            s.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
