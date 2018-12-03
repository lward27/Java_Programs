import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class BasicGui
{
	private JFrame f = new JFrame("Basic GUI");
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlSouth = new JPanel();	
	private JPanel pnlEast = new JPanel();
	private JPanel pnlWest = new JPanel();

	private JButton btnNorth = new JButton("North");	
	private JButton btnSouth = new JButton("South");	
	private JButton btnEast = new JButton("East");
	private JButton btnWest = new JButton("West");	

	public BasicGui()
	{	
		pnlNorth.add(btnNorth);
		pnlSouth.add(btnSouth);	
		pnlEast.add(btnEast);
		pnlWest.add(btnWest);		

		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pnlNorth, BorderLayout.NORTH);
		f.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		f.getContentPane().add(pnlEast, BorderLayout.EAST);
		f.getContentPane().add(pnlWest, BorderLayout.WEST);
	}

	public static void main(String[] args)
	{
		BasicGui gui = new BasicGui();
		gui.launchFrame();
	}
	
	public void launchFrame()
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
