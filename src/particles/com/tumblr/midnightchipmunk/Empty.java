package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class Empty extends Particle{

	public Empty(int x, int y, Map map) throws IOException {
		super(x, y, 0, 0, "empty", ImageIO.read(new File("resources/Empty.png")), map, 5);
	}
	
}
