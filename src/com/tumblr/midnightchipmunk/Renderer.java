package com.tumblr.midnightchipmunk;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel{
	
	private Map map;
	
	public Renderer(Map map){
		this.map = map;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//Grid and Outline
		for(int i = 0; i < Display.MAX_X+2; i++){
			for(int j = 0; j < Display.MAX_Y+2; j++){
				if(i == 0 || j == 0 || i == Display.MAX_X+1 || j == Display.MAX_Y+1 ){
					g.fillRect(i*Display.TILE_WIDTH, j*Display.TILE_HEIGHT, Display.TILE_WIDTH, Display.TILE_HEIGHT);
				}else{
					g.drawRect(i*Display.TILE_WIDTH, j*Display.TILE_HEIGHT, Display.TILE_WIDTH, Display.TILE_HEIGHT);
				}
			}
		}
		
		//Particles
		for(int i = 0; i <= Display.MAX_X; i++){
			for(int j = 0; j <= Display.MAX_Y; j++){
				try{
					//System.out.println("Drew " + entityMap[i][j].getEntityType() + " " + entityMap[i][j] + " at " + entityMap[i][j].getX() + "," + entityMap[i][j].getY());
					g.drawImage(map.getParticleAt(i, j).getImage(), map.getParticleAt(i, j).getX()*Display.TILE_WIDTH, map.getParticleAt(i, j).getY()*Display.TILE_HEIGHT, null);
				}catch(Exception e){};
			}
		}
		
		//Entities
		for(int i = 0; i <= Display.MAX_X; i++){
			for(int j = 0; j <= Display.MAX_Y; j++){
				try{
					//System.out.println("Drew " + entityMap[i][j].getEntityType() + " " + entityMap[i][j] + " at " + entityMap[i][j].getX() + "," + entityMap[i][j].getY());
					g.drawImage(map.getEntityAt(i, j).getImage(), map.getEntityAt(i, j).getX()*Display.TILE_WIDTH, map.getEntityAt(i, j).getY()*Display.TILE_HEIGHT, null);
				}catch(Exception e){};
			}
		}
		
	}
	
}