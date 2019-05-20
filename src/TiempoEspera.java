import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class TiempoEspera {

	final static String operaciones[] = {"CONSULTA SALDO ","OTROS ","RETIROS ","TRANSFERENCIAS "};
	final static double tardanza[] = {1.20,0.50,2,1};

	public TiempoEspera() {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		double alea,alea2;
		double tEsperaL=0, momDL=0, tieEsp=0, tieTerm=0, tieIni;
		double tiempoPromedio = 0;
		int n, operacion;
		System.out.println("Ingrese numero de veces a simular: ");
		n=sc.nextInt();
		DecimalFormat df = new DecimalFormat("#.000");

		System.out.println("Usuario\t#Alea1\tTEspL\tMomDL\tTieIni\tTEesp\t#Alea2\tOperacion\tTieOp\tTieT");
		for(int i=0; i<n ; i++){

			alea = random.nextDouble();
			tEsperaL=calculaMinutos(alea);
			momDL=momDL+tEsperaL;
			if(i==0){
				tieIni= momDL;
				tieEsp = 0;
			}
			else{

				if(momDL<tieTerm){
					tieIni = tieTerm;
					tieEsp=tieTerm-momDL;
				}else {
					tieEsp=0;
					tieIni = momDL;
				}

			}
			tiempoPromedio+=tieEsp;
			alea2 = random.nextDouble();
			operacion = metodoMontecarlo(alea);
			tieTerm = tieIni+(tardanza[operacion]);
			
			System.out.println((i+1)+"\t"+df.format(alea)+"\t"+df.format(tEsperaL)+"\t"+df.format(momDL)+"\t"+df.format(tieIni)+"\t"+df.format(tieEsp)+"\t"+df.format(alea2)+
					"\t"+operaciones[operacion]+(operacion==1?"\t\t":"\t")+tardanza[operacion]+"\t"+df.format(tieTerm));
		}
		double prom=tiempoPromedio/n;
		System.out.println("\nPROMEDIO TIEMPO DE ESPERA : "+prom);
		sc.close();
	}

	public double calculaMinutos(double r){
		double aux;
		aux = (-Math.log(1-r)/30)*60;

		return aux;
	}

	public static int metodoMontecarlo(double r){
		if(r<=0.25) return 0;
		if( r>0.25 && r<=0.50 ) return 1;
		if( r>0.50 && r<=0.85 ) return 2;
		return 3;
	}

	public static void main (String args []) {
		new TiempoEspera();
	}

}
