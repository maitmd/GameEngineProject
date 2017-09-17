package entities.com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Hostile;
import particles.com.tumblr.midnightchipmunk.PoisonMarker;
import particles.com.tumblr.midnightchipmunk.PoisonPuddle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;

public class ArtillaryWorm extends Entity implements Hostile{

	final int DETECTION_RADIUS = 4;
	final int RECHARGE_DELAY = 30;
	final int ATTACK_DELAY = 20;
	final int MOB_ID = 0002;
	
	int rechargeTimer = 0;
	int attackTimer = 0;
	boolean attacking;
	int delX = 0;
	int delY = 0;
	
	public ArtillaryWorm(int x, int y, Map map) throws IOException {
		super();
	
		setImage(ImageIO.read(new File("resources/ArtillaryWorm.png")));
		setEntityType("artillery_worm");
		setX(x);
		setY(y);
		setAttack(5);
		setHealth(15);
		setMap(map);
	}

	public void searchForTarget() throws IOException {
		rechargeTimer++;
		
		if(rechargeTimer == 0){
			ArrayList<Entity> entities = getNearbyEntities(DETECTION_RADIUS);
			for(int i = 0; i < entities.size(); i++){
				Entity temp = entities.get(i);
				
				if(temp instanceof Player){
					if(!attacking){
						delX = temp.getX();
						delY = temp.getY();
						
						getMap().spawnParticle(new PoisonMarker(delX, delY, getMap()));
						attacking = true;
					}
				}	
					
			}
		}else if(rechargeTimer == RECHARGE_DELAY){
			rechargeTimer = -1;
		}
		
		if(attacking){
			incrementDelayedAttack(delX, delY);
		}
	}

	public void incrementDelayedAttack(int aX, int aY) throws IOException{
		attackTimer++;

		if(attackTimer == ATTACK_DELAY){
			getMap().spawnParticle(new PoisonPuddle(aX, aY, getMap()));
			attack(aX, aY);
			attacking = false; 
			attackTimer = 0;
		}
}
}
