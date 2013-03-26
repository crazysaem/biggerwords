import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	// Mouse data
    ArrayList<TextCharacter> myString;
    
    private long startKeypress, endKeypress;
    private boolean newKey = true;
    private static int count = 0;
    
    public MainPanel() {
        setBackground(Color.DARK_GRAY);
        myString=new ArrayList<TextCharacter>();
        /*myString.add(new TextCharacter('T', 50f));
        myString.add(new TextCharacter('e', 50f));
        myString.add(new TextCharacter('s', 50f));
        myString.add(new TextCharacter('t', 50f));*/
        
        //Timer timer = new Timer(10, this);
        //timer.start();
        this.setFocusable(true);
        this.addKeyListener(this);
        
        Timer t = new Timer(1, this);
        t.start();
    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	Rectangle r=g.getClipBounds();
    	int x=10, y=200;
        Iterator<TextCharacter> iter = myString.iterator();
        while(iter.hasNext()) {
          x= iter.next().render(g, x, y);
          if(x>r.width) { x=10; y+=30; }
        }
    }

    public void actionPerformed(ActionEvent actionEvent) 
    {
    	this.repaint();
    	
    	if (!newKey)
    	{
    		char c = myString.get(myString.size() - 1).getChar();
    		myString.remove(myString.size() - 1);
			endKeypress = System.nanoTime();
			long duration = endKeypress - startKeypress;	
			double fduration = duration * 0.000000001;		
			myString.add(new TextCharacter(c, (float) (fduration * 200)));	
    	}
    }

	@Override
	public void keyPressed(KeyEvent e) 
	{		
		if (e.getKeyCode() == 8)
		{
			if (myString.size() >= 1)
			{
				myString.remove(myString.size() - 1);
			}
		}
		
		if (newKey/* && isValidKey(e.getKeyChar())*/)
		{
			startKeypress = System.nanoTime();
			newKey = false;
			
			endKeypress = System.nanoTime();
			long duration = endKeypress - startKeypress;	
			double fduration = duration * 0.000000001;		
			myString.add(new TextCharacter(e.getKeyChar(), (float) (fduration * 200)));				
		}
	}
	
	public boolean isValidKey(char c)
	{
		if (c>=32 && c<=90 	|| c == 'ö' || c == 'Ö' || c == 'ä' || c == 'Ä' || c == 'ü' || c == 'Ü' || c == '_' || c == '~' || c == '´' || c == '`' || c == '°' || c == '^'
							|| c == '{' || c == '}' || c == '[' || c == ']' || c == '§' || c == '|' || c == 'ß' || c == '\\')
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == 27)
		{
			myString.clear();
		}
		
		newKey = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
