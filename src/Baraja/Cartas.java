package Baraja;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Cartas extends JFrame implements ActionListener
{
	//Paneles
	private JPanel pnlNorte, pnlSur, pnlEste, pnlOeste, pnlCentro;
	//Imagenes de jugadores
	private JLabel lblJ1, lblJ2, lblJ3, lblJ4;
	//Cartas
	private JLabel lblCJ1, lblCJ2, lblCJ3, lblCJ4;
	//Selección de simulaciones a realizar / Datos a mostrar
	private JButton btnIniciar;
	private JTextField jtfNumeroPartidas;
	private JLabel lblNumeroPartidas, lblVictorias, lblGanador;
	private JLabel lblVJ1, lblVJ2, lblVJ3, lblVJ4;
	Barajear barajear=new Barajear();
	Vector<JLabel> J1=new Vector<JLabel>(10);
	Vector<JLabel> J2=new Vector<JLabel>(10);
	Vector<JLabel> J3=new Vector<JLabel>(10);
	Vector<JLabel> J4=new Vector<JLabel>(10);
	Timer T = new Timer(1000,this);
	
	public Cartas() 
	{
    	super("Juego de Cartas");
    	setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
        IniciarComponentes();
    }
	
	public void IniciarComponentes() 
	{
		lblNumeroPartidas=new JLabel("Partidas a jugar");
		jtfNumeroPartidas=new JTextField(8);
		btnIniciar=new JButton("Empezar");
		btnIniciar.setPreferredSize(new Dimension(93,25));
		btnIniciar.addActionListener(this);
		lblVictorias=new JLabel("Victorias:");
		lblGanador=new JLabel("");
		
		lblVJ1=new JLabel("Jugador 1: ");
		lblVJ2=new JLabel("Jugador 2: ");
		lblVJ3=new JLabel("Jugador 3: ");
		lblVJ4=new JLabel("Jugador 4: "); 
		
		lblJ1=new JLabel("JUGADOR 1");
		lblJ2=new JLabel("JUGADOR 2");
		lblJ3=new JLabel("JUGADOR 3");
		lblJ4=new JLabel("JUGADOR 4");
		 
		lblCJ1=new JLabel(new ImageIcon(new ImageIcon("src/Cartas/o5.jpg").getImage()));
		lblCJ2=new JLabel(new ImageIcon(new ImageIcon("src/Cartas/o5.jpg").getImage()));
		lblCJ3=new JLabel(new ImageIcon(new ImageIcon("src/Cartas/o5.jpg").getImage()));
		lblCJ4=new JLabel(new ImageIcon(new ImageIcon("src/Cartas/o5.jpg").getImage()));
		 
		pnlNorte=new JPanel();
		//pnlNorte.setLayout(new GridBagLayout());
		
		pnlSur=new JPanel();
		//pnlSur.setLayout(new GridLayout(2,2));
		
		pnlEste=new JPanel();
		//pnlEste.setLayout(new GridLayout(2,2));
		
		pnlOeste=new JPanel();
		//pnlOeste.setLayout(new GridLayout(2,2));
		
		pnlCentro=new JPanel();
		pnlCentro.setLayout(new GridBagLayout());
		
		//PANEL NORTE
		pnlNorte.setBackground(new Color(62,168,239));
		pnlNorte.add(lblJ1);
		pnlNorte.add(lblCJ1);
		pnlNorte.add(lblVJ1);
		add(pnlNorte, BorderLayout.NORTH);
		 
		//PANEL SUR
		pnlSur.setBackground(new Color(62,168,239));
		pnlSur.add(lblJ2);
		pnlSur.add(lblCJ2);
		pnlSur.add(lblVJ2);
		add(pnlSur, BorderLayout.SOUTH);
		
		//PANEL ESTE
		pnlEste.setBackground(new Color(62,168,239));
		pnlEste.add(lblJ3);
		pnlEste.add(lblCJ3);
		pnlEste.add(lblVJ3);
		add(pnlEste, BorderLayout.EAST);
		 
		//PANEL OESTE
		pnlOeste.setBackground(new Color(62,168,239));
		pnlOeste.add(lblJ4);
		pnlOeste.add(lblCJ4);
		pnlOeste.add(lblVJ4);
		add(pnlOeste, BorderLayout.WEST);
		 
		//PANEL CENTRO
		pnlCentro.setBackground(new Color(62,168,239));
		GridBagConstraints gbc=new GridBagConstraints();
	    gbc.weightx=0;
	    gbc.weighty=0;
	    
	    gbc.gridx=0;
	    gbc.gridy=0;
	    gbc.gridwidth=2;
		pnlCentro.add(lblNumeroPartidas, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=1;
		pnlCentro.add(jtfNumeroPartidas, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=3;
		pnlCentro.add(lblVictorias, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=8;
		pnlCentro.add(lblGanador, gbc);
		
		gbc.gridwidth=0;
		gbc.gridx=0;
	    gbc.gridy=2;
		pnlCentro.add(btnIniciar, gbc);
		
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=0;
	    gbc.gridy=4;
		pnlCentro.add(lblVJ1, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=5;
		pnlCentro.add(lblVJ3, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=6;
		pnlCentro.add(lblVJ2, gbc);
		
		gbc.gridx=0;
	    gbc.gridy=7;
		pnlCentro.add(lblVJ4, gbc);
		
		add(pnlCentro, BorderLayout.CENTER);	 
	}

	public int Jerarquia(String jerarquia){
        int retorno=41;
        switch(jerarquia){
            case "o1":
                retorno = 1;
                break;
            case "c1":
                retorno = 2;
                break;
            case "e1":
                retorno = 3;
                break;
            case "b1":
                retorno = 4;
                break;
            case "b2":
                retorno = 40;
                break;
            case "e2":
                retorno = 39;
                break;
            case "c2":
                retorno = 38;
                break;
            case "o2":
                retorno = 37;
                break;
            case "b3":
                retorno = 36;
                break;
            case "e3":
                retorno = 35;
                break;
            case "c3":
                retorno = 34;
                break;
            case "o3":
                retorno = 33;
                break;
            case "b4":
                retorno = 32;
                break;
            case "e4":
                retorno = 31;
                break;
            case "c4":
                retorno = 30;
                break;
            case "o4":
                retorno = 29;
                break;
            case "b5":
                retorno = 28;
                break;
            case "e5":
                retorno = 27;
                break;
            case "c5":
                retorno = 26;
                break;
            case "o5":
                retorno = 25;
                break;
            case "b6":
                retorno = 24;
                break;
            case "e6":
                retorno = 23;
                break;
            case "c6":
                retorno = 22;
                break;
            case "o6":
                retorno = 21;
                break;
            case "b7":
                retorno = 20;
                break;
            case "e7":
                retorno = 19;
                break;
            case "c7":
                retorno = 18;
                break;
            case "o7":
                retorno = 17;
                break;
            case "b10":
                retorno = 16;
                break;
            case "e10":
                retorno = 15;
                break;
            case "c10":
                retorno = 14;
                break;
            case "o10":
                retorno = 13;
                break;
            case "b11":
                retorno = 12;
                break;
            case "e11":
                retorno = 11;
                break;
            case "c11":
                retorno = 10;
                break;
            case "o11":
                retorno = 9;
                break;
            case "b12":
                retorno = 8;
                break;
            case "e12":
                retorno = 7;
                break;
            case "c12":
                retorno = 6;
                break;
            case "o12":
                retorno = 5;
                break;
        }
        return retorno;
    }
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==btnIniciar)
		{
			if(jtfNumeroPartidas.getText().isEmpty())
				return;
			T.start();
			return;
		}
		
		if(evt.getSource()==T)
		{
			Vector<lblCartas> auxcartas=new Vector<lblCartas>(40);
			int contJugadas=0, verificador=0, cartasJ1, cartasJ2, cartasJ3, cartasJ4;
			int VicJ1, VicJ2, VicJ3, VicJ4, contN=0;
			
			int N=Integer.parseInt(jtfNumeroPartidas.getText());
			VicJ1=0;
			VicJ2=0;
			VicJ3=0;
			VicJ4=0;
			
			//Acabalo como puedas xd
			do //Otro ciclo, ten en cuenta que esto se va ejecutando una vez por vez cada tick del Timer
			{
				while(contJugadas<10) //No puedes usar un ciclo while ni for, cada vez que se haga un tick del Timer es una vez que se llama al ActionPermormed
				{
					if(verificador==0)	//Este if si esta bien, porque solo lo va a hacer cuando el juego inicie
					{
						barajear.hacerBaraja();
						barajear.llenaVector();
						auxcartas=barajear.llamadaVector();
					
						for(int i=0; i<auxcartas.size(); i++)		
						{
							if(i<10)
								J1.add(auxcartas.get(i));
	            	
							if(i<20 && i>=10)
								J2.add(auxcartas.get(i));
	            	
							if(i<30 && i>=20)
								J3.add(auxcartas.get(i));
	            	
							if(i<40 && i>=30)
								J4.add(auxcartas.get(i));
						}
					}
					
					//Cambio de cartas por cada turno
					lblCJ1.setIcon(new ImageIcon());	//Tendrias que ir poniendo la imagen o el lbl mas bien
		            lblCJ2.setIcon(new ImageIcon());	//dependiendo del vector. Si es el turno 5 jalarias 
		            lblCJ3.setIcon(new ImageIcon());	//la posicion 5 del respectivo vector de cada jugador
		            lblCJ4.setIcon(new ImageIcon());	//Tambien hacer la actualizacion del lbl
					verificador++;
				} //Fin de los 10 turnos por jugador
				
				lblVJ1.setText("Jugador 1: "+VicJ1);
	            lblVJ2.setText("Jugador 2: "+VicJ2);
	            lblVJ3.setText("Jugador 3: "+VicJ3);
	            lblVJ4.setText("Jugador 4: "+VicJ4);
	            
				contN++;	//contN se estaria avanzando cuando verificador haya hecho todos los turnos, otra cond
			}while(contN<N); //Fin de todos los juegos	//Aqui tienes que quitar el while y poner una cond de que cuando el contador de los juegos sea igual al numJuegos entonces el Timer se para y acaba 
		}
	}

	public static void main(String[] args) 
	{
		new Cartas().setVisible(true);
	}
}
