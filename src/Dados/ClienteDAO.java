package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Apresentacao.ClienteApresentacao;
import Negocios.Cliente;
import Negocios.NomeInvalidoExcepiton;
import Negocios.CpfInvalidoException;
import Negocios.EmailInvalidoException;
import Negocios.TelefoneIinvalidoException;

public class ClienteDAO {

	public void Salvar(Cliente c ){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("INSERT INTO CLIENTE(CPF,NOME,TELEFONE,EMAIL) VALUES(?,?,?,?)");
			pst.setString(1, c.getCpf());
			pst.setString(2, c.getNome());
			pst.setString(3, c.getTelefone());
			pst.setString(4, c.getEmail());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public void Editar(Cliente c){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" UPDATE CLIENTE SET NOME = ?,TELEFONE = ?,EMAIL = ? WHERE CPF = ?");
			pst.setString(1, c.getNome());
			pst.setString(2, c.getTelefone());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getCpf());
			pst.execute(); 
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public void Excluir(Cliente c){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" DELETE FROM CLIENTE WHERE CPF = ?");
			pst.setString(1, c.getCpf());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	
	public List<Cliente> Ler(){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Cliente> cliente = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM CLIENTE ORDER BY NOME");
			rs=pst.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
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
	public List<Cliente> Enviar(Cliente c){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
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
}