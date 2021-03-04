package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Dados.LoginDao;
import Negocios.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CadastroFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLog;
	private JTextField textFieldSenha;
	private JTextField textFieldEmail;
	private JTextField textFieldRepita;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFormulario frame = new CadastroFormulario();
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
	public CadastroFormulario() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFormulario.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Cadastro de Usu\u00E1rio");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				LoginApresentacao a = new LoginApresentacao();
				a.setVisible(true);
			}
		});
		setBounds(100, 100, 433, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblLogin.setBounds(10, 31, 46, 14);
		contentPane.add(lblLogin);
		textFieldLog = new JTextField();
		textFieldLog.setBounds(166, 29, 238, 20);
		contentPane.add(textFieldLog);
		textFieldLog.setColumns(10);
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSenha.setBounds(10, 73, 46, 14);
		contentPane.add(lblSenha);
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(166, 71, 238, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(10, 166, 46, 14);
		contentPane.add(lblEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(166, 164, 238, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCadastrar.setBounds(303, 211, 98, 23);
		contentPane.add(btnCadastrar);
		JLabel lblRepitaASenha = new JLabel("Repita a senha:");
		lblRepitaASenha.setForeground(Color.WHITE);
		lblRepitaASenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblRepitaASenha.setBounds(10, 115, 98, 14);
		contentPane.add(lblRepitaASenha);
		textFieldRepita = new JPasswordField();
		textFieldRepita.setColumns(10);
		textFieldRepita.setBounds(166, 113, 238, 20);
		contentPane.add(textFieldRepita);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastroFormulario.class.getResource("/Imagens/sistema.jpg")));
		label.setBounds(0, 0, 427, 273);
		contentPane.add(label);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senharepi;
				LoginDao ldao = new LoginDao();
				Login l = new Login();
				senharepi=textFieldRepita.getText();
				l.setUsuario(textFieldLog.getText());
				ldao.Enviar(l);
				if(!textFieldSenha.getText().equalsIgnoreCase(senharepi)){
					JOptionPane.showMessageDialog(null, "Repita a senha corretamente!");
				}
				else if(textFieldLog.getText().isEmpty() || textFieldSenha.getText().isEmpty() || textFieldRepita.getText().isEmpty() || textFieldEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");			
				}else{
					l.setUsuario(textFieldLog.getText().trim());
					l.setSenha(textFieldSenha.getText().trim());
					l.setEmail(textFieldEmail.getText().trim());
					ldao.Salvar(l);	
					textFieldLog.setText("");
					textFieldSenha.setText("");
					textFieldRepita.setText("");
					textFieldEmail.setText("");
				}			
			}
		});
	}
}