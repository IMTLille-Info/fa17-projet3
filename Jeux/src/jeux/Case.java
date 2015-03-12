package jeux;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class Case extends AbstractComponent {

	private Vector2f posEcran = null; 	// Position de la case sur l'écran
	private String nomCase; 			// Nom de la case
	private boolean over,mouseDown; 	// Lors du passage/clic de la souris sur la case
	private Color current; 				// Couleur de la case
	Shape area;

	public Case(GUIContext container, Rectangle shape, ComponentListener listener,Vector2f posEcran, String name) {
		super(container);
		addListener(listener);
		this.posEcran = posEcran;
		this.nomCase = name;
		Input input = container.getInput();
		this.area = shape;
		over = area.contains(input.getMouseX(), input.getMouseY());
		mouseDown = input.isMouseButtonDown(0);
	}

	private void updateImage(Graphics g) {
		if (!over) { // Si la case n'est pas coché
			current = new Color(Color.transparent);
		} else { // Si la case est survolé par la souris
			current = new Color(Color.red);
			if (mouseDown) { // Si la case est cliqué
				current = new Color(Color.red);
				notifyListeners();
			}
		}
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	public Vector2f getPosEcran(){
		return posEcran;
	}
	
	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		g.setColor(current);
		g.fill(area);
		updateImage(g); 
	}
	
	@Override
	public void setLocation(int arg0, int arg1) {
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		 over = area.contains(newx, newy);
	}

	public void mousePressed(int button, int mx, int my) {
		over = area.contains(mx, my);
		// A corriger provoque une exception
		//if (button == 0)
		//	mouseDown = true; 
	}

	public void mouseReleased(int button, int mx, int my) {
		over = area.contains(mx, my);
		if (button == 0)
			mouseDown = false; 
	}
	  
	public String toString(String test){
		return "Nom Case : "+ nomCase + " Position x " + this.posEcran.x + " Position y : " + this.posEcran.y;
	}

}
