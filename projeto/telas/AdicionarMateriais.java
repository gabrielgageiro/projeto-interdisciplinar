package projeto.telas;

import projeto.bancoDeDados.BancoDeDados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AdicionarMateriais extends JFrame {

	private JPanel telaMateriais;
	private JTextField txtTextonome;
	private JTextField txtTipo;
	private JTextField txtQuantidade;
	private JTextField txtValor;



	/**
	 * Create the frame.
	 */
	public AdicionarMateriais() {
		setTitle("Cadastrar Materiais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		telaMateriais = new JPanel();
		telaMateriais.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaMateriais);
		telaMateriais.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNome = new JLabel("Nome:");
		telaMateriais.add(lblNome);
		
		txtTextonome = new JTextField();
		txtTextonome.setToolTipText("insira o nome");
		telaMateriais.add(txtTextonome);
		txtTextonome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		telaMateriais.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setToolTipText("insira o tipo");
		telaMateriais.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade: ");
		telaMateriais.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setToolTipText("insira a quantidade");
		telaMateriais.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblValor = new JLabel("valor");
		telaMateriais.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setToolTipText("insira o valor");
		telaMateriais.add(txtValor);
		txtValor.setColumns(10);

		//Chama a classe do banco de dados e salva os dados

        JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                BancoDeDados bd = new BancoDeDados();
                bd.inserirDados(txtTextonome.getText(),txtTipo.getText(),Integer.parseInt(txtQuantidade.getText()),
                        Float.parseFloat(txtValor.getText()));
                txtQuantidade.setText("");
                txtValor.setText("");
                txtQuantidade.setText("");
                txtTipo.setText("");
                txtTextonome.setText("");
            }
		});
		getRootPane().setDefaultButton(btnCadastrar);

		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 10));
		telaMateriais.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 10));
		telaMateriais.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
