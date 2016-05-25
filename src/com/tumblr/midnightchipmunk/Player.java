package com.tumblr.midnightchipmunk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Entity implements KeyListener{

	private Map map;
	
	public Player(int x, int y, Map map) throws IOException{
		super("player", x, y, 20, 5, map);
		this.map = map;
		
		if(getFacing().equals("up")){
			setImage(ImageIO.read(new File("resources/PlayerUp.png")));
		}else if(getFacing().equals("down")){
			setImage(ImageIO.read(new File("resources/PlayerDown.png")));
		}else if(getFacing().equals("left")){
			setImage(ImageIO.read(new File("resources/PlayerLeft.png")));
		}else if(getFacing().equals("right")){
			setImage(ImageIO.read(new File("resources/PlayerRight.png")));
		}
	}
	
	public Player(Map map) throws IOException{
		super(map);
		
		if(getFacing().equals("up")){
			setImage(ImageIO.read(new File("resources/PlayerUp.png")));
		}else if(getFacing().equals("down")){
			setImage(ImageIO.read(new File("resources/PlayerDown.png")));
		}else if(getFacing().equals("left")){
			setImage(ImageIO.read(new File("resources/PlayerLeft.png")));
		}else if(getFacing().equals("right")){
			setImage(ImageIO.read(new File("resources/PlayerRight.png")));
		}
	}
	
	public KeyListener getKeyListener(){
		return this;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		try{
			if(e.getKeyChar() == 's'){
				boolean temp = map.moveEntity(getX(), getY(), getX(), getY()+1);
				
				setFacing("down");
				setImage(ImageIO.read(new File("resources/PlayerDown.png")));
				
				if(temp){
					setY(getY()+1);
				}
			}else if(e.getKeyChar() == 'w'){
				boolean temp = map.moveEntity(getX(), getY(), getX(), getY()-1);
				
				setFacing("up");
				setImage(ImageIO.read(new File("resources/PlayerUp.png")));
				
				if(temp){
					setY(getY()-1);
				}
			}else if(e.getKeyChar() == 'a'){
				boolean temp = map.moveEntity(getX(), getY(), getX()-1, getY());
				
				setFacing("left");
				setImage(ImageIO.read(new File("resources/PlayerLeft.png")));
				
				if(temp){
					setX(getX()-1);
				}
			}else if(e.getKeyChar() == 'd'){
				boolean temp = map.moveEntity(getX(), getY(), getX()+1, getY());
				setFacing("right");
				setImage(ImageIO.read(new File("resources/PlayerRight.png")));
				
				if(temp){
					setX(getX()+1);
				}
			}
		}catch(Exception e1){
		}
		
		if(e.getKeyChar() == ' '){
			try {
				sweepAttack();
				map.spawnEntity(new Wisp((int)(Math.random()*Display.MAX_X), (int)(Math.random()*Display.MAX_Y), map));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void sweepAttack() throws Exception{
		
		if(getFacing().equals("down")){
			attack(getX()+1, getY());
			attack(getX()-1, getY());
			attack(getX()+1, getY()+1);
			attack(getX()-1, getY()+1);
			attack(getX(), getY()+1);
			//setImage(ImageIO.read(new File("resources/SweepDown.png")));
		}else if(getFacing().equals("up")){
			attack(getX()+1, getY());
			attack(getX()-1, getY());
			attack(getX()+1, getY()-1);
			attack(getX()-1, getY()-1);
			attack(getX(), getY()-1);
			//setImage(ImageIO.read(new File("resources/SweepUp.png")));
		}else if(getFacing().equals("right")){
			attack(getX(), getY()+1);
			attack(getX(), getY()-1);
			attack(getX()+1, getY()+1);
			attack(getX()+1, getY()-1);
			attack(getX()+1, getY());
			//setImage(ImageIO.read(new File("resources/SweepRight.png")));
		}else if(getFacing().equals("left")){
			attack(getX(), getY()-1);
			attack(getX(), getY()+1);
			attack(getX()-1, getY()+1);
			attack(getX()-1, getY()-1);
			attack(getX()-1, getY());
			//setImage(ImageIO.read(new File("resources/SweepLeft..png")));
		}
	}
}