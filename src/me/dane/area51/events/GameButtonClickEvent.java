package me.dane.area51.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import me.dane.area51.ScreenHandler;
import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;
import me.dane.area51.objects.Player;

public class GameButtonClickEvent implements MouseListener{

	private LinkedList<GameObject> obj;
	
	public GameButtonClickEvent(LinkedList<GameObject> obj) {
		this.obj = obj;
	}


	public void mouseClicked(MouseEvent e) {
		if (ScreenHandler.getScreenNum() == 2) {
			for (int i = 0; i < obj.size(); i++) {
				if (obj.get(i).getId() == ObjectId.Player) {
					Player p = (Player) obj.get(i);
					if (p.isControlled()) {
						return;
					}
					
					if ((e.getX() >= p.getX() && e.getX() <= p.getX() + 48) && (e.getY() >= p.getY() && e.getY() <= e.getY() + 96)) {
						for (int i2 = 0; i2 < obj.size(); i2++) {
							if (obj.get(i2).getId() == ObjectId.Player) {
								Player p2 = (Player) obj.get(i2);
								p2.setControlled(false);
							}
						}
						p.setControlled(true);
					}
				}
			}
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
