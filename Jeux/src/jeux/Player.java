package jeux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	SpriteSheet spriteSheet;
	private Animation[] animations = new Animation[8]; // Tableau d'animations
	private float x, y; // Coordonnées du joueur
	public int direction = 2; // Direction du joueur sur la carte
	/*
	 * 1 -> vers la gauche 
	 * 2 -> vers le bas 
	 * 3 -> vers la droite 
	 * 4 -> vers lehaut
	 */
	protected boolean moving = false; // Etat du joueur en mouvement/static

	Player(Image img, int largeur, int hauteur, int nbImage, float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		this.createAnimation(img, largeur, hauteur, nbImage);
	}

	protected void createAnimation(Image img, int largeur, int hauteur, int nbImage) throws SlickException {
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
		for (int a = startX; a < endX; a++)
			animation.addFrame(spriteSheet.getSprite(a, y), 120);
		return animation;
	}

	public void move(Graphics g, float toX, float toY) throws SlickException {
		if(this.getPositionX() != toX || this.getPositionY() != toY){ // Si la position de départ et l'arrivé sont différentes
			this.moving = true;
			if(this.getPositionX() != toX){
				if(this.getPositionY() == toY){
					if ((double) toX < (double) this.getPositionX()) // Si la destination se trouveà gauche du personnage
						this.direction = 1;
					else // Si la destination se trouve à droite du personnage
						this.direction = 3;
				}
				if ((this.direction == 1 && ((double) this.getPositionX() <= (double) toX)) || (this.direction == 3 && ((double) this.getPositionX() >= (double) toX))){
					this.setPositionX(toX); 
				} else {
					if(this.getPositionY() != toY){
						// On s'occupe d'abord du déplacement vertical
						if ((double) toX < (double) this.getPositionX()) // Si la destination se trouveà gauche du personnage
								this.direction = 1;
						else // Si la destination se trouve à droite du personnage
								this.direction = 3;
					}
				}
			}
			if(this.getPositionY() != toY && toX == this.getPositionX()){
				// Une fois que le joueur est bien placé horizontalement on le déplace verticalement
				if (toY < this.getPositionY()) // Si la destination se trouve au dessus du personnage
					this.direction = 0;
				else // Si la destination se trouve en dessous du personnage
					this.direction = 2;
				if ((this.direction == 0 && (this.getPositionY() <= toY)) || (this.direction == 2 && (this.getPositionY() >= toY))) {
					this.setPositionY(toY);
					this.moving = false;
				} else {
					if (toY < this.getPositionY()) // Si la destination se trouve au dessus du personnage
						this.direction = 0;
					else // Si la destination se trouve en dessous du personnage
						this.direction = 2;
				}	
			} else if(this.getPositionY() == toY && toX == this.getPositionX() )
				this.moving = false;
		} else {
			this.moving = false;
		}
	
		g.drawAnimation(this.animations[this.direction + (this.moving ? 4 : 0)],this.x, this.y); // Animation du joueur
	}

	public float getPositionX() {
		return this.x;
	}

	public float getPositionY() {
		return this.y;
	}
	
	public void setPositionX(float posx) {
		this.x = posx;
	}

	public void setPositionY(float posy) {
		this.y = posy;
	}

	public void updateImage(int delta) {
		if (this.moving) {
			switch (this.direction) {
				case 0:
					this.y -= .1 * delta;
					break;
				case 1:
					this.x -= .1 * delta;
					break;
				case 2:
					this.y += .1 * delta;
					break;
				case 3:
					this.x += .1 * delta;
					break;
			}
		}
	}

}
