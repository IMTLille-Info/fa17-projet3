package jeux;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Link {
	
	public Link(int port) {
		
		Socket socket;

		try {
			 System.out.println("Connexion au serveur...");
		     socket = new Socket(InetAddress.getLocalHost(),port);
		     System.out.println("Connexion OK !");
	         socket.close();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}
}