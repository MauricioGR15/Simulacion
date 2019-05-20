
import javax.swing.JFrame;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

public class MetodoMontecarlo{
	
	DefaultPieDataset grafico;
	int veces = 0,index;
	int cara, cruz;
	double aleatorio;
	String evento;
	Random rnd = new Random();
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.######");
	
	public MetodoMontecarlo() {
		entrada();
		Montecristo();
		hacerGrafico();
	}
	
	private void hacerGrafico() {
	 grafico = new DefaultPieDataset();
	 grafico.setValue("Cara", cara);
	 grafico.setValue("Cruz", cruz);
	 
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
	
	private void entrada() {
		System.out.println("Cuantas veces desea que se lance la moneda?");
		veces = sc.nextInt();
		sc.close();
	}
	
	
	
	private void Montecristo() {
		System.out.println("N \t\t  Numero\t\tEvento");
		while(veces>index) {
			index++;
			aleatorio = rnd.nextDouble();
			if(aleatorio > 0.000001 && aleatorio < 0.5) {
				evento = "cara";
				cara++;
			}
			if(aleatorio > 0.5 && aleatorio <1.000001) {
				evento = "cruz";
				cruz++;
			}
			System.out.println(index + "\t\t  " + df.format(aleatorio )+"\t\t"+ evento);
			
		}
		System.out.println(veces);
		double prcntCara = 100 * cara / veces;
		double prcntCruz = 100 * cruz / veces;
		System.out.println("\nContador de eventos: \nCara >>> " + cara + "\nCruz >>> " +cruz);
		System.out.println("\nPorcentajes: \nCara >>> " + df.format(prcntCara )+"%"  
				+ "\nCruz >>> " + prcntCruz+"%");
		
	}
	
	public static void main(String[] arg) {
		new MetodoMontecarlo();
	}

}
