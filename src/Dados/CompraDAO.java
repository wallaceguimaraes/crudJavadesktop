package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Apresentacao.Calcular;
import Negocios.Cliente;
import Negocios.NomeInvalidoExcepiton;
import Negocios.CodigoInvalidoException;
import Negocios.Compras;
import Negocios.CpfInvalidoException;
import Negocios.Produto;
import Negocios.TelefoneIinvalidoException;

public class CompraDAO{
	
	
	public void Salvar(Compras c ){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("INSERT INTO COMPRAS(ID_COMPRA,CLIENTE,PRODUTO,QTD_PRODUTO, VALOR_COMPRA,DATA_COMPRA) VALUES(?,?,?,?,?,?)");
			pst.setInt(1, c.getId_compra());
	;
			pst.setString(2,c.getCliente());
			
			/*
			O problema todo se encontra, pois quando instancio a classe cliente na camada de negócios em compras
			, ao tentar fazer qualquer operação e manipulação com o banco de dados, eu não consigo pegar os dados do objeto instanciado
			tanto para salva, excluir, selecionar etc. Por isso coloquei uma string cliente la em compras para que aqui eu possa buscar os dados
			atraves do GetCliente
			*/
			
			
			//pst.setString(2,c.toString());
			pst.setString(3,c.getProduto());
			pst.setInt(4, c.getQtdProduto());
			pst.setDouble(5, c.getValorCompra());
			pst.setString(6, c.getDataCompra());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, " Compra realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar comprar o produto!!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public void Editar(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("UPDATE PRODUTO SET QTD_PRODUTO = ? WHERE COD_PRODUTO = ?");
			pst.setInt(1, p.getQtd());
			pst.setInt(2, p.getCod());
			pst.execute(); 
			//JOptionPane.showMessageDialog(null, "Baixa no do estoque!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public List<Produto> Enviar(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Produto> produto = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?");
			pst.setInt(1, p.getCod());
			rs=pst.executeQuery();
			while(rs.next()){	
				//p.setCod(rs.getInt("COD_PRODUTO"));
				//p.setNome(rs.getString("NOME_PRODUTO"));
				p.setQtd(rs.getInt("QTD_PRODUTO"));
				//p.setDescricao(rs.getString("DESCRIC_PRODUTO"));
				//p.setPreco(rs.getDouble("PRECO"));
				produto.add(p);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return produto;
	}
	public List<Compras> Enviar2(Compras c){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Compras> compra = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM COMPRAS WHERE CLIENTE = ?");
			//pst.setInt(1, c.getId_compra());
		
			//pst.setString(1, c.getCliente());
			
			rs=pst.executeQuery();
			//Cliente cliente = new Cliente();
			//Produto produto = new Produto();			
			while(rs.next()){	
				c.setId_compra(rs.getInt("ID_COMPRA"));
				c.setCliente(rs.getString("CLIENTE"));
				//cliente.setNome((rs.getString("CLIENTE")));
				//c.setCliente(cliente);
				c.setProduto(rs.getString("PRODUTO"));
				//produto.setNome(rs.getString("PRODUTO"));
				//c.setProduto(produto); 			
				c.setQtdProduto(rs.getInt("QTD_PRODUTO"));
				c.setValorCompra(rs.getDouble("VALOR_COMPRA"));
				c.setDataCompra(rs.getString("DATA_COMPRA"));
				compra.add(c);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return compra;
	}
	public List<Compras> Ler(){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Compras> compras = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM COMPRAS ORDER BY CLIENTE");
			rs=pst.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				Produto produto = new Produto();			

				Compras c = new Compras();
				c.setId_compra(rs.getInt("ID_COMPRA"));
				c.setCliente(rs.getString("CLIENTE"));
				c.setProduto(rs.getString("PRODUTO"));
				//cliente.setNome(rs.getString("CLIENTE"));
				//c.setCliente(cliente);
				produto.setNome(rs.getString("PRODUTO"));
				//c.setProduto(produto);
				c.setQtdProduto(rs.getInt("QTD_PRODUTO"));
				c.setValorCompra(rs.getDouble("VALOR_COMPRA"));
				c.setDataCompra(rs.getString("DATA_COMPRA"));
				compras.add(c);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return compras;
	}
	public List<Cliente> Verificar(Cliente c){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		Cliente cli = new Cliente();
		List<Cliente> cliente = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
			pst.setString(1, c.getCpf());
			rs=pst.executeQuery();
			while(rs.next()){	
				c.setCpf(rs.getString("CPF"));
				c.setNome(rs.getString("NOME"));
				c.setTelefone(rs.getString("TELEFONE"));
				c.setEmail(rs.getString("EMAIL"));
				cliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelefoneIinvalidoException e) {
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

	public List<Produto> Verificar(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Produto> produto = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?");
		//	pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE '"+p.getNome()+"%' ORDER BY NOME_PRODUTO");

			pst.setInt(1, p.getCod());
			//pst.setString(1, p.getNome());
			
			rs=pst.executeQuery();
			while(rs.next()){
				p.setNome(rs.getString("NOME_PRODUTO"));
				p.setPreco(Double.parseDouble(rs.getString("PRECO")));
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



	public List<Produto> Verificar2(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Produto> produto = new ArrayList<>();

		try {
			//pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?");
			pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE '"+p.getNome()+"%'");

			//pst.setInt(1, p.getCod());
			//pst.setString(1, p.getNome());
			
			rs=pst.executeQuery();
			
			while(rs.next()){
				p.setNome(rs.getString("NOME_PRODUTO"));
				p.setPreco(Double.parseDouble(rs.getString("PRECO")));
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


	public void Editar2(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			//pst = con.prepareStatement("UPDATE PRODUTO SET QTD_PRODUTO = ? WHERE COD_PRODUTO = ?");
			//pst = con.prepareStatement("UPDATE PRODUTO WHERE NOME_PRODUTO LIKE '"+p.getNome()+"%'");// aperfeiçoar aqui depois
			pst = con.prepareStatement("UPDATE PRODUTO SET QTD_PRODUTO = "+p.getQtd()+" WHERE NOME_PRODUTO LIKE '"+p.getNome()+"%'");// aperfeiçoar aqui depois
            
			//pst.setInt(1, quantidadefinal);
			//pst.setInt(2, p.getCod());
			pst.execute(); 
			JOptionPane.showMessageDialog(null, "Produto cancelado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	

	public List<Produto> Enviar3(Produto p){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Produto> produto = new ArrayList<>();
		try {
			//pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?");
			pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE'"+p.getNome()+"%'");// aperfeiçoar aqui depois
		//	pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE '"+p.getNome()+"%' ORDER BY NOME_PRODUTO");

			
			//pst.setInt(1, p.getCod());
			rs=pst.executeQuery();
			
			while(rs.next()){	
				//p.setCod(rs.getInt("COD_PRODUTO"));
				//p.setNome(rs.getString("NOME_PRODUTO"));
				p.setQtd(rs.getInt("QTD_PRODUTO"));
				//p.setDescricao(rs.getString("DESCRIC_PRODUTO"));
				//p.setPreco(rs.getDouble("PRECO"));
				produto.add(p);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return produto;
	}
	
	
}
