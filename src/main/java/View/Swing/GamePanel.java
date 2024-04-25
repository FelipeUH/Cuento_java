/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;



public class GamePanel extends JPanel implements ActionListener{
	
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	static final int UNIT_SIZE = 20;
	static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        static final int WIN_SCORE_CONDITION = 5;

	int x[] = new int[NUMBER_OF_UNITS];
	int y[] = new int[NUMBER_OF_UNITS];
	
	int snakeLength = 5;
	int score;
	int foodX;
	int foodY;
	char snakeDirection = 'D';
	boolean status = false;
        boolean isLost = true;
	Random random;
	Timer clock;
	
	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		play();
	}	
	
	public void play() {
		placeFood();
		status = true;
		
		clock = new Timer(80, this);
		clock.start();
                
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		draw(graphics);
	}
	
	public void move() {
		for (int i = snakeLength; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		if (snakeDirection == 'L') {
			x[0] = x[0] - UNIT_SIZE;
		} else if (snakeDirection == 'R') {
			x[0] = x[0] + UNIT_SIZE;
		} else if (snakeDirection == 'U') {
			y[0] = y[0] - UNIT_SIZE;
		} else {
			y[0] = y[0] + UNIT_SIZE;
		}	
	}
	
	public void checkFood() {
		if(x[0] == foodX && y[0] == foodY) {
			snakeLength++;
			score++;
			placeFood();
		}
	}
	
	public void draw(Graphics graphics) {
		
		if (status) {
			graphics.setColor(new Color(210, 115, 90));
			graphics.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
			
			graphics.setColor(Color.white);
			graphics.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);
			
			for (int i = 1; i < snakeLength; i++) {
				graphics.setColor(new Color(40, 200, 150));
				graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
			FontMetrics metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Puntuacion: " + score, (WIDTH - metrics.stringWidth("Puntuacion: " + score)) / 2, graphics.getFont().getSize());
		
		} else {
			gameLost(graphics);
		}
	}
	
	public void placeFood() {
		foodX = random.nextInt((int)(WIDTH / UNIT_SIZE))*UNIT_SIZE;
		foodY = random.nextInt((int)(HEIGHT / UNIT_SIZE))*UNIT_SIZE;
	}
	
	public void checkHit() {
		
		for (int i = snakeLength; i > 0; i--) {
			if (x[0] == x[i] && y[0] == y[i]) {
				status = false;
			}
		}
		
		// check if head run into walls
		if (x[0] < 0 || x[0] > WIDTH || y[0] < 0 || y[0] > HEIGHT) {
			status = false;
		}
		
		if(!status) {
			clock.stop();
		}
	}
	
	public void gameLost(Graphics graphics) {
                if (score < WIN_SCORE_CONDITION) {
                    graphics.setColor(new Color(88, 250, 84));
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 50));
                    FontMetrics metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Perdiste", (WIDTH - metrics.stringWidth("Perdiste")) / 2, HEIGHT / 2);
                    
                    graphics.setColor(Color.white);
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
                    metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Puntuacion: " + score, (WIDTH - metrics.stringWidth("Puntuacion: " + score)) / 2, graphics.getFont().getSize());
                    
                    
                    
                } else {
                    graphics.setColor(new Color(88, 250, 84));
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 50));
                    FontMetrics metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Ayudaste a Serpentina", (WIDTH - metrics.stringWidth("Ayudaste a Serpentina")) / 2, HEIGHT / 2);
                    
                    graphics.setColor(Color.white);
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
                    metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Puntuacion: " + score, (WIDTH - metrics.stringWidth("Puntuacion: " + score)) / 2, graphics.getFont().getSize());
                    isLost = false;
                }

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (status) {
			move();
			checkFood();
			checkHit();
		}
		repaint();
	}
	
        public void resetStatus() {
            this.isLost = false;
            this.x = new int[NUMBER_OF_UNITS];
            this.y = new int[NUMBER_OF_UNITS];
            this.snakeLength = 5;
            this.score = 0;
            this.foodX = 0;
            this.foodY = 0;
            this.snakeDirection = 'D';
            this.status = false;
            this.isLost = true;
            this.clock = null;
            
        }
        
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (snakeDirection != 'R') {
						snakeDirection = 'L';
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					if (snakeDirection != 'L') {
						snakeDirection = 'R';
					}
					break;
					
				case KeyEvent.VK_UP:
					if (snakeDirection != 'D') {
						snakeDirection = 'U';
					}
					break;
					
				case KeyEvent.VK_DOWN:
					if (snakeDirection != 'U') {
						snakeDirection = 'D';
					}
					break;		
			}
		}
	}
}