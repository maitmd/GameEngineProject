package entities.com.tumblr.midnightchipmunk;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import particles.com.tumblr.midnightchipmunk.PoisonMarker;

import com.tumblr.midnightchipmunk.Entity;
import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class ArtillaryWormAttack extends Entity{

	protected int timer;
	protected int delay;
	protected int delayedX;
	protected int delayedY;
	protected Particle delayedParticle;
	protected boolean delayedAttack;
	
	public ArtillaryWormAttack(int x, int y, Map map, int delay, double hp, double atk) throws IOException {
		super(ImageIO.read(new File("resources/Empty.png")), x, y, hp, atk, map);
		
		this.delay = delay;
		timer = 0;
		
		getMap().spawnParticle(new PoisonMarker(getX()-1, getY()-1, getMap()));
		
		if(map.getEntityAt(x,y) != null){
			delayedX = x;
			delayedY = y;
		}
	}

	public void incrementDelayedAttack() throws IOException{
			timer+=1;

			if(timer == delay){
				attack(delayedX, delayedY);
				getMap().removeEntity(this);
			}
	}
	
}
