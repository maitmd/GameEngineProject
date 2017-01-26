package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class PoisonMarker extends Particle{

	public PoisonMarker(int x, int y, Map map) throws IOException{
		super(x, y, -1, -1, "poison_marker", ImageIO.read(new File("resources/PoisonMarker.png")), map, 20);
	}
	
	public void delayCount(){
		timer+=1;
		
		if(timer == removeDelay){
			try {
				getMap().removeParticle(getX(), getY());
				getMap().spawnParticle(new PoisonPuddle(getX(), getY(), getMap()));
			} catch (IOException e) {}
			
		}
	}

}

