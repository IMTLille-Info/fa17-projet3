/**
 * 
 */
package jeux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;

/**
 * @author nicolaspicart, jeancastel
 *
 */

public class WindowsGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	private float x = 284, y = 276;
	private static int ycarte = 600, xcarte = 600;
	private int direction = 0;
	private boolean moving = false;
	Animation[] animations;
	static Link link;

	public static void main(String[] args) throws SlickException {
		//link = new Link("castwab.ddns.net", 2015);
		// Création de la fenêtre de jeux
		AppGameContainer container = new AppGameContainer(new WindowsGame(), xcarte, ycarte, false);
		container.start();
		
	}

	public WindowsGame() {
		super("Zelfa");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		// Déclaration de la map
		this.map = new TiledMap("resources/map/map2.tmx");
		// Création d'un joueur
		Player player = new Player();
		// Enregistrement des différentes positions et animations du perosonnage
		animations = player.CreateAnimation(new Image("resources/characters/char2.png"), 32, 48, 4);;
	}
	
	/*
	 * Fonction qui gère le rendu pour chaque frame
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Affichage de la carte
		this.map.render(0, 0);
		// Affichage des animations du personnages
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
		
	}

	/*
	 * Mise à jour du personnage
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
	        }
	    }
	}

	@Override
	public void keyReleased(int key, char c) {
		this.moving = false;

	}
	@Override
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;
	    }
	}
	
	public String getXY(){
		String varx = Float.toString(x);
		String vary = Float.toString(y);
		return varx+'/'+vary;
	}

}
