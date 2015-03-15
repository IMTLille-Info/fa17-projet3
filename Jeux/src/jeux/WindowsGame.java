package jeux;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author NicolasPicart, JeanCastel
 *
 */

public class WindowsGame extends BasicGame {

	private TiledMap map; // Map
	public float x; // Position du joueur au démarrage du jeux
	public float y;
	private static int ycarte = 600, xcarte = 600; // Coordonnées de la carte
	public int direction = 2; // Direction du joueur sur la carte
	protected boolean moving = false; // Etat du joueur en mouvement/static
	Animation[] animations; // Animation du joueur
	Player player1;
	static Client client;
	private CaseListener ecouteur;
	public static Maps cases; // Maps avec les différentes cases

	public static void main(String[] args) throws SlickException {
		//client = new Client("castwab.ddns.net", 2015);
		AppGameContainer container = new AppGameContainer(new WindowsGame(),xcarte, ycarte, false); // Création de la fenêtre de jeux
		container.setShowFPS(false); // Cacher l'affichage FPS
		container.setVSync(true);	
		container.setMultiSample(64);
		container.setTargetFrameRate(60);
		container.setVerbose(true);
		container.start();
	}

	public WindowsGame() {
		super("Zelfa"); // Titre application
	}

	/*
	 * Traitements à réaliser avant le rendu du jeux
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
		
		map = new TiledMap("resources/map/map2.tmx"); // Déclaration de la map
		player1 = new Player(new Image("resources/characters/char2.png"), 32, 48, 4); // Création d'un joueur 
		ecouteur = new CaseListener(container);
		cases = new Maps(container, ecouteur); // Mise en place des cases
	}

	/*
	 * Fonction qui gère le rendu pour chaque frame
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.render(0, 0); // Affichage de la carte (Visuel)
		cases.drawMap(container,g); // Affichage des cases
		player1.move(x,y,g,direction,moving);
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount){
		this.x = ecouteur.getX();
		this.y = ecouteur.getY();
	}

	/*
	 * Mise à jour du personnage
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (this.moving) {
			switch (this.direction) {
				case 0:
					this.y -= .1f * delta;
					break;
				case 1:
					this.x -= .1f * delta;
					break;
				case 2:
					this.y += .1f * delta;
					break;
				case 3:
					this.x += .1f * delta;
					break;
			}
		}
	}

	/*
	 * Evenement lors du relachement de la souris
	 */
	@Override
	public void keyReleased(int key, char c) {
		this.moving = false;
	}
	
	/*
	 * Evenement lors du clic sur les touches directionnelles
	 */
	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_UP:
			this.direction = 0;
			this.moving = true;
			break;
		case Input.KEY_LEFT:
			this.direction = 1;
			this.moving = true;
			break;
		case Input.KEY_DOWN:
			this.direction = 2;
			this.moving = true;
			break;
		case Input.KEY_RIGHT:
			this.direction = 3;
			this.moving = true;
			break;
		}
	}

	/*
	 * Récupération des coordonnées pour le déplacement du joueur en réseau
	 */
	public String getXY() {
		String varx = Float.toString(x);
		String vary = Float.toString(y);
		return varx + '/' + vary;
	}

}
