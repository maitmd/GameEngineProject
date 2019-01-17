package entities.com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Neutral;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import particles.com.tumblr.midnightchipmunk.Zap;

import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;


public class Wisp extends Entity implements Neutral{
	
	int detectionRadius = 1;
	final int MOB_ID = 0001;
	
	public Wisp(int x, int y, Map map) throws IOException {
		
		super();
		
		setEntityType("wisp");
		setX(x);
		setY(y);
		setHealth(5);
		setAttack(1);
		setMap(map);
		
		this.map = map;
		
		setImage(ImageIO.read(new File("resources/Wisp" + randomFacing() + ".png")));
	}
	
	public void trigger() throws IOException{
		
		randomMovement();
		
		for(int i = 0; i <= detectionRadius; i++){
			for(int j = 0; j <= detectionRadius; j++){

				Entity entityRight = getMap().getEntityAt((this.getX()+i), (this.getY()));
				Entity entityLeft = getMap().getEntityAt((this.getX()-i), (this.getY()));
				Entity entityUp = getMap().getEntityAt((this.getX()), (this.getY()-j));
				Entity entityDown = getMap().getEntityAt((this.getX()), (this.getY()+j));
				Entity entityRightUp = getMap().getEntityAt((this.getX()+i), (this.getY()-j));
				Entity entityRightDown = getMap().getEntityAt((this.getX()+i), (this.getY()+j));
				Entity entityLeftUp = getMap().getEntityAt((this.getX()-i), (this.getY()-j));
				Entity entityLeftDown = getMap().getEntityAt((this.getX()-i), (this.getY()+j));
				
				if(entityRight instanceof Player){
					
					try {
						attack(entityRight, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityLeft instanceof Player){
					
					try {
						attack(entityLeft, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityUp instanceof Player){
					
					try {
						attack(entityUp, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityDown instanceof Player){
					
					try {
						attack(entityDown, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityRightUp instanceof Player){
					
					try {
						attack(entityRightUp, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityRightDown instanceof Player){
					
					try {
						attack(entityRightDown, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityLeftUp instanceof Player){
					
					try {
						attack(entityLeftUp, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}else if(entityLeftDown instanceof Player){
					
					try {
						attack(entityLeftDown, new Zap(getX(), getY(), getMap()));
					} catch (IOException e) {
					}
					
				}
			}
		}
	}
}
