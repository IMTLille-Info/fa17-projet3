package jeux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client implements Runnable{

	public static Socket socket = null;
	public static Thread t1;
	private PrintWriter out = null;
	
	public static Thread t2;
	public static String name = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	

	Client(String ip, int port) {	
		
		try {
			
			System.out.println("Demande de connexion");
			socket = new Socket(InetAddress.getByName(ip), port);
			System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté
			
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (UnknownHostException e) {
		  System.err.println("Impossible de se connecter a l'adresse " + ip);
		} catch (IOException e) {
		  System.err.println("Aucun serveur a l'ecoute du port " + port);
		}
	}
	
	public void run() {

		try {
			sc = new Scanner(System.in);

			while (!connect) {

				System.out.println(in.readLine());
				name = sc.nextLine();
				out.println(name);
				out.flush();

				System.out.println("Je suis connecté");
				connect = true;

			}

		} catch (IOException e) {

			System.err.println("Le serveur ne répond plus ");
		}
	}
	
	public void send_pos(Player p){
	
		out.println("X :" + p.getPositionX());
		out.println("Y :" + p.getPositionY());
		out.flush();
	}
}
