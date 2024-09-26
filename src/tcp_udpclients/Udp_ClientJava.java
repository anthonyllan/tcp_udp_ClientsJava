/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_udpclients;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class Udp_ClientJava {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Dirección IP del servidor
        int port = 9999; // Puerto del servidor

        try {
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                
                // Enviar mensaje al servidor
                String mensaje;
                mensaje = JOptionPane.showInputDialog(null, "Ingrese un mensaje");
                mensaje += " [Cliente 6]";
                byte[] buffer = mensaje.getBytes();
                InetAddress address = InetAddress.getByName(serverAddress);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);

                // Recibir respuesta del servidor
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Servidor: " + response);

                socket.close();
            }
        } catch (HeadlessException | IOException e) {
        }
    }
}
