package entities.com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Neutral;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import particles.com.tumblr.midnightchipmunk.Zap;

import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;


public class Wisp extends Entity implements Neutral{
	
	int detectionRadius = 1;
	
	public Wisp(int x, int y, Map map) throws IOException {
		super("wisp" , x, y, 15, 1, map);
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
	
	public void trigger() throws IOException{
		ArrayList<Entity> entities = getNearbyEntities(detectionRadius);
		
		for(int i = 0; i <= detectionRadius; i++){
			Entity temp = entities.get(i);
			
			if(temp instanceof Player){	
				try {
					attack(temp, new Zap(getX(), getY(), getMap()));
				} catch (IOException e) {}
			}
		}
	}
}
