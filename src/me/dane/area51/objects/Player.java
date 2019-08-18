package me.dane.area51.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;

import me.dane.area51.GameHandler;
import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;

public class Player extends GameObject {

	private float width = 48;
	private float height = 96;
	
	private float gravity = 0.5f;
	
	private final float MAX_SPEED = 9.8f;
	
	private boolean isControlled;
	
	private GameHandler gh;
	
	private int playerID;
	
	public Player(float x, float y, ObjectId id, GameHandler gh, int playerID) {
		super(x, y, id);
		
		this.playerID = playerID;
		this.gh = gh;
		
		isControlled = false;
		
		if (playerID == 0) {
			isControlled = true;
		}
		
	}

	public void tick(LinkedList<GameObject> obj) {
		x += velX;
		y += velY;
		
		Collision(obj);
		
	}

	public void render(Graphics g) {
		String location = "5c8e54cf893930029d46f820.png";
		Image img = Toolkit.getDefaultToolkit().getImage(location);

		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
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

	
	private void Collision(LinkedList<GameObject> obj) {
		for (int i = 0; i < gh.obj.size(); i++) {
			GameObject tempObj = gh.obj.get(i);
			
			if (tempObj.getId() == ObjectId.Block) {
				
				if (getBoundsTop().intersects(tempObj.getBounds())) {
					y = tempObj.getY() + 32;
					velY = 0;
				}
				
				if (getBounds().intersects(tempObj.getBounds())) {
					y = tempObj.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				} else {
					falling = true;
				}
				
				if (getBoundsRight().intersects(tempObj.getBounds())) {
					x = tempObj.getX() - width;
				}
				
				if (getBoundsLeft().intersects(tempObj.getBounds())) {
					x = tempObj.getX() + 33;
				}
				
			}
			
		}
	}
	
	public void setControlled(boolean controlled) {
		this.isControlled = controlled;
	}
	
	public boolean isControlled() {
		return isControlled;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	
}
