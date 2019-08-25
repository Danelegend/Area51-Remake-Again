 package me.dane.area51;

import java.awt.Dimension;

import javax.swing.JFrame;

import me.dane.area51.menu.GameOver;
import me.dane.area51.menu.MainMenu;
import me.dane.area51.menu.NextLevel;

public class Window {
	
	private String title;
	
	private Main game;
	
	private int amountOfPlayers;
	private int amountOfEnemies;
	private int amountOfAliens;
	
	private int w;
	private int h;
	
	private JFrame f;
	
	public Window(int w, int h, String title) {
		this.title = title;
		
		this.w = w;
		this.h = h;
		
	}
	
	public void checker() {
		if (ScreenHandler.getScreenNum() == 1) {
			f = new JFrame("Menu");
			f.add(new MainMenu(f, this));
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		
		if (ScreenHandler.getScreenNum() == 2) {
			game = new Main(new GameHandler(10, 51, 10));		
			
			game.setPreferredSize(new Dimension(w, h));
			game.setMaximumSize(new Dimension(w, h));
			game.setMinimumSize(new Dimension(w, h));
			
			f = new JFrame(title);
			f.add(game);
			f.pack();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			
			game.start();
		}
		
		if (ScreenHandler.getScreenNum() == 3) {
			//Run Game Over
			f.dispose();
			f = new JFrame(title);
			f.add(new GameOver(f, this));
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		
		if (ScreenHandler.getScreenNum() == 4) {
			f.dispose();
			f = new JFrame(title);
			f.add(new NextLevel(f, this));
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		
		if (ScreenHandler.getScreenNum() == 5) {
			f.dispose();
			ScreenHandler.setScreenNum(6);
		}
		
		if (ScreenHandler.getScreenNum() == 6) {
			// Run 2nd onwards iterations of game
			game = new Main(new GameHandler(amountOfPlayers, amountOfAliens, amountOfEnemies));
			
			game.setPreferredSize(new Dimension(w, h));
			game.setMaximumSize(new Dimension(w, h));
			game.setMinimumSize(new Dimension(w, h));
			
			f = new JFrame(title);
			f.add(game);
			f.pack();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			
			game.start();
		}
		
	}
	
	public void setAmountOfPlayers(int amountOfPlayers) {
		this.amountOfPlayers = amountOfPlayers;
	}
	
	public void setAmountOfAliens(int amountOfAliens) {
		this.amountOfAliens = amountOfAliens;
	}
	
	public void setAmountOfEnemies(int amountOfEnemies) {
		this.amountOfEnemies = amountOfEnemies;
	}
	
	public int getAmountOfPlayers() {
		return amountOfPlayers;
	}
	
	public int getAmountOfAliens() {
		return amountOfAliens;
	}
	
	public int getAmountOfEnemies() {
		return amountOfEnemies;
	}
	
}
