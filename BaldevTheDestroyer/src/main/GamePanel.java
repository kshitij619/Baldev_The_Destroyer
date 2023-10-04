package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Baldev;
import entity.Hammer;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	final static int originalTileSize = 16; // 16x16 tile
	final static int scale = 4;
	
	public final static int tileSize = originalTileSize * scale; 	// 64x64 tile
	final static int maxScreenCol = 16;
	final static int maxScreenRow = 12;
	public final static int screenWidth = tileSize * maxScreenCol; 	// 1024 pixels
	public final static int screenHeight = tileSize * maxScreenRow; 	// 768 pixels
	
	//FPS
	int fps = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	PlayManager pm;
	Baldev baldev = new Baldev(this, keyH);
	Hammer hammer = new Hammer(this, keyH);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension (screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		pm = new PlayManager();
	}

	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/fps; 
		double delta = 0;
		long lastTime= System.nanoTime();
		long currentTime;
		long timer = 0;
		//long drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval; 
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				
				update();
				repaint();
				delta--;
				//drawCount++;
			}
			
			if (timer >= 1000000000) {
				
				//System.out.println("fps: " + drawCount);
				//drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		
		pm.update();
		
		baldev.update();
		
		hammer.update();
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		pm.draw(g2);
		
		baldev.draw(g2);
		
		hammer.draw(g2);
		
		g2.dispose();
	}
}
