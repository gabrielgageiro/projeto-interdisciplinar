/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.telas;

import projeto.bancoDeDados.BancoDeDados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class RelatorioMateriais extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RelatorioMateriais(TelaPrincipal tp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
                setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JTextArea textArea = new JTextArea("Gasto total foi de : " + String.valueOf(new BancoDeDados().calc()));
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
}
