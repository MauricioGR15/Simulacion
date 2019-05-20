import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class tiempo {

	public static void main(String[] args) {
		
		GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
		
		int incremento = 20;
		 
        System.out.println(
            new SimpleDateFormat("HH:mm:ss").format(gc.getTime())
        );
 
        // hora actual + incremento
        gc.add(GregorianCalendar.MINUTE, incremento);
 
        System.out.println(
            new SimpleDateFormat("HH:mm:ss").format(gc.getTime())
        );

	}

}
