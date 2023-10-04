package blocks;

import java.awt.Color;
import java.awt.Graphics2D;

import main.PlayManager;

public class DropBlocks {
	//DO NOT TOUCH
	public Block b[] = new Block[1];
	public Block tempB[] = new Block[1];
	//DO NOT TOUCH
	int autoDropCounter = 0;
	
	public void create(Color c) {
		
	}
	
	public void setXY(int x, int y) {
		
	}
	
	public void updateXY() {
		
	}
	
	public void update() {
		autoDropCounter++;
		if(autoDropCounter == PlayManager.dropInterval) {
			b[0].y += Block.SIZE/3;
			autoDropCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(b[0].c);
		g2.fillRect(b[0].x, b[0].y, Block.SIZE, Block.SIZE);
		
	}
}
