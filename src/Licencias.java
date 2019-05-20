import java.awt.Font;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

public class Licencias {

	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int licV,licD;
	double costo,ingresoVta,ingresoDev,utilidad;
	DecimalFormat df = new DecimalFormat("0.####");
	DefaultPieDataset grafico;
	int Cont100,Cont150,Cont200,Cont250,Cont300;
	double promedio;

	public Licencias() {

		System.out.print("Cuantas veces desea realizar la simulacion?: ");
		int veces = sc.nextInt();
		System.out.println("Cuantas licencias se van a comprar?");
		int numLics = sc.nextInt();

		System.out.println("N \tNum Aleatorio\tLic Vendidas\tLic Devueltas"
				+ "\tCosto\t\tIngreso x Vta\tIngreso x Dev\tUtilidad");
		for(int i=1; i<=veces;i++) {
			double numA = r.nextDouble();

			if(probabilidad(numA)<= numLics)
				licV = probabilidad(numA);
			else
				licV = numLics;

			if(licV <= numLics)
				licD = numLics-licV;
			else
				licD = 0;

			costo = numLics*75;
			ingresoVta = licV*100;
			ingresoDev = licD*25;
			utilidad = ingresoVta+ingresoDev -costo;

			promedio += utilidad;
			System.out.println(i+"\t"+df.format(numA)+"\t\t"+licV+"\t\t"+licD+"\t\t"+costo
					+"\t\t"+ingresoVta
					+ "\t\t"+ingresoDev+"\t\t"+utilidad);
		}
		System.out.println("Promedio utilidad >>> " + promedio/veces);
		hacerGrafico();
	}

	private void hacerGrafico() {
		grafico = new DefaultPieDataset();
				 grafico.setValue("100", Cont100);
				 grafico.setValue("150", Cont150);
				 grafico.setValue("200", Cont200);
				 grafico.setValue("250", Cont250);
				 grafico.setValue("300", Cont300);

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

	public int probabilidad(double num) {
		if(num >= 0 && num <=0.30){
			Cont100++;
			return 100;
		}
		if(num >= 0.300001 && num <=0.50){
			Cont150++;
			return 150;
		}	
		if(num >= 0.500001 && num <=0.80){
			Cont200++;
			return 200;
		}
		if(num >= 0.800001 && num <=0.95){
			Cont250++;
			return 250;
		}
		if(num >= 0.9500001 && num <=1.0){
			Cont300++;
			return 300;
		}
			
		return 0;
	}

	public static void main (String args[]) {
		new Licencias();
	}
}
