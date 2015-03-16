package jeux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	SpriteSheet spriteSheet;
	private Animation[] animations = new Animation[8];
	
	Player(Image img, int largeur, int hauteur, int nbImage) throws SlickException{
		this.createAnimation(img, largeur, hauteur, nbImage);
	}
	
	protected void createAnimation(Image img,int largeur,int hauteur, int nbImage) throws SlickException{
		spriteSheet = new SpriteSheet(img, largeur, hauteur);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[4] = loadAnimation(spriteSheet, 1, nbImage, 3);
		this.animations[5] = loadAnimation(spriteSheet, 1, nbImage, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, nbImage, 0);
		this.animations[7] = loadAnimation(spriteSheet, 1, nbImage, 2);
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++)
	        animation.addFrame(spriteSheet.getSprite(x, y), 120);
	    return animation;
	}
	
	public void move(float x, float y, Graphics g, int direction, boolean moving ){
		g.drawAnimation(this.animations[direction + (moving ? 4 : 0)], x, y); // Affichage des différentes position du joueur en fonction des coordonnées
	}
	
	public String getName(){
		return "test";
	}
	
	
}
