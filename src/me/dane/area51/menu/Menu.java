package me.dane.area51.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Menu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private double height;
	private double width;
	
	private Image background;

	
	public Menu() {
		height = getSize().getHeight();
		width = getSize().getWidth();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (background != null) {
			g.drawImage(background, 0, 0, this);
		}
	}
	
	public void drawButton(Graphics g, int x, int y, int height, int width, Color buttonColor, String text, Color textColor, String font, int size, int style) {
		g.setColor(buttonColor);
		g.fillRect(x, y, width, height);
		
		Font stringFont = new Font(font, style, size);
		
		FontMetrics metrics = g.getFontMetrics(stringFont);
		
		x = ((getWidth() - metrics.stringWidth(text)) / 2);
		y = y + 18;
		
		g.setFont(stringFont);	
		g.setColor(textColor);
		g.drawString(text, x, y+height/2);
	}
	
	public void drawTitle(Graphics g, int y, String title, Color textColor, String font, int size, int style) {
		Font stringFont = new Font(font, style, size);
		FontMetrics metrics = g.getFontMetrics(stringFont);
		
		int x = ((getWidth() - metrics.stringWidth(title)) / 2);
		y = y + 18;
		
		g.setColor(textColor);
		g.setFont(stringFont);
		g.drawString(title, x, y);
	}
	
	public void setBackground(String location) {
		background = Toolkit.getDefaultToolkit().createImage(location);
	}
	
	public void changeBackgroundImage(String location) {
		background = Toolkit.getDefaultToolkit().createImage(location);
	}
 
	public double getFrameHeight() {
		return this.height;
	}
	
	public void setFrameHeight(int height) {
		this.height = height;
	}
	
	public double getFrameWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
}
