package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.LoginDao;
import Negocios.Login;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SenhaEsquecApresenta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsu;
	private JTextField textFieldEmai;
	private JTextField textFieldSenhaRec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhaEsquecApresenta frame = new SenhaEsquecApresenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SenhaEsquecApresenta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SenhaEsquecApresenta.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setResizable(false);
		setTitle("Recuperar senha");

		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e){

				LoginApresentacao a = new LoginApresentacao();
				a.setVisible(true);

			}

		});
		
		
		
		
		setBounds(100, 100, 375, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUsurio.setBounds(22, 42, 64, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEmail.setBounds(22, 90, 52, 14);
		contentPane.add(lblEmail);
		
		textFieldUsu = new JTextField();
		textFieldUsu.setBounds(89, 39, 232, 20);
		contentPane.add(textFieldUsu);
		textFieldUsu.setColumns(10);
		
		textFieldEmai = new JTextField();
		textFieldEmai.setColumns(10);
		textFieldEmai.setBounds(89, 87, 232, 20);
		contentPane.add(textFieldEmai);
		
		JButton btnRecuperarSenha = new JButton("Recuperar senha");
		
		btnRecuperarSenha.setBounds(116, 228, 205, 23);
		contentPane.add(btnRecuperarSenha);
		
		JLabel lblSenhaRecuperada = new JLabel("Senha Recuperada:");
		lblSenhaRecuperada.setForeground(Color.WHITE);
		lblSenhaRecuperada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSenhaRecuperada.setBounds(22, 165, 124, 14);
		contentPane.add(lblSenhaRecuperada);
		
		textFieldSenhaRec = new JTextField();
		textFieldSenhaRec.setEditable(false);
		textFieldSenhaRec.setBounds(156, 162, 165, 20);
		contentPane.add(textFieldSenhaRec);
		textFieldSenhaRec.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SenhaEsquecApresenta.class.getResource("/Imagens/sistema.jpg")));
		label.setBounds(0, 0, 369, 272);
		contentPane.add(label);

		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			LoginDao ldao = new LoginDao();
			Login l = new Login();
			
			
			l.setUsuario(textFieldUsu.getText().trim());
			l.setEmail(textFieldEmai.getText().trim());
			ldao.Enviar2(l);
			
			textFieldSenhaRec.setText(l.getSenha());
			
			
			}
		});
	
	}

	
}
