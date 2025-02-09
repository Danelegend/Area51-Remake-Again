package me.dane.area51.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;

public class Block extends GameObject {

	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> obj) {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect((int) x, (int) y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}


}
