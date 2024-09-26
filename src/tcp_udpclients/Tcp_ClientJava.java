package tcp_udpclients;

import java.io.*;
import java.net.*;

public class Tcp_ClientJava {

    public static void main(String[] args) {
        String serverAddress = "192.168.234.88"; // Dirección IP del servidor
        int port = 9999; // Puerto del servidor

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Enviar primer mensaje al servidor
            out.println("Hola servidor!");
            out.flush(); // Forzar vaciado del buffer
            System.out.println("Servidor: " + in.readLine());

            // Enviar segundo mensaje al servidor
            out.println("Adios!");
            out.flush(); // Forzar vaciado del buffer
            System.out.println("Servidor: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

