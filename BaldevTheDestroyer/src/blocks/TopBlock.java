package blocks;

import java.awt.Color;

public class TopBlock extends DropBlocks {
	
	public TopBlock() {
		//create(Color.blue);
		b[0] = new Block(Color.blue);
	}
	
	public void setXY(int x, int y) {
		
		b[0].x = x;
		b[0].y = y;
	}
}
