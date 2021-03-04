package Apresentacao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dados.CompraDAO;
import Dados.ProdutoDAO;
import Negocios.CodigoInvalidoException;
import Negocios.Compras;
import Negocios.Produto;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CompraRealizadasApresentacao extends JFrame {

	private JPanel contentPane;
	private JTable tabelaV;
	private JTextField textFieldBusc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraRealizadasApresentacao frame = new CompraRealizadasApresentacao();
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
	public CompraRealizadasApresentacao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CompraRealizadasApresentacao.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Sistema de vendas");

		
addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				ApresentacaoPrincipal ap = new ApresentacaoPrincipal();
				ap.setVisible(true);
				dispose();
			}
			
		});
		
		setBounds(100, 100, 859, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 71, 801, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		tabelaV = new JTable();
		//tabelaV.setBounds(10, 11, 611, 231);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setAlignmentY(10.0f);
		scrollPane.setAlignmentX(2.0f);
		scrollPane.setBounds(10, 11, 782, 232);
		panel.add(scrollPane);


		scrollPane.setViewportView(tabelaV);
	
		tabelaV.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabelaV.setAutoCreateRowSorter(true);
		tabelaV.setEnabled(false);
		tabelaV.setCellSelectionEnabled(true);
		tabelaV.setColumnSelectionAllowed(true);
		tabelaV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cliente", "Produto", "Qtd (Kg ou L)", "Valor R$", "Data"
			}
		));
		tabelaV.getColumnModel().getColumn(0).setPreferredWidth(42);
		tabelaV.getColumnModel().getColumn(1).setPreferredWidth(211);
		tabelaV.getColumnModel().getColumn(2).setPreferredWidth(113);
		tabelaV.getColumnModel().getColumn(3).setPreferredWidth(53);
		tabelaV.getColumnModel().getColumn(4).setPreferredWidth(76);
		tabelaV.getColumnModel().getColumn(5).setPreferredWidth(54);

		JLabel lblVendasRealizadas = new JLabel("Vendas realizadas");
		lblVendasRealizadas.setForeground(Color.WHITE);
		lblVendasRealizadas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblVendasRealizadas.setBounds(40, 11, 164, 14);
		contentPane.add(lblVendasRealizadas);
		
		textFieldBusc = new JTextField();
		textFieldBusc.setBounds(438, 40, 261, 20);
		contentPane.add(textFieldBusc);
		textFieldBusc.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				buscarTabela();
			}
		});
		btnBuscar.setBounds(709, 37, 91, 23);
		contentPane.add(btnBuscar);

		JButton btnAtualizar = new JButton("Atualizar ");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				readTable();

			}
		});
		btnAtualizar.setBounds(693, 333, 107, 23);
		contentPane.add(btnAtualizar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CompraRealizadasApresentacao.class.getResource("/Imagens/sistema.jpg")));
		label.setBounds(0, 0, 853, 367);
		contentPane.add(label);

		readTable();

	}

	public void readTable(){
		DefaultTableModel modelo = (DefaultTableModel) tabelaV.getModel();
		modelo.setNumRows(0);
	    CompraDAO cDao = new CompraDAO();

	    for(Compras c:cDao.Ler()){
	    	modelo.addRow(new Object[]{
	    			c.getId_compra(),
	    			c.getCliente(),
	    			c.getProduto(),
	    			c.getQtdProduto(),
	    			String.format("%.2f",c.getValorCompra()),
	    			c.getDataCompra()
	    			});
	    }
		}
	public void buscarTabela(){
		DefaultTableModel modelo = (DefaultTableModel) tabelaV.getModel();
		modelo.setNumRows(0);
	    CompraDAO pDao = new CompraDAO();
		Compras c = new Compras();
		
		//c.setId_compra(Integer.parseInt(textFieldBusc.getText()));
		c.setCliente(textFieldBusc.getText().toUpperCase());
		pDao.Enviar2(c);
		
		
		modelo.addRow(new Object[]{
				c.getId_compra(),
				c.getCliente(),
				c.getProduto(),
				c.getQtdProduto(),
				String.format("%.2f",c.getValorCompra()),
				c.getDataCompra()
		
		});
		
		}
}
