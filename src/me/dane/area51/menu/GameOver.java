package me.dane.area51.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import me.dane.area51.Window;
import me.dane.area51.events.ButtonClickEvent;

public class GameOver extends Menu {

	private static final long serialVersionUID = 1L;
	
	private JFrame game;
    private Window w;

    public GameOver(JFrame game, Window w) {
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

        drawTitle(g, getHeight()/2, "Game Over!", Color.WHITE, "Comic Sans MS", 64, Font.BOLD);
        drawTitle(g, (int) ((int) getHeight()/1.7), "Click to play again!", Color.WHITE, "Comic Sans MS", 32, Font.BOLD);
        
    }

}
