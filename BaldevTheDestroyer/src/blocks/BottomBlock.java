package blocks;

import java.awt.Color;

public class BottomBlock extends DropBlocks {
	
	public BottomBlock() {
		//create(Color.blue);
		b[0] = new Block(Color.green);
	}
	
	public void setXY(int x, int y) {
		
		b[0].x = x;
		b[0].y = y;
	}
}