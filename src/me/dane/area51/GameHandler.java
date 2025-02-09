package me.dane.area51;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;
import me.dane.area51.objects.*;

public class GameHandler {

	public LinkedList<GameObject> obj = new LinkedList<GameObject>();

	private GameObject tempObj;

	private int amountOfPlayers;
	private int amountOfAliens;
	private int amountOfEnemies;
	
	public GameHandler(int amountOfPlayers, int amountOfAliens, int amountOfEnemies) {
		this.amountOfAliens = amountOfAliens;
		this.amountOfPlayers = amountOfPlayers;
		this.amountOfEnemies = amountOfEnemies;
	}
	
	public void tick() {
		for (int i = 0; i < obj.size(); i++) {
			tempObj = obj.get(i);
			tempObj.tick(obj);
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < obj.size(); i++) {
			tempObj = obj.get(i);
			tempObj.render(g);
		}
	}

	public void addObject(GameObject obj) {
		this.obj.add(obj);
	}

	public void removeObject(GameObject obj) {
		this.obj.remove(obj);
	}

	public void killPlayerForBounds() {
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getId() == ObjectId.Player) {
				Player p = (Player) obj.get(i);
				if (p.getZone() == "none") {
					obj.remove(i);
				}
			}
		}
	}

	public void killPlayerForEnemy() {
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getId() == ObjectId.Player) {
				Player p = (Player) obj.get(i);
				if (p.isHit()) {
					obj.remove(i);

					for (int i2 = 0; i2 < obj.size(); i2++) {
						if (obj.get(i2).getId() == ObjectId.Player) {
							Player p1 = (Player) obj.get(i2);

							if (p1.isHit() == false) {
								p1.setControlled(true);
							}
						}
					}

				}
			}
		}
	}

	public void removeAlien() {
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getId() == ObjectId.Alien) {
				Alien a = (Alien) obj.get(i);
				if (a.isHit()) {
					obj.remove(i);
				}

			}
		}
	}

	public void createLevel() {

		//Borders
		for (int xx = 0; xx <= 5472; xx += 32) {
			addObject(new Block(xx, 0, ObjectId.Block));
			addObject(new Block(xx, 6976, ObjectId.Block));
		}

		for (int yy = 0; yy <= 6976; yy += 32) {
			addObject(new Block(0, yy, ObjectId.Block));
			addObject(new Block(5472, yy, ObjectId.Block));
		}

		//Generate aliens & enemies
		for (int i = 0; i <= amountOfAliens; i++) {
			Random rand = new Random();
			addObject(new Alien(4000 + rand.nextInt(1500), rand.nextInt(7000), ObjectId.Alien, this));
			Score.addAlien();
		}

		for (int i = 0; i <= amountOfEnemies; i++) {
			Random rand = new Random();
			addObject(new Enemy(1000 + rand.nextInt(4500), rand.nextInt(7000), ObjectId.Enemy, this));
		}
		
		for (int i = 0; i < amountOfPlayers; i++) {
			Random rand = new Random();
			int x = rand.nextInt(900);
					
			if (x < 64) {
				x = 64;
				}
					
			int y = rand.nextInt(6000);
					
			if (y < 32) {
				y = 32;
				}
					
			addObject(new Player(x, y, ObjectId.Player, this, i));
			Score.addPlayer();
			}

	}
	
	public int getAmountOfPlayers() {
		return amountOfPlayers;
	}
	
	public int getAmountOfAliens() {
		return amountOfAliens;
	}
	
	public int getAmountOfEnemies() {
		return amountOfEnemies;
	}

}
