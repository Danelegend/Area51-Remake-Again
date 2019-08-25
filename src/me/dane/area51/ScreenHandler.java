package me.dane.area51;

public class ScreenHandler {

	// 1 = menu
	// 2 = game
	
	private static int screenNum = 1;
	
	public static int getScreenNum() {
		return screenNum;
	}
	
	public static void setScreenNum(int num) {
		screenNum = num;
	}
	
}
