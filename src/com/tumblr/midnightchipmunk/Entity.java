package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import particles.com.tumblr.midnightchipmunk.Empty;

public class Entity{

	protected BufferedImage image;
	protected String entityType;
	protected int x;
	protected int y;
	protected double health;
	protected double attack;
	protected String facing;
	protected Map map;
	
	protected int timer;
	protected int delay;
	protected ArrayList<Particle> delayedParticle = new ArrayList<Particle>();
	protected boolean delayedAttack;
	
	public Entity() throws IOException{
		this.image = ImageIO.read(new File("resources/NoTexture.png"));
		this.entityType = "null";
		this.x = 1;
		this.y = 1;
		this.health = 10;
		this.attack = 1;
		this.map = null;
		facing = randomFacing();
	}	

	public void attack(Entity entity, Particle particle){
		entity.setHealth(entity.getHealth() - attack);
		map.spawnParticle(particle);
		
		if(entity.getHealth() <= 0){
			map.removeEntity(entity.getX(), entity.getY());
		}
	}
	
	public void attack(Entity entity) throws IOException{
		attack(entity, new Empty(getX(), getY(), getMap()));
	}
	
	public void attack(int x, int y, Particle particle){
		map.spawnParticle(particle);
		if(map.getEntityAt(x, y) != null){
			attack(map.getEntityAt(x, y), particle);
		}
	}
	
	public void attack(int x, int y) throws IOException{
		if(map.getEntityAt(x, y) != null){
			attack(map.getEntityAt(x, y), new Empty(getX(), getY(), getMap()));
		}
	}
	
	public ArrayList<Entity> getNearbyEntities(int range){
		
		ArrayList<Entity> entities = new ArrayList<Entity>();
		
		for(int i = 0; i <= range; i++){
			for(int j = 0; j <= range; j++){
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY())));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY())));
				entities.add(getMap().getEntityAt((this.getX()), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()), (this.getY()+j)));
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY()+j)));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY()+j)));
				
				if(entities.get(i) == this){
					entities.set(i, null);
				}
			}
		}
		
		return entities;
	}
	
	public void randomMovement()throws IOException{
		int random = (int)(Math.random()*100);
		if(random < 5){
				int moveRandom = (int)(Math.random()*4);
				if(moveRandom == 0){move("up");}
				else if(moveRandom == 1){move("down");}
				else if(moveRandom == 2){move("left");}
				else if(moveRandom == 3){move("right");}
		}
	}
	
	public void move(String direction) throws IOException{
		if(direction.equals("right")){
			setFacing("right");
			setImage(ImageIO.read(new File("resources/" + entityType + "Right.png")));
			
			if(getX() < Display.MAX_X){
				setX(getX()+1);
			}
		}else if(direction.equals("left")){
			setFacing("left");
			setImage(ImageIO.read(new File("resources/" + entityType + "Left.png")));
			
			if(getX() > 1){
				setX(getX()-1);
			}
		}else if(direction.equals("up")){
			setFacing("up");
			setImage(ImageIO.read(new File("resources/" + entityType + "Up.png")));
			
			if(getY() > 1){
				setY(getY()-1);
			}
		}else if(direction.equals("down")){
			setFacing("down");
			setImage(ImageIO.read(new File("resources/" + entityType + "Down.png")));
			
			if(getY() < Display.MAX_Y){
				setY(getY()+1);
			}
		}
	}
	
	public static String randomFacing(){
		int random = (int)(Math.random()*4);
		String facing;
		
		if(random == 0){facing = "up";
		}else if(random == 1){facing = "down";
		}else if(random == 2){facing = "right";
		}else{facing = "left";}
		
		return facing;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public String getEntityType(){
		return entityType;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public double getAttack(){
		return attack;
	}
	
	public double getHealth(){
		return health;
	}
	
	public String getFacing(){
		return facing;
	}
	
	public Map getMap(){
		return map;
	}
	
	public void setAttack(double attack){
		this.attack = attack;
	}
	
	public void setHealth(double health){
		this.health = health;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int setY(int y){
		return this.y = y;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	public void setEntityType(String type){
		this.entityType = type;
	}
	
	public void setFacing(String facing){
		this.facing = facing;
	}
	
	public void setMap(Map map){
		this.map = map;
	}
}
