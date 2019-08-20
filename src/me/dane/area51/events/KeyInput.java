package me.dane.area51.events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.dane.area51.GameHandler;
import me.dane.area51.framework.Camera;
import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;
import me.dane.area51.objects.Player;

public class KeyInput extends KeyAdapter {

	private GameHandler gh;
	private Camera cam;
	
	public KeyInput(GameHandler gh, Camera cam) {
		this.gh = gh;
		this.cam = cam;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		char c = e.getKeyChar();
		
		if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					p.setControlled(false);
				}
				
			}
		}
		
		if (c == '0') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 0) {
						p.setControlled(true);
						cam.setX(p.getX());

					}
					
				}
				
			}
		}
		
		if (c == '1') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 1) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '2') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 2) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '3') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 3) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '4') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 4) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '5') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 5) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '6') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 6) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '7') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 7) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '8') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 8) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (c == '9') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.getPlayerID() == 9) {
						p.setControlled(true);
						cam.setX(p.getX());
					}
					
				}
				
			}
		}
		
		if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					p.setControlled(true);
					cam.setY(p.getY());
					cam.setX(p.getX());
				}
				
			}
		}
		
		if (e.getKeyChar() == 'N' || e.getKeyChar() == 'n') {
			for (int i = 0; i < gh.obj.size(); i++) {
				GameObject tempObj = gh.obj.get(i);
				
				if (tempObj.getId() == ObjectId.Player) {
					Player p = (Player) tempObj;
					
					if (p.isControlled()) {
						if (p.narutoActive() == false) {
							p.setNarutoActive(true);
							p.setNarutoAvaliable(false);
						}
					}
					
				}
				
			}
		}
		
		for (int i = 0; i < gh.obj.size(); i++) {
			GameObject tempObj = gh.obj.get(i);
			
			if (tempObj.getId() == ObjectId.Player) {
				Player p = (Player) tempObj;
				
				if (p.isControlled()) {
				
					if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
						tempObj.setVelX(5);
					}
					
					if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
						tempObj.setVelX(-5);
					}
					
					if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
						tempObj.setVelY(-5);
					}
					
					if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
						tempObj.setVelY(5);
					}
				}
				
			}
			
		}
		
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < gh.obj.size(); i++) {
			GameObject tempObj = gh.obj.get(i);
			
			if (tempObj.getId() == ObjectId.Player) {
				if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
					tempObj.setVelX(0);
				}
				
				if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
					tempObj.setVelX(0);
				}
				
				if (e.getKeyChar() == 'W' || e.getKeyChar() == 'w') {
					tempObj.setVelY(0);
				}
				
				if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
					tempObj.setVelY(0);
				}
				
			}
			
		}
	}
	
}
