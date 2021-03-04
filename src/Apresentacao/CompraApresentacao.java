package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Dados.ClienteDAO;
import Dados.CompraDAO;
import Dados.LucroDAO;
import Dados.ProdutoDAO;
import Dados.VendaFDAO;
import Negocios.Cliente;
import Negocios.CodigoInvalidoException;
import Negocios.Compras;
import Negocios.CpfInvalidoException;
import Negocios.NomeInvalidoExcepiton;
import Negocios.Produto;
import Negocios.VendaF;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.ScrollPane;

public class CompraApresentacao extends JFrame implements Calcular {
	private JPanel panel;
	private JPanel contentPane;
	private JTextField textFieldCpfCliente;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldProduto;
	private JTextField textFieldQtd;
	private JTextField textFieldParcelas;
	private JTextField textFieldValorCompras;
	private JTextField textFieldData;
	private JTextField textFieldCliecompra;
	private JTextField textFieldUnidade;
	private JTextField textFieldCodigo;
	private JTextField textFieldValorParc;
	private JTextField textFieldID;
	private JTextField textFieldValorrece;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldTotalF;
	private JTextField textField;
	private JTextField textFieldVserPago;
	private JTable table_2;
	private JTable table_3;
	private JTextField textFieldCodCancela;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraApresentacao frame = new CompraApresentacao();
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
	public CompraApresentacao() {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatar.format(data);
		SimpleDateFormat formatar2 = new SimpleDateFormat("hh:mm");
		String data2 = formatar2.format(data);
		
		
		
		
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CompraApresentacao.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setTitle("Sistema de Compras");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				
				
				// apagar todas as informações do banco de dados
				//da tabela de venda
				
				
				VendaFDAO vDao = new VendaFDAO();
                vDao.Excluir();				
				
				
				
				
				
				ApresentacaoPrincipal a = new ApresentacaoPrincipal();
				a.setVisible(true);
			}
		});
		setBounds(100, 100, 1146, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 34, 672, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCpf.setBounds(10, 51, 46, 14);
		panel.add(lblCpf);
		textFieldCpfCliente = new JTextField();
		textFieldCpfCliente.setBounds(66, 48, 209, 20);
		panel.add(textFieldCpfCliente);
		textFieldCpfCliente.setColumns(10);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNome.setBounds(10, 99, 46, 14);
		panel.add(lblNome);
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(66, 96, 263, 20);
		panel.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);
		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setForeground(new Color(72, 61, 139));
		lblDadosDoCliente.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		lblDadosDoCliente.setBounds(10, 11, 163, 14);
		panel.add(lblDadosDoCliente);
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setForeground(Color.BLACK);
		lblTel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTel.setBounds(339, 51, 46, 14);
		panel.add(lblTel);
		textFieldTelefone = new JTextField();
		textFieldTelefone.setEditable(false);
		textFieldTelefone.setBounds(395, 48, 209, 20);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(395, 96, 267, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEmail.setBounds(339, 99, 46, 14);
		panel.add(lblEmail);
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(571, 129, 91, 23);
		panel.add(btnVerificar);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 197, 672, 209);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblCompras = new JLabel("Frente de caixa");
		lblCompras.setForeground(new Color(0, 0, 255));
		lblCompras.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		lblCompras.setBounds(10, 11, 146, 14);
		panel_1.add(lblCompras);
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setForeground(Color.BLACK);
		lblProduto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblProduto.setBounds(292, 100, 60, 14);
		panel_1.add(lblProduto);
		textFieldProduto = new JTextField();
		textFieldProduto.setEditable(false);
		textFieldProduto.setBounds(362, 97, 182, 20);
		panel_1.add(textFieldProduto);
		textFieldProduto.setColumns(10);
		JLabel lblQtd = new JLabel("Qtd:");
		lblQtd.setForeground(Color.BLACK);
		lblQtd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblQtd.setBounds(565, 100, 46, 14);
		panel_1.add(lblQtd);
		textFieldQtd = new JTextField();
		textFieldQtd.setEditable(false);
		textFieldQtd.setBounds(602, 97, 60, 20);
		panel_1.add(textFieldQtd);
		textFieldQtd.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setForeground(Color.BLACK);
		lblPreo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPreo.setBounds(292, 139, 46, 14);
		panel_1.add(lblPreo);

		textFieldValorCompras = new JTextField();
		textFieldValorCompras.setEditable(false);
		textFieldValorCompras.setBounds(362, 136, 182, 20);
		panel_1.add(textFieldValorCompras);
		textFieldValorCompras.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);

		btnBuscar.setBounds(571, 48, 91, 23);
		panel_1.add(btnBuscar);

		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.BLACK);
		lblData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblData.setBounds(493, 13, 35, 14);
		panel_1.add(lblData);

		textFieldData = new JFormattedTextField();
		textFieldData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textFieldData.setEditable(false);
		textFieldData.setText(dataFormatada);
		
		textFieldData.setBounds(527, 10, 66, 20);
		panel_1.add(textFieldData);
		textFieldData.setColumns(10);

		/*
		try{
			MaskFormatter form = new MaskFormatter("##/##/####");
			((JFormattedTextField) textFieldData).setFormatterFactory(new DefaultFormatterFactory(form));
			}catch(ParseException t){
				
			}
		*/
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCliente.setBounds(10, 52, 46, 14);
		panel_1.add(lblCliente);

		textFieldCliecompra = new JTextField();
		textFieldCliecompra.setEditable(false);
		textFieldCliecompra.setBounds(73, 49, 209, 20);
		panel_1.add(textFieldCliecompra);
		textFieldCliecompra.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setForeground(Color.BLACK);
		lblUnidade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUnidade.setBounds(10, 100, 56, 14);
		panel_1.add(lblUnidade);

		textFieldUnidade = new JTextField();
		textFieldUnidade.setEditable(false);
		textFieldUnidade.setBounds(73, 97, 90, 20);
		panel_1.add(textFieldUnidade);
		textFieldUnidade.setColumns(10);

		JButton btnCalcular = new JButton("Add Produto");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(571, 135, 91, 23);
		panel_1.add(btnCalcular);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCodigo.setBounds(292, 52, 46, 14);
		panel_1.add(lblCodigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(364, 48, 180, 20);
		panel_1.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblId.setBounds(10, 139, 46, 14);
		panel_1.add(lblId);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(73, 136, 91, 20);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);



		JButton btnCancelar = new JButton("Cancelar Compra");
		btnCancelar.setBounds(527, 169, 135, 23);
		panel_1.add(btnCancelar);
		
		JLabel lblServioEmOperao = new JLabel("Servi\u00E7o em opera\u00E7\u00E3o");
		lblServioEmOperao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblServioEmOperao.setForeground(new Color(0, 128, 0));
		lblServioEmOperao.setBounds(236, 13, 125, 14);
		panel_1.add(lblServioEmOperao);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblHora.setBounds(603, 13, 35, 14);
		panel_1.add(lblHora);
		
		JLabel horaq = new JLabel(data2);
		horaq.setFont(new Font("Tahoma", Font.ITALIC, 10));
		
		horaq.setBounds(637, 13, 35, 14);
		panel_1.add(horaq);
		
		JButton btnCancelarProduto = new JButton("Cancelar Produto");
		
		btnCancelarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			/*
			 aqui temos que cancelar o produto, ou pelo seu nome ou pelo código, ou seja
			deve-se buscar no banco de dados da venda pelo codigo ou nome o produto e fazer a comparação com o 
			banco de venda depois buscar a quantidade de produto do banco e repor o produto ao banco dde produtos
			em seguida calcular o valor unidade pela quantidade e em seguida enviar o valor total para o textfield total.
			*/
			VendaFDAO vDao = new VendaFDAO();
			VendaF v = new VendaF();
			v.setProduto(textFieldCodCancela.getText());
			vDao.Enviar(v);
			
			double compraC = (v.getQtd()*v.getUnidade());
			double t =Double.parseDouble(textFieldTotalF.getText());
			textFieldTotalF.setText(Double.toString(t-compraC));	
			//textFieldCodCancela.getText();
			CompraDAO cDao = new CompraDAO();
			Compras c = new Compras();
			Produto p = new Produto();
			//LucroDAO ldao = new LucroDAO();	
			
			try {
				
				p.setNome(textFieldCodCancela.getText());
				cDao.Enviar3(p);
				
				int quantidadeBD=p.getQtd();
				
				int quantidadeSub=(v.getQtd());
			
				System.out.println(quantidadeBD+" "+quantidadeSub);
				int Y =(quantidadeBD+quantidadeSub); 	
				System.out.println("resultado "+Y);
                           
				p.setQtd(Y);			
					//p.setCod(Integer.parseInt(textFieldCodCancela.getText()));		
				p.setNome(textFieldCodCancela.getText().toUpperCase());
					
				cDao.Editar2(p);
						
                vDao.Excluir2(v);
				readTable();	
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			} catch (NomeInvalidoExcepiton e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
			
				
			
		});
			
		btnCancelarProduto.setBounds(174, 169, 125, 23);
		panel_1.add(btnCancelarProduto);
		
		
		textFieldCodCancela = new JTextField();
		textFieldCodCancela.setBounds(73, 170, 91, 20);
		panel_1.add(textFieldCodCancela);
		textFieldCodCancela.setColumns(10);
		
		JLabel lblCod = new JLabel("Produto:");
		lblCod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCod.setBounds(10, 173, 56, 14);
		panel_1.add(lblCod);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(10, 417, 722, 186);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setForeground(new Color(255, 255, 255));
		lblPagamento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPagamento.setBounds(10, 0, 121, 27);
		panel_2.add(lblPagamento);
		
		JLabel lblTipoDePagamento = new JLabel("Tipo de pagamento:");
		lblTipoDePagamento.setForeground(new Color(0, 255, 255));
		lblTipoDePagamento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTipoDePagamento.setBounds(10, 31, 147, 14);
		panel_2.add(lblTipoDePagamento);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(0, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblValor.setBounds(404, 31, 46, 14);
		panel_2.add(lblValor);
		
		textFieldValorrece = new JTextField();
		
		textFieldValorrece.setBounds(460, 28, 91, 20);
		panel_2.add(textFieldValorrece);
		textFieldValorrece.setColumns(10);
		
		//table = new JTable();
		
		
		
		
		
		/*
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descri\u00E7\u00E3o"
			}
		));
		table.setBounds(10, 88, 351, 73);
		panel_2.add(table);
		*/
		JLabel lblInformeOsValores = new JLabel("Informe os valores pagos");
		lblInformeOsValores.setForeground(Color.BLUE);
		lblInformeOsValores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblInformeOsValores.setBounds(10, 63, 242, 14);
		panel_2.add(lblInformeOsValores);
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(371, 88, 69, 14);
		panel_2.add(lblParcelas);
		lblParcelas.setForeground(new Color(0, 255, 255));
		lblParcelas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
				textFieldParcelas = new JTextField();
				textFieldParcelas.setBounds(460, 85, 86, 20);
				panel_2.add(textFieldParcelas);
				textFieldParcelas.setEditable(false);
				textFieldParcelas.setColumns(10);
				
						JLabel lblValorParcelas = new JLabel("Valor Parcelas:");
						lblValorParcelas.setBounds(367, 119, 99, 14);
						panel_2.add(lblValorParcelas);
						lblValorParcelas.setForeground(new Color(0, 255, 255));
						lblValorParcelas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
						
								textFieldValorParc = new JTextField();
								textFieldValorParc.setBounds(460, 116, 86, 20);
								panel_2.add(textFieldValorParc);
								textFieldValorParc.setEditable(false);
								textFieldValorParc.setColumns(10);
								
										JButton btnCalcularParcelas = new JButton("Calcular Parcelas");
										btnCalcularParcelas.setBounds(566, 84, 149, 23);
										panel_2.add(btnCalcularParcelas);
										btnCalcularParcelas.setEnabled(false);
										
												JButton btnEfetuarCompra = new JButton("Efetuar Compra");
												btnEfetuarCompra.setBounds(566, 143, 149, 23);
												panel_2.add(btnEfetuarCompra);
												btnEfetuarCompra.setEnabled(false);
												
												JComboBox comboBoxTipopaga = new JComboBox();
												comboBoxTipopaga.setForeground(new Color(148, 0, 211));
												comboBoxTipopaga.setModel(new DefaultComboBoxModel(new String[] {"", "01 - Dinheiro", "02 - Cart\u00E3o de Cr\u00E9dito", "03 - Cart\u00E3o de D\u00E9bito", "04 - Cheque", "05 - Vale Refei\u00E7\u00E3o", "06 - Ticket Alimenta\u00E7\u00E3o"}));
												comboBoxTipopaga.setBounds(138, 27, 242, 22);
												panel_2.add(comboBoxTipopaga);
												
												/*
												if(comboBoxTipopaga.getSelectedItem().equals("01 - Dinheiro")){
													textFieldValorrece.setEditable(true);
													
												}else{
													textFieldValorrece.setEditable(false);
												}
												
												*/
												JLabel lblTroco = new JLabel("Troco:");
												lblTroco.setForeground(new Color(0, 255, 255));
												lblTroco.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
												lblTroco.setBounds(367, 147, 46, 14);
												panel_2.add(lblTroco);
												
												textField = new JTextField();
												textField.setEditable(false);
												textField.setBounds(460, 144, 86, 20);
												panel_2.add(textField);
												textField.setColumns(10);
												
												JButton btnAdicionarValor = new JButton("Adicionar Valor");
												btnAdicionarValor.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
													
													
													// jogar o get combox item e o valor recebido na tabela a esquerda
													
													// quando for jogado na tabela instantaneamente debita o valor recebido do total
													// e joga o q falta no textfiel valor a ser pago	
													
													
													
													
													}
												});
												btnAdicionarValor.setFont(new Font("Tahoma", Font.PLAIN, 10));
												btnAdicionarValor.setBounds(592, 27, 113, 23);
												panel_2.add(btnAdicionarValor);
												
												JLabel lblValorASer = new JLabel("Valor a ser pago:");
												lblValorASer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
												lblValorASer.setForeground(new Color(0, 255, 255));
												lblValorASer.setBounds(556, 122, 106, 14);
												panel_2.add(lblValorASer);
												
												textFieldVserPago = new JTextField();
												textFieldVserPago.setEditable(false);
												textFieldVserPago.setBounds(662, 119, 53, 20);
												panel_2.add(textFieldVserPago);
												textFieldVserPago.setColumns(10);
												
												JScrollPane scrollPane_1 = new JScrollPane();
												scrollPane_1.setBounds(10, 77, 351, 98);
												panel_2.add(scrollPane_1);
												
												table_3 = new JTable();
												scrollPane_1.setViewportView(table_3);
												
								
												
												table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

												table_3.setAlignmentX(Component.LEFT_ALIGNMENT);
												table_3.setAutoCreateRowSorter(true);
												table_3.setEnabled(false);
												table_3.setCellSelectionEnabled(true);
												table_3.setModel(new DefaultTableModel(
													new Object[][] {
													},
													new String[] {
														"DESCRI\u00C7\u00C2O", "VALOR"
													}
												));
												table_3.getColumnModel().getColumn(0).setPreferredWidth(264);
												table_3.getColumnModel().getColumn(1).setPreferredWidth(66);
												
												
												
												
												
												
												
												btnEfetuarCompra.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														CompraDAO cDao = new CompraDAO();
														Compras c = new Compras();
														Produto p = new Produto();
														LucroDAO ldao = new LucroDAO();	
														try {
															p.setCod(Integer.parseInt(textFieldCodigo.getText()));	
															cDao.Enviar(p);
															int quantidadeBD=p.getQtd();
															int quantidadeSub=Integer.parseInt(textFieldQtd.getText());
															if(quantidadeBD >= quantidadeSub){
																int t =quantidadeBD - quantidadeSub; 	
																p.setQtd(t);			
																p.setCod(Integer.parseInt(textFieldCodigo.getText()));
																cDao.Editar(p);
																c.setId_compra(Integer.parseInt(textFieldID.getText()));
																c.setCliente(textFieldCliecompra.getText());
																
																
																c.setProduto(textFieldProduto.getText());
																c.setQtdProduto(Integer.parseInt(textFieldQtd.getText()));
																c.setValorCompra(Double.parseDouble(textFieldValorCompras.getText()));
																c.setDataCompra(textFieldData.getText());
																cDao.Salvar(c);		

																ldao.Ler(c);
																ldao.Salvar(c);// salvar o lucro bruto

																textFieldCliecompra.setText("");
																textFieldCodigo.setText("");
																textFieldCodigo.setEditable(false);
																textFieldCpfCliente.setText("");
																textFieldData.setText("");
																textFieldData.setEditable(false);
																textFieldEmail.setText("");
																textFieldID.setText("");
																textFieldID.setEditable(false);
																textFieldNomeCliente.setText("");
																textFieldParcelas.setText("");
																textFieldParcelas.setEditable(false);
																textFieldProduto.setText("");
																textFieldProduto.setEditable(false);
																textFieldQtd.setText("");
																textFieldQtd.setEditable(false);
																textFieldTelefone.setText("");
																textFieldTelefone.setEditable(false);
																textFieldUnidade.setText("");
																textFieldValorCompras.setText("");
																textFieldValorCompras.setEditable(false);
																textFieldValorParc.setText("");
																textFieldValorParc.setEditable(false);                        
															}else{
																JOptionPane.showMessageDialog(null, "Não há produtos suficientes no estoque para a venda!");
															}
														} catch (NumberFormatException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														} catch (CodigoInvalidoException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
												});
												
										btnCalcularParcelas.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												try {
													textFieldValorParc.setText(String.format("%.2f",(retornarValorParcelas())));
													
													textFieldID.setEditable(true);
													btnEfetuarCompra.setEnabled(true);
												} catch (CodigoInvalidoException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}		
											}
										});
		
		JLabel lblVendaAberta = new JLabel("Venda em andamento");
		lblVendaAberta.setForeground(new Color(0, 255, 255));
		lblVendaAberta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblVendaAberta.setBounds(725, 11, 287, 38);
		contentPane.add(lblVendaAberta);
		
	
		
		
		
		
		
		
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setForeground(new Color(255, 255, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblTotal.setBounds(763, 438, 114, 38);
		contentPane.add(lblTotal);
		
		textFieldTotalF = new JTextField();
		textFieldTotalF.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		textFieldTotalF.setBounds(887, 441, 195, 38);
		
		JFormattedTextField field = new JFormattedTextField();
		field.setHorizontalAlignment(textFieldTotalF.RIGHT);
		
		
		textFieldTotalF.setText("0");
		contentPane.add(textFieldTotalF);
		textFieldTotalF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(692, 45, 438, 365);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		table_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		table_2.setAutoCreateRowSorter(true);
		table_2.setEnabled(false);
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"QTD", "Valor", "UNIDADE", "PRODUTO"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(48);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(63);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(67);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(187);
		
		JLabel lblR = new JLabel("R$");
		lblR.setForeground(new Color(255, 255, 0));
		lblR.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblR.setBounds(1092, 453, 46, 14);
		contentPane.add(lblR);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CompraApresentacao.class.getResource("/Imagens/sistema.jpg")));
		label.setBounds(0, 0, 1158, 618);
		contentPane.add(label);
		
		
		
		
		
		
		
		
		
		
		btnCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					//textFieldValorCompras.setText(Double.toString(calcularCompras()));
					
					String rep =String.format("%.2f",(calcularCompras()));
					
				      rep = rep.replaceAll(",", ".");
				      textFieldValorCompras.setText(rep);
					
					//textFieldValorCompras.setText(Double.toString(calcularCompras()));
					
				} catch (CodigoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				if(textFieldValorCompras.getText()!= null){
					btnCalcularParcelas.setEnabled(true);
					textFieldParcelas.setEditable(true);
				}
				
				
				VendaFDAO vDAO = new VendaFDAO();
				VendaF v = new VendaF();
				
				v.setQtd(Integer.parseInt(textFieldQtd.getText().trim()));
                v.setValort(Double.parseDouble((textFieldValorCompras.getText().trim())));				
				v.setUnidade(Double.parseDouble(textFieldUnidade.getText().trim()));
				v.setProduto(textFieldProduto.getText().trim());
				vDAO.Salvar(v);
				
				
				readTable();
				
				
				double total =Double.parseDouble(textFieldTotalF.getText());
				double compra =Double.parseDouble(textFieldValorCompras.getText());
				
				total= total + compra;
				
				textFieldTotalF.setText(String.valueOf(total));
				
				
				// OBS : erro no valor da chave primaria
				
				;
				
				
				textFieldCodigo.setText("");
				textFieldProduto.setText("");
				textFieldQtd.setText("");
				textFieldUnidade.setText("");
				textFieldValorCompras.setText("");
				
		
				
				
				// limpar campos para recolocar novamente
				// preço + textfilTotalF
				// e adiociona na lista à direita os produtos
				//dar a baixa nos produtos 
				// caso cancele a venda, va no banco de dados e verifique o nome e a data da venda para apagar do banco de dados a venda
				// em seguida verificar o nome do produto e repor o produto vendido
				
			}
		});

		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {					
				textFieldCliecompra.setText(textFieldNomeCliente.getText());
				CompraDAO cDao = new CompraDAO();
				Produto p = new Produto();
				try {
					if(!textFieldCodigo.getText().equals("")){
						p.setCod(Integer.parseInt(textFieldCodigo.getText()));
						
						/*
						try {
							p.setNome(textFieldCodigo.getText());
						
						} catch (NomeInvalidoExcepiton e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
*/
						btnCalcular.setEnabled(true);
						textFieldQtd.setEditable(true);
						
					}else{
						throw new CodigoInvalidoException();
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CodigoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cDao.Verificar(p);
				textFieldProduto.setText(p.getNome());
				textFieldUnidade.setText(Double.toString(p.getPreco()));
			}
		});
		btnCancelar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldCpfCliente.setText("");
				textFieldCliecompra.setText("");
				textFieldCodigo.setText("");
				textFieldCodigo.setEditable(false);
				textFieldData.setText("");
				textFieldData.setEditable(false);
				textFieldEmail.setText("");
				textFieldID.setText("");
				textFieldID.setEditable(false);
				textFieldNomeCliente.setText("");
				textFieldParcelas.setText("");
				textFieldParcelas.setEditable(false);
				textFieldProduto.setText("");
				textFieldQtd.setText("");
				textFieldQtd.setEditable(false);
				textFieldTelefone.setText("");
				textFieldUnidade.setText("");
				textFieldUnidade.setEditable(false);
				textFieldValorCompras.setText("");
				textFieldValorParc.setText("");
				btnBuscar.setEnabled(false);
				btnCalcular.setEnabled(false);
				btnEfetuarCompra.setEnabled(false);
				btnCalcularParcelas.setEnabled(false);

			}
		});

		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraDAO cDao = new CompraDAO();
				Cliente cli = new Cliente();
				try {
					cli.setCpf(textFieldCpfCliente.getText());
					cDao.Verificar(cli);
					textFieldNomeCliente.setText(cli.getNome());	
					textFieldTelefone.setText(cli.getTelefone());
					textFieldEmail.setText(cli.getEmail());
				} catch (CpfInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!textFieldNomeCliente.getText().trim().equals("")){
					btnBuscar.setEnabled(true);
					textFieldCodigo.setEditable(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
					textFieldCpfCliente.setText("");
				}
			}
		});
	}
	
	
	
	
	
	
	
	
	public void readTable(){
		DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();
		modelo.setNumRows(0);
	    VendaFDAO vDao = new VendaFDAO();
	    for(VendaF v:vDao.Ler()){
	    	modelo.addRow(new Object[]{
	    			v.getQtd(),
	    			v.getValort(),
	    			v.getUnidade(),
	    			v.getProduto()
	    	});
			//System.out.println(tabelaC.getSelectedRow());
			//System.out.println(cont);
	    }
	    
	    
		}
	
	
	
	
	public double retornarValorParcelas() throws CodigoInvalidoException {
		// TODO Auto-generated method stub
		double preco = 0;
		int qtd = 0;
		if(!textFieldParcelas.getText().equalsIgnoreCase("")){
			preco =Double.parseDouble(textFieldValorCompras.getText());
			qtd = Integer.parseInt(textFieldParcelas.getText());

		}else{
			throw new CodigoInvalidoException("A quantidade de parcelas não pode ser nula!");
		}		
		return (preco/qtd);
	}
	@Override
	public double calcularCompras() throws CodigoInvalidoException {
		// TODO Auto-generated method stub
		/*
		DecimalFormat formato = new DecimalFormat("#.##");      
		double numero ;
			*/	 
		
		int qtd = 0;
		double unidade=0;
		if(!textFieldQtd.getText().equalsIgnoreCase("")){
			qtd=Integer.parseInt(textFieldQtd.getText());
			unidade =Double.parseDouble(textFieldUnidade.getText());
			/*
			numero =Double.valueOf(formato.format(qtd*unidade));

		*/
		} else{
			throw new CodigoInvalidoException("Insira a quantidade de produtos!");			 
		}
		return (qtd*unidade);
	}
}
