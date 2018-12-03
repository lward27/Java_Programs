import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawingGUI extends JFrame implements ActionListener
{

	private JButton btn;
	private DrawingPanel panel;	

	public DrawingGUI()
	{
		super();
		setSize(400,400);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();

		panel = new DrawingPanel();

		btn = new JButton("Click Me");
		btn.addActionListener(this);	
	
		c.add(panel, BorderLayout.CENTER);
		c.add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		panel.updateGraphic();
	}
	
	public static void main(String[] args)
	{
		new DrawingGUI();
	}
}
