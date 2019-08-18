package me.dane.area51.zone;

import java.awt.Color;
import java.awt.Graphics;

public class SafeZone extends Zone{

	public void display(Graphics g) {
		draw(g, Color.GREEN, 0f, -1000f, 1000f, 8000f);
	}
	
}
