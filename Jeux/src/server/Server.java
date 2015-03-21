package server;

import java.io.IOException;
import java.net.ServerSocket;


public class Server {
 public static ServerSocket ss = null;
 public static Thread t;
 
	public static void main(String[] args) {
		
		int port = 2015;
		
		try {
			ss = new ServerSocket(port);
			System.out.println("Le serveur est à l'écoute du port "+ss.getLocalPort());
			
			t = new Thread(new Accept_connexion(ss));
			t.start();
			
		} catch (IOException e) {
			System.err.println("Le port " + port + " est déjà utilisé !");
		}
	
	}

	
	}