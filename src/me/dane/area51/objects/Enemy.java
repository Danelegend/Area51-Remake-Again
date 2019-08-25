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

	private Player closestPlayer;
	private GameHandler gh;
	
    private final float width = 48;
	private final float height = 96;

	private Image img;
	
    public Enemy(float x, float y, ObjectId id, GameHandler gh) {
        super(x, y, id);

        this.gh = gh;
        
        String loc = "Cleveland.png";
        
        img = Toolkit.getDefaultToolkit().getImage(loc);
    }

    public void tick(LinkedList<GameObject> obj) {
    	searchForPlayer();
    	chasePlayer();
    }

	public void render(Graphics g) {
		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
	}
	
	/* public void chasePlayer(Player p) {

		double pX = p.getX();
		double pY = p.getY();

		if (x > pX) {
			if (p.getZone() == "tz") {
				x-=3;
			}

			if (p.getZone() == "51z") {
				x-=5;
			}
		}
		
		if (x < pX) {
			if (p.getZone() == "tz") {
				x+=3;
			}

			if (p.getZone() == "51z") {
				x+=5;
			}
		}
		
		if (x == pX) {
			if (p.getZone() == "tz") {
				x+=3;
			}

			if (p.getZone() == "51z") {
				x+=5;
			}
		}
		
		if (y > pY) {
			if (p.getZone() == "tz") {
				y-=3;
			}

			if (p.getZone() == "51z") {
				y-=5;
			}
		}
		
		if (y < pY) {
			if (p.getZone() == "tz") {
				y+=3;
			}

			if (p.getZone() == "51z") {
				y+=5;
			}
		}
		
		if (y == pY) {
			if (p.getZone() == "tz") {
				y+=3;
			}

			if (p.getZone() == "51z") {
				y+=5;
			}
		}
		
	} */
	
	private void Collision(Player player) {
		Player p = player;
		if (p.getZone() != "51z") {
			return;
		}
		
		if (getBoundsTop().intersects(p.getBounds())) {
			p.setHit(true);
			p.killPlayer();
		}

		if (getBounds().intersects(p.getBounds())) {
			p.setHit(true);
			p.killPlayer();
		}

		if (getBoundsRight().intersects(p.getBounds())) {
			p.setHit(true);
			p.killPlayer();
		}

		if (getBoundsLeft().intersects(p.getBounds())) {
			p.setHit(true);
			p.killPlayer();
		}
	}
	
	public void chasePlayer() {
		if (closestPlayer == null) {
			return;
		}
		
		Player p = closestPlayer;
		
		double pX = p.getX();
		double pY = p.getY();
		
		if (p.getZone() == "tz") {
			
			if (x > pX) {
				x-=3;
			}
			
			if (x < pX) {
				x+=3;
			}
			
			if (x == pX) {
				x+=3;
			}
			
			if (y > pY) {
				y-=3;
			}
			
			if (y < pY) {
				y+=3;
			}
			
			if (y == pY) {
				y+=3;
			}
		}
		
		if (p.getZone() == "51z") {
			
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
				y+=5;
			}
		}
		
	}
	
	public void searchForPlayer() {		
		double closestDist = 100000000;
		closestPlayer = null;
		for (int i = 0; i < gh.obj.size(); i++) {
			if (gh.obj.get(i).getId() == ObjectId.Player) {
				Player p = (Player) gh.obj.get(i);
				
				Collision(p);
				
				if (p.getZone() == "tz" || p.getZone() == "51z") {
					double playerDistance = Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2));
					
					if (playerDistance < 0) {
						playerDistance = playerDistance * -1;
					}
					
					if (playerDistance < closestDist) {
						closestDist = playerDistance;
						closestPlayer = p;
					}
				}
				
			}
		}
		
		//Added this to prevent a single player from attracting ALL enemies
		if (closestDist >= 2000) {
			closestPlayer = null;
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
