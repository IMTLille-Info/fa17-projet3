package jeux;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class CaseListener extends WindowsGame implements ComponentListener {
	Graphics g;
	int posX,posY,colonne,ligne;
	  
	public CaseListener(GameContainer c){
		 g = c.getGraphics();
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		this.posX = source.getX();
		this.posY = source.getY();
		this.colonne = source.getHeight();
		this.ligne = source.getWidth();
	}
	
	public int getX() {
		return (int) this.posX;
	}
	
	public int getY() {
		return (int) this.posY;
	}
	
	public int getColonne() {
		return (int) this.colonne;
	}
	
	public int getLigne() {
		return (int) this.ligne;
	}
	
}
