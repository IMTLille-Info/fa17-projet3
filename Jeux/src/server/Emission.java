package server;

import java.io.PrintWriter;


public class Emission{


	private PrintWriter out;
	private String message = null;
	
	public Emission(PrintWriter out) {
		this.out = out;
	}
	
	public void sendPos(int x, int y){
		
		message = x + ";" + y;
		
		out.println(message);
		out.flush();
	}
}
