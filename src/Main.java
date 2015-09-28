
/* Enrico Carlo Agrillo VR377929
 * Matteo Brentegani VR376670
 * Andrea Armani VR378136
 */




import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Main {

	public static void main(String[] args) {
		
        EventQueue.invokeLater(new Runnable() {
        	
        	public void run() {
               
        		Grafica cb = new Grafica();
        		JFrame f = new JFrame("Scacchi");
                        f.add(cb.getGrafica());
                        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        f.setLocationByPlatform(true);

                        f.pack();
                        f.setMinimumSize(f.getSize());
                        f.setVisible(true);
   
              }
        });
		

	}
}