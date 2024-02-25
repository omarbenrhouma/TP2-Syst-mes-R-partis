package EX2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServeurUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        try {
            // on récupère le paramètre : port d'écoute
            System.out.println("port d'écoute : ");
            port = keyb.nextInt();
            socket = new DatagramSocket(port);

            // Création d'un tableau de bytes pour stocker les données de l'objet Voiture
            byte[] buffer = new byte[1024];

            // Création d'un paquet pour recevoir les données du client
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

            // Attente de la réception du paquet du client
            socket.receive(receivePacket);

            // Transformation des bytes reçus en un objet Voiture
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            voiture voitureReçue = (voiture) ois.readObject();

            // Modification de la quantité de carburant de la voiture côté serveur
            voitureReçue.setCarburant(50); // Exemple: ajouter 50 litres de carburant

            // Affichage de la quantité de carburant après modification
            System.out.println("Quantité de carburant côté serveur: " + voitureReçue.getCarburant());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
