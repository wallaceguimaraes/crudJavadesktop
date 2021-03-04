package Apresentacao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dados.ClienteDAO;
import Dados.ProdutoDAO;
import Negocios.Cliente;
import Negocios.CodigoInvalidoException;
import Negocios.CpfInvalidoException;
import Negocios.NomeInvalidoExcepiton;
import Negocios.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ProdutoApresentacao extends JFrame {
 
	private JPanel panel;
	private JPanel contentPane;
	private JTextField textFielCodP;
	private JTextField textFieldProduto;
	private JTextField textFieldQtdProd;
	private JTextField textFieldDescric;
	private JTable tabelaP;
	private JTextField textFieldPreco;
	int cont=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoApresentacao frame = new ProdutoApresentacao();
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
	public ProdutoApresentacao() {
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProdutoApresentacao.class.getResource("/Imagens/17425819_1671761313118416_642056269222443453_n.jpg")));

		
addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				
				ApresentacaoPrincipal ap = new ApresentacaoPrincipal();
				ap.setVisible(true);
				dispose();
			}
			
		});
		
		setBounds(100, 100, 820, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel panel = new JPanel();
		panel = new JPanel();
		panel.setBounds(0, 0, 804, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPro = new JLabel("C\u00F3digo:");
		lblPro.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblPro.setForeground(Color.WHITE);
		lblPro.setBounds(10, 30, 46, 14);
		panel.add(lblPro);
		
		textFielCodP = new JTextField();
		textFielCodP.setBounds(95, 27, 228, 20);
		panel.add(textFielCodP);
		textFielCodP.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Produto:");
		lblDescrio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setBounds(10, 70, 84, 14);
		panel.add(lblDescrio);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setEnabled(false);
		textFieldProduto.setColumns(10);
		textFieldProduto.setBounds(95, 58, 228, 20);
		panel.add(textFieldProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setBounds(333, 30, 98, 14);
		panel.add(lblQuantidade);
		
		textFieldQtdProd = new JTextField();
		textFieldQtdProd.setEnabled(false);
		textFieldQtdProd.setBounds(431, 27, 214, 20);
		panel.add(textFieldQtdProd);
		textFieldQtdProd.setColumns(10);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblDescrio_1.setForeground(Color.WHITE);
		lblDescrio_1.setBounds(333, 61, 98, 14);
		panel.add(lblDescrio_1);
		
		textFieldDescric = new JTextField();
		textFieldDescric.setEnabled(false);
		textFieldDescric.setBounds(431, 58, 363, 20);
		panel.add(textFieldDescric);
		textFieldDescric.setColumns(10);
		
		//tabelaP.setBounds(21, 136, 624, 298);
		//panel.add(tabelaP);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(20, 102, 91, 23);
		panel.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(111, 102, 91, 23);
		panel.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(199, 102, 91, 23);
		panel.add(btnBuscar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(285, 102, 91, 23);
		panel.add(btnAtualizar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(374, 102, 91, 23);
		panel.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(464, 102, 91, 23);
		panel.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(554, 102, 91, 23);
		panel.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setAlignmentY(10.0f);
		scrollPane.setAlignmentX(2.0f);
		scrollPane.setBounds(10, 138, 758, 265);
		panel.add(scrollPane);


		tabelaP = new JTable();
		tabelaP.setEnabled(false);
		scrollPane.setViewportView(tabelaP);
	
		
		
		tabelaP.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabelaP.setAutoCreateRowSorter(true);
		tabelaP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Produto", "Quantidade", "Descri\u00E7\u00E3o", "Pre\u00E7o R$"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaP.getColumnModel().getColumn(0).setResizable(false);
		tabelaP.getColumnModel().getColumn(0).setPreferredWidth(56);
		tabelaP.getColumnModel().getColumn(1).setPreferredWidth(119);
		tabelaP.getColumnModel().getColumn(2).setPreferredWidth(73);
		tabelaP.getColumnModel().getColumn(3).setPreferredWidth(154);
		tabelaP.getColumnModel().getColumn(4).setPreferredWidth(55);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblPreo.setForeground(Color.WHITE);
		lblPreo.setBounds(657, 30, 46, 14);
		panel.add(lblPreo);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setEnabled(false);
		textFieldPreco.setBounds(708, 24, 86, 20);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		
	
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				textFieldProduto.setEnabled(true);
				textFieldQtdProd.setEnabled(true);
				textFieldDescric.setEnabled(true);
				textFieldPreco.setEnabled(true);
				btnEditar.setEnabled(false);
				btnNovo.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnCadastrar.setEnabled(true);
				textFielCodP.setText("");
				textFieldProduto.setText("");
				textFieldQtdProd.setText("");
				textFieldDescric.setText("");	
				textFieldPreco.setText("");
				readTable();
							
			}
		});
		
		
		
		
		btnEditar.addActionListener(new  ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				 btnCancelar.setEnabled(true);
					btnAtualizar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnBuscar.setEnabled(false);
					btnCadastrar.setEnabled(false);
					btnNovo.setEnabled(false);
					btnEditar.setEnabled(false);
					textFieldProduto.setEnabled(true);
					textFieldQtdProd.setEnabled(true);
					textFieldDescric.setEnabled(true);
					textFieldPreco.setEnabled(true);
					textFieldProduto.setText("");
					textFieldQtdProd.setText("");
					textFieldDescric.setText("");
					textFieldPreco.setText("");
				
				
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				btnAtualizar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnNovo.setEnabled(true);
				btnEditar.setEnabled(true);
				btnCadastrar.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnCancelar.setEnabled(false);
				textFielCodP.setEnabled(true);
				textFieldProduto.setEnabled(false);
				textFieldQtdProd.setEnabled(false);
				textFieldDescric.setEnabled(false);
                textFieldPreco.setEnabled(false);
                textFielCodP.setText("");
                textFieldDescric.setText("");
                textFieldPreco.setText("");
                textFieldProduto.setText("");
                textFieldQtdProd.setText("");
				readTable();

				
			}
		});
		
		
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				ProdutoDAO pDao = new ProdutoDAO();
				Produto p = new Produto();	

			
					
					try {
						p.setCod(Integer.parseInt(textFielCodP.getText().trim()));
					} catch (NumberFormatException | CodigoInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pDao.Enviar(p);
					textFieldProduto.setText(p.getNome());
				    textFielCodP.setText(Integer.toString(p.getCod()));
					textFieldQtdProd.setText(Integer.toString(p.getQtd()));;
					textFieldDescric.setText(p.getDescricao());
					textFieldPreco.setText(Double.toString(p.getPreco()));
					
				btnCancelar.setEnabled(true);
				buscarTabela();
				
				
			}
		});
		
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ProdutoDAO pDao = new ProdutoDAO();
				Produto p = new Produto();

				try {

					p.setNome(textFieldProduto.getText().trim());
					p.setQtd(Integer.parseInt(textFieldQtdProd.getText().trim()));
					p.setDescricao(textFieldDescric.getText().trim());
					p.setPreco(Double.parseDouble(textFieldPreco.getText()));
					p.setCod(Integer.parseInt(textFielCodP.getText().trim()));
					pDao.Editar(p);
				} catch (CodigoInvalidoException es) {
					// TODO Auto-generated catch block
					es.printStackTrace();
				} catch (NomeInvalidoExcepiton e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				textFielCodP.setText("");
				textFieldProduto.setText("");
				textFieldQtdProd.setText("");
				textFieldDescric.setText("");
				textFieldPreco.setText("");
				textFieldProduto.setEnabled(false);
				textFieldQtdProd.setEnabled(false);
				textFieldDescric.setEnabled(false);
				textFieldPreco.setEnabled(false);
				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNovo.setEnabled(true);
				btnAtualizar.setEnabled(false);
                btnCancelar.setEnabled(false);
                
                readTable();                
             
				
			}
		});
		
		
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				ProdutoDAO pDao = new ProdutoDAO();
				Produto p = new Produto();

				try {
					p.setCod(Integer.parseInt(textFielCodP.getText().trim()));
					pDao.Excluir(p);

				} catch (CodigoInvalidoException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}				
				textFielCodP.setText("");
				textFieldProduto.setText("");
				textFieldQtdProd.setText("");
				textFieldDescric.setText("");
				textFieldPreco.setText("");
				textFieldProduto.setEnabled(false);
				textFieldQtdProd.setEnabled(false);
				textFieldDescric.setEnabled(false);
				textFieldPreco.setEnabled(false);
				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNovo.setEnabled(true);
				btnAtualizar.setEnabled(false);
				btnCancelar.setEnabled(false);
				readTable();
				
				
				
				
			}
		});
		
		
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

		
				ProdutoDAO produtoDao = new ProdutoDAO();
				Produto p = new Produto();
				

				try {
					p.setCod(Integer.parseInt(textFielCodP.getText().trim()));
					p.setNome(textFieldProduto.getText().trim());
					p.setQtd(Integer.parseInt(textFieldQtdProd.getText().trim()));
					p.setDescricao(textFieldDescric.getText().trim());
					p.setPreco(Double.parseDouble(textFieldPreco.getText().trim()));
					produtoDao.Salvar(p);

				} catch (CodigoInvalidoException | NomeInvalidoExcepiton e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				

				readTable();
                btnCancelar.setEnabled(false);
				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNovo.setEnabled(true);
				btnAtualizar.setEnabled(false);
				textFielCodP.setText("");
				textFieldProduto.setText("");
				textFieldQtdProd.setText("");
				textFieldDescric.setText("");
				textFieldPreco.setText("");
				textFieldProduto.setEnabled(false);
				textFieldQtdProd.setEnabled(false);
				textFieldDescric.setEnabled(false);
				textFieldPreco.setEnabled(false);
				textFielCodP.setText("");
				
				
			}
		});
			
			
			
			
		readTable();

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ProdutoApresentacao.class.getResource("/Imagens/sistema.jpg")));
		label_1.setBounds(0, 0, 804, 455);
		panel.add(label_1);	
			}
	
	public void readTable(){
	DefaultTableModel modelo = (DefaultTableModel) tabelaP.getModel();
	modelo.setNumRows(0);
    ProdutoDAO pDao = new ProdutoDAO();
    int con = 0;
    
    for(Produto p:pDao.Ler()){
    	modelo.addRow(new Object[]{
    			p.getCod(),
    			p.getNome(),
    			p.getQtd(),
    			p.getDescricao(),
    			p.getPreco()
    			
    	});
   

    	
    }

    //System.out.println(tabelaP.getRowCount());


    JLabel lblProdutosCadastrados = new JLabel(tabelaP.getRowCount()+" produtos cadastrados.");
	lblProdutosCadastrados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	lblProdutosCadastrados.setForeground(Color.WHITE);
	lblProdutosCadastrados.setBounds(27, 430, 263, 14);
	panel.add(lblProdutosCadastrados);
	
	System.out.println(tabelaP.getRowCount());
	}

	
	public void buscarTabela(){
		DefaultTableModel modelo = (DefaultTableModel) tabelaP.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pDao = new ProdutoDAO();
		Produto p = new Produto();
		pDao.Enviar(p);
		try {
			p.setCod(Integer.parseInt(textFielCodP.getText().trim()));
			p.setNome(textFieldProduto.getText().trim());
			p.setQtd(Integer.parseInt(textFieldQtdProd.getText().trim()));
			p.setDescricao(textFieldDescric.getText().trim());
            p.setPreco(Double.parseDouble(textFieldPreco.getText().trim()));
			textFieldProduto.setText("");
            textFieldQtdProd.setText("");
            textFieldDescric.setText("");
            textFieldPreco.setText("");
			
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo.addRow(new Object[]{
				p.getCod(),
				p.getNome(),
				p.getQtd(),
				p.getDescricao(),
				p.getPreco()
				

		});
		
		}
}
