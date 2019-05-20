package programaDianas;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CanvasDiana extends JPanel{
	
	ArrayList<Punto> puntos = new ArrayList<Punto>();
	Color azulitoMasOscuro = new Color(0,23,72);
	Color azul = new Color(34,97,144);
	Color azulito = new Color(0,143,215);
	Color verdesito = new Color(8,250,231);
	
	public CanvasDiana() {
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(azulitoMasOscuro);
		g.fillRect(0, 0, 510, 510);
		g.setColor(Color.WHITE);
		g.fillOval(0, 0, 510, 510);
		g.setColor(azul);
		g.fillOval(5, 5, 500, 500);
		g.setColor(azulito);
		g.fillOval(55,55,400,400);
		g.setColor(azul);
		g.fillOval(105,105,300,300);
		g.setColor(azulito);
		g.fillOval(155,155,200,200);
		g.setColor(azul);
		g.fillOval(205,205,100,100);
		g.setColor(verdesito);
		
		for(int i=0; i<puntos.size();i++) {
			int x,y;
			x = puntos.get(i).x;
			y = puntos.get(i).y;
			g.fillOval(x, y, 3, 3);
		}
		
	}
	
	public void tiraDardo(Punto p, Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(p.x, p.y, 3, 3);
		puntos.add(p);
		repaint();
	}
}

class Punto {
	
	int x,y;
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
