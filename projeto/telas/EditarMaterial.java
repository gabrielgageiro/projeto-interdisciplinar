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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditarMaterial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public EditarMaterial(TelaPrincipal tp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbEditaMaterial = new JLabel("Editor");
		lbEditaMaterial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnEditaSetor = new JButton("Editar Setor");
		
		JButton btnEditaEscola = new JButton("Editar Escola");
		
		JButton btnEditaMaterial = new JButton("Editar Materiais");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try{
									new RemoverMateriais(tp);
									//setvisible(false);

								}catch(Exception e){
									System.out.println(e.getMessage());
								}
							}
						});
            }
        });
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnEditaEscola, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEditaSetor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEditaMaterial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(173)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(lbEditaMaterial, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbEditaMaterial)
					.addGap(18)
					.addComponent(btnEditaSetor, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnEditaEscola, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSair, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEditaMaterial, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
