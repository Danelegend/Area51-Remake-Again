package me.dane.area51;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;
import me.dane.area51.objects.Alien;
import me.dane.area51.objects.Block;
import me.dane.area51.objects.Enemy;
import me.dane.area51.objects.Player;

public class GameHandler {

	public LinkedList<GameObject> obj = new LinkedList<GameObject>();
	
	private GameObject tempObj;
	
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
		
		for (int xx = 0; xx <= 5472; xx += 32) {
			addObject(new Block(xx, 0, ObjectId.Block));
			addObject(new Block(xx, 6976, ObjectId.Block));
		}
		
		for (int yy = 0; yy <= 6976; yy += 32) {
			addObject(new Block(0, yy, ObjectId.Block));
			addObject(new Block(5472, yy, ObjectId.Block));
		}

		for (int i = 0; i <= 10; i++) {
			Random rand = new Random();
			addObject(new Alien(4000 + rand.nextInt(1500), rand.nextInt(7000), ObjectId.Alien, this));
		}
		
		for (int i = 0; i <= 10; i++) {
			Random rand = new Random();
			addObject(new Enemy(1000 + rand.nextInt(4500), rand.nextInt(7000), ObjectId.Enemy, this));
		}

	}
 	
}
