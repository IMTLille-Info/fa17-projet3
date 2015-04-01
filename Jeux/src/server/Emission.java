package server;

import java.io.PrintWriter;


public class Emission{


	private PrintWriter out;
	private String message = null;
	
	public Emission(PrintWriter out) {
		this.out = out;
	}
	
	public void sendPos(String name, int x, int y){
		
		message = name + ";" + x + ";" + y;
		
		out.println(message);
		out.flush();
	}
}
