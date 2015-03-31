package server;

public class Reception {

	private String login = null;
	private int posX, posY;
	
	public Reception(String log){
		this.login = log;
	}
	
	public void changePositions(String message){
		String origin = message;
		String [] parts = origin.split(";");
		this.posX = Integer.parseInt(parts[0]);
		this.posY = Integer.parseInt(parts[1]);
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public String getLogin(){
		return this.login;
	}
}