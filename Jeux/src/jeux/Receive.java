package jeux;

import java.io.BufferedReader;
import java.io.IOException;



public class Receive implements Runnable {

	private BufferedReader in;
	private String message = null;
	
	public Receive(BufferedReader in){
		
		this.in = in;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	
			message = in.readLine();
			System.out.println(message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
