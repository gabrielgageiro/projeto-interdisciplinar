package projeto.telas;

import projeto.bancoDeDados.BancoDeDados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarLogins extends JFrame {

    private JPanel contentPane;
    private JTextField txtLogin;
    private JPasswordField fieldSenha;

    /**
     * Create the frame.
     */
    public GerenciarLogins(JFrame em, int op) {
    	
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 3, 3, 3));
        if (op != 1 ){
            JLabel lblLogin = new JLabel("Usuario : ");
            lblLogin.setToolTipText("Insira o usuario");
            contentPane.add(lblLogin);

            txtLogin = new JTextField();
            txtLogin.setToolTipText("Insira o usuario");
            contentPane.add(txtLogin);
            txtLogin.setColumns(10);

            JLabel lblSenha = new JLabel("Senha: ");
            contentPane.add(lblSenha);

            fieldSenha = new JPasswordField();
            fieldSenha.setToolTipText("Insira a senha");
            contentPane.add(fieldSenha);

            JButton btnCadastrar = new JButton("Cadastrar");
            contentPane.add(btnCadastrar);

            btnCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BancoDeDados bd = new BancoDeDados();
                    char[] chars = fieldSenha.getPassword();
                    String password = String.valueOf(chars);
                    bd.setUsuarios(txtLogin.getText(), password);
                    JOptionPane.showMessageDialog(null,"Cadastrado!");
                    dispose();
                    em.setVisible(true);
                }
            });


            JButton btnCancelar = new JButton("Cancelar");
            contentPane.add(btnCancelar);

            btnCancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    em.setVisible(true);
                    dispose();
                }
            });

        }else {
            JLabel lblLogin = new JLabel("Usuario : ");
            lblLogin.setToolTipText("Insira o usuario");
            contentPane.add(lblLogin);

            txtLogin = new JTextField();
            txtLogin.setToolTipText("Insira o usuario");
            contentPane.add(txtLogin);
            txtLogin.setColumns(10);

            JButton btnRemover = new JButton("Remover");
            contentPane.add(btnRemover);

            btnRemover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BancoDeDados bd = new BancoDeDados();

                    bd.removerUsuarios(txtLogin.getText());
                    JOptionPane.showMessageDialog(null,txtLogin.getText()+" removido!");
                    dispose();
                    em.setVisible(true);
                }
            });


            JButton btnCancelar = new JButton("Cancelar");
            contentPane.add(btnCancelar);

            btnCancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    em.setVisible(true);
                    dispose();
                }
            });

        }


    }

}
