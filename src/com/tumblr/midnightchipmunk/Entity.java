package com.tumblr.midnightchipmunk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity{

	private BufferedImage image;
	private String entityType;
	private int x;
	private int y;
	private double health;
	private double attack;
	private String facing;
	private Map map;
	
	public Entity(BufferedImage image, String entityType, int x, int y, double health, double attack, Map map){
		this.image = image;
		this.entityType = entityType;
		this.x = x;
		this.y = y;
		this.health = health;
		this.attack = attack;
		this.map = map;
		facing = randomFacing();
	}	
	
	public Entity(String entityType, int x, int y, double health, double attack, Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		this.entityType = entityType;
		this.x = x;
		this.y = y;
		this.health = health;
		this.attack = attack;
		this.map = map;
		facing = randomFacing();
	}
	
	public Entity(int x, int y, Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		entityType = "entity";
		this.x = x;
		this.y = y;
		health = 5;
		attack = 1;
		this.map = map;
		facing = randomFacing();
	}
	
	public Entity(Map map) throws IOException{
		image = ImageIO.read(new File("resources/NoTexture.png"));
		entityType = "entity";
		x = 0;
		y = 0;
		health = 5;
		attack = 1;
		this.map = map;
		facing = randomFacing();
	}
	
	public void attack(Entity entity){
		entity.setHealth(entity.getHealth() - attack);
		if(entity.getHealth() <= 0){
			map.removeEntity(entity.getX(), entity.getY());
		}
	}
	
	public void attack(int x, int y){
		if(map.getEntityAt(x, y) != null){
			map.getEntityAt(x, y).setHealth(map.getEntityAt(x, y).getHealth() - attack);
			if(map.getEntityAt(x,y).getHealth() <= 0){
				map.removeEntity(x,y);
			}
		}
	}
	
	public void randomMovement(){
		int random = (int)(Math.random()*100);
		
		if(random < 5){
			try{
				int moveRandom = (int)(Math.random()*4);
				boolean temp;
				switch(moveRandom){
					case 0:
						temp = map.moveEntity(getX(), getY(), getX(), getY()-1);
						
						setFacing("up");
						setImage(ImageIO.read(new File("resources/" + entityType + "Up.png")));
						
						if(temp){
							setY(getY()-1);
						}
						
						break;
					case 1:
						temp = map.moveEntity(getX(), getY(), getX(), getY()+1);
						
						setFacing("down");
						setImage(ImageIO.read(new File("resources/" + entityType + "Down.png")));
						
						if(temp){
							setY(getY()+1);
						}
						
						break;
					case 2:
						temp = map.moveEntity(getX(), getY(), getX()-1, getY());
						
						setFacing("left");
						setImage(ImageIO.read(new File("resources/" + entityType + "Left.png")));
						
						if(temp){
							setX(getX()-1);
						}
						
						break;
						
					case 3:
						temp = map.moveEntity(getX(), getY(), getX()+1, getY());
						
						setFacing("right");
						setImage(ImageIO.read(new File("resources/" + entityType + "Right.png")));
						
						if(temp){
							setX(getX()+1);
						}
						
						break;
					}
			}catch(Exception e){
				e.printStackTrace();
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
