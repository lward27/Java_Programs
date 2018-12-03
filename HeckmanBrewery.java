package edu.ncsu.csc.csc216.heckman_brewery.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import edu.ncsu.csc.csc216.heckman_brewery.Brewery;

public class HeckmanBrewery extends JFrame implements ActionListener {
	
	private JLabel lblWelcome;
	private JList listBeers;
	private JButton btnAddBeer;
	private Brewery brewery;
	
	public HeckmanBrewery() {
		super();
		
		Container c = getContentPane();
		
		//Construct the underlying model
		brewery = Brewery.getInstance();
		setTitle("Heckman Brewery");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Construct components
		lblWelcome = new JLabel("Welcome to Heckman Brewery");
		listBeers = new JList();
		listBeers.setListData(brewery.getBeers());
		btnAddBeer = new JButton("Add a Beer");
		btnAddBeer.addActionListener(this);
		
		c.setLayout(new BorderLayout());
		c.add(lblWelcome, BorderLayout.NORTH);
		c.add(listBeers, BorderLayout.CENTER);
		c.add(btnAddBeer, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new HeckmanBrewery();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddBeer) {
			new AddBeer();
		}
	}

}
