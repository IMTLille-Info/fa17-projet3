package jeux;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class CaseListener extends WindowsGame implements ComponentListener {
	Graphics g;
	  
	public CaseListener(GameContainer c){
		 g = c.getGraphics();
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		//this.player1.move(source.getX(),source.getY(),g,this.direction,this.moving);
		this.x = source.getX();
		this.y = source.getY();
		//g.drawString("la case "+source.getClass().getName()+" est activée", 200, 200);
	}
	
	public void dessineGUI(GameContainer container, Graphics g) {
		
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount){
		System.out.println("COUCOUTAMERE");
	}
	
	public String toString(){
		return "test";
	}
}
