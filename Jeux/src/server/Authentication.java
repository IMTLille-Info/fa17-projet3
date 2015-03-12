package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Authentication implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "client";
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentication(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
			out.println("Entrez votre pseudo :");
			out.flush();
			login = in.readLine();
			
				
				out.println("connecte");
				System.out.println(login + " vient de se connecter ");
				out.flush();
				
				authentifier = true;
				
		 }
			t2 = new Thread(new Exchange(socket,login));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println(login + " ne répond pas !");
		}
	}

}