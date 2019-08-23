package me.dane.area51.menu;

import me.dane.area51.ScreenHandler;
import me.dane.area51.Window;
import me.dane.area51.events.ButtonClickEvent;

import javax.swing.*;
import java.awt.*;

public class GameOver extends Menu {

    private JFrame game;
    private ScreenHandler sh;
    private Window w;

    public GameOver(JFrame game, ScreenHandler sh, Window w) {
        this.game = game;
        this.sh = sh;
        this.w = w;
        inMainMenu();
    }

    private void inMainMenu() {
        setBackground("MainMenuBackground.jpg");
        addMouseListener(new ButtonClickEvent(game, sh, w));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        drawTitle(g, getHeight()/2, "Game Over!", Color.WHITE, "Comic Sans MS", 64, Font.BOLD);
    }

}
