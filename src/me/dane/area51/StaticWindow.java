package me.dane.area51;

public class StaticWindow {

	private static Window win;
	
	public static void setWindow(Window window) {
		win = window;
	}
	
	public static Window getWindow() {
		return win;
	}
	
}
