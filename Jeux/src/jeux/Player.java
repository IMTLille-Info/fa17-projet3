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
	private int currentLine, currentCol;

	private int hp; // Points de vie du joueur
	private int move_capacity; // Capacité de mouvement

	public int direction = 2; // Direction du joueur sur la carte
	/*
	 * 1 -> vers la gauche 
	 * 2 -> vers le bas 
	 * 3 -> vers la droite 
	 * 4 -> vers lehaut
	 */
	protected boolean moving = false; // Etat du joueur en mouvement/static

	Player(Image img, int largeur, int hauteur, int nbImage, float x, float y, int hp, int move_cap) throws SlickException {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.move_capacity = move_cap;
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
		if(Math.ceil(this.getPositionX()) != Math.ceil(toX) || Math.ceil(this.getPositionY()) != Math.ceil(toY)){ // Si la position de départ et l'arrivé sont différentes
			this.moving = true;
			if(this.getPositionX() != toX){
				if(this.getPositionY() == toY){
					this.getDirX(toX);
				}
				if (this.checkVertical(toX)){
					this.setPositionX(toX); 
				} else {
					if(this.getPositionY() != toY){
						this.getDirX(toX);
					}
				}
			}
			if(Math.ceil(this.getPositionY()) != toY && toX == Math.ceil(this.getPositionX())){
				this.getDirY(toY);
				if (this.checkHorizontal(toY)) {
					this.setPositionY(toY);
					this.moving = false;
				} else {
					this.getDirY(toY);
				}	
			} else if(Math.ceil(this.getPositionY()) == toY && toX == Math.ceil(this.getPositionX() ))
				this.moving = false;
		} else {
			this.moving = false;
			this.direction = 2;
		}
		g.drawAnimation(this.animations[this.direction + (this.moving ? 4 : 0)],this.x, this.y); // Animation du joueur
	}
	
	private void getDirX(float toX){
		if (toX < this.getPositionX()) // Si la destination se trouve à gauche du personnage
			this.direction = 1;
		else // Si la destination se trouve à droite du personnage
			this.direction = 3;
	}
	
	private void getDirY(float toY){
		if (toY < this.getPositionY()) // Si la destination se trouve au dessus du personnage
			this.direction = 0;
		else // Si la destination se trouve en dessous du personnage
			this.direction = 2;
	}
	
	private boolean checkVertical(float toX){
		return (
				this.direction == 1 && 
				((Math.ceil(this.getPositionX()) <= Math.ceil(toX)) ||  ((Math.ceil(this.getPositionX())-1 <= Math.ceil(toX))))
			   ) || (
			    this.direction == 3 && 
			    ((Math.ceil(this.getPositionX()) >= Math.ceil(toX)) ||  ((Math.ceil(this.getPositionX())+1 >= Math.ceil(toX))))
			   );
	}
	
	private boolean checkHorizontal(float toY){
		return (	
				this.direction == 0 && 
				((Math.ceil(this.getPositionY()) <= Math.ceil(toY)) || (Math.ceil(this.getPositionY())-1 <= Math.ceil(toY)))
			   ) || (
			    this.direction == 2 && 
			    ((Math.ceil(this.getPositionY()) >= Math.ceil(toY)) || (Math.ceil(this.getPositionY())+1 >= Math.ceil(toY)))
			   );
	}
	
	public void check_movable(Maps map){
		int col = this.currentCol;
		int line = this.currentLine;
		 //Case position = map.get_case(line, col);
		 //position.setmovable(false);
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
		delta = 16;
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
	
	public int getMove_capacity() {
		return move_capacity;
	}

	public void setMove_capacity(int move_capacity) {
		this.move_capacity = move_capacity;
	}
	
	public int getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(int currentLine) {
		this.currentLine = currentLine;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

}

