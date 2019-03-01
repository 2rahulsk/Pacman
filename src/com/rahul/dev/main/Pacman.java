package com.rahul.dev.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Pacman extends JFrame{
	
	public Pacman() {
		
		this.setTitle("Pacman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new Game());
		this.setVisible(true);
	
	}
	
}
