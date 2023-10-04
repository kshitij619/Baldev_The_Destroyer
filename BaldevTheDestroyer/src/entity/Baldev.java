package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Baldev extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Baldev (GamePanel gp,  KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		
		getBaldevImage();
	}
	
	public void setDefaultValues() {
		
		x = (gp.screenWidth - gp.tileSize) /2;
		y = (gp.screenHeight - gp.tileSize) /2;
		speed = 8;
		direction = "base";
	}
	
	public void getBaldevImage() {
		try {
			
			base = ImageIO.read(getClass().getResourceAsStream("/Baldev/Baldev_base.png"));
			up = ImageIO.read(getClass().getResourceAsStream("/Baldev/Baldev_up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/Baldev/Baldev_down.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/Baldev/Baldev_right.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/Baldev/Baldev_left.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (keyH.upPressed == true) {
			direction = "up";
//			y -= speed;
		}
		else if (keyH.downPressed == true) {
			direction = "down";
//			y += speed;
		}
		else if (keyH.rightPressed == true) {
			direction = "right";
//			x += speed;
		}
		else if (keyH.leftPressed == true) {
			direction = "left";
//			x -= speed;
		}
	}
	
	public void draw (Graphics g2) {
		
		BufferedImage image = base;
		
		switch(direction) {
		case "up":
			image = up;
			break;
		case "down":
			image = down;
			break;
		case "right":
			image = right;
			break;
		case "left":
			image = left;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
}
