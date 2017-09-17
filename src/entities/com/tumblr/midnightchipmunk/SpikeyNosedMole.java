package entities.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Display;
import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;

import interfaces.com.tumblr.midnightchipmunk.Hostile;

public class SpikeyNosedMole extends Entity implements Hostile{
	
	int detectionRadius;
	int attackDelay;
	int walkDelay;
	int walkCounter;
	final int MOB_ID = 0003;
	
	public SpikeyNosedMole(int x, int y, Map map) throws IOException {
		super();
		
		setEntityType("spikeynosedmole");
		setX(x);
		setY(y);
		setHealth(20);
		setAttack(5);
		setMap(map);
		
		if(getFacing().equals("up")){
			setImage(ImageIO.read(new File("resources/SpikeyNosedMoleUpRight.png")));
		}else if(getFacing().equals("down")){
			setImage(ImageIO.read(new File("resources/spikeynosedmoleDownRight.png")));
		}else if(getFacing().equals("left")){
			setImage(ImageIO.read(new File("resources/spikeynosedmoleLeft.png")));
		}else if(getFacing().equals("right")){
			setImage(ImageIO.read(new File("resources/spikeynosedmoleRight.png")));
		}
		
		detectionRadius = 3;
		attackDelay = 5;
		walkDelay = 10;
		walkCounter = 0;
		
	}

	@Override
	public void searchForTarget() {
		
		ArrayList<Entity> entities = getNearbyEntities(detectionRadius);
		boolean playerCheck = false;

			for(int i = 0; i < entities.size(); i++){
				Entity temp = entities.get(i);
				
				if(temp instanceof Player){
					playerCheck = true;
					if(walkCounter > walkDelay){
						try {moveTowardsTarget(temp);} catch (IOException e) {}
						try {attackCheck(temp);} catch (IOException e) {}
						walkCounter = 0;
					}
				}	
			}
			
		if(!playerCheck){
			try {randomMovement();} catch (IOException e) {}
		}
		
		walkCounter++;
	}
	
	public void moveTowardsTarget(Entity temp) throws IOException{

		if(getX() > temp.getX() && getY() > temp.getY()){
			move("left");
		}else if( getX() < temp.getX() && getY() < temp.getY()){
			move("right");
		}else if(getX() > temp.getX() && getY() < temp.getY()){
			move("left");
		}else if( getX() < temp.getX() && getY() > temp.getY()){
			move("right");
		}else if(getX() == temp.getX() && getY() > temp.getY()){
			if(getY()-1 != temp.getY()){
				move("up");
			}
		}else if(getX() == temp.getX() && getY() < temp.getY()){
			if(getY()+1 != temp.getY()){
				move("down");
			}
		}else if(getX() > temp.getX() && getY() == temp.getY()){
			if(getX()+1 != temp.getX()){
				move("left");
			}
		}else if(getX() < temp.getX() && getY() == temp.getY()){
			if(getX()+1 != temp.getX()){
				move("right");
			}
		}
	}

	
	public void attackCheck(Entity entity) throws IOException{
		if(getX()+1 == entity.getX() || getX()-1 == entity.getX() || getY()+1 == entity.getX() || getY()-1 == entity.getX() || (getX()+1 == entity.getX() && getY()+1 == entity.getY()) || (getX()+1 == entity.getX() && getY()-1 == entity.getY() || (getX()-1 == entity.getX() && getY()+1 == entity.getY() || (getX()-1 == entity.getX() && getY()-1 == entity.getY())))){
			if(attackDelay == 0){
				setImage(ImageIO.read(new File("resources/" + entityType + "Attack" + getFacing() + ".png")));
				attack(entity);
				attackDelay = 5;
			}else{
				if(getFacing().equals("up")){
					setImage(ImageIO.read(new File("resources/" + entityType + getFacing() + "Right.png")));
				}else if(getFacing().equals("down")){
					setImage(ImageIO.read(new File("resources/" + entityType + getFacing() + "Left.png")));
				}else{
					setImage(ImageIO.read(new File("resources/" + entityType + getFacing() + ".png")));	
				}
			}
			attackDelay--;
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
			if(getFacing().equals("right")){
				setImage(ImageIO.read(new File("resources/" + entityType + "UpRight.png")));
			}else if(getFacing().equals("left")){
				setImage(ImageIO.read(new File("resources/" + entityType + "UpLeft.png")));
			}else{
				setImage(ImageIO.read(new File("resources/" + entityType + "UpRight.png")));
			}
			
			setFacing("up");
			
			if(getY() > 1){
				setY(getY()-1);
			}
		}else if(direction.equals("down")){
			if(getFacing().equals("right")){
				setImage(ImageIO.read(new File("resources/" + entityType + "DownRight.png")));
			}else if(getFacing().equals("left")){
				setImage(ImageIO.read(new File("resources/" + entityType + "DownLeft.png")));
			}else{
				setImage(ImageIO.read(new File("resources/" + entityType + "DownRight.png")));
			}
			
			setFacing("down");
			
			if(getY() < Display.MAX_Y){
				setY(getY()+1);
			}
		}
	}
}
