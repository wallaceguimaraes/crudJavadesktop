package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.Factory;
import Dados.LoginDao;
import Negocios.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;




/**Criador Wallace Guimarães
 * 
 * 
 * 
*/

public class LoginApresentacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLog;

	/**
	 * Launch the application.
	 */
	
	
	Factory entrar = new Factory();
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginApresentacao frame = new LoginApresentacao();
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
	public LoginApresentacao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginApresentacao.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 567, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblLogin.setBounds(348, 26, 58, 14);
		panel.add(lblLogin);
		textFieldLog = new JTextField();
		textFieldLog.setBounds(348, 51, 199, 20);
		panel.add(textFieldLog);
		textFieldLog.setColumns(10);
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSenha.setBounds(348, 82, 58, 14);
		panel.add(lblSenha);
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginDao lDao= new LoginDao();
				Login l = new Login();
				l.setUsuario(textFieldLog.getText().trim());
				lDao.Enviar(l);
			if(passwordField.getText().equals(l.getSenha())){
				ApresentacaoPrincipal a = new ApresentacaoPrincipal();
				a.setVisible(true);
				//a.setValor(textFieldLog.getText().trim());
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, " Usuário ou senha incorretos!");
			}
			}
		});
		btnEntrar.setBounds(285, 155, 126, 23);
		panel.add(btnEntrar);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCadastrar.setBounds(421, 155, 126, 23);
		panel.add(btnCadastrar);
		JButton btnEsqueceuASenha = new JButton("Esqueceu a senha?");
		btnEsqueceuASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SenhaEsquecApresenta s = new SenhaEsquecApresenta();
				s.setVisible(true);
				dispose();
			}
		});
		btnEsqueceuASenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnEsqueceuASenha.setBounds(285, 189, 262, 23);
		panel.add(btnEsqueceuASenha);
		passwordField = new JPasswordField();
		passwordField.setBounds(348, 117, 199, 20);
		panel.add(passwordField);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginApresentacao.class.getResource("/Imagens/sistema.jpg")));
		lblNewLabel.setBounds(0, 0, 567, 288);
		panel.add(lblNewLabel);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			CadastroFormulario c = new CadastroFormulario();
			c.setVisible(true);
			dispose();					
			}
		});
	}
}