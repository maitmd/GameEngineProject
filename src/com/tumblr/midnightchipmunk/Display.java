package com.tumblr.midnightchipmunk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display implements ActionListener{
	
	public final static int TILE_WIDTH = 100, TILE_HEIGHT = 100, MAX_X = 8, MAX_Y = 8;
	private static Map map = new Map();
	private JPanel jpanel = new Renderer(map);
	
	private static Player player;
	
	public Display(){
		JFrame frame = new JFrame();
		Timer timer = new Timer(50, this);
		timer.start();
		
		frame.add(jpanel);
		frame.setTitle("Walk Demo");
		frame.getContentPane().add(BorderLayout.CENTER, jpanel);
		frame.setSize(((TILE_WIDTH*MAX_X)+19), ((TILE_HEIGHT*MAX_Y)+48));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(player.getKeyListener());
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Entity> list = map.getAllEntities("Wisp");
		for(int i = 0; i < list.size(); i++){
			Wisp wisp = (Wisp)list.get(i);
			
			list.get(i).randomMovement();
			wisp.attack();
		}
		
		jpanel.repaint();
	}
	
	public static void main(String[] args) {
		try {
			player = new Player((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map);
			
			map.spawnEntity(player);
			map.spawnEntity(new Wisp((int)(Math.random()*MAX_X), (int)(Math.random()*MAX_Y), map));
			
		} catch (IOException e) {
			System.out.println("Unable to spawn Entity");
			e.printStackTrace();
		}
		new Display();
	}
}