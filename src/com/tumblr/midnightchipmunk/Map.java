package com.tumblr.midnightchipmunk;

import java.util.ArrayList;

public class Map {

	//Creating grid for entity storage
	private ArrayList<Entity> entities;
	private ArrayList<Particle> particles;
			
	//Initializing map
	public Map(){	
		entities = new ArrayList<Entity>();
		particles= new ArrayList<Particle>();
	}
	
	public void spawnEntity(Entity entity){
		entities.add(entity);
	}

	public void spawnParticle(Particle particle){
		particles.add(particle);
	}
	
	public Entity getEntityAt(double x, double y){
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i).getX() == x && entities.get(i).getY() == y){
				return entities.get(i);
			}
		}
		
		return null;
	}
	 
	public Particle getParticleAt(int x, int y){
		for(int i = 0; i < particles.size(); i++){
			if(particles.get(i).getX() == x && particles.get(i).getY() == y){
				return particles.get(i);
			}
		}
		
		return null;
	}
	
	public Entity getEntity(String type){
		for(Entity temp:entities){
			if(temp != null && temp.getEntityType().equals(type)){
				return temp;
			}
		}
		return null;
	}
	
	public ArrayList<Entity> getAllEntities(){
		return entities;
	}
	
	public ArrayList<Particle> getAllParticles(){
		return particles;
	}
	
	public void removeEntity(int x, int y){
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i).getX() == x && entities.get(i).getY() == y){
				entities.remove(i);
			}
		}
	}
	
	public void removeParticle(int x, int y){
		for(int i = 0; i < particles.size(); i++){
			if(particles.get(i).getX() == x && particles.get(i).getY() == y){
				particles.remove(i);
			}
		}
	}
	
	public void removeAllParticles(){
		for(int i = 0; i < particles.size(); i++){
				particles.remove(i);
		}
	}
}
