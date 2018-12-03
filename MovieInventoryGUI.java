import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class displays the add movie functionality in a GUI
 * @author Lucas Ward
 * @version 1.0
 */
public class MovieInventoryGUI extends JFrame implements ActionListener {
	
	private MovieInventory model;
	
    private JButton btnSubmit;
    private JLabel lblTitle;
    private JLabel lblReleaseYear;
    private JLabel lblGenre;
    private JLabel lblRating;
    private JLabel lblResults;
    private JTextField txtTitle;
    private JTextField txtReleaseYear;
    private JTextField txtGenre;
    private JTextField txtRating;
    
    /**
     * Sets up the GUI
     */
    public MovieInventoryGUI()
    {
            super("Movie Inventory GUI");
            setSize(500,500);
            setLocation(100,100);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            model = new MovieInventory();

            Container c = getContentPane();

            btnSubmit = new JButton("Submit");
            btnSubmit.addActionListener(this);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5,2));

            lblTitle = new JLabel("Title: ");
            lblReleaseYear = new JLabel("ReleaseYear: ");
            lblGenre = new JLabel("Genre: ");
            lblRating = new JLabel("Rating: ");
            lblResults = new JLabel("Results: ");
            txtTitle = new JTextField("", 20);
            txtReleaseYear = new JTextField("", 20);
            txtGenre = new JTextField("", 20);
            txtRating = new JTextField("", 20);

            panel.add(lblTitle);
            panel.add(txtTitle);
            panel.add(lblReleaseYear);
            panel.add(txtReleaseYear);
            panel.add(lblGenre);
            panel.add(txtGenre);
            panel.add(lblRating);
            panel.add(txtRating);
            panel.add(lblResults);
            panel.add(btnSubmit);

            c.add(panel, BorderLayout.NORTH);

            setVisible(true);
    }
    
    /**
     * Adds a movie to the list when an action is performed
     */
    public void actionPerformed(ActionEvent c)
    {
            if(c.getSource() == btnSubmit)
            {
                    String title = txtTitle.getText();
                    String releaseYear = txtReleaseYear.getText();
                    String genre = txtGenre.getText();
                    String rating = txtRating.getText();
                    try {
						model.addMovie(title, Integer.parseInt(releaseYear), genre, rating);
					} catch (Exception e) {
						System.out.println("invalid release year");				}
            }
            /*if(model.addBook(title, author, Integer.parseInt(pubYear)))
            {
                    lblResults.setText("Book successfully Added");
            }*/
            else
            {
                    lblResults.setText("Movie cannot be added");
            }
    }

    /**
     * creates the gui and runs it
     * @param args
     */
    public static void main(String[] args)
    {
            new MovieInventoryGUI();
    }



}
