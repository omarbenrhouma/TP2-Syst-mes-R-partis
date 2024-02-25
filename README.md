# TP2-Syst-mes-R-partis

ceci concerne le travail réaliser du tp 2 concerne la création et la Mise en œuvre du protocole de transport UDP au moyen des sockets en Java.
Le TP se divise en 3 exercices chaqu'un est réaliser dans un package indépendant.

            Exercice 1 :
L’exercice a pour but de développer une connexion client serveur en mode UDP

            Exercice 2 :
On souhaite échanger entre le client/serveur les objets d’une classe voiture via les sockets
UDP. La classe voiture
Pour cela le client Crée un objet voiture et l’envoi au serveur pour lui fixer une quantité de
carburant avec la méthode setCarburant().
1. Ecrire la partie client de l’application et la partie serveur.
2. Tester cette application sur la même machine.
3. Tester cette application sur deux machines reliées par réseaux.


            Exercice 3 :
Créez localement un serveur UDP qui écoutera sur le port 1250 et qui pour chaque
datagramme reçu et quelque soit leur contenu, retournera à l’émetteur un datagramme
contenant la date et l’heure courante.
Afin d'assurer la fermeture de la socket serveur a la fin de la commmunication, nous avons pris en cosidération un nombre maximale de datagramme en entrées et par la suite   
la socket se ferme automatiquement.
