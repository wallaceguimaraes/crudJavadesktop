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
import Dados.FornecedorDAO;
import Negocios.Cliente;
import Negocios.NomeInvalidoExcepiton;
import Negocios.CnpjInvalidoException;
import Negocios.CpfInvalidoException;
import Negocios.Fornecedor;
import Negocios.TelefoneIinvalidoException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FornecedorApresentacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCnpj;
	private JTextField textFieldNome;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorApresentacao frame = new FornecedorApresentacao();
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
	public FornecedorApresentacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FornecedorApresentacao.class.getResource("/Imagens/17458134_1671777209783493_8199517020815639075_n.jpg")));
		setResizable(false);
		setTitle("Fornecedores");

        addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				
				ApresentacaoPrincipal p = new ApresentacaoPrincipal();
				p.setVisible(true);
				dispose();
				
			}
			
		});
		
		
		setBounds(100, 100, 730, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCnpj.setBounds(31, 4, 46, 14);
		contentPane.add(lblCnpj);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(31, 29, 209, 20);
		contentPane.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEmpresa.setBounds(31, 55, 68, 14);
		contentPane.add(lblEmpresa);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(31, 80, 209, 20);
		textFieldNome.setEnabled(false);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setForeground(Color.WHITE);
		lblTel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTel.setBounds(292, 4, 46, 14);
		contentPane.add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(292, 29, 183, 20);
		textFieldTel.setEnabled(false);
		contentPane.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEmail.setBounds(292, 55, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(292, 80, 183, 20);
		textFieldEmail.setEnabled(false);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnNovo = new JButton("Novo");
		
		btnNovo.setBounds(492, 11, 91, 23);
		contentPane.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		
		btnEditar.setBounds(492, 45, 91, 23);
		contentPane.add(btnEditar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		
		btnCadastrar.setBounds(593, 11, 91, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		
		btnAtualizar.setBounds(593, 45, 91, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		
		btnExcluir.setBounds(492, 79, 91, 23);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		
		btnCancelar.setBounds(593, 79, 91, 23);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 125, 653, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(580, 278, 91, 23);
		contentPane.add(btnBuscar);
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				FornecedorDAO fDao = new FornecedorDAO();
				Fornecedor f = new Fornecedor();	

                try {
					f.setCpf(textFieldCnpj.getText().trim());
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fDao.Enviar(f);
				textFieldCnpj.setText(f.getCpf());
				textFieldNome.setText(f.getNome());
				textFieldTel.setText(f.getTelefone());;
				textFieldEmail.setText(f.getEmail());
				btnCancelar.setEnabled(true);
				buscarTabela();
				
				
					/*				
				f.setCpf(textFieldCnpj.getText().trim());
				fDao.Enviar(f);
				textFieldNome.setText(f.getNome());
				textFieldCnpj.setText(f.getCpf());
				textFieldTel.setText(f.getTelefone());;
				textFieldEmail.setText(f.getEmail());	
				btnCancelar.setEnabled(true);
				buscarTabela();
			*/
			}
		});
		
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
				textFieldNome.setEnabled(true);
				textFieldTel.setEnabled(true);
				textFieldEmail.setEnabled(true);
				btnEditar.setEnabled(false);
				btnNovo.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(false);
				btnBuscar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnCadastrar.setEnabled(true);
				textFieldCnpj.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				textFieldEmail.setText("");	
				readTable();
			
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				btnAtualizar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnNovo.setEnabled(true);
				btnEditar.setEnabled(true);
				btnCadastrar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnBuscar.setEnabled(true);
				textFieldCnpj.setEnabled(true);
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				textFieldEmail.setEnabled(false);

				readTable();
			
			
			
			}
		});
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				FornecedorDAO fornecedorDao = new FornecedorDAO();
				Fornecedor f = new Fornecedor();
				try {
					f.setCpf(textFieldCnpj.getText().trim());
					f.setNome(textFieldNome.getText().trim());
					f.setTelefone(textFieldTel.getText().trim());
					f.setEmail(textFieldEmail.getText().trim());
					fornecedorDao.Salvar(f);
				
				
				} catch (TelefoneIinvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (CpfInvalidoException e) {
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
				btnAtualizar.setEnabled(false);
				textFieldCnpj.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				textFieldEmail.setText("");
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				textFieldEmail.setEnabled(false);
				textFieldCnpj.setText("");
				
			
			
			}
		});
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 btnCancelar.setEnabled(true);
					btnAtualizar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnBuscar.setEnabled(false);
					btnCadastrar.setEnabled(false);
					btnNovo.setEnabled(false);
					btnEditar.setEnabled(false);
					textFieldNome.setEnabled(true);
					textFieldTel.setEnabled(true);
					textFieldEmail.setEnabled(true);
					textFieldNome.setText("");
					textFieldTel.setText("");
					textFieldEmail.setText("");
				
			}
		});
		
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
				FornecedorDAO fDao = new FornecedorDAO();
				Fornecedor f = new Fornecedor();

				try {

					f.setNome(textFieldNome.getText().trim());
					f.setTelefone(textFieldTel.getText().trim());
					f.setEmail(textFieldEmail.getText().trim());
					f.setCpf(textFieldCnpj.getText().trim());
					fDao.Editar(f);
			
				} catch (TelefoneIinvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NomeInvalidoExcepiton e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textFieldCnpj.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				textFieldEmail.setText("");
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
			public void actionPerformed(ActionEvent e) {
			
				FornecedorDAO fDao = new FornecedorDAO();
				Fornecedor f = new Fornecedor();
				
				try {
					f.setCpf(textFieldCnpj.getText().trim());
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fDao.Excluir(f);
			
	
				textFieldCnpj.setText("");
				textFieldNome.setText("");
				textFieldTel.setText("");
				textFieldEmail.setText("");
				textFieldNome.setEnabled(false);
				textFieldTel.setEnabled(false);
				textFieldEmail.setEnabled(false);
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setToolTipText("");
		scrollPane.setAlignmentY(10.0f);
		scrollPane.setAlignmentX(2.0f);
		scrollPane.setBounds(10, 0, 633, 128);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 11, 586, 117);	
		scrollPane.setViewportView(table);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CNPJ", "Fornecedor", "Telefone", "E-mail"
			}
		));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FornecedorApresentacao.class.getResource("/Imagens/sistema.jpg")));
		label.setBounds(0, 0, 724, 322);
		contentPane.add(label);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(187);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(176);
		
		
	
	
	readTable();
	
	}
	
	
	public void readTable(){
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
	    FornecedorDAO fDao = new FornecedorDAO();

	    for(Fornecedor f:fDao.Ler()){
	    	modelo.addRow(new Object[]{
	    			f.getCpf(),
	    			f.getNome(),
	    			f.getTelefone(),
	    			f.getEmail()
	    	});

	    }
	}
	
	
	public void buscarTabela(){
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		FornecedorDAO fDao = new FornecedorDAO();
		Fornecedor f = new Fornecedor();
		fDao.Enviar(f);
		try {
			
			f.setCpf(textFieldCnpj.getText().trim());
			f.setNome(textFieldNome.getText().trim());
			f.setTelefone(textFieldTel.getText().trim());
			f.setEmail(textFieldEmail.getText().trim());
            textFieldNome.setText("");
            textFieldTel.setText("");
            textFieldEmail.setText("");
			
		} catch (TelefoneIinvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.addRow(new Object[]{
				f.getCpf(),
				f.getNome(),
				f.getTelefone(),
				f.getEmail()
		});
		
		}
	
}
