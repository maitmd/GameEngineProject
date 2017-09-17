package particles.com.tumblr.midnightchipmunk;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class Sweep extends Particle{

	public Sweep(int x, int y, Map map, String facing) throws IOException {
		super();
		
		setX(x);
		setY(y);
		setParticleName("sweep");
		setMap(map);
		setRemoveDelay(5);
		
		if(facing.equals("down")){
			setImage(ImageIO.read(new File("resources/SweepDown.png")));
			setXOffset(-2);
			setYOffset(-1);
		}else if(facing.equals("up")){
			setImage(ImageIO.read(new File("resources/SweepUp.png")));
			setXOffset(-2);
			setYOffset(-2);
		}else if(facing.equals("right")){
			setImage(ImageIO.read(new File("resources/SweepRight.png")));
			setXOffset(-1);
			setYOffset(-2);
		}else if(facing.equals("left")){
			setImage(ImageIO.read(new File("resources/SweepLeft.png")));
			setXOffset(-2);
			setYOffset(-2);
		}
		}
	}
