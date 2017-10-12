package projeto.telas;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame{

    private JButton cadastrarMaterial;
    private JButton cadastrarPessoa;

    public Principal(){
        super("Tela principal");

        cadastrarMaterial = new JButton("Cadastrar material");
        cadastrarPessoa = new JButton("Cadastrar pessoa");

        Container c = getContentPane();
        c.setLayout(new GridLayout(1,2));
        c.add(cadastrarMaterial);
        c.add(cadastrarPessoa);

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
