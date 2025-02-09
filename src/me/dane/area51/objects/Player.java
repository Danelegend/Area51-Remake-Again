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

	private final float width = 48;
	private final float height = 96;

	private boolean isControlled;

	private final double POS_MAX_SPEED = 7;
	private final double NEG_MAX_SPEED = -7;

	private boolean narutoActive;
	private boolean narutoAvaliable;

	private boolean hit;

	private int counter;

	private GameHandler gh;
	private Enemy closestEnemy1;

	private int playerID;

	public Player(float x, float y, ObjectId id, GameHandler gh, int playerID) {
		super(x, y, id);

		this.playerID = playerID;
		this.gh = gh;

		counter = 0;

		hit = false;
		isControlled = false;
		narutoActive = false;
		narutoAvaliable = true;

		if (playerID == 0) {
			isControlled = true;
		}

	}

	public void tick(LinkedList<GameObject> obj) {
		
		//searchForNearestEnemy();
		
		if (narutoAvaliable == false) {
			counter++;
			resetCounter();
		}

		if (narutoActive) {
			velX = (float) (velX * 1.4);
			velY = (float) (velY * 1.4);
		}

		if (velX > POS_MAX_SPEED) {
			velX = (float) POS_MAX_SPEED;
		}

		if (velX < NEG_MAX_SPEED) {
			velX = (float) NEG_MAX_SPEED;
		}

		if (velY > POS_MAX_SPEED) {
			velY = (float) POS_MAX_SPEED;
		}

		if (velY < NEG_MAX_SPEED) {
			velY = (float) NEG_MAX_SPEED;
		}

		x += velX;
		y += velY;

		Collision(obj);

	}

	//Use this searching method if you want a max of one alien to attack 1 player.
	/*public void searchForNearestEnemy() {
		if (getZone() == "sz" || getZone() == "none") {
			return;
		}
		
		double closestEnemy = 1000000000;
		for (int i = 0; i < gh.obj.size(); i++) {
			if (gh.obj.get(i).getId() == ObjectId.Enemy) {
				Enemy e = (Enemy) gh.obj.get(i);
				double distance = Math.sqrt(Math.pow((x - e.getX()), 2) + Math.pow((y - e.getY()), 2));
				if (distance < 0) {
					distance = distance * -1;
				}
				if (distance < closestEnemy) {
					closestEnemy = distance;
					closestEnemy1 = e;
				}
			}
		}
		
		closestEnemy1.chasePlayer(this);
		
	}*/
	
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

	public void killPlayer() {
		gh.killPlayerForEnemy();
		Score.removePlayer();
		System.out.println(Score.getAmountOfPlayersLeft() + "/" + Score.getAmountOfPlayers());
	}

	private void Collision(LinkedList<GameObject> obj) {
		for (int i = 0; i < gh.obj.size(); i++) {
			GameObject tempObj = gh.obj.get(i);

			if (tempObj.getId() == ObjectId.Block) {
				
				if (x > 64 && x < 4400 && y > 64 && y < 6800) {
					return;
				}
				
				if (getBoundsTop().intersects(tempObj.getBounds())) {
					y = tempObj.getY() + 32;
				}

				if (getBounds().intersects(tempObj.getBounds())) {
					y = tempObj.getY() - height;
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

	public boolean narutoActive() {
		return narutoActive;
	}

	public void setNarutoActive(boolean boo) {
		this.narutoActive = boo;
	}

	public void setNarutoAvaliable(boolean boo) {
		this.narutoAvaliable = boo;
	}

	private void resetCounter() {

		if (counter >= 100) {
			narutoActive = false;
		}

		if (counter >= 1100) {
			narutoAvaliable = true;
			counter = 0;
		}
	}

	public String getZone() {
		if (x >= 0 && x <= 1000) {
			return "sz";
		}

		if (x > 1000 && x <= 4000) {
			return "tz";
		}

		if (x > 4000 && x <= 5500) {
			return "51z";
		}

		return "none";
	}

	public boolean isHit() {
		return hit;
	}
	
	public void setHit(boolean boo) {
		this.hit = boo;
	}

}
