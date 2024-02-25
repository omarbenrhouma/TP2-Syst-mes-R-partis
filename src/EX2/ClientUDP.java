package EX2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
        try {
            // Création d'une socket UDP côté client
            socket = new DatagramSocket();
            // on récupère les paramètres
            System.out.println("Adresse du serveur : ");
            host = keyb.next();
            System.out.println("Port d'écoute du serveur : ");
            port = keyb.nextInt();
            InetAddress serverAddress;

            // Création d'un objet Voiture
            voiture maVoiture = new voiture("SUV", "ModèleX");

            // Modification de la quantité de carburant côté client
            maVoiture.setCarburant(30); // Exemple: ajouter 30 litres de carburant

            // Transformation de l'objet Voiture en tableau de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(maVoiture);
            byte[] data = baos.toByteArray();

            // Envoi du tableau de bytes au serveur
            serverAddress = InetAddress.getByName(host); // Remplacez par l'adresse IP du serveur
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, serverAddress, port);
            socket.send(sendPacket);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
