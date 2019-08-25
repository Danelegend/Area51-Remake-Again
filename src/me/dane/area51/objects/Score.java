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
	
	private static int amountOfAliens = 0;
	private static int capturedAliens = 0;
	
	private static int amountOfPlayers = 0;
	private static int playersLeft = 0;
	
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
	
	public static void addPlayer() {
		amountOfPlayers++;
		playersLeft++;
	}
	
	public static void removePlayer() {
		playersLeft--;
		if (playersLeft < 0) {
			playersLeft = 0;
		}
	}
	
	public static void addAlien() {
		amountOfAliens++;
	}
	
	public static void capturedAliens() {
		capturedAliens++;
	}
	
	public static int getAmountOfCapturedAliens() {
		return capturedAliens;
	}
	
	public static int getAmountOfAliens() {
		return amountOfAliens;
	}
	
	public static int getAmountOfPlayers() {
		return amountOfPlayers;
	}

	public static int getAmountOfPlayersLeft() {
		return playersLeft;
	}
	
	public static void reset() {
		playersLeft = 0;
		amountOfPlayers = 0;
		amountOfAliens = 0;
		capturedAliens = 0;
	}
	
}
