package particles.com.tumblr.midnightchipmunk;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tumblr.midnightchipmunk.Map;
import com.tumblr.midnightchipmunk.Particle;

public class Zap extends Particle{

	ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
	
	public Zap(int x, int y, Map map) throws IOException{
		super();
		
		setX(x);
		setY(y);
		setXOffset(-2);
		setYOffset(-2);
		setParticleName("zap");
		setImage(ImageIO.read(new File("resources/Zap1.png")));
		setMap(map);
		setRemoveDelay(5);
	}
}
