import javax.swing.JFrame;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

public class MetodoDados {
	
	DefaultPieDataset grafico;
	int veces = 0,index;
	int cara1, cara2,cara3,cara4,cara5,cara6;
	double aleatorio;
	String evento;
	Random rnd = new Random();
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.######");
	DecimalFormat df2 = new DecimalFormat("0.##");
	
	public MetodoDados() {
		entrada();
		metodoMontecarlo();
		hacerGrafico();
	}
	
	private void entrada() {
		System.out.println("Cuantas veces desea que se lancen los dados?");
		veces = sc.nextInt();
		sc.close();
	}
	
	private void hacerGrafico() {
		 grafico = new DefaultPieDataset();
		 grafico.setValue("Uno", cara1);
		 grafico.setValue("Dos", cara2);
		 grafico.setValue("Tres", cara3);
		 grafico.setValue("Cuatro", cara4);
		 grafico.setValue("Cinco", cara5);
		 grafico.setValue("Seis", cara6);
		 
		 JFreeChart chart = ChartFactory.createPieChart("Metodo de Montecarlo",grafico,true,true,false);
		 LegendTitle legend = chart.getLegend();
		 legend.setPosition(RectangleEdge.LEFT);
		 
		 PiePlot plot = (PiePlot) chart.getPlot();
	     plot.setLabelFont(new Font("ComicSans", Font.PLAIN, 12));
	     plot.setNoDataMessage("No data available");
	     plot.setLabelGap(0.02);
		 
		 ChartFrame frame = new ChartFrame("Metodo Montecarlo",chart);
		 frame.pack();
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		}
	
	private void metodoMontecarlo() {
		System.out.println("N \t\t  Numero\t\tEvento");
		while(veces>index) {
			index++;
			aleatorio = rnd.nextDouble();
			if(aleatorio > 0.000001 && aleatorio < 0.166667) {
				evento = "Uno";
				cara1++;
			}
			else if(aleatorio > 0.1666667 && aleatorio < 0.033334) {
				evento = "Dos";
				cara2++;
			}
			else if(aleatorio > 0.333334 && aleatorio < 0.500001) {
				evento = "Tres";
				cara3++;
			}
			else if(aleatorio > 0.500001 && aleatorio < 0.666667) {
				evento = "Cuatro";
				cara4++;
			}
			else if(aleatorio > 0.666667 && aleatorio < 0.833334) {
				evento = "Cinco";
				cara5++;
			}
			else if(aleatorio > 0.833334 && aleatorio <1) {
				evento = "Seis";
				cara6++;
			}
			System.out.println(index + "\t\t  " + df.format(aleatorio )+"\t\t"+ evento);
			
		}
		System.out.println(veces);
		double prcntCara1 = 100 * cara1 / veces;
		double prcntCara2 = 100 * cara2 / veces;
		double prcntCara3 = 100 * cara3 / veces;
		double prcntCara4 = 100 * cara4 / veces;
		double prcntCara5 = 100 * cara5 / veces;
		double prcntCara6 = 100 * cara6 / veces;
		System.out.println("\nContador de eventos: \nUno >>> " + cara1 + "\nDos >>> " +cara2
				+ "\nTres >>> " + cara3 + "\nCuatro >>> " + cara4 + "\nCinco >>> " 
				+ cara5 + "\nSeis >>> " + cara6);
		System.out.println("\nPorcentajes: \nUno >>> " + df2.format(prcntCara1 )+"%"  
				+ "\nDos >>> " + df2.format(prcntCara2 )+"%" + "\nTres >>> " + df.format(prcntCara3 )+"%"
				+ "\nCuatro >>> " + df.format(prcntCara4 )+"%" + "\nCinco >>> " + df.format(prcntCara5 )+"%"
				+ "\nSeis >>> " + df.format(prcntCara6 )+"%");
	}
	
	
	public static void main(String ar[]) {
		new MetodoDados();
	}

}
