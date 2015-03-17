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
	private float posx = 30,posy = 30;
	private int ligne,colonne;

	public Case(GUIContext container, Rectangle shape, ComponentListener listener,Vector2f posEcran, String name, float posx, float posy, int colonne, int ligne) {
		super(container);
		addListener(listener);
		this.posEcran = posEcran;
		this.nomCase = name;
		this.posx = posx;
		this.posy = posy;
		this.colonne = colonne;
		this.ligne = ligne;
		Input input = container.getInput();
		this.area = shape;
		over = area.contains(input.getMouseX(), input.getMouseY());
		mouseDown = input.isMouseButtonDown(0);
	}

	private void updateImage(Graphics g) {
		if (!over) { // Si la case n'est pas coché
			current = new Color(Color.white);
		} else { // Si la case est survolé par la souris
			current = new Color(Color.red);
			if (mouseDown) { // Si la case est cliqué
				current = new Color(Color.magenta);
				notifyListeners();
			}
		}
	}

	@Override
	public int getHeight() {
		return this.colonne; // Solution à modifier
	}

	@Override
	public int getWidth() {
		return this.ligne; // Solution à modifier
	}
	
	public void setPosX(float posx) {
		this.posx = posx;
	}

	public void setPosY(float posy) {
		this.posy = posy;
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
	
	public boolean whichButton(float x, float y){
		return area.contains(x, y);
	}

	public void mousePressed(int button, int mx, int my) {
		over = area.contains(mx, my);
		if (button == 0)
			mouseDown = true; 
	}

	public void mouseReleased(int button, int mx, int my) {
		over = area.contains(mx, my);
		if (button == 0)
			mouseDown = false; 
	}
	  
	public String toString(String test){
		return "Nom Case : "+ nomCase + " Position x " + this.posEcran.x + " Position y : " + this.posEcran.y;
	}

	@Override
	public int getX() {
		return (int) this.posx;
	}

	@Override
	public int getY() {
		return (int) this.posy;
	}
	
	public int getLigne() {
		return this.ligne;
	}

	public int getColonne() {
		return this.colonne;
	}

}
