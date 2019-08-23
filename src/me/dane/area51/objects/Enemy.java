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
	
    public Enemy(float x, float y, ObjectId id, GameHandler gh) {
        super(x, y, id);
        this.gh = gh;


        String loc = "Cleveland.png";
        
        img = Toolkit.getDefaultToolkit().getImage(loc);
    }

    public void tick(LinkedList<GameObject> obj) {

    }

	public void render(Graphics g) {
		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
	}
	
	public void chasePlayer(Player p) {

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
