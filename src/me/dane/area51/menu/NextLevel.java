package me.dane.area51.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import me.dane.area51.Window;
import me.dane.area51.events.ButtonClickEvent;

public class NextLevel extends Menu{

	private static final long serialVersionUID = 1L;

	private static int levelNum = 1; 
	
	private JFrame game;
    private Window w;

    public NextLevel(JFrame game, Window w) {
        this.game = game;
        this.w = w;
        inMainMenu();
    }

    private void inMainMenu() {
        addMouseListener(new ButtonClickEvent(game, w));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        drawTitle(g, getHeight()/2, "Level " + Integer.toString(levelNum), Color.WHITE, "Comic Sans MS", 64, Font.BOLD);
    }
	
	public static void addLevel() {
		levelNum++;
	}
	
}
