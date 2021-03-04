package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dados.ClienteDAO;
import Dados.Factory;
import Dados.ProdutoDAO;
import Negocios.Cliente;
import Negocios.Compras;
import Negocios.CpfInvalidoException;
import Negocios.MinhaThread;
import Negocios.NomeInvalidoExcepiton;
import Negocios.Produto;
import Negocios.TelefoneIinvalidoException;

import javax.swing.JTextArea;

public class TrheadsApresentacao extends JFrame {

	private JPanel contentPane;
	//MinhaThread t1, t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrheadsApresentacao frame = new TrheadsApresentacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public TrheadsApresentacao() throws InterruptedException {
		setTitle("Lista em paralelo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 50, 390, 188);
		contentPane.add(textArea);
		
		
		
		List<String> string = new ArrayList<>();

		
		
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = new Cliente();
		ProdutoDAO pdao = new ProdutoDAO();
		Produto pp = new Produto();
		
		//Enviar(c);
		
	
		
		
		//string.add(Enviar(c));
		
		Enviar2(pp);
		
		MinhaThread p1 = new MinhaThread();
		MinhaThread p2 = new MinhaThread();
		
		p1.setB(c.getNome());
		//p2.setB(Enviar2(pp));		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);

		t1.start();
		t2.start();
		t2.wait();
		t2.join();
		
		
		
		
		//t1.start();
		//t2.start();
	}
	
	
	
	public List<Cliente> Enviar(Cliente c){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
		List<Cliente> cliente = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM CLIENTE");
			rs=pst.executeQuery();
			
			while(rs.next()){
				
				c.setNome(rs.getString("NOME"));
			  // System.out.println(c.getNome());
			  //t1 = new MinhaThread(c.getNome(),10, 500);
			   //t1.start();
				cliente.add(c);
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			Factory.closeConnection(con, pst, rs);
		}
		return cliente;
	}
	
	
	
	public List<Produto> Enviar2(Produto p){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
		List<Produto> produto = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM PRODUTO");
			
			rs=pst.executeQuery();
			
			while(rs.next()){
				
				p.setNome(rs.getString("NOME_PRODUTO"));
				//t2=new MinhaThread(p.getNome(), 10, 500);
				//System.out.println(p.getNome());
				//t2.start();
				produto.add(p);
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			Factory.closeConnection(con, pst, rs);
		}
		return produto;
	}
	
	
}
