package entities.com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Hostile;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import particles.com.tumblr.midnightchipmunk.Empty;
import particles.com.tumblr.midnightchipmunk.PoisonMarker;

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
		rechargeDelay = 5;
		attackTimer = 0;
		attackDelay = 10;
	
	}

	public void searchForTarget() {
		rechargeTimer++;
		if(rechargeTimer == 0){
			for(int i = 0; i <= detectionRadius; i++){
				for(int j = 0; j <= detectionRadius; j++){
					
					Entity entityRight = getMap().getEntityAt((this.getX()+i), (this.getY()));
					Entity entityLeft = getMap().getEntityAt((this.getX()-i), (this.getY()));
					Entity entityUp = getMap().getEntityAt((this.getX()), (this.getY()-j));
					Entity entityDown = getMap().getEntityAt((this.getX()), (this.getY()+j));
					Entity entityRightUp = getMap().getEntityAt((this.getX()+i), (this.getY()-j));
					Entity entityRightDown = getMap().getEntityAt((this.getX()+i), (this.getY()+j));
					Entity entityLeftUp = getMap().getEntityAt((this.getX()-i), (this.getY()+j));
					Entity entityLeftDown = getMap().getEntityAt((this.getX()-i), (this.getY()-j));
					
					if(entityRight instanceof Player){
						
						try {
							delayedAttack(entityRight.getX(), entityRight.getY(), new PoisonMarker(entityRight.getX(), entityRight.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityLeft instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityLeft.getX(), entityLeft.getY(), getMap()));
							delayedAttack(entityLeft.getX(), entityLeft.getY(), new PoisonMarker(entityLeft.getX(), entityLeft.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityUp instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityUp.getX(), entityUp.getY(), getMap()));
							delayedAttack(entityUp.getX(), entityUp.getY(), new PoisonMarker(entityUp.getX(), entityUp.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityDown instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityDown.getX(), entityDown.getY(), getMap()));
							delayedAttack(entityDown.getX(), entityDown.getY(), new PoisonMarker(entityDown.getX(), entityDown.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityRightUp instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityRightUp.getX(), entityRightUp.getY(), getMap()));
							delayedAttack(entityRightUp.getX(), entityRightUp.getY(), new PoisonMarker(entityRightUp.getX(), entityRightUp.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityRightDown instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityRightDown.getX(), entityRightDown.getY(), getMap()));
							delayedAttack(entityRightDown.getX(), entityRightDown.getY(), new PoisonMarker(entityRightDown.getX(), entityRightDown.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityLeftUp instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityLeftUp.getX(), entityLeftUp.getY(), getMap()));
							delayedAttack(entityLeftUp.getX(), entityLeftUp.getY(), new PoisonMarker(entityLeftUp.getX(), entityLeftUp.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}else if(entityLeftDown instanceof Player){
						
						try {
							getMap().spawnParticle(new PoisonMarker(entityLeftDown.getX(), entityLeftDown.getY(), getMap()));
							delayedAttack(entityLeftDown.getX(), entityLeftDown.getY(), new PoisonMarker(entityLeftDown.getX(), entityLeftDown.getY(), getMap()), attackDelay);
						} catch (IOException e) {
						}
						
					}
				}
			}
		}else if(rechargeTimer == rechargeDelay){
			rechargeTimer = -1;
		}
	}

}
