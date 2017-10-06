package projeto.telas;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField login;
    private JPasswordField senha;
    private JButton logar;
    private JButton cancelar;

    public Login() {
        super("Tela de login");

        login = new JTextField();
        senha = new JPasswordField();

        logar = new JButton("Logar");
        logar.addActionListener(new BotaoLogar());
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new BotaoCancelar());

        Container c = getContentPane();

        c.setLayout(new GridLayout(3, 2, 3, 3));
        //Poe Fonte
        Font fonte = new Font("serif", Font.BOLD | Font.ITALIC, 20);
        //icones
        ImageIcon iconeSenha = new ImageIcon(getClass().getResource("icones/senha.png"));

        ImageIcon iconeLogin = new ImageIcon(getClass().getResource("icones/login_photo.png"));

        //Da forma aos botoes
        JLabel log = new JLabel("Login: ");

        log.setIcon(iconeLogin);
        log.setToolTipText("Insira seu usuario");
        log.setFont(fonte);

        JLabel senh = new JLabel("Senha: ");
        senh.setIcon(iconeSenha);
        senh.setToolTipText("Insira sua senha");
        log.setFont(fonte);
        //Adiciona os labels e botoes
        c.add(log);
        c.add(login);

        c.add(senh);
        c.add(senha);
        c.add(logar);
        c.add(cancelar);
        //tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    private class BotaoCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            login.setText("");
            senha.setText("");

        }
    }

    private class BotaoLogar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (login.getText().equals("admin") && new String(senha.getPassword()).equals("admin")) {

                dispose();
                new Principal();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario e senha nao confere!");
            }
        }
    }
}