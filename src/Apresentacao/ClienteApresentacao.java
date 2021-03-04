package Apresentacao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Dados.ClienteDAO;
import Dados.Factory;
//import br.org.ftc.dados.ClienteDAO;
//import br.org.ftc.dados.DAOException;

import Negocios.Cliente;
import Negocios.NomeInvalidoExcepiton;
import Negocios.CpfInvalidoException;
import Negocios.EmailInvalidoException;
import Negocios.TelefoneIinvalidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class ClienteApresentacao extends JFrame {


	Factory con = new Factory();
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteApresentacao frame = new ClienteApresentacao();
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
	//ClienteTabelModel tableModel = new ClienteTabelModel();
	private JTextField textFieldNome;
	private JTextField textFieldTel;
	private JTextField TextfieldEmail;
	private JTextField textFieldCpf;
	private JTable tabelaC;
	int cont=0;

	public ClienteApresentacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteApresentacao.class.getResource("/Imagens/desenvolvimento-de-software.jpg")));
		//con.getConnection();
		setTitle("Cadastro de clientes");
		setResizable(false);
   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				ApresentacaoPrincipal p = new ApresentacaoPrincipal();
				p.setVisible(true);
				dispose();
			}
		});
		
		setBounds(100, 100, 895, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 113, 820, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setAlignmentY(10.0f);
		scrollPane.setAlignmentX(2.0f);
		scrollPane.setBounds(0, 0, 820, 200);
		panel.add(scrollPane);
		tabelaC = new JTable();
		tabelaC.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//tabelaC.setBounds(30, 11, 649, 184);
		//panel.add(tabelaC);
		scrollPane.setViewportView(tabelaC);
		tabelaC.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabelaC.setAutoCreateRowSorter(true);
		tabelaC.setEnabled(false);
		tabelaC.setCellSelectionEnabled(true);
		tabelaC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "Cliente", "Telefone", "E-mail"
			}
		));
		tabelaC.getColumnModel().getColumn(0).setPreferredWidth(56);
		tabelaC.getColumnModel().getColumn(1).setPreferredWidth(207);
		tabelaC.getColumnModel().getColumn(3).setPreferredWidth(211);
		tabelaC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				if(tabelaC.getSelectedRow() != -1){
					textFieldCpf.setText(tabelaC.getValueAt(tabelaC.getSelectedRow(), 0).toString());
					textFieldNome.setText(tabelaC.getValueAt(tabelaC.getSelectedRow(), 1).toString());
					textFieldTel.setText(tabelaC.getValueAt(tabelaC.getSelectedRow(), 2).toString());
					TextfieldEmail.setText(tabelaC.getValueAt(tabelaC.getSelectedRow(), 3).toString());
					}
			}
		});
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCliente.setBounds(250, 14, 46, 14);
		contentPane.add(lblCliente);
		JLabel lblTelefone = new JLabel("Tel:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTelefone.setBounds(10, 71, 46, 14);
		contentPane.add(lblTelefone);
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setBounds(306, 11, 175, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldTel = new JTextField();
		textFieldTel.setEnabled(false);
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(66, 68, 156, 20);
		contentPane.add(textFieldTel);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCpf.setBounds(10, 14, 46, 14);
		contentPane.add(lblCpf);
		JLabel lblEnd = new JLabel("E-mail:");
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEnd.setBounds(250, 71, 46, 14);
		contentPane.add(lblEnd);
		TextfieldEmail = new JTextField();
		TextfieldEmail.setEnabled(false);
		TextfieldEmail.setBounds(306, 68, 175, 20);
		contentPane.add(TextfieldEmail);
		TextfieldEmail.setColumns(10);
		textFieldCpf = new JTextField();
		textFieldCpf.setEnabled(true);
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(66, 11, 156, 20);
		contentPane.add(textFieldCpf);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCadastrar.setBounds(739, 67, 91, 23);
		contentPane.add(btnCadastrar);
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Excluir: para excluir basta colocar o n\u00FAmero do CPF, em seguida aperte excluir.");
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnExcluir.setBounds(624, 10, 91, 23);
		contentPane.add(btnExcluir);
		JButton btnEditar = new JButton("Editar");
		btnEditar.setToolTipText("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEditar.setBounds(506, 10, 91, 23);
		contentPane.add(btnEditar);
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNovo.setBounds(507, 67, 91, 23);
		contentPane.add(btnNovo);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBuscar.setBounds(624, 67, 90, 23);
		contentPane.add(btnBuscar);
		JButton btnAtua = new JButton("Atualizar");
		btnAtua.setEnabled(false);
		btnAtua.setToolTipText("Atualizar");
		btnAtua.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtua.setBounds(739, 11, 91, 23);
		contentPane.add(btnAtua);
		JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setEnabled(false);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCancelar.setBounds(739, 342, 91, 23);
		contentPane.add(btnCancelar);
		
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtua.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnNovo.setEnabled(true);
				btnEditar.setEnabled(true);
				btnCadastrar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnBuscar.setEnabled(true);
				textFieldCpf.setEnabled(true);
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				TextfieldEmail.setEnabled(false);
				readTable();
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cDao = new ClienteDAO();
				Cliente c = new Cliente();	
				try {
					c.setCpf(textFieldCpf.getText().trim());
					cDao.Enviar(c);
					textFieldNome.setText(c.getNome());
					textFieldCpf.setText(c.getCpf());
					textFieldTel.setText(c.getTelefone());;
					TextfieldEmail.setText(c.getEmail());
		
				} catch (CpfInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnCancelar.setEnabled(true);
				buscarTabela();
			}	
		});
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {     
				textFieldNome.setEnabled(true);
				textFieldTel.setEnabled(true);
				TextfieldEmail.setEnabled(true);
				btnEditar.setEnabled(false);
				btnNovo.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(false);
				btnAtua.setEnabled(false);
				btnCadastrar.setEnabled(true);
				textFieldCpf.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				TextfieldEmail.setText("");	
				readTable();
			}
		});
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO clienteDao = new ClienteDAO();
				Cliente c = new Cliente();
				try {
					c.setCpf(textFieldCpf.getText().trim());
					c.setNome(textFieldNome.getText().trim());
					c.setTelefone(textFieldTel.getText().trim());
					c.setEmail(TextfieldEmail.getText().trim());
					clienteDao.Salvar(c);
				} catch (CpfInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TelefoneIinvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NomeInvalidoExcepiton e) {
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
				btnAtua.setEnabled(false);
				textFieldCpf.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				TextfieldEmail.setText("");
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				TextfieldEmail.setEnabled(false);
				textFieldCpf.setText("");
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                btnCancelar.setEnabled(true);
				btnAtua.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnBuscar.setEnabled(false);
				btnCadastrar.setEnabled(false);
				btnNovo.setEnabled(false);
				btnEditar.setEnabled(false);
				textFieldNome.setEnabled(true);
				textFieldTel.setEnabled(true);
				TextfieldEmail.setEnabled(true);
				textFieldNome.setText("");
				textFieldTel.setText("");
				TextfieldEmail.setText("");
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cDao = new ClienteDAO();
				Cliente c = new Cliente();
				try {
					c.setCpf(textFieldCpf.getText().trim());
					cDao.Excluir(c);

				} catch (CpfInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				textFieldCpf.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				TextfieldEmail.setText("");
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				TextfieldEmail.setEnabled(false);
				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNovo.setEnabled(true);
				btnAtua.setEnabled(false);
				btnCancelar.setEnabled(false);
				readTable();
			}
		});

		btnAtua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cDao = new ClienteDAO();
				Cliente c = new Cliente();
				try {
					c.setNome(textFieldNome.getText().trim());
					c.setTelefone(textFieldTel.getText().trim());
					c.setEmail(TextfieldEmail.getText().trim());
					c.setCpf(textFieldCpf.getText().trim());
					cDao.Editar(c);
				} catch (CpfInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TelefoneIinvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NomeInvalidoExcepiton e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textFieldCpf.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				TextfieldEmail.setText("");
				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNovo.setEnabled(true);
				btnAtua.setEnabled(false);
                btnCancelar.setEnabled(false);
				readTable();
			}
		});
		readTable();
	}
	public void readTable(){
	DefaultTableModel modelo = (DefaultTableModel) tabelaC.getModel();
	modelo.setNumRows(0);
    ClienteDAO cDao = new ClienteDAO();
    for(Cliente c:cDao.Ler()){
    	modelo.addRow(new Object[]{
    			c.getCpf(),
    			c.getNome(),
    			c.getTelefone(),
    			c.getEmail()
    	});
		//System.out.println(tabelaC.getSelectedRow());
        cont++;
		//System.out.println(cont);
		
    }
    
    JLabel label_1 = new JLabel(String.valueOf(cont)+" clientes cadastrados.");
	label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label_1.setForeground(Color.WHITE);
	label_1.setBounds(43, 345, 253, 14);
	contentPane.add(label_1);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(ClienteApresentacao.class.getResource("/Imagens/sistema.jpg")));
	label.setBounds(0, 0, 889, 384);
	contentPane.add(label);
    
	}
	public void buscarTabela(){
		DefaultTableModel modelo = (DefaultTableModel) tabelaC.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDao = new ClienteDAO();
		Cliente c = new Cliente();
		cDao.Enviar(c);
		try {
			c.setCpf(textFieldCpf.getText().trim());
			c.setNome(textFieldNome.getText().trim());
			c.setTelefone(textFieldTel.getText().trim());
			c.setEmail(TextfieldEmail.getText().trim());
            textFieldNome.setText("");
            textFieldTel.setText("");
            TextfieldEmail.setText("");		
		} catch (CpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelefoneIinvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.addRow(new Object[]{
				c.getCpf(),
				c.getNome(),
				c.getTelefone(),
				c.getEmail()
		        
		});
		}
	}