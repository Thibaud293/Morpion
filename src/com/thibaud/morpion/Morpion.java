package com.thibaud.morpion;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Morpion {

	private JFrame frame;
	private int joueur = 0;
	private int W;
	private int cptO;
	private int cptX;
	private String J1;
	private String J2;
	private String nbcoups;
	
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morpion window = new Morpion("", "");
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Morpion(String J1, String J2) {
		initialize();
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
		
		//Remise à 0 des variables
		W=0;
		joueur=0;
		cptX=0;
		cptO=0;
		
	}
	
	ActionListener actionMorpion = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JButton btn = (JButton) arg0.getSource();
			
			joueur++;
	        if(joueur%2==0)
	        {
	            btn.setText("O");
	            cptO++;
	        }
	        else
	        {
	        	btn.setText("X");
	        	cptX++;
	        }
	        
	        W=testsWin();
	        if(W==2) {
	        	//Le joueur a gagné en "joueur" coups
	        	//Récuperer une chaine de caractère en sortie des tests pour la renvoyer directement dans la fenêtre win
	        }
	        else if(joueur>=9) {
	        	//Il y a une égalité
	        }
	        
	        
	        
	
		}
	};
	
	private int testsWin() {
		
		//Refaire tous les tests avec btn.getText;
		//Je test la 1ère ligne horizontale
        if(button_00.getText().equals(button_10.getText()) && button_00.getText().equals(button_20.getText()) && !button_00.getText().equals("")) {
        	//Vers fenêtre gagnée + nombre de coups
        	if(button_00.getText().equals("X")) {
        		
        	}
        	return(2);
        }
        //Je test la 2ème ligne horizontale
        else if(button_01.getText().equals(button_11.getText()) && button_01.getText().equals(button_21.getText()) && !button_01.getText().equals("")) {
        	//Vers fenêtre gagnée + nombre de coups
        	return(2);
        }
        //Je test la 3ème ligne horizontale
        else if(button_02.getText().equals(button_12.getText()) && button_02.getText().equals(button_22.getText()) && !button_02.getText().equals("")) {
        	//Vers fenêtre gagnée + nombre de coups
        	return(2);
        }
        //finir de tester tous les lignes/colonnes/diagonales
        else {
        	return(7);
        }
	}
	
	

}
