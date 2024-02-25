package EX3;

import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        String serverAddress = "";
        Scanner keyb = new Scanner(System.in);        int serverPort = 1250;

        try {
            // on récupère les paramètres
            System.out.println("Adresse du serveur : ");
            serverAddress = keyb.next();

            DatagramSocket socket = new DatagramSocket();

            // Envoyer un datagramme vide au serveur
            byte[] requestData = new byte[0];
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, InetAddress.getByName(serverAddress), serverPort);
            socket.send(requestPacket);

            // Attendre la réponse du serveur
            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            // Afficher la réponse du serveur
            String reponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Réponse du serveur : " + reponse);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}