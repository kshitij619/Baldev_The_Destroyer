package blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public class Block extends Rectangle {
	
	public int x, y;
	public static final int SIZE = GamePanel.tileSize ;
	public Color c;
	
	public Block(Color c) {
		this.c = c;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(c);
		g2.fillRect(x, y, SIZE, SIZE);
	}
}
