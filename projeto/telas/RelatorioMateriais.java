/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RelatorioMateriais extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private JComboBox comboQtd;
	private JComboBox comboSetor;

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
		
		JLabel lbBusca = new JLabel("Busca");
		lbBusca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		textBusca = new JTextField();
		textBusca.setColumns(10);
		
		JComboBox comboMaterial = new JComboBox();
		comboMaterial.setModel(new DefaultComboBoxModel(new String[] {"Materiais"}));
		
		comboQtd = new JComboBox();
		comboQtd.setModel(new DefaultComboBoxModel(new String[] {"Quantidade"}));
		
		comboSetor = new JComboBox();
		comboSetor.setModel(new DefaultComboBoxModel(new String[] {"Setor"}));
		
		JButton btnImprimir = new JButton("Imprimir");
		
		JButton btnRelacao = new JButton("Rela\u00E7\u00E3o");
		
		JButton btnSair = new JButton("Sair");
		
		btnSair.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try{
									new RemoverMateriais(tp);
									//setvisible(false);

								}catch(Exception e){
									JOptionPane.showMessageDialog(null,"Erro");
								}
							}
						});
            }
        });
		
		JLabel label = new JLabel("");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbBusca, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboMaterial, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnRelacao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboQtd, Alignment.TRAILING, 0, 86, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboSetor, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(label)
					.addContainerGap(334, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbBusca)
						.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboMaterial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboSetor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimir)
						.addComponent(btnRelacao)
						.addComponent(btnSair)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
