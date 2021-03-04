package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Negocios.Compras;


public class LucroDAO {
	
	public void Salvar(Compras l ){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement("INSERT INTO LUCRO(LUCRO_BRUTO) VALUES(?)");
			pst.setDouble(1, l.getValorCompra());
			//pst.setDouble(2, l.getLucroLiquido());
			pst.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Lucro bruto cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar lucro!"+e);
		}finally{
			Factory.closeConnection(con, pst);
		}
	}
	public List<Compras> Ler(Compras comp){
		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Compras> compra = new ArrayList<>();
		double d=0;
		try {
			pst = con.prepareStatement("SELECT * FROM COMPRAS ");
			rs=pst.executeQuery();
			while(rs.next()){ 
				comp.setValorCompra(rs.getDouble("VALOR_COMPRA"));
				d=comp.getValorCompra()+d;
				comp.setValorCompra(d);
				compra.add(comp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally{

			Factory.closeConnection(con, pst, rs);
		}
		return compra;
	
	}

	public List<Compras> Ler2(Compras comp){

		Connection con = Factory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs  = null;
		List<Compras> compra = new ArrayList<>();

		try {
			pst = con.prepareStatement("SELECT * FROM LUCRO ");
			rs=pst.executeQuery();
			while(rs.next()){
				//Compras c = new Compras();

				comp.setValorCompra(rs.getDouble("LUCRO_BRUTO")); 
				compra.add(comp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Factory.closeConnection(con, pst, rs);
		}
		return compra;
	}
}
