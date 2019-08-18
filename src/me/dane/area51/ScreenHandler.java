package me.dane.area51;

public class ScreenHandler {

	// 1 = menu
	// 2 = game
	
	private int screenNum;
	
	public ScreenHandler() {
		screenNum = 1;
	}
	
	public int getScreenNum() {
		return screenNum;
	}
	
	public void setScreenNum(int num) {
		this.screenNum = num;
	}
	
}
