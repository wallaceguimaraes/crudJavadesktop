package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.LucroDAO;
import Negocios.Compras;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LucrosApresentacao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LucrosApresentacao frame = new LucrosApresentacao();
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
	public LucrosApresentacao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LucrosApresentacao.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Lucro das vendas realizadas");

		
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e){

				ApresentacaoPrincipal a = new ApresentacaoPrincipal();
				a.setVisible(true);

			}

		});
		
		
		
		setBounds(100, 100, 450, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLucroTotalDas = new JLabel("Capital bruto");
		lblLucroTotalDas.setForeground(Color.WHITE);
		lblLucroTotalDas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLucroTotalDas.setBounds(167, 32, 118, 14);
		contentPane.add(lblLucroTotalDas);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		textField.setForeground(Color.BLUE);
		textField.setCaretColor(Color.BLACK);
		textField.setEditable(false);
		textField.setBounds(307, 30, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCapitalLquido = new JLabel("Capital L\u00EDquido");
		lblCapitalLquido.setForeground(Color.WHITE);
		lblCapitalLquido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCapitalLquido.setBounds(167, 84, 118, 14);
		contentPane.add(lblCapitalLquido);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		textField_1.setForeground(Color.RED);
		textField_1.setEditable(false);
		textField_1.setBounds(307, 82, 113, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
       LucroDAO ldao = new LucroDAO();      
       Compras comp = new Compras();
       
       ldao.Ler(comp);
       
       textField_1.setText(String.format("%.2f",porcentagem(comp.getValorCompra())));
       textField.setText(String.format("%.2f",comp.getValorCompra()));
       
       JLabel label = new JLabel("");
       label.setIcon(new ImageIcon(LucrosApresentacao.class.getResource("/Imagens/sistema.jpg")));
       label.setBounds(0, 0, 444, 219);
       contentPane.add(label);
       
	}


	
public double porcentagem(double dc){
	return ((dc*50)/100);
}
}
