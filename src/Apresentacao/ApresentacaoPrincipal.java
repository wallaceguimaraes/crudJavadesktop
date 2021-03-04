package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocios.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ApresentacaoPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApresentacaoPrincipal frame = new ApresentacaoPrincipal();
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
	public ApresentacaoPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApresentacaoPrincipal.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Sistema de vendas");
		setResizable(false);


		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e){

				LoginApresentacao a = new LoginApresentacao();
				a.setVisible(true);

			}

		});
		
		setBounds(100, 100, 483, 334);
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuBar_1.add(mnCadastros);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		mntmClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ClienteApresentacao c = new ClienteApresentacao();
				c.setVisible(true);
				dispose();
			}
		});

		mnCadastros.add(mntmClientes);
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		mnCadastros.add(mntmProdutos);

		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");

		mntmFornecedores.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		mnCadastros.add(mntmFornecedores);
		mntmProdutos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProdutoApresentacao p = new ProdutoApresentacao();
				p.setVisible(true);
				dispose();

			}
		});

		mntmFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FornecedorApresentacao f= new FornecedorApresentacao();
				f.setVisible(true);
				dispose();
			}
		});
		JMenu mnCompras = new JMenu("Compras");
		mnCompras.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuBar_1.add(mnCompras);
		JMenuItem mntmEfetuarCompras = new JMenuItem("Efetuar compras");
		mntmEfetuarCompras.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		
		mntmEfetuarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraApresentacao ca = new CompraApresentacao();
				ca.setVisible(true);
				dispose();
			}
		});
		mnCompras.add(mntmEfetuarCompras);
		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuBar_1.add(mnVendas);
		JMenuItem mntmVendasRealizadas = new JMenuItem("Vendas realizadas");
		mntmVendasRealizadas.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		mntmVendasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraRealizadasApresentacao ca = new CompraRealizadasApresentacao();
				ca.setVisible(true);
				dispose();
			}
		});
		mnVendas.add(mntmVendasRealizadas);
		JMenu mnLucrosDaEmpresa = new JMenu("Lucros da empresa");
		mnLucrosDaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LucrosApresentacao l = new LucrosApresentacao();
				l.setVisible(true);
				dispose();
			}
		});
		mnLucrosDaEmpresa.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuBar_1.add(mnLucrosDaEmpresa);
		JMenuItem mntmLucros = new JMenuItem("Lucros");
		mntmLucros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LucrosApresentacao l = new LucrosApresentacao();
				l.setVisible(true);
				dispose();
			}
		});

		mntmLucros.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		mnLucrosDaEmpresa.add(mntmLucros);
		
		JMenu mnInformaes = new JMenu("Informa\u00E7\u00F5es");
		menuBar_1.add(mnInformaes);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre...");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JOptionPane.showMessageDialog(null, " Agradecemos a você por utilizar nosso produto!"+"\r\n"+
			" Estaremos disponibilizando nossos serviços e atualizações."+"\r\n"+
						" Para mais informações entre em contato conosco:"+"\r\n"+ " wallaceguimaraes7@outlook.com"+"\r\n"+" wallaceguimaraes45@gmail.com "+"\r\n"+
			" O programa foi desenvolvido pelo programador Wallace Guimarâes!");
				
			
			
			
			}
		});
		mntmSobre.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		mnInformaes.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ApresentacaoPrincipal.class.getResource("/Imagens/desenvolvimento-de-software.jpg")));
		lblNewLabel.setBounds(0, 0, 477, 283);
		contentPane.add(lblNewLabel);


	}
}
