package jeux;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author NicolasPicart, JeanCastel co author, qui n'a pas vraiment réussi à
 *         coder... AlexandreD
 */

public class WindowsGame extends BasicGame {

	private TiledMap map; // Map
	private static int ycarte = 600, xcarte = 600; // Coordonnées de la carte
	Player player1;
	static Client client;
	private CaseListener ecouteur;
	private int Newy = 90, Newx = 90;
	public Maps cases; // Maps avec les différentes cases

	public static void main(String[] args) throws SlickException {
		client = new Client("127.0.0.1", 2015);
		AppGameContainer container = new AppGameContainer(new WindowsGame(),xcarte, ycarte, false); // Création de la fenêtre de jeux
		container.setShowFPS(false); // Cacher l'affichage FPS
		container.setVSync(true);
		container.setTargetFrameRate(60);
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
		ecouteur = new CaseListener(container); // Ecouteurs sur chaque case
		cases = new Maps(container, ecouteur); // Mise en place des cases
		this.setPostionJour(7, 15);
		player1 = new Player(new Image("resources/characters/char2.png"), 32, 48, 4, this.Newx, this.Newy, 90,  5); // Création d'un joueur
		
		
		
	}
	
	public void setPostionJour(int col, int ligne){
		this.Newx = cases.get_coordonnees(col, ligne).getX();
		this.Newy = cases.get_coordonnees(col, ligne).getY();
	}

	/*
	 * Fonction qui gère le rendu pour chaque frame
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		/*
		 * Todo
		 * Déclenchement action de déplacement du joueur à la reception des coordonnées données par le serveur.
		 */
		
		map.render(0, 0); // Affichage de la carte (Visuel)
		cases.drawMap(container, g); // Affichage des cases
		player1.move(g, (float) Newx, (float) Newy); // Déplacement du joueur
														// sur la carte
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		this.Newx = ecouteur.getX();
		this.Newy = ecouteur.getY();
		this.player1.setCurrentCol(ecouteur.getColonne());
		this.player1.setCurrentLine(ecouteur.getLigne());
		client.send_pos(player1);
	}

	/*
	 * Mise à jour du personnage
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		this.player1.updateImage(delta);
		this.player1.check_movable(this.cases);
	}

}
