package projeto.telas;
import projeto.escola.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
	
	private Escola bucao = new Escola();
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton listarMateriais = new JButton("Listar Materiais");
		listarMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bucao.mostrarMateriais();
			}
		});
		contentPane.add(listarMateriais);
		
		JButton calcularCustos = new JButton("Calcular Custos");
		contentPane.add(calcularCustos);
		
		JButton cadastrarMateriais = new JButton("Cadastrar Materiais");
		cadastrarMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bucao.cadastrarMateriais();
			}
		});
		contentPane.add(cadastrarMateriais);
		
	}

}
