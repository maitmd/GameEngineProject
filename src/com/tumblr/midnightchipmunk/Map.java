package com.tumblr.midnightchipmunk;

import java.util.ArrayList;

class Map {

	private Entity[][] grid =  new Entity[Display.MAX_X][Display.MAX_Y];
	
	public Map(){
		for(int i = 0; i < grid[0].length; i++){
			for(int j = 0; j < grid.length; j++){
				grid[i][j] = null;
			}
		}
	}
	
	public Entity[][] getMap(){
		return grid;
	}
	
	public void spawnEntity(Entity entity){
		if(grid[entity.getX()][entity.getY()] == null){
			grid[entity.getX()][entity.getY()] = entity;
			System.out.println("Spawned " + entity.getEntityType() + " " + entity + " at " + entity.getX() + "," + entity.getY());
		}else{
			System.out.println("Could not spawn the entity there!");
		}
	}

	public Entity getEntityAt(int x, int y){
		try{
			if(grid[x][y] != null){
				return grid[x][y];
			}else{
				return null;
			}
		}catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	 
	public Entity getEntity(String type){
		for(Entity[] temp:grid){
			for(Entity temp2:temp){
				if(temp2 != null && temp2.getEntityType().equals(type)){
						return temp2;
				}
			}
		}
		return null;
	}
	
	public ArrayList<Entity> getAllEntities(String type){
		ArrayList<Entity> list = new ArrayList<Entity>();
		
		for(int i = 0; i < grid[0].length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j] != null && grid[i][j].getEntityType().equals(type)){
					list.add(grid[i][j]);
				}
			}
		}
		
		return list;
	}
	
	public ArrayList<Entity> getAllEntities(){
		ArrayList<Entity> list = new ArrayList<Entity>();
		
		for(int i = 0; i < grid[0].length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j] != null && !grid[i][j].getEntityType().equals("player")){
					list.add(grid[i][j]);
				}
			}
		}
		
		return list;
	}
	
	public boolean moveEntity(int currentx, int currenty, int newx, int newy){
		if(grid[newx][newy] == null){
			grid[newx][newy] = grid[currentx][currenty];
			grid[currentx][currenty] = null;
			return true;
		}
		
		return false;
	}
	
	public void removeEntity(int x, int y){
		grid[x][y] = null;
	}
}
