package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Exchange implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "client", message;
	private Thread t3, t4;
	
	public Exchange(Socket s, String log){
		socket = s;
		login = log;
	}
	
	public void run() {
		
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		
		while(!socket.isClosed()){
			message = in.readLine();
			Reception test = new Reception(message);
			if (message != null) {
				
				System.out.println(test.getPosX());
				System.out.println(test.getPosY());
			}
		}
		
		} catch (IOException e) {
			System.err.println(login +" s'est déconnecté ");
		}
}
}