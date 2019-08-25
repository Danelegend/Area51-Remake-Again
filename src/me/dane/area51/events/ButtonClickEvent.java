package me.dane.area51.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import me.dane.area51.ScreenHandler;
import me.dane.area51.StaticWindow;
import me.dane.area51.Window;

public class ButtonClickEvent implements MouseListener {
	
	private JFrame menu;
	private Window w;

	public ButtonClickEvent(JFrame menu, Window w) {
		this.menu = menu;
		this.w = w;
	}

	public void mouseClicked(MouseEvent e) {
		if (ScreenHandler.getScreenNum() == 1) {
			
			if ((e.getX() >= 160 && e.getX() <= e.getX() + 700) && (e.getY() >= 500 && e.getY() <= 500 + 100)) {
				ScreenHandler.setScreenNum(2);
				System.out.println(ScreenHandler.getScreenNum());
				w.checker();
				menu.dispose();
			}

			if ((e.getX() >= 160 && e.getX() <= e.getX() + 700) && (e.getY() >= 650 && e.getY() <= 650 + 100)) {
				menu.dispose();
			}

		}
		
		if (ScreenHandler.getScreenNum() == 3) {
			menu.dispose();
			ScreenHandler.setScreenNum(2);
			StaticWindow.getWindow().checker();
		}
		
		if (ScreenHandler.getScreenNum() == 4) {
			menu.dispose();
			ScreenHandler.setScreenNum(5);
			StaticWindow.getWindow().checker();
		}
		
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
