package me.dane.area51.zone;

import java.awt.Color;
import java.awt.Graphics;

public class Zone {

	public void draw(Graphics g, Color c, float x, float y, float w, float h) {
		g.setColor(c);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
	}
	
}
