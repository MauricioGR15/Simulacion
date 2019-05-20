import java.util.*;

public class Evaluacion {

	Random rnd = new Random();
	Scanner sc = new Scanner(System.in);
	
	public Evaluacion() {
		
		
		
	}
	
	
	
	private int cantCamiones() {
		double alea = rnd.nextDouble();
		if(alea < 0.50)
			return 0;
		else if(alea > 0.50 && alea < 0.75)
			return 1;
		else if(alea > 0.75 && alea < 0.90)
			return 2;
		else 
			return 3;

	}
	
	private int tiempoEntreLlegadas() {
		double alea = rnd.nextDouble();
		if(alea < 0.02) return 20;
		if(alea > 0.02 && alea < 0.10) return 25;
		if(alea > 0.10 && alea < 0.22) return 30;
		if(alea > 0.22 && alea < 0.47) return 35;
		if(alea > 0.47 && alea < 0.67) return 40;
		if(alea > 0.67 && alea < 0.82) return 45;
		if(alea > 0.82 && alea < 0.92) return 50;
		if(alea > 0.92 && alea < 0.97) return 55;
		return 60;
	}
	
	public static void main(String args[]) {
		new Evaluacion();
		
	}
	
	
}
