package me.dane.area51.zone;

import java.awt.Color;
import java.awt.Graphics;

public class Area51Zone extends Zone{

	public void display(Graphics g) {
		draw(g, Color.RED, 4000f, -1000f, 1500f, 8000f);
	}
	
}
