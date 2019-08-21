package me.dane.area51.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;

import me.dane.area51.GameHandler;
import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;

public class Enemy extends GameObject {

    private GameHandler gh;

    private final float width = 48;
	private final float height = 96;
	
	private Image img;
	
	private Player closestPlayer;
	
    public Enemy(float x, float y, ObjectId id, GameHandler gh) {
        super(x, y, id);
        this.gh = gh;
        
        String loc = "200px-Roger_Smith.png";
        
        img = Toolkit.getDefaultToolkit().getImage(loc);
    }

    public void tick(LinkedList<GameObject> obj) {
    	searchForPlayer();
    	chasePlayer();
    }

	public void render(Graphics g) {
		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
	}
	
	public void chasePlayer() {
		if (closestPlayer == null) {
			return;
		}
		
		Player p = closestPlayer;
		
		System.out.println(p.getPlayerID());
		
		double pX = p.getX();
		double pY = p.getY();
		
		System.out.println(pX + " " + pY);
		System.out.println(x + " " + y);
		
		if (x > pX) {
			x-=5;
		}
		
		if (x < pX) {
			x+=5;
		}
		
		if (x == pX) {
			x+=5;
		}
		
		if (y > pY) {
			y-=5;
		}
		
		if (y < pY) {
			y+=5;
		}
		
		if (y == pY) {
			y+=0;
		}
		
	}
	
	public void searchForPlayer() {		
		double closestDist = 1000000000;
		closestPlayer = null;
		for (int i = 0; i < gh.obj.size(); i++) {
			if (gh.obj.get(i).getId() == ObjectId.Player) {
				Player p = (Player) gh.obj.get(i);
				
				if (p.getZone() == "tz" || p.getZone() == "51z") {
					double playerDistance = Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2));
				
					if (playerDistance < 0) {
						playerDistance = playerDistance * -1;
					}
					
					if (playerDistance < closestDist) {
						closestDist = playerDistance;
						closestPlayer = p;
					}
					
				} else {
					if (closestPlayer == null) {
						closestPlayer = null;
					}
				}
			}
		}
	}
	
	//Collision Boxes
	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) ((int) y+(height/2)), (int) width/2, (int) height/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) y, (int) width/2, (int) height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}
