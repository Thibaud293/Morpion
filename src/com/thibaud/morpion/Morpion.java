package com.thibaud.morpion;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Morpion {

	private JFrame frame;
	private int coup ;
	private int cptO;
	private int cptX;
	private Joueur J1;
	private Joueur J2;
	private String textWPopUp;
	private JOptionPane PopUpFin ;
	
	
	private JButton button_00;
	private JButton button_10;
	private JButton button_20;
	private JButton button_01;
	private JButton button_11;
	private JButton button_21;
	private JButton button_02;
	private JButton button_12;
	private JButton button_22;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Morpion(Joueur J1, Joueur J2, JFrame F) {
		this.J1 = J1;
		this.J2 = J2;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 411, 305);
		
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		
		button_00 = new JButton(" ");
		frame.getContentPane().add(button_00, "cell 0 0,grow");
		
		button_10 = new JButton(" ");
		frame.getContentPane().add(button_10, "cell 1 0,grow");
		
		button_20 = new JButton(" ");
		frame.getContentPane().add(button_20, "cell 2 0,grow");
		
		button_01 = new JButton(" ");
		frame.getContentPane().add(button_01, "cell 0 1,grow");
		
		button_11 = new JButton(" ");
		frame.getContentPane().add(button_11, "cell 1 1,grow");
		
		button_21 = new JButton(" ");
		frame.getContentPane().add(button_21, "cell 2 1,grow");
		
		button_02 = new JButton(" ");
		frame.getContentPane().add(button_02, "cell 0 2,grow");
		
		button_12 = new JButton(" ");
		frame.getContentPane().add(button_12, "cell 1 2,grow");
		
		button_22 = new JButton(" ");
		frame.getContentPane().add(button_22, "cell 2 2,grow");
		
		button_00.addActionListener(actionMorpion);
		button_10.addActionListener(actionMorpion);
		button_20.addActionListener(actionMorpion);
		button_01.addActionListener(actionMorpion);
		button_11.addActionListener(actionMorpion);
		button_21.addActionListener(actionMorpion);
		button_02.addActionListener(actionMorpion);
		button_12.addActionListener(actionMorpion);
		button_22.addActionListener(actionMorpion);
		
		PopUpFin = new JOptionPane();
		cptO = 0;
		cptX = 0;
		coup = 0;
		
	}
	
	ActionListener actionMorpion = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JButton btn = (JButton) arg0.getSource();

	        if(coup%2==0)
	        {
	            btn.setText("O");
	            cptO++;
	            testsWin();
	            
	            if(textWPopUp.equals("O")) {
	            	PopUpFin.showMessageDialog(null,Morpion.this.J1.pseudo_joueur + " a gagné avec les "+"O"+" en "+cptO+" coups","information",PopUpFin.INFORMATION_MESSAGE);
	            }
	            else if(textWPopUp.equals("0")) {
	            	PopUpFin.showMessageDialog(null,"égalité !","information",PopUpFin.INFORMATION_MESSAGE);
	            }
	        }
	        else if(coup%2==1)
	        {
	        	btn.setText("X");
	        	cptX++;
	        	testsWin();
	        	
	        	if(textWPopUp.equals("X")) {
	            	PopUpFin.showMessageDialog(null,Morpion.this.J2.pseudo_joueur + " a gagné avec les "+"X"+" en "+cptX+" coups","information",PopUpFin.INFORMATION_MESSAGE);
	            }
	            else if(textWPopUp.equals("0")) {
	            	PopUpFin.showMessageDialog(null,"égalité !","information",PopUpFin.INFORMATION_MESSAGE);
	            }
	        }
	        coup++;
	
		}
	};
	
	private void testsWin() {
		
		//Refaire tous les tests avec btn.getText;
		//Je test la 1ère ligne horizontale
        if(button_00.getText().equals(button_10.getText()) && button_00.getText().equals(button_20.getText()) && !button_00.getText().equals("")) {
        	textWPopUp=button_00.getText();
        }
        //Je test la 2ème ligne horizontale
        else if(button_01.getText().equals(button_11.getText()) && button_01.getText().equals(button_21.getText()) && !button_01.getText().equals("")) {
        	textWPopUp=button_01.getText();
        	
        }
        //Je test la 3ème ligne horizontale
        else if(button_02.getText().equals(button_12.getText()) && button_02.getText().equals(button_22.getText()) && !button_02.getText().equals("")) {
        	textWPopUp=button_02.getText();
        }
        else if(button_00.getText().equals(button_01.getText()) && button_00.getText().equals(button_02.getText()) && !button_00.getText().equals("")) {
        	textWPopUp=button_00.getText();
        }
        //Je test la 2ème ligne verticale
        else if(button_10.getText().equals(button_11.getText()) && button_10.getText().equals(button_12.getText()) && !button_10.getText().equals("")) {
        	textWPopUp=button_10.getText();
        	
        }
        //Je test la 3ème ligne verticale
        else if(button_20.getText().equals(button_21.getText()) && button_20.getText().equals(button_22.getText()) && !button_20.getText().equals("")) {
        	textWPopUp=button_20.getText();
        }
        else if(button_00.getText().equals(button_11.getText()) && button_00.getText().equals(button_22.getText()) && !button_00.getText().equals("")) {
        	textWPopUp=button_00.getText();
        }
        else if(button_20.getText().equals(button_11.getText()) && button_20.getText().equals(button_02.getText()) && !button_20.getText().equals("")) {
        	textWPopUp=button_20.getText();
        }
        else if(!button_00.getText().equals("")&&!button_01.getText().equals("")&&!button_02.getText().equals("")&&!button_10.getText().equals("")&&!button_11.getText().equals("")&&!button_12.getText().equals("")&&!button_20.getText().equals("")&&!button_21.getText().equals("")&&!button_22.getText().equals("")) {
        	textWPopUp="0";
        }
	}
	
	

}
