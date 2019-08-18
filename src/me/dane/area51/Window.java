 package me.dane.area51;

import java.awt.Dimension;

import javax.swing.JFrame;

import me.dane.area51.menu.MainMenu;

public class Window {
	
	private ScreenHandler sh;
	private String title;
	
	private Main game;
	
	public Window(int w, int h, String title, Main game) {
		this.sh = game.getScreenHandler();
		this.title = title;
		
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));

		this.game = game;
	}
	
	public void checker() {
		if (sh.getScreenNum() == 1) {
			JFrame f = new JFrame("Menu");
			f.add(new MainMenu(f, sh, this));
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		
		if (sh.getScreenNum() == 2) {
			JFrame f = new JFrame(title);
			f.add(game);
			f.pack();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			
			game.start();
		}
		
	}
	
}
