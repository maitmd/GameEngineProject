package com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wisp extends Entity{

	Map map;
	
	public Wisp(int x, int y, Map map) throws IOException {
		super("Wisp" , x, y, 10, 0.5, map);
		this.map = map;
		
		if(getFacing().equals("up")){
			setImage(ImageIO.read(new File("resources/WispUp.png")));
		}else if(getFacing().equals("down")){
			setImage(ImageIO.read(new File("resources/WispDown.png")));
		}else if(getFacing().equals("left")){
			setImage(ImageIO.read(new File("resources/WispLeft.png")));
		}else if(getFacing().equals("right")){
			setImage(ImageIO.read(new File("resources/WispRight.png")));
		}
	}
	
	public Wisp(Map map) throws IOException {
		super(map);
		this.map = map;
		
		if(getFacing().equals("up")){
			setImage(ImageIO.read(new File("resources/WispUp.png")));
		}else if(getFacing().equals("down")){
			setImage(ImageIO.read(new File("resources/WispDown.png")));
		}else if(getFacing().equals("left")){
			setImage(ImageIO.read(new File("resources/WispLeft.png")));
		}else if(getFacing().equals("right")){
			setImage(ImageIO.read(new File("resources/WispRight.png")));
		}
	}
	
	public void attack(){
		if(map.getEntityAt(getX()-1, getY()) != null && map.getEntityAt(getX()-1, getY()).getEntityType().equals("player")){
			attack(getX()-1, getY());
		}else if(map.getEntityAt(getX()+1, getY()) != null && map.getEntityAt(getX()+1, getY()).getEntityType().equals("player")){
			attack(getX()+1, getY());
		}else if(map.getEntityAt(getX(), getY()-1) != null && map.getEntityAt(getX(), getY()-1).getEntityType().equals("player")){
			attack(getX(), getY()-1);
		}else if(map.getEntityAt(getX(), getY()+1) != null && map.getEntityAt(getX(), getY()+1).getEntityType().equals("player")){
			attack(getX(), getY()+1);
		}else if(map.getEntityAt(getX()-1, getY()-1) != null && map.getEntityAt(getX()-1, getY()-1).getEntityType().equals("player")){
			attack(getX()-1, getY()-1);
		}else if(map.getEntityAt(getX()-1, getY()+1) != null && map.getEntityAt(getX()-1, getY()+1).getEntityType().equals("player")){
			attack(getX()-1, getY()+1);
		}else if(map.getEntityAt(getX()+1, getY()-1) != null && map.getEntityAt(getX()+1, getY()-1).getEntityType().equals("player")){
			attack(getX()+1, getY()-1);
		}else if(map.getEntityAt(getX()+1, getY()+1) != null && map.getEntityAt(getX()+1, getY()+1).getEntityType().equals("player")){
			attack(getX()+1, getY()+1);
		}
	}
}
