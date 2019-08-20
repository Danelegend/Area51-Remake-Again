package me.dane.area51.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import me.dane.area51.framework.Camera;

public class Score {

	private int score;
	private FontMetrics metrics;
	private Font font;
	
	private int width;
	private String title;
	
	private Camera cam;
	
	public Score(int width, Camera cam) {
		score = 0;
		
		this.cam = cam;
		
		title = Integer.toString(score);
		
		this.width = width;
		
		font = new Font("Comic Sans MS", 1, 108);
	}
	
	public void addScore() {
		score++;
		title = Integer.toString(score);
	}
	
	public void display(Graphics g) {
		metrics = g.getFontMetrics(font);
		
		int x = 100;
		int y = 100;
		
		//int x = (int) cam.getX() + 50;
		//int y = (int) cam.getY() + 50;
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(title, x, y);
	}
	
}
