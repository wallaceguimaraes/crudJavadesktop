package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Negocios.NomeInvalidoExcepiton;
import Negocios.CnpjInvalidoException;
import Negocios.CpfInvalidoException;
import Negocios.Fornecedor;
import Negocios.TelefoneIinvalidoException;

public class FornecedorDAO {
	
	
	public void Salvar(Fornecedor f ){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement("INSERT INTO FORNECEDOR(CNPJ,NOME,TELEFONE,EMAIL) VALUES(?,?,?,?)");
			pst.setString(1, f.getCpf());
			pst.setString(2, f.getNome());
			pst.setString(3, f.getTelefone());
			pst.setString(4, f.getEmail());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}

	}

	public void Editar(Fornecedor f){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" UPDATE FORNECEDOR SET NOME = ?,TELEFONE = ?,EMAIL = ? WHERE CNPJ = ?");
			pst.setString(1, f.getNome());
			pst.setString(2, f.getTelefone());
			pst.setString(3, f.getEmail());
			pst.setString(4, f.getCpf());
			
			pst.execute(); 

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}

	}

	public void Excluir(Fornecedor f){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" DELETE FROM FORNECEDOR WHERE CNPJ = ?");
			pst.setString(1, f.getCpf());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}


	public List<Fornecedor> Ler(){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;

		List<Fornecedor> forn = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM FORNECEDOR ORDER BY NOME");
			rs=pst.executeQuery();
			while(rs.next()){
				Fornecedor f = new Fornecedor();
				f.setCpf(rs.getString("CNPJ"));
				f.setNome(rs.getString("NOME"));
				f.setTelefone(rs.getString("TELEFONE"));
				f.setEmail(rs.getString("EMAIL"));
				forn.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelefoneIinvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			Factory.closeConnection(con, pst, rs);
		}
		return forn;

	}

	public List<Fornecedor> Enviar(Fornecedor f){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Fornecedor f = new Fornecedor();
		List<Fornecedor> fornecedor = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM FORNECEDOR WHERE CNPJ = ?");
			pst.setString(1, f.getCpf());
			rs=pst.executeQuery();
			
			while(rs.next()){
				
				f.setCpf(rs.getString("CNPJ"));
				f.setNome(rs.getString("NOME"));
				f.setTelefone(rs.getString("TELEFONE"));
				f.setEmail(rs.getString("EMAIL"));
			    fornecedor.add(f);
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelefoneIinvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			Factory.closeConnection(con, pst, rs);
		}
		return fornecedor;
	
	
	
	}

}
