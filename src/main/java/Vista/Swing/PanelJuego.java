/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;



public class PanelJuego extends JPanel implements ActionListener{
	
	static final int ANCHO = 500;
	static final int ALTO = 500;
	static final int MEDIDA_UNIDAD = 20;
	static final int NUMERO_UNIDADES = (ANCHO * ALTO) / (MEDIDA_UNIDAD * MEDIDA_UNIDAD);

	// Coordenadas de las partes de la serpiente
	int x[] = new int[NUMERO_UNIDADES];
	int y[] = new int[NUMERO_UNIDADES];
	
	int largo = 5;
	int puntos;
	int comidaX;
	int comidaY;
	char direccion = 'D';
	boolean estado = false;
        boolean perdido = true;
	Random random;
	Timer reloj;
	
	PanelJuego() {
		random = new Random();
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		jugar();
	}	
	
	public void jugar() {
		ponerComida();
		estado = true;
		
		reloj = new Timer(80, this);
		reloj.start();
                
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		dibujar(graphics);
	}
	
	public void mover() {
		for (int i = largo; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		if (direccion == 'L') {
			x[0] = x[0] - MEDIDA_UNIDAD;
		} else if (direccion == 'R') {
			x[0] = x[0] + MEDIDA_UNIDAD;
		} else if (direccion == 'U') {
			y[0] = y[0] - MEDIDA_UNIDAD;
		} else {
			y[0] = y[0] + MEDIDA_UNIDAD;
		}	
	}
	
	public void comprobarComida() {
		if(x[0] == comidaX && y[0] == comidaY) {
			largo++;
			puntos++;
			ponerComida();
		}
	}
	
	public void dibujar(Graphics graphics) {
		
		if (estado) {
			graphics.setColor(new Color(210, 115, 90));
			graphics.fillOval(comidaX, comidaY, MEDIDA_UNIDAD, MEDIDA_UNIDAD);
			
			graphics.setColor(Color.white);
			graphics.fillRect(x[0], y[0], MEDIDA_UNIDAD, MEDIDA_UNIDAD);
			
			for (int i = 1; i < largo; i++) {
				graphics.setColor(new Color(40, 200, 150));
				graphics.fillRect(x[i], y[i], MEDIDA_UNIDAD, MEDIDA_UNIDAD);
			}
			
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
			FontMetrics metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Puntuacion: " + puntos, (ANCHO - metrics.stringWidth("Puntuacion: " + puntos)) / 2, graphics.getFont().getSize());
		
		} else {
			juegoPerdido(graphics);
		}
	}
	
	public void ponerComida() {
		comidaX = random.nextInt((int)(ANCHO / MEDIDA_UNIDAD))*MEDIDA_UNIDAD;
		comidaY = random.nextInt((int)(ALTO / MEDIDA_UNIDAD))*MEDIDA_UNIDAD;
	}
	
	public void comprobarGolpe() {
		
		for (int i = largo; i > 0; i--) {
			if (x[0] == x[i] && y[0] == y[i]) {
				estado = false;
			}
		}
		
		// check if head run into walls
		if (x[0] < 0 || x[0] > ANCHO || y[0] < 0 || y[0] > ALTO) {
			estado = false;
		}
		
		if(!estado) {
			reloj.stop();
		}
	}
	
	public void juegoPerdido(Graphics graphics) {
                if (puntos < 5) {
                    graphics.setColor(new Color(88, 250, 84));
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 50));
                    FontMetrics metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Perdiste", (ANCHO - metrics.stringWidth("Perdiste")) / 2, ALTO / 2);
                    
                    graphics.setColor(Color.white);
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
                    metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Puntuacion: " + puntos, (ANCHO - metrics.stringWidth("Puntuacion: " + puntos)) / 2, graphics.getFont().getSize());
                    
                    
                    
                } else {
                    graphics.setColor(new Color(88, 250, 84));
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 50));
                    FontMetrics metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Ayudaste a Serpentina", (ANCHO - metrics.stringWidth("Ayudaste a Serpentina")) / 2, ALTO / 2);
                    
                    graphics.setColor(Color.white);
                    graphics.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
                    metrics = getFontMetrics(graphics.getFont());
                    graphics.drawString("Puntuacion: " + puntos, (ANCHO - metrics.stringWidth("Puntuacion: " + puntos)) / 2, graphics.getFont().getSize());
                    perdido = false;
                }

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (estado) {
			mover();
			comprobarComida();
			comprobarGolpe();
		}
		repaint();
	}
	
        public void reiniciarEstado() {
            this.perdido = false;
            this.x = new int[NUMERO_UNIDADES];
            this.y = new int[NUMERO_UNIDADES];
            this.largo = 5;
            this.puntos = 0;
            this.comidaX = 0;
            this.comidaY = 0;
            this.direccion = 'D';
            this.estado = false;
            this.perdido = true;
            this.reloj = null;
            
        }
        
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (direccion != 'R') {
						direccion = 'L';
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					if (direccion != 'L') {
						direccion = 'R';
					}
					break;
					
				case KeyEvent.VK_UP:
					if (direccion != 'D') {
						direccion = 'U';
					}
					break;
					
				case KeyEvent.VK_DOWN:
					if (direccion != 'U') {
						direccion = 'D';
					}
					break;		
			}
		}
	}
}