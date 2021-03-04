package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Negocios.Cliente;
import Negocios.CpfInvalidoException;
import Negocios.NomeInvalidoExcepiton;
import Negocios.TelefoneIinvalidoException;
import Negocios.VendaF;

public class VendaFDAO {
	
	public void Salvar(VendaF v ){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("INSERT INTO VENDA (QTD,VALORT,UNIDADE,PRODUTO) VALUES(?,?,?,?)");
			pst.setInt(1, v.getQtd());
			pst.setDouble(2, v.getValort());
			pst.setDouble(3, v.getUnidade());
			pst.setString(4, v.getProduto());
			pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Produto adicionado ao banco com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	
	
	
	
	
	
	public List<VendaF> Enviar(VendaF v){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		//Cliente cli = new Cliente();
		List<VendaF> venda = new ArrayList<>();
		try {
			//pst = con.prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
			pst = con.prepareStatement("SELECT * FROM VENDA WHERE PRODUTO LIKE '"+v.getProduto()+"%'");// verificar aq

			//pst.setString(1, v.getProduto());
			rs=pst.executeQuery();
			
			while(rs.next()){			
				v.setQtd(rs.getInt("QTD"));
				v.setValort(rs.getDouble("VALORT"));
				v.setUnidade(rs.getDouble("UNIDADE"));
				v.setProduto(rs.getString("PRODUTO"));
				venda.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return venda;
	}
	
	
	
	
	
	
	
	
	public void Excluir(){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" DELETE FROM VENDA WHERE COD >= 1");
			//pst.setString(1, c.getCpf());
			pst.execute();
		//	JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}

	
	public void Excluir2(VendaF v){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(" DELETE FROM VENDA WHERE PRODUTO LIKE'"+v.getProduto()+"%'");
			//pst.setString(1, c.getCpf());
			pst.execute();
			//JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
		
	
	public List<VendaF> Ler(){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<VendaF> venda = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM VENDA");
			rs=pst.executeQuery();
			while(rs.next()){
				VendaF v = new VendaF();
				v.setQtd(rs.getInt("QTD"));
				v.setValort(rs.getDouble("VALORT"));
				v.setUnidade(rs.getDouble("UNIDADE"));
				v.setProduto(rs.getString("PRODUTO"));
				venda.add(v);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		  e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return venda;
	}
	
}