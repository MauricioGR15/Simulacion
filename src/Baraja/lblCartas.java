package Baraja;

import javax.swing.JLabel;

public class lblCartas extends JLabel
{
	private String Nombre;
	
	public lblCartas(String nombre){
		Nombre= nombre;
	}
	
	public String getNombre() 
	{
		return Nombre;
	}
}
