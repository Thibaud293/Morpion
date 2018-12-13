package com.thibaud.morpion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblJoueur_1;
	private JLabel lblJoueur_2;
	private Morpion morp;
	private String J1;
	private String J2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,left][grow 20][grow,right]", "[][][][][][]"));
		
		lblJoueur_1 = new JLabel("Joueur 1 :");
		frame.getContentPane().add(lblJoueur_1, "cell 0 1,alignx right");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		lblJoueur_2 = new JLabel("Joueur 2 :");
		frame.getContentPane().add(lblJoueur_2, "cell 0 3,alignx right");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 2 3,growx");
		textField_2.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		frame.getContentPane().add(btnOk, "cell 1 5,alignx center");
		
		btnOk.addActionListener(actionOK);
		
		
	}
	
	ActionListener actionOK = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JButton btn = (JButton) arg0.getSource();
			
			//appui sur le bouton OK, renvoi les noms des joueurs à la fenêtre Morpion
			//rend le menu invisible et créer la fenêtre Morpion
			J1 = lblJoueur_1.getText();
			J2 = lblJoueur_2.getText();
			Menu.this.frame.setVisible(false);
			Morpion morp = new Morpion(J1, J2);
			
			
			
		}
	};

}
