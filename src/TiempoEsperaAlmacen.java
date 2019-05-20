import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class TiempoEsperaAlmacen {
	
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	double alea, alea2;
	double TiempoDeLlegada=0, OcioDePersonal=0, TerminacionDeServicio=0,TiempoEsperaCamion=0;
	double   TiempoEntreLlegada=0, totalOcio=0,TiempoDeServicio=0, InicioDeServicio=0;
	double E1,E2,E3, E4, E5 = 8;
	int LongCola=0, cantCamiones=0, Simulaciones;
	boolean comida = false;
	
	public TiempoEsperaAlmacen(){
		
		DecimalFormat df = new DecimalFormat("#.0000");
		DecimalFormat ct = new DecimalFormat("#.00");
		
		System.out.println("#Alea1\tTi/Ll\tTiDLl\tInDS\t#Alea2\tTiDS\tTeDS\tOcDP\tTiEC\tLoDC");
		for(int i=0; InicioDeServicio<7; i++){		
			
			if(i==0){
				LongCola = cantidadCamiones(random.nextDouble());
				LongCola++;
				TiempoDeLlegada = 0;
				InicioDeServicio = TiempoDeLlegada;
				alea2 = random.nextDouble();
				TiempoDeServicio = formatMins(tiempoDeServicio(alea2));
				TerminacionDeServicio = InicioDeServicio+TiempoDeServicio;
				OcioDePersonal = 0;
				TiempoEsperaCamion = 0;
			}
			else{
				LongCola++;
				alea = random.nextDouble();
				TiempoEntreLlegada = formatMins(tiempoEntreLlegadas(alea));
				TiempoDeLlegada += TiempoEntreLlegada;

				if(TiempoDeLlegada>TerminacionDeServicio) {
					OcioDePersonal = TiempoDeLlegada - TerminacionDeServicio;
					InicioDeServicio = TiempoDeLlegada;
				}
				else {
					TiempoEsperaCamion = TerminacionDeServicio - TiempoDeLlegada;
					InicioDeServicio = TerminacionDeServicio;
				}

				alea2 = random.nextDouble();
				TiempoDeServicio = formatMins(tiempoDeServicio(alea2));
				TerminacionDeServicio = InicioDeServicio+TiempoDeServicio;			
			}
			
			LongCola--;
			E1 = E1+ Integer.parseInt(formatTiempo2(TiempoEsperaCamion));
			E2 = (double) 100/60;

			System.out.println(df.format(alea) + "\t" + formatTiempo2(TiempoEntreLlegada) + "\t" + formatTiempo(TiempoDeLlegada) + "\t" + formatTiempo(InicioDeServicio) 
					+ "\t" + df.format(alea2) + "\t" + formatTiempo2(TiempoDeServicio) + "\t" + formatTiempo2(TerminacionDeServicio) + "\t" 
					+ formatTiempo2(OcioDePersonal) + "\t" + formatTiempo2(TiempoEsperaCamion) + "\t" + LongCola);
			
			OcioDePersonal = 0;
			TiempoEsperaCamion = 0;
		}
		
		if (TerminacionDeServicio >7.5) {
			
			E3= TerminacionDeServicio-7.5;
			E5=E5+E3;
			E3 = Double.parseDouble(formatTiempo2(E3));
			E3= (((double) 37.5/60)* E3) * 3;
			
		}
		

		E4 = (3*25*8);
		E5= E5*500;
		E1=E1*E2;
		System.out.println("\nCOSTO TOTAL DE ESPERA $" +ct.format(E1));
		System.out.println("\nCOSTO TOTAL POR SALARIOS: $" +ct.format(E4));
		System.out.println("\nCOSTO TOTAL POR HORAS EXTRA: $" +ct.format(E3));
		System.out.println("\nCOSTO TOTAL POR OPERACION DE ALMACEN : $" +ct.format(E5));
		System.out.println("\nCOSTO TOTAL DEL TURNO : $" +ct.format(E1+E4+E3+E5));

		

		sc.close();
	}
	
	public double formatMins(double mins) {
		return mins/60;
	}
	
	public String formatTiempo(double tiempo) {
		int h = (int)tiempo;
        int m = (int)((tiempo-h)*60);
        if(m%5 != 0)
        	m+=1;
        
        h+=11;
        if(h>12) 
        	h=h-12;
        
        return (h==0)?m+"":h+":"+m;
	}
	
	public String formatTiempo2(double tiempo) {
		int h = (int)tiempo;
        int m = (int)((tiempo-h)*60);
        if(m%5 != 0)
        	m+=1;
        
        if(h==1) {
        	m = 60;
        	return m+"";
        }

        	
        
        return (h==0)?m+"":h+":"+m;
	}
	
	public int cantidadCamiones(double r){
		if(r>=0.0 && r<=0.5) return 0;
		if( r>0.5 && r<=0.75 ) return 1;
		if( r>0.75 && r<=0.90 ) return 2;
		return 3;
	}
	
	public int tiempoEntreLlegadas(double r){
		if(r>=0.0 && r<=0.02) return 20;
		if( r>0.02 && r<=0.10 ) return 25;
		if( r>0.10 && r<=0.22 ) return 30;
		if( r>0.22 && r<=0.47 ) return 35;
		if( r>0.47 && r<=0.67 ) return 40;
		if( r>0.67 && r<=0.82 ) return 45;
		if( r>0.82 && r<=0.92 ) return 50;
		if( r>0.92 && r<=0.97 ) return 55;
		return 60;
	}
	
	public static int tiempoDeServicio(double r){
		if(r>=0.0 && r<=0.05) return 20;
		if( r>0.05 && r<=0.15 ) return 25;
		if( r>0.15 && r<=0.35 ) return 30;
		if( r>0.35 && r<=0.60 ) return 35;
		if( r>0.60 && r<=0.72 ) return 40;
		if( r>0.72 && r<=0.82 ) return 45;
		if( r>0.82 && r<=0.90 ) return 50;
		if( r>0.90 && r<=0.96 ) return 55;
		return 60;
	}
	
	public static void main(String[] args){
		new TiempoEsperaAlmacen();
	}
}
