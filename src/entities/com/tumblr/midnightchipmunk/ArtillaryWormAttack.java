package entities.com.tumblr.midnightchipmunk;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
	
	public ArtillaryWormAttack(int x, int y, Map map, int delay, double hp, double atk, Particle particle) throws IOException {
		super(ImageIO.read(new File("resources/Empty.png")), x, y, hp, atk, map);
		
		this.delay = delay;
		timer = 0;
		
		if(map.getEntityAt(x,y) != null){
			delayedX = x;
			delayedY = y;
			delayedParticle = particle;
		}
	}

	public void incrementDelayedAttack(){
			timer+=1;

			if(timer == delay){
				attack(delayedX, delayedY, delayedParticle);
				getMap().removeEntity(this);
			}
	}
	
}
