package entities.com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Hostile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;

public class ArtillaryWorm extends Entity implements Hostile{

	int detectionRadius;
	int rechargeDelay;
	int rechargeTimer;
	int attackDelay;
	int attackTimer;
	
	public ArtillaryWorm(int x, int y, Map map) throws IOException {
		super(ImageIO.read(new File("resources/ArtillaryWorm.png")), "artillery_worm", x, y, 5, 5, map);
		
		detectionRadius = 4;
		rechargeTimer = 0;
		rechargeDelay = 30;
		attackTimer = 0;
		attackDelay = 20;
	
	}

	public void searchForTarget() {
		rechargeTimer++;
		
		if(rechargeTimer == 0){
			ArrayList<Entity> entities = getNearbyEntities(detectionRadius);
			for(int i = 0; i < entities.size(); i++){
				Entity temp = entities.get(i);
				
				if(temp instanceof Player){
					try {
						getMap().spawnEntity(new ArtillaryWormAttack(temp.getX(), temp.getY(), getMap(), attackDelay, getHealth(), getAttack()));
					} catch (IOException e) {}
				}	
					
			}
		}else if(rechargeTimer == rechargeDelay){
			rechargeTimer = -1;
		}
	}

}
