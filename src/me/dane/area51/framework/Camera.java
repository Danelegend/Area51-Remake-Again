package me.dane.area51.framework;

import me.dane.area51.Main;

public class Camera {

	private float x;
	private float y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject player) {
		x = -player.getX() + Main.WIDTH/2;
		y = -player.getY() + Main.HEIGHT/2;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
}
