package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class Empty extends Particle{

	public Empty(int x, int y, Map map) throws IOException {
		super();
		
		setX(x);
		setY(y);
		setXOffset(0);
		setYOffset(0);
		setParticleName("empty");
		setImage(ImageIO.read(new File("resources/Empty.png")));
		setMap(map);
		setRemoveDelay(5);
		
	}
	
}
