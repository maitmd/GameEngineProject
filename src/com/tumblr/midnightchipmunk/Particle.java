package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Particle{

	protected int x;
	protected int y;
	protected int xOffset;
	protected int yOffset;
	protected BufferedImage image;
	protected String particleName;
	protected Map map;
	protected int removeDelay;
	protected int timer = 0;
	
	public Particle() throws IOException{
		this.x= 1;
		this.y = 1;
		this.xOffset = 0;
		this.yOffset = 0;
		this.image = ImageIO.read(new File("resources/Empty.png"));
		this.particleName = "null";
		this.map = null;
		this.removeDelay = 0;
	}

	public void delayCount(){
		timer++;
		
		if(timer >= removeDelay){
				getMap().removeParticle(this);
		}
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getXOffset(){
		return xOffset;
	}
	
	public int getYOffset(){
		return yOffset;
	}
	
	public String getParticleName(){
		return particleName;
	}
	
	public int getTimer(){
		return timer;
	}
	
	public int getRemoveDelay(){
		return removeDelay;
	}
	
	public Map getMap(){
		return map;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setXOffset(int xOffset){
		this.x= (x+1)+xOffset;
	}
	
	public void setYOffset(int yOffset){
		this.y = (y+1)+yOffset;
	}
	
	public void setTimer(int timer){
		this.timer = timer;
	}
	
	public void setRemoveDelay(int removeDelay){
		this.removeDelay = removeDelay;
	}
	
	public void setMap(Map map){
		this.map = map;
	}
	
	public void setParticleName(String particleName){
		this.particleName = particleName;
	}
}
