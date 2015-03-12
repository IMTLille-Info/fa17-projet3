package jeux;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class CaseListener implements ComponentListener {
	Graphics g;
	  
	public CaseListener(GameContainer c){
		 g = c.getGraphics();
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		g.drawString("Case : " + source.getClass().getName(), 200, 200);
	}
}
