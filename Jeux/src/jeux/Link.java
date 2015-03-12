package jeux;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Link {

	public Link(String ip, int port) {
		Socket socket;
		BufferedReader in;
		
		try {
			socket = new Socket(InetAddress.getByName(ip), port); // Ouverture de la socket
			System.out.println("Demande de connexion");

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message_distant = in.readLine();
			System.out.println(message_distant);

			socket.close(); // Fermeture de la socket

		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}