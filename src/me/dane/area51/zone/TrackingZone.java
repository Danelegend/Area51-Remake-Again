package me.dane.area51.zone;

import java.awt.Color;
import java.awt.Graphics;

public class TrackingZone extends Zone {

	public void display(Graphics g) {
		draw(g, Color.BLUE, 1000f, -1000f, 3000f, 8000f);
	}
	
}
