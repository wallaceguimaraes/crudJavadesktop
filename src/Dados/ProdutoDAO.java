package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Negocios.CodigoInvalidoException;
import Negocios.NomeInvalidoExcepiton;
import Negocios.Produto;

public class ProdutoDAO {
	
	
	public void Salvar(Produto p ){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement("INSERT INTO PRODUTO(COD_PRODUTO,NOME_PRODUTO,QTD_PRODUTO,DESCRIC_PRODUTO, PRECO) VALUES(?,?,?,?,?)");
			pst.setInt(1, p.getCod());
			pst.setString(2, p.getNome());
			pst.setInt(3, p.getQtd());
			pst.setString(4, p.getDescricao());
			pst.setDouble(5, p.getPreco());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar produto!!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}

	}

	public void Editar(Produto p){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement("UPDATE PRODUTO SET NOME_PRODUTO = ?,QTD_PRODUTO = ?,DESCRIC_PRODUTO = ?,PRECO = ? WHERE COD_PRODUTO = ?");
			pst.setString(1, p.getNome());
			pst.setInt(2, p.getQtd());
			pst.setString(3, p.getDescricao());
			pst.setDouble(4, p.getPreco());
			pst.setInt(5, p.getCod());

			pst.execute(); 

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}

	}

	public void Excluir(Produto p){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" DELETE FROM PRODUTO WHERE COD_PRODUTO = ?");
			pst.setInt(1, p.getCod());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}


	public List<Produto> Ler(){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;

		List<Produto> produto = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM PRODUTO ORDER BY NOME_PRODUTO");
			rs=pst.executeQuery();
			while(rs.next()){
				Produto p = new Produto();
				p.setCod(rs.getInt("COD_PRODUTO"));
				p.setNome(rs.getString("NOME_PRODUTO"));
				p.setQtd(rs.getInt("QTD_PRODUTO"));
				p.setDescricao(rs.getString("DESCRIC_PRODUTO"));
				p.setPreco(rs.getDouble("PRECO"));
				produto.add(p);
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
		return produto;

	}

	public List<Produto> Enviar(Produto p){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		Produto cli = new Produto();
		List<Produto> produto = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?");
			pst.setInt(1, p.getCod());
			rs=pst.executeQuery();
			while(rs.next()){
				
				p.setCod(rs.getInt("COD_PRODUTO"));
				p.setNome(rs.getString("NOME_PRODUTO"));
				p.setQtd(rs.getInt("QTD_PRODUTO"));
				p.setDescricao(rs.getString("DESCRIC_PRODUTO"));
	            p.setPreco(rs.getDouble("PRECO"));
				produto.add(p);
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
		return produto;
	}
	
		

}
