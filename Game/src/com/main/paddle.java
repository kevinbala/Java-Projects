package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class paddle {
	
	private int x, y;
	private int vel = 0;
	private int speed = 10;
	private int width = 22, height = 85;
	private int score = 0;
	private Color color;
	private boolean left;
	
	
	public paddle(Color c, boolean left) {
		color = c;
		
		this.left = left;
		
		if (left)
			x = 0;
		else
			x = game.WIDTH - width;
		y = game.HEIGHT / 2 - height / 2;
	}
	
	public void addPoint() {
		score++;
	}

	public void draw(Graphics g) {
		//draw paddle
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		//draw score
		int sx;
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);
		
		
		int strWidth = g.getFontMetrics(font).stringWidth(scoreText) + 1;
		int padding = 25;
		
		if (left)
			sx = game.WIDTH / 2 - padding - strWidth;
		else
			sx = game.WIDTH / 2 + padding;
		
		g.setFont(font);
	    g.drawString(scoreText, sx, 50);
	    
		
	}

	public void update(ball b) {
		//update position
		y = game.ensureRange(y += vel, 0, game.HEIGHT - height);
		
		int ballX = b.getX();
		int ballY = b.getY();
		
		//collisions with the ball
		if(left) {
			
			if (ballX <= width && ballY + ball.SIZE >= y && ballY <= y + height)
			b.changeXDir();
			
		} else {
			
			if(ballX + ball.SIZE >= game.WIDTH - width && ballY + ball.SIZE >= y && ballY <= y + height)
			b.changeXDir();
			
		}
	}

	public void switchDirection(int direction) {
		vel = speed * direction;
	}
	
	public void stop() {
		vel = 0;
	}

}
