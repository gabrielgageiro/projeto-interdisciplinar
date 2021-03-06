package projeto.telas;
import projeto.bancoDeDados.BancoDeDados;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
    private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		super("Gerenciador de Finanças Escolares - GFE");

        TelaPrincipal tp = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel LabelControlePrincipal = new JLabel("Controle Principal");
		LabelControlePrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnCadastroMaterial = new JButton("Cadastrar Materiais");
		btnCadastroMaterial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("icones/lapis3.png")));
                contentPane.add(btnCadastroMaterial);

        btnCadastroMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new AdicionarMateriais(tp);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnListarMaterial = new JButton(" Relat\u00F3rio de Materiais");
		btnListarMaterial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("icones/pancheta.png")));
                btnListarMaterial.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                       try{
                           new mostrarItem(new BancoDeDados().mostrarDados(),tp);
						   setVisible(false);

					   }catch(Exception e){
                           JOptionPane.showMessageDialog(null,"Erro");
                       }
                    }
                });
            }
		});
                
		
		JButton btnremoverMaterial = new JButton("Remover Materiais");
		btnremoverMaterial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("icones/remover4.png")));
		btnremoverMaterial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                       try{
                           new RemoverMateriais(tp);
                           setVisible(false);

                       }catch(Exception e){
                           System.out.println("Deu erro");
                       }
                    }
                });
            }
        });
                
		JButton btnSair = new JButton("Sair");
                btnSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                       try{
                           dispose();
                       }catch(Exception e){
                           System.out.println("Deu erro");
                       }
                    }
                });
            }
        });
		
		JButton btnCalcularVerba = new JButton("Adicionar Verba");
		btnCalcularVerba.setIcon(new ImageIcon(TelaPrincipal.class.getResource("icones/cifrao.png")));
                 btnCalcularVerba.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                       try{
                           new AdicionarVerba(tp);
                           setVisible(false);

                       }catch(Exception e){
                           System.out.println("Deu erro");
                       }
                    }
                });
            }
        });

		JButton btnCalcularCusto = new JButton("Calcular Custos");
		btnCalcularCusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RelatorioMateriais(tp);
				setVisible(false);
			}
		});
		btnCalcularCusto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("icones/custo.png")));
		
		JButton btnEditar = new JButton("Editar");
                btnEditar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                       try{
                           new EditarMaterial(tp);
                           setVisible(false);

                       }catch(Exception e){
                           System.out.println("Deu erro");
                       }
                    }
                });
            }
        });
		
		JLabel lblNewLabel = new JLabel("Verba: "+ new BancoDeDados().verbaLabel());
                
                
                
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(LabelControlePrincipal, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
							.addGap(58))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnremoverMaterial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnListarMaterial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCadastroMaterial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnCalcularCusto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCalcularVerba, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(58))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelControlePrincipal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastroMaterial)
						.addComponent(btnCalcularVerba))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalcularCusto)
						.addComponent(btnListarMaterial))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnremoverMaterial)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnEditar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
