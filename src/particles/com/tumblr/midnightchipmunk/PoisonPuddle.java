package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class PoisonPuddle extends Particle{

	boolean switched = false;
	public PoisonPuddle(int x, int y, Map map) throws IOException{
		super(x, y, -1, -1, "poison_puddle", ImageIO.read(new File("resources/PoisonPuddle.png")), map, 50);
	}
}
