package com.tumblr.midnightchipmunk;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel{
	
	private Entity[][] entityMap;
	
	public Renderer(Map map){
		entityMap = map.getMap();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i = 0; i < entityMap[0].length; i++){
			for(int j = 0; j < entityMap.length; j++){
				try{
						//System.out.println("Drew " + entityMap[i][j].getEntityType() + " " + entityMap[i][j] + " at " + entityMap[i][j].getX() + "," + entityMap[i][j].getY());
						g.drawImage(entityMap[i][j].getImage(), entityMap[i][j].getX()*Display.TILE_WIDTH, entityMap[i][j].getY()*Display.TILE_HEIGHT, null);
				}catch(Exception e){}
			}
		}
		
		for(int i = 0; i < Display.MAX_X; i++){
			for(int j = 0; j < Display.MAX_Y; j++){
				g.drawRect(i*Display.TILE_WIDTH, j*Display.TILE_HEIGHT, Display.TILE_WIDTH, Display.TILE_HEIGHT);
			}
		}
		
		
		
	}
	
}