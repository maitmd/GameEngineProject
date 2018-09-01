package com.tumblr.midnightchipmunk;

import interfaces.com.tumblr.midnightchipmunk.Hostile;
import interfaces.com.tumblr.midnightchipmunk.Neutral;
import interfaces.com.tumblr.midnightchipmunk.Passive;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import entities.com.tumblr.midnightchipmunk.ArtillaryWorm;
import entities.com.tumblr.midnightchipmunk.Player;
import entities.com.tumblr.midnightchipmunk.SpikeyNosedMole;
import entities.com.tumblr.midnightchipmunk.Wisp;

public class Display implements ActionListener {
	
	public final static int TILE_WIDTH = 50, TILE_HEIGHT = 50, MAX_X = 15, MAX_Y = 15;
	public static Map map = new Map();
	private Renderer renderer = new Renderer(map);
	
	public static Player player;
	
	//Building the Frame
	public Display(){
		JFrame frame = new JFrame();
		Timer timer = new Timer(50, this);
		timer.start();
		
		frame.add(renderer);
		frame.setTitle("Walk Demo");
		frame.setLayout(new BorderLayout());
		frame.setSize((((MAX_X+2)*TILE_WIDTH)+19), ((TILE_HEIGHT*(MAX_Y+2)+48)));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(player.getKeyListener());
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.setBackground(Color.WHITE);
		frame.add(renderer, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	//Performing game actions - Random Entity Movement, Particle Ticks, Redrawing Frame...
	@Override
	public void actionPerformed(ActionEvent e){
		
		//Getting all entities on the map
		ArrayList<Entity> entityList = map.getAllEntities();
		ArrayList<Particle> particleList = map.getAllParticles();
		
		//Running through each entity to perform passive actions - Movement, Attacks...
		for(int i = 0; i < entityList.size(); i++){
			Entity entity = entityList.get(i);
			
			if(!(entity instanceof Player)){
				
				if(entity instanceof Neutral){
					try {((Neutral) entity).trigger();} catch (IOException e1) {}
				}else if(entity instanceof Hostile){
					try {((Hostile) entity).searchForTarget();} catch (IOException e1){}
				}else if(entity instanceof Passive){
					try {entity.randomMovement();} catch (IOException e1) {}
				}
			}
		}
		
		//Running through each particle incrementing the remove delay
		for(int i = 0; i < particleList.size(); i++){
			Particle particle = particleList.get(i);
			
			particle.delayCount();
		}
		
		renderer.repaint();
	}
	
	//Launch
	public static void main(String[] args) throws IOException {
		int randomEntities = (int)(Math.random()*10);
		
		//randomly place player
		player = new Player((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map);
		
		//Spawns random entities at random quantities based on randomEntities and randomMobID
		for(int i = 0; i < randomEntities; i++){
			int randomMobID = (int)(Math.random()*4);
			System.out.println(randomMobID);
			switch (randomMobID){
				case 1:
					map.spawnEntity(new Wisp((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
					break;
				case 2:
					map.spawnEntity(new ArtillaryWorm((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
					break;
				case 3:
					map.spawnEntity(new SpikeyNosedMole((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
					break;
			}
		}
			
		map.spawnEntity(player);;

		map.spawnEntity(new Wisp((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
		map.spawnEntity(new Wisp((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
		new Display();
	}
}