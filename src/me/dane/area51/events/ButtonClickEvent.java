package me.dane.area51.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import me.dane.area51.ScreenHandler;
import me.dane.area51.Window;

public class ButtonClickEvent implements MouseListener {

	private ScreenHandler sh;
	private JFrame menu;
	private Window w;

	public ButtonClickEvent(JFrame menu, ScreenHandler sh, Window w) {
		this.sh = sh;
		this.menu = menu;
		this.w = w;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("test");
		if (sh.getScreenNum() == 1) {
			
			if ((e.getX() >= 160 && e.getX() <= e.getX() + 700) && (e.getY() >= 500 && e.getY() <= 500 + 100)) {
				sh.setScreenNum(2);
				System.out.println(sh.getScreenNum());
				w.checker();
				menu.dispose();
			}

			if ((e.getX() >= 160 && e.getX() <= e.getX() + 700) && (e.getY() >= 650 && e.getY() <= 650 + 100)) {
				menu.dispose();
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseClicked(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}