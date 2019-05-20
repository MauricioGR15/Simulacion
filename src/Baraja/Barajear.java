package Baraja;

import javax.swing.*; 
import java.util.*;

public class Barajear 
{
	String [] color = {"b","e","c","o"};
	String [] numero = {"2","3","4","5","6","7","10","11","12","1"};
	String [] baraja;
	Vector<String> vector;
	Vector<lblCartas> cartas;
	JLabel aux;
	Random rnd = new Random();
	double aleatorio;
	
	//Devuelve un tipo de carta por metodo de montecarlo
	public String probabilidadColor() 
	{
		aleatorio = rnd.nextDouble();
		if(aleatorio < 0.25) 
			return "o";
		if(aleatorio > 0.25 && aleatorio < 0.50) 
			return "c";
		if(aleatorio > 0.5 && aleatorio < 0.75) 
			return "e";
		return "b";
	}
	
	//Devuelve un numero de carta por metodo de montecarlo
	public String probabilidadNumero() 
	{
		aleatorio =rnd.nextDouble();
		if(aleatorio < 0.10)
			return "2";
		if(aleatorio > 0.10 && aleatorio < 0.20)
			return "3";
		if(aleatorio > 0.20 && aleatorio < 0.30)
			return "4";
		if(aleatorio > 0.30 && aleatorio < 0.40)
			return "5";
		if(aleatorio > 0.40 && aleatorio < 0.50)
			return "6";
		if(aleatorio > 0.50 && aleatorio < 0.60)
			return "7";
		if(aleatorio > 0.60 && aleatorio < 0.70) 
			return "10";
		if(aleatorio > 0.70 && aleatorio < 0.80)
			return "11";
		if(aleatorio > 0.80 && aleatorio < 0.90)
			return "12";
		
		return "1";
	}
	
	//Metodo en el que llena el arreglo baraja[] con los datos necesarios (las imagenes)
	public void hacerBaraja() 
	{
		baraja = new String[40];
		String str = "";
		int cont = 0;
		for(int i=0,j=0; j<4;i++) 
		{
			str = color[j] + numero[i]+".jpg";	
			baraja[cont++]= str;
			if(i==9) 
			{
				i=-1;
				j++;
			}	
		}
	}
	
	//Metodo para llenar el vector con todos los labels que son imagenes (cada label es una imagen de la baraja)
	public void llenaVector() 
	{
		vector = new Vector<String>(40);
		cartas = new Vector<lblCartas>(40);
		String auxStr;
		for(int i=0; i<40;i++) 
		{
			auxStr = hacerString();
			while(true) 
			{
				while(vector.contains(auxStr)) 
				{
					auxStr = hacerString();
				}
				vector.add(auxStr);
				cartas.add(new lblCartas(auxStr));
				break;
			}
		}
	}
	
	public Vector<lblCartas> llamadaVector()
	{
		hacerBaraja();
		llenaVector();
		
		return cartas;
	}
	
	//El metodo este obtiene la parte de color y la de numeros con metodo montecarlo
	//Se obtiene un string aleatoreamente, va a servir para obtener las cartas
	public String hacerString() 
	{ 
		return probabilidadColor() + probabilidadNumero() + ".jpg";
	}
}