package projeto.telas;

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

public class mostrarItem extends JFrame {

	private JPanel contentPane;

	
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
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		JTextArea textArea = new JTextArea(dados);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();tp.setVisible(true);
            }
        });
	}

}
