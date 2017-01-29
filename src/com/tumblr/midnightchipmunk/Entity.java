package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
	protected ArrayList<Integer> delayedX = new ArrayList<Integer>();
	protected ArrayList<Integer> delayedY = new ArrayList<Integer>();
	protected ArrayList<Particle> delayedParticle = new ArrayList<Particle>();
	protected boolean delayedAttack;
	
	public Entity(BufferedImage image, String entityType, int x, int y, double health, double attack, Map map){
		this.image = image;
		this.entityType = entityType;
		this.x = x+1;
		this.y = y+1;
		this.health = health;
		this.attack = attack;
		this.map = map;
		facing = randomFacing();
	}	
	
	public Entity(BufferedImage image, int x, int y, Map map){
		this.image = image;
		this.x = x+1;
		this.y = y+1;
		this.map = map;
		health = 1;
		attack = 1;
		entityType = "entity";
	}
	
	public Entity(BufferedImage image, int x, int y, double health, double attack, Map map){
		this.image = image;
		this.x = x+1;
		this.y = y+1;
		this.map = map;
		this.health = health;
		this.attack = attack;
		entityType = "entity";
	}
	
	public Entity(String entityType, int x, int y, double health, double attack, Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		this.entityType = entityType;
		this.x = x+1;
		this.y = y+1;
		this.health = health;
		this.attack = attack;
		this.map = map;
		facing = randomFacing();
	}
	
	public Entity(int x, int y, Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		entityType = "entity";
		this.x = x+1;
		this.y = y+1;
		health = 5;
		attack = 1;
		this.map = map;
		facing = randomFacing();
	}
	
	public Entity(Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		entityType = "entity";
		x = 1;
		y = 1;
		health = 5;
		attack = 1;
		this.map = map;
		facing = randomFacing();
	}
	
	public void attack(Entity entity, Particle particle){
		entity.setHealth(entity.getHealth() - attack);
		map.spawnParticle(particle);
		
		if(entity.getHealth() <= 0){
			map.removeEntity(entity.getX(), entity.getY());
		}
	}
	
	public void attack(int x, int y, Particle particle){
		if(map.getEntityAt(x, y) != null){
			attack(map.getEntityAt(x, y), particle);
		}
	}
	
	public ArrayList<Entity> getNearbyEntities(int range){
		
		ArrayList<Entity> entities = new ArrayList<Entity>();
		
		for(int i = 1; i <= range; i++){
			for(int j = 1; j <= range; j++){
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY())));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY())));
				entities.add(getMap().getEntityAt((this.getX()), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()), (this.getY()+j)));
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()+i), (this.getY()+j)));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY()-j)));
				entities.add(getMap().getEntityAt((this.getX()-i), (this.getY()+j)));
			}
		}
		
		return entities;
	}
	
	public void randomMovement()throws IOException{
		int random = (int)(Math.random()*100);
		
		if(random < 5){
				int moveRandom = (int)(Math.random()*4);
				switch(moveRandom){
					case 0:
						
						setFacing("up");
						setImage(ImageIO.read(new File("resources/" + entityType + "Up.png")));
						
						if(getY() > 1){
							setY(getY()-1);
						}
						
						break;
					case 1:
						setFacing("down");
						setImage(ImageIO.read(new File("resources/" + entityType + "Down.png")));
						
						if(getY() < Display.MAX_Y){
							setY(getY()+1);
						}
						
						break;
					case 2:
						setFacing("left");
						setImage(ImageIO.read(new File("resources/" + entityType + "Left.png")));
						
						if(getX() > 1){
							setX(getX()-1);
						}
						
						break;
						
					case 3:
						setFacing("right");
						setImage(ImageIO.read(new File("resources/" + entityType + "Right.png")));
						
						if(getX() < Display.MAX_X){
							setX(getX()+1);
						}
						
						break;
					}
		}
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
	
	public static String randomFacing(){
		int random = (int)(Math.random()*4);
		String facing;
		
		if(random == 0){
			facing = "up";
		}else if(random == 1){
			facing = "down";
		}else if(random == 2){
			facing = "right";
		}else{
			facing = "left";
		}
		
		return facing;
	}
}
