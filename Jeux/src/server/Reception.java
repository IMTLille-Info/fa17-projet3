package server;

public class Reception {

	private String login = null;
	private String posx, posy;
	
	public Reception(String log){
		this.login = log;
	}
	
	public void setPositions(String message){
		String origin = message;
		String [] parts = origin.split(";");
		this.posx = parts[0];
		this.posy = parts[1];
	}
	
	public String getPosX(){
		return this.posx;
	}
	
	public String getPosY(){
		return this.posy;
	}
}