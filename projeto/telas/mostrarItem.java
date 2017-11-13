package projeto.telas;

import projeto.bancoDeDados.BancoDeDados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class mostrarItem extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextArea textArea;

	
	/**
	 * Create the frame.
	 */
	public mostrarItem(String dados, TelaPrincipal tp) {
		setVisible(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnOk = new JButton("ok");
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		BancoDeDados bd = new BancoDeDados();
		textArea = new JTextArea(bd.mostrarDados());
		textArea.setEditable(false);
		
		panel.add(textArea);
		System.out.println(bd.mostrarDados());
		btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();tp.setVisible(true);
            }
        });
	}

}
