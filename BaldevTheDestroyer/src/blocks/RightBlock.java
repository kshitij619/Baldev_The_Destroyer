package blocks;

import java.awt.Color;

public class RightBlock extends DropBlocks {
	
	public RightBlock() {
		//create(Color.blue);
		b[0] = new Block(Color.orange);
	}
	
	public void setXY(int x, int y) {
		
		b[0].x = x;
		b[0].y = y;
	}
}
