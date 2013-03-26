import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * VL Interaktive Systeme, Angewandte Informatik, DHBW Mannheim
 * Prof. Dr. Eckhard Kruse
 */
public class ISMain extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ISMain gui = new ISMain();
				gui.setLocationRelativeTo(null);
			}
		});					
	}
	
	public ISMain() {
		MainPanel mainPanel;
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
				
	    setSize(1024, 700);
	    setVisible(true);	  		
		setResizable(true);
	    setTitle("Tastatureingabe");

		mainPanel =  new MainPanel();
		this.getContentPane().add(mainPanel);
	} 
}
