import java.util.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

public class TextCharacter {

    private char myChar;
    private float size;
    private Random rand;
    
    public TextCharacter(char c, float size) {
        myChar=c;
       // size=50.f;
        this.size = size;
        rand = new Random();
    }
        
    // draws character, returns new x increased by offset
	public int render(Graphics g, int x, int y)
	{	
    	Font f = new Font("Arial", Font.BOLD | Font.ITALIC, (int)size);
    	float a = rand.nextFloat();
    	float b = rand.nextFloat();
    	float c = rand.nextFloat();
    	g.setColor(new Color(a, b, c));
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
        g.drawString(""+myChar, x, y);		
        return x+fm.charWidth(myChar);
	}
	
	public char getChar()
	{
		return myChar;
	}
}
