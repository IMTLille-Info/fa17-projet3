package jeux;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class Maps {
	
	private Map<String, Case> listeCases = new HashMap<String, Case>();
	
	public Maps(GUIContext container, ComponentListener listener) {
		createMap(container, listener);
	}

	public void createMap(GUIContext container, ComponentListener listener) {
		Vector2f positionEcran = new Vector2f(0, 0);
		int posX = 0;
		int posY = 0;
		int nbCaseVertical = container.getHeight()/30;
		int nbCaseHorizontal = container.getWidth()/30;
		int index = 0;
		for(int i = 0; i< nbCaseHorizontal; i++){
			for(int j = 0; j< nbCaseVertical; j++){
				String nomCase = ((i+1) + "." + (j+1));
				Case carre = new Case(container, new Rectangle(posX+1, posY+1, 28, 28),listener,positionEcran, "Case : " + j+1 + " / " + i+1, posX-1, posY-20, j+1, i+1);
				listeCases.put(nomCase,carre);
				posX += 30; 
				index++;
			}
			posY += 30;
			posX = 0;
		}
	}

	public void drawMap(GUIContext container, Graphics g) throws SlickException {
		for (Object mapKey : listeCases.keySet()) {
			Case carre = (Case) listeCases.get(mapKey);
			carre.render(container, g);
		}
	}
	
	public Case get_case(int col, int line){
		return listeCases.get(col+"."+line);
	}
	
	public Case get_coordonnees(int col, int line){
		return listeCases.get(col+"."+line);
	}
	
}
