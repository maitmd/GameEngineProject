package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class PoisonPuddle extends Particle{

	public PoisonPuddle(int x, int y, Map map) throws IOException{
		super();
		
		setX(x);
		setY(y);
		setXOffset(-1);
		setYOffset(-1);
		setParticleName("poison_puddle");
		setImage(ImageIO.read(new File("resources/PoisonPuddle.png")));
		setMap(map);
		setRemoveDelay(30);
		
	}
}
