package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import blocks.TopBlock;
import blocks.RightBlock;
import blocks.LeftBlock;
import blocks.Block;
import blocks.BottomBlock;

public class PlayManager {

	//Main Play Area
	final int maxPlayCol = 14;
	public final int maxPlayRow = 10;
	public final int maxPlayWidth = maxPlayCol * GamePanel.tileSize;
	public final int maxPlayHeight = maxPlayRow * GamePanel.tileSize;
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public static int bottom_y;
	
	//Blocks   ////
	TopBlock topBlock ;
	RightBlock rightBlock ;
	LeftBlock leftBlock ;
	BottomBlock bottomBlock ;
	
	final int startTopX;
	final int startTopY;
	
	final int startRightX;
	final int startRightY;
	
	final int startLeftX;
	final int startLeftY;
	
	final int startBottomX;
	final int startBottomY;
	
	//Others
	public static int dropInterval = 10;
	
	public PlayManager() {
		
		//Play Area Frame
		left_x = (GamePanel.screenWidth - maxPlayWidth)/2;
		right_x = left_x + maxPlayWidth;
		top_y = GamePanel.tileSize + 16;
		bottom_y = top_y + maxPlayHeight;
		
		//Block Start Point
		startTopX = (left_x + maxPlayWidth) / 2;
		startTopY = top_y;
		
		startRightX = right_x;
		startRightY = (top_y + maxPlayHeight) / 2;
		
		startLeftX = left_x;
		startLeftY = (top_y + maxPlayHeight) / 2;
		
		startBottomX = (left_x + maxPlayWidth) / 2;
		startBottomY = bottom_y;
		
		//Set the starting block
		topBlock = new TopBlock();
		topBlock.setXY(startTopX, startTopY);
		
		rightBlock = new RightBlock();
		rightBlock.setXY(startRightX - Block.SIZE, startRightY);
		
		leftBlock = new LeftBlock();
		leftBlock.setXY(startLeftX, startLeftY);
		
		bottomBlock = new BottomBlock();
		bottomBlock.setXY(startBottomX, startBottomY - Block.SIZE);
	}
	
	public void update() {
		
		topBlock.update();
		rightBlock.update();
		leftBlock.update();
		bottomBlock.update();
	}

	public void draw(Graphics2D g2) {
		
		//Draw Play Area Frame
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4f));
		g2.drawRect(left_x-4, top_y-4, maxPlayWidth+8, maxPlayHeight+8);
		
		//Top Bar
		int x = left_x;
		int y = top_y-32;
		g2.setFont(new Font("Arial", Font.PLAIN, 30));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("SCORE : ", x, y);
		
		//Draw current block
		if(topBlock != null) {
			topBlock.draw(g2);
		}
		if(rightBlock != null) {
			rightBlock.draw(g2);
		}
		if(leftBlock != null) {
			leftBlock.draw(g2);
		}
		if(bottomBlock != null) {
			bottomBlock.draw(g2);
		}
	}
}
