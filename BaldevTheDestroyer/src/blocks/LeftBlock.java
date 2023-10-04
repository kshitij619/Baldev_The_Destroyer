package blocks;

import java.awt.Color;

public class LeftBlock extends DropBlocks {
	
	public LeftBlock() {
		//create(Color.blue);
		b[0] = new Block(Color.yellow);
	}
	
	public void setXY(int x, int y) {
		
		b[0].x = x;
		b[0].y = y;
	}
}