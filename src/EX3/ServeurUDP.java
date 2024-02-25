package EX3;

import java.net.*;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        int port = 1250;
        DatagramSocket socket = null;
        int numberOfDatagramsToReceive = 1;
        int receivedDatagrams = 0;
        try {
            socket = new DatagramSocket(port);
            System.out.println("Serveur UDP en attente sur le port " + port);

            while (receivedDatagrams < numberOfDatagramsToReceive) {
                // Attendre la réception d'un datagramme
                byte[] buffer = new byte[1024];
                DatagramPacket receptionPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receptionPacket);

                // Récupérer l'adresse IP et le port de l'émetteur
                InetAddress clientAddress = receptionPacket.getAddress();
                int clientPort = receptionPacket.getPort();

                // Obtenir la date et l'heure courante
                String dateHeure = new Date().toString();
                byte[] reponseData = dateHeure.getBytes();

                // Créer un datagramme pour la réponse
                DatagramPacket reponsePacket = new DatagramPacket(reponseData, reponseData.length, clientAddress, clientPort);

                // Envoyer la réponse au client
                socket.send(reponsePacket);

                System.out.println("Réponse envoyée à " + clientAddress + ":" + clientPort);

                receivedDatagrams++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("Serveur UDP fermé.");
            }
        }
    }
}
