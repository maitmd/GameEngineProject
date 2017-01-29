package entities.com.tumblr.midnightchipmunk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Display;
import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;

import particles.com.tumblr.midnightchipmunk.Empty;
import particles.com.tumblr.midnightchipmunk.Sweep;


public class Player extends Entity implements KeyListener{

	private boolean attackCheck = false;
	
	public Player(int x, int y, Map map) throws IOException{
		super("player", x, y,  1000, 5, map);
		
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
		if(e.getKeyChar() == ' '){
			attackCheck = false;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		try{
			if(e.getKeyChar() == 's'){
				setFacing("down");
				setImage(ImageIO.read(new File("resources/PlayerDown.png")));
				
				if(getY() < Display.MAX_Y){
					setY(getY()+1);
				}
				
			}else if(e.getKeyChar() == 'w'){
				setFacing("up");
				setImage(ImageIO.read(new File("resources/PlayerUp.png")));
				
				if(getY() > 1){
					setY(getY()-1);
				}
				
			}else if(e.getKeyChar() == 'a'){
				setFacing("left");
				setImage(ImageIO.read(new File("resources/PlayerLeft.png")));
				
				if(getX() > 1){
					setX(getX()-1);
				}
			}else if(e.getKeyChar() == 'd'){
				setFacing("right");
				setImage(ImageIO.read(new File("resources/PlayerRight.png")));
				
				if(getX() < Display.MAX_X){
					setX(getX()+1);
				}
			}
		}catch(Exception e1){
		}
		
		if(e.getKeyChar() == ' '){
			try {
				if(!attackCheck){
					attackCheck = true;
					attack();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void attack() throws Exception{
		if(getFacing().equals("down")){
			attack(getX()-1, getY());
			attack(getX()+1, getY()+1);
			attack(getX()-1, getY()+1);
			attack(getX(), getY()+1);
			attack(getX()+1, getY(), new Sweep(getX(), getY(), getMap(), getFacing()));
		}else if(getFacing().equals("up")){
			attack(getX()-1, getY());
			attack(getX()+1, getY()-1);
			attack(getX()-1, getY()-1);
			attack(getX(), getY()-1);
			attack(getX()+1, getY(), new Sweep(getX(), getY(), getMap(), getFacing()));
		}else if(getFacing().equals("right")){
			attack(getX(), getY()-1, new Empty(getX(), getY(), getMap()));
			attack(getX()+1, getY()+1, new Empty(getX(), getY(), getMap()));
			attack(getX()+1, getY()-1, new Empty(getX(), getY(), getMap()));
			attack(getX()+1, getY(), new Empty(getX(), getY(), getMap()));
			attack(getX(), getY()+1, new Sweep(getX(), getY(), getMap(), getFacing()));
		}else if(getFacing().equals("left")){
			attack(getX(), getY()+1, new Empty(getX(), getY(), getMap()));
			attack(getX()-1, getY()+1, new Empty(getX(), getY(), getMap()));
			attack(getX()-1, getY()-1, new Empty(getX(), getY(), getMap()));
			attack(getX()-1, getY(), new Empty(getX(), getY(), getMap()));
			attack(getX(), getY()-1, new Sweep(getX(), getY(), getMap(), getFacing()));
		}
	}
}