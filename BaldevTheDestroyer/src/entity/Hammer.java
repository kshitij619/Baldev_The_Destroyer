package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Hammer extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Hammer (GamePanel gp,  KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		
		getBaldevImage();
	}
	
	public void setDefaultValues() {
		
		x = (gp.screenWidth - gp.tileSize) /2 + 30;
		y = (gp.screenHeight - gp.tileSize) /2 - 30 ;
		speed = 16;
		direction = "base";
	}
	
	public void getBaldevImage() {
		try {

			up = ImageIO.read(getClass().getResourceAsStream("/Hammer/Hammer_up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/Hammer/Hammer_down.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/Hammer/Hammer_right.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/Hammer/Hammer_left.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		}
		else if (keyH.downPressed == true) {
			direction = "down";
			y += speed;
		}
		else if (keyH.rightPressed == true) {
			direction = "right";
			x += speed;
		}
		else if (keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		}
	}
	
	public void draw (Graphics g2) {
		
		BufferedImage image = up;
		
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
