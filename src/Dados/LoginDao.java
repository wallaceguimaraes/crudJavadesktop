package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Negocios.Login;


public class LoginDao {

	public void Salvar(Login l ){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("INSERT INTO USUARIO(USUA,SENHA,EMAIL) VALUES(?,?,?)");
			pst.setString(1, l.getUsuario());
			pst.setString(2, l.getSenha());
			pst.setString(3, l.getEmail());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Usuário já existente!");
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public List<Login> Enviar(Login l){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
		List<Login> login = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM USUARIO WHERE USUA = ?");
			pst.setString(1, l.getUsuario());
			rs=pst.executeQuery();
			while(rs.next()){
				l.setUsuario(rs.getString("USUA"));
				l.setSenha(rs.getString("SENHA"));
				l.setEmail(rs.getString("EMAIL"));
				login.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Usuário ou senha incorretos! "+e.getMessage());
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return login;
	}
	public List<Login> Enviar2(Login l){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
		List<Login> login = new ArrayList<>();
		try {
			pst = con.prepareStatement("SELECT * FROM USUARIO WHERE USUA = ? and EMAIL = ?");
			pst.setString(1, l.getUsuario());
			pst.setString(2, l.getEmail());
			rs=pst.executeQuery();
			while(rs.next()){
				//l.setUsuario(rs.getString("USUA"));
				l.setSenha(rs.getString("SENHA"));
				//l.setEmail(rs.getString("EMAIL"));
				login.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Usuário ou senha incorretos! "+e.getMessage());
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return login;
	}
}