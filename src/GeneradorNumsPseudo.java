import java.util.Random;

public class GeneradorNumsPseudo {

	public static void main(String[] args) {
		Random random = new Random();
		for(int i = 0; i < 36; i++) {
			if(i%6 == 0) System.out.println();
			
			System.out.printf("%.5f \t", random.nextDouble());
		}

	}

}
