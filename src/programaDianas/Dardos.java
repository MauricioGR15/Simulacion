package programaDianas;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Dardos extends JFrame implements ActionListener{

	Image img;
	JPanel panel,panelSur,panelNorte;
	JTextField numTiros;
	JButton btnInicia;
	Timer T = new Timer(50,this);
	Color azulito = new Color(0,143,215);
	CanvasDiana panelDiana;
	JLabel LBLpi, LBLaciertos;
	int cont,num,aciert;
	double dist;
	double Pi;
	DecimalFormat df = new DecimalFormat("0.####");
	
	public Dardos() {
		super("Dardos");
		
		hazInterfaz();
	}
	
	public void hazInterfaz() {
		setSize(900,550);
		panelDiana = new CanvasDiana();
		panelDiana.setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(null);
		
		panelNorte = new JPanel();
		panelSur = new JPanel(new GridLayout(0,4,5,5));
		LBLaciertos = new JLabel("0",SwingConstants.LEFT);
		LBLpi = new JLabel("0",SwingConstants.LEFT);
		
		
		JLabel lblPi = new JLabel("Pi: ",SwingConstants.RIGHT);
		lblPi.setForeground(Color.WHITE);
		LBLpi.setForeground(Color.WHITE);
		
		panelSur.add(lblPi);
		panelSur.add(LBLpi);
		
		JLabel lblAciertos = new JLabel("Aciertos: ",SwingConstants.RIGHT);
		lblAciertos.setForeground(Color.WHITE);
		LBLaciertos.setForeground(Color.WHITE);
		
		panelSur.setBackground(null);
		panelSur.add(lblAciertos);
		panelSur.add(LBLaciertos);
		
		JLabel label = new JLabel("Numero de tiros >>>",SwingConstants.RIGHT);
		label.setForeground(azulito);
		btnInicia = new JButton("INICIA");
		btnInicia.setBackground(azulito);
		numTiros = new JTextField(15);
		
		btnInicia.addActionListener(this);
		
		panelNorte.setBackground(null);
		panelNorte.add(label);
		panelNorte.add(numTiros);
		panelNorte.add(btnInicia);
		panel.add(panelNorte,BorderLayout.NORTH);
		panel.add(panelSur,BorderLayout.CENTER);
		
		add(panel,BorderLayout.EAST);
		add(panelDiana);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		panelDiana.repaint();
	}
	


	public static void main(String[]a) {
		new Dardos();		
	}
	
	public void paint(Graphics g) {
		Image img = new ImageIcon("dianaImg/fondo.jpg").getImage();
		g.drawImage(img, 0,0,getWidth(),getHeight(),null);
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == btnInicia) {
			cont=0;
			Pi=0;
			dist=0;
			aciert=0;
			T.start();
			LBLpi.setText("0");
			LBLaciertos.setText("0");
			num = Integer.parseInt(numTiros.getText());
			panelDiana.puntos.clear();
			panelDiana.repaint();
			return;
		}
		
		if(evt.getSource()== T) {
			int x,y;	
			while(cont<num) {
				x = Rutinas.nextInt(0, 508);
				y = Rutinas.nextInt(0, 508);
				Punto aux = new Punto(x,y);
				
				dist = Math.pow((x-255)*(x-255)+(y-255)*(y-255),0.5);
				if(dist<=255) 
					aciert++;
				
				panelDiana.tiraDardo(aux,panelDiana.getGraphics());
				cont++;
			}
			
			LBLaciertos.setText(aciert+"");
			Pi = ((double)aciert/(double)num)*4;
			LBLpi.setText(df.format(Pi)+"");
			System.out.println(aciert);
			System.out.println(Pi);
			T.stop();
			return;
		}
		
	}
	
	
	

}
