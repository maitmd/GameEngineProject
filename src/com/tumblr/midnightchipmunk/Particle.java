package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Particle extends Entity{

	int x;
	int y;
	int xOffset;
	int yOffset;
	BufferedImage image;
	Map map;
	
	public Particle(BufferedImage image, int x, int y, int xOffset, int yOffset, Map map){
		super(image, (x + (xOffset)), (y + (yOffset)), map);
	}
	
	public void animate(int frames) throws InterruptedException, IOException{
		for(int i = 1; i <= frames; i++){
			setImage(ImageIO.read(new File("resources/" + getEntityType() + i + ".png")));
			Thread.sleep(50);
		}
	}
}
