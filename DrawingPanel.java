import javax.swing.*;
import java.awt.*;
import java.lang.InterruptedException;

public class DrawingPanel extends JPanel
{
	
	int x1 = 20;
	int y1 = 20;
	int x2 = 300;
	int y2 = 300;
	public DrawingPanel()
	{
		setSize(200,200);
		setBackground(Color.white);
	}

	public void paint(Graphics g)
	{	

		g.drawLine(x1,y1,x2,y2);

		repaint();
	}
	
	public void updateGraphic()
	{
		for(int i = 0; i < 200; i++)
		{
			try
			{
				Thread.currentThread().sleep(100);
			}
			catch(InterruptedException ie){
			}
			x1 += 1;
			x2 -= 1;
			repaint();
		}	
	}
}
