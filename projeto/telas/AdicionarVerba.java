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
import javax.swing.text.MaskFormatter;

public class AdicionarVerba extends JFrame {

	private JPanel contentPane;
	private JTextField txtVerba;
	private JFormattedTextField textPrazo;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AdicionarVerba(TelaPrincipal tp) {
        super("Adicionar Verba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbCalculaVerba = new JLabel("C\u00E1lcula Verba");
		lbCalculaVerba.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lbqtdDinheiro = new JLabel("Quantidade de Dinheiro: ");
		
		txtVerba = new JTextField();
		txtVerba.setColumns(10);
		
		JLabel lbPrazo = new JLabel("Prazo de Entrega: ");

		textPrazo = new JFormattedTextField();
		try{
            textPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new MaskFormatter("##/##/####")));

        }catch (Exception e){
		    e.printStackTrace();
        }

        JButton btnSairCalcVerba = new JButton("Sair");
		btnSairCalcVerba.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try{
									tp.setVisible(true);
									dispose();

								}catch(Exception e){
									System.out.println(e.getMessage());
								}
							}
						});
            }
        });

		JButton btnOrçamento = new JButton("Adicionar Orçamento");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);

		btnOrçamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BancoDeDados bd = new BancoDeDados();
                bd.inserirVerba(Float.parseFloat(txtVerba.getText()),Integer.parseInt(textPrazo.getText()));
            }
        });


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
						.addComponent(txtVerba)
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
						.addComponent(txtVerba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
