import java.util.*;
public class Ruleta {

	public Ruleta() {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("¿Cuántas simulaciones desea hacer?");
		int nVeces = sc.nextInt();
		int Jug1 = 200,Jug2 = 200, jug2Apuesta = 1;
		sc.close();
		
		System.out.println("n \t ");
		for(int i=0; i<nVeces;i++) {
			
			double num = r.nextDouble();
			char c = Montecarlo(num);
			
			switch(c) {
			case 'r':
				Jug1++;
				
				break;
			case 'n':
				Jug1--;
				
				
				break;
			case 'v':
				Jug1--;
				
				break;
			}
			
			
		}
		
		
		
	}
	
	
	public char Montecarlo(double aleat) {
		
		if(aleat<0.45) return 'r';
		if(aleat>=0.45 || aleat<0.90) return 'n';
		return 'v';
		
	}
	
	
	public static void main(String[] args) {
		new Ruleta();
	}

}
