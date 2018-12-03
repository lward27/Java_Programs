import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibraryGUI extends JFrame implements ActionListener
{
	private Library model;
	
	private JButton btnSubmit;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblPubYear;
	private JLabel lblResults;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPubYear;

	public LibraryGUI()
	{
		super("Library GUI");
		setSize(500,500);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		model = new Library();

		Container c = getContentPane();

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		lblTitle = new JLabel("Title: ");
		lblAuthor = new JLabel("Author: ");
		lblPubYear = new JLabel("PubYear: ");
		lblResults = new JLabel("Results: ");
		txtTitle = new JTextField("", 20);
		txtAuthor = new JTextField("", 20);
		txtPubYear = new JTextField("", 20);
		
		panel.add(lblTitle);
		panel.add(txtTitle);
		panel.add(lblAuthor);
		panel.add(txtAuthor);
		panel.add(lblPubYear);
		panel.add(txtPubYear);
		panel.add(lblResults);
		panel.add(btnSubmit);
		

		c.add(panel, BorderLayout.NORTH);

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnSubmit)
		{
			String title = txtTitle.getText();
			String author = txtAuthor.getText();
			String pubYear = txtPubYear.getText();
			model.addBook(title, author, Integer.parseInt(pubYear));
		}
		/*if(model.addBook(title, author, Integer.parseInt(pubYear)))
		{
			lblResults.setText("Book successfully Added");
		}*/
		else
		{
			lblResults.setText("Book cannot be added");
		}
	}
	
	public static void main(String[] args)
	{
		new LibraryGUI();
	}
}
