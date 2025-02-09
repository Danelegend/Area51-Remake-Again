package me.dane.area51.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import me.dane.area51.Window;
import me.dane.area51.events.ButtonClickEvent;

public class MainMenu extends Menu {
	private static final long serialVersionUID = 1L;
	
	private JFrame game;
	private Window w;
	
	public MainMenu(JFrame game, Window w) {	
		this.game = game;
		this.w = w;
		inMainMenu();
	}
	
	private void inMainMenu() {
		setBackground("MainMenuBackground.jpg");
		addMouseListener(new ButtonClickEvent(game, w));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawTitle(g, 75, "Area51", Color.CYAN, "Comic Sans MS", 70, Font.PLAIN);
		drawButton(g, 160, 500, 100, 700, Color.RED, "test", Color.BLACK, "Comic Sans MS", 70, Font.PLAIN);
		drawButton(g, 160, 650, 100, 700, Color.RED, "test2", Color.BLACK, "Comic Sans MS", 70, Font.PLAIN);
	}
	
}
