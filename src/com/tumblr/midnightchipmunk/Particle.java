package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;

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
	
	public Particle(int x, int y, int xOffset, int yOffset, String particleName, BufferedImage image, Map map, int removeDelay){
		this.x= (x+1)+xOffset;
		this.y = (y+1)+yOffset;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.image = image;
		this.particleName = particleName;
		this.map = map;
		this.removeDelay = removeDelay;
	}
	
	public Particle(int x, int y, String particleName, BufferedImage image, Map map, int removeDelay) {
		this.x= x;
		this.y = y;
		this.image = image;
		this.particleName = particleName;
		this.map = map;
		this.removeDelay = removeDelay;
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
		this.xOffset = xOffset;
	}
	
	public void setYOffset(int yOffset){
		this.yOffset = yOffset;
	}
	
	public void setTimer(int timer){
		this.timer = timer;
	}
	
	public void setRemoveDelay(int removeDelay){
		this.removeDelay = removeDelay;
	}
	
	public void delayCount(){
		timer+=1;
		
		if(timer >= removeDelay){
			map.removeParticle(x, y);
		}
	}
}
