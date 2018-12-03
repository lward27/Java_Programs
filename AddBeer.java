package edu.ncsu.csc.csc216.heckman_brewery.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.ncsu.csc.csc216.heckman_brewery.Brewery;
import edu.ncsu.csc.csc216.heckman_brewery.beer.Beer;
import edu.ncsu.csc.csc216.heckman_brewery.beer.Lager;

public class AddBeer extends JFrame implements ActionListener {
	
	private JLabel lblName;
	private JTextField editName;
	private JLabel lblAle;
	private JRadioButton rBtnAle;
	private JLabel lblLager;
	private JRadioButton rBtnLager;
	private ButtonGroup groupBeerType;
	private JButton btnWater;
	private JButton btnHops;
	private JButton btnMaltose;
	private JButton btnYeast;
	private JTextArea areaIngredientList;
	private JButton btnSave;
	private JButton btnCancel;
	private Beer beer;
	
	public AddBeer() {
		super();
		
		Container c = getContentPane();
				
		setTitle("Heckman Brewery");
		setSize(600, 600);
		
		//Initialize Beer to a Lager - handle 
		//chaning to an Ale in actionPerformed
		beer = new Lager("");
		
		//Create widgets
		lblName = new JLabel("Brew Name: ");
		editName = new JTextField(40);
		groupBeerType = new ButtonGroup();
		lblAle = new JLabel("Ale");
		rBtnAle = new JRadioButton();
		lblLager = new JLabel("Lager");
		rBtnLager = new JRadioButton();
		rBtnLager.setSelected(true);
		groupBeerType.add(rBtnAle);
		groupBeerType.add(rBtnLager);
		btnWater = new JButton("Add Water");
		btnHops = new JButton("Add Hops");
		btnHops.addActionListener(this);
		btnMaltose = new JButton("Add Maltose");
		btnYeast = new JButton("Add Yeast");
		areaIngredientList = new JTextArea(20, 40);
		btnSave = new JButton("Save Brew");
		btnSave.addActionListener(this);
		btnCancel = new JButton("Cancel Brew");
		btnCancel.addActionListener(this);
		
		c.setLayout(new BorderLayout());
		
		JPanel pnlName = new JPanel();
		pnlName.setLayout(new FlowLayout());
		pnlName.add(lblName);
		pnlName.add(editName);
		
		JPanel pnlRadioButtons = new JPanel();
		pnlRadioButtons.setLayout(new FlowLayout());
		pnlRadioButtons.add(lblAle);
		pnlRadioButtons.add(rBtnAle);
		pnlRadioButtons.add(lblLager);
		pnlRadioButtons.add(rBtnLager);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setLayout(new GridLayout(2,1));
		pnlNorth.add(pnlName);
		pnlNorth.add(pnlRadioButtons);
		
		JPanel pnlRecipeIngredients = new JPanel();
		pnlRecipeIngredients.setLayout(new FlowLayout());
		pnlRecipeIngredients.add(btnHops);
		pnlRecipeIngredients.add(btnMaltose);
		pnlRecipeIngredients.add(btnWater);
		pnlRecipeIngredients.add(btnYeast);
		pnlRecipeIngredients.add(areaIngredientList);
		
		JPanel pnlBtns = new JPanel();
		pnlBtns.setLayout(new FlowLayout());
		pnlBtns.add(btnSave);
		pnlBtns.add(btnCancel);
		
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(pnlRecipeIngredients, BorderLayout.CENTER);
		c.add(pnlBtns, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHops) {
			new AddHops();
		} else if (e.getSource() == btnSave) {
			Brewery.getInstance().addBeer(beer);
			this.dispose();
		} else if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}

}
