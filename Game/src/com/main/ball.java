package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class ball {
	
	public static final int SIZE = 16;
	
	private int x, y;
	private int xVel, yVel; //value either 1 or -1
	private int speed = 5;
	
	public ball() {
		reset();
		
	}

	private void reset() {
		//initial position
		
		x = game.WIDTH / 2 - SIZE / 2;
	    y = game.HEIGHT / 2 - SIZE / 2;
	    
	    //initial velocities
	    xVel = game.sign(Math.random() * 2.0 - 1);
	    yVel = game.sign(Math.random() * 2.0 - 1);
	    
		}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void changeYDir() {
		yVel *= -1;
	}
    public void changeXDir() {
	    xVel *= -1;
}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
		
	}

	public void update(paddle p1, paddle p2) {
		//update movement
		x += xVel * speed;
		y += yVel * speed;
		
		//collisions
		if (y + SIZE >= game.HEIGHT || y <= 0)
			changeYDir();
		
		// with walls
		if (x + SIZE >= game.WIDTH) {
			p1.addPoint();
			reset();
			}
		
		if (x <= 0) {
			p2.addPoint();
			reset();
			
			
		}
		
		
		
		
		
		
	}
}
