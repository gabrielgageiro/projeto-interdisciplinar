package projeto.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CalculaVerba extends JFrame {

	private JPanel contentPane;
	private JTextField textqtdDinheiro;
	private JTextField textPrazo;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CalculaVerba(TelaPrincipal tp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbCalculaVerba = new JLabel("C\u00E1lcula Verba");
		lbCalculaVerba.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lbqtdDinheiro = new JLabel("Quantidade de Dinheiro: ");
		
		textqtdDinheiro = new JTextField();
		textqtdDinheiro.setColumns(10);
		
		JLabel lbPrazo = new JLabel("Prazo de Entrega: ");
		
		textPrazo = new JTextField();
		textPrazo.setColumns(10);
		
		JButton btnSairCalcVerba = new JButton("Sair");
		
		JButton btnOrçamento = new JButton("Calcular Or\u00E7amento");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(132, Short.MAX_VALUE)
					.addComponent(lbCalculaVerba, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(130))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbqtdDinheiro)
						.addComponent(lbPrazo))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textqtdDinheiro)
						.addComponent(textPrazo, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(btnOrçamento)
					.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
					.addComponent(btnSairCalcVerba, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lbCalculaVerba)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbqtdDinheiro)
						.addComponent(textqtdDinheiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbPrazo)
						.addComponent(textPrazo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSairCalcVerba)
						.addComponent(btnOrçamento)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
