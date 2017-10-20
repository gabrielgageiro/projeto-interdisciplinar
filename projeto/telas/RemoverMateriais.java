package projeto.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

public class RemoverMateriais extends JFrame {

	private JPanel contentPane;
	private JTextField FieldNomeMaterial;
	private JTextField FieldQtdMaterial;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RemoverMateriais() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton remover = new JButton("Remover");
		remover.setBounds(24, 227, 89, 23);
		contentPane.add(remover);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(313, 227, 89, 23);
		contentPane.add(Cancelar);
		
		JLabel textoLabel = new JLabel("Remover Material");
		textoLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		textoLabel.setBounds(133, 11, 227, 14);
		contentPane.add(textoLabel);
		
		JLabel nomeMaterial = new JLabel("Nome do Material: ");
		nomeMaterial.setBounds(114, 57, 116, 14);
		contentPane.add(nomeMaterial);
		
		FieldNomeMaterial = new JTextField();
		FieldNomeMaterial.setBounds(258, 54, 86, 20);
		contentPane.add(FieldNomeMaterial);
		FieldNomeMaterial.setColumns(10);
		
		JLabel QuantidadeMateriais = new JLabel("Quantidade de Materiais: ");
		QuantidadeMateriais.setBounds(114, 109, 136, 14);
		contentPane.add(QuantidadeMateriais);
		
		FieldQtdMaterial = new JTextField();
		FieldQtdMaterial.setBounds(258, 106, 86, 20);
		contentPane.add(FieldQtdMaterial);
		FieldQtdMaterial.setColumns(10);
	}
}
