package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Factory {
	
	
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String url = "jdbc:derby:C:/Users/Wallace Guimaraes/Desktop/Banco de DadosD/Derbinho;create=true;";
	private static String user = "wallace";
	private static String password = "12345";
	private static Connection conn;
	public  ResultSet rs;
	public  Statement stm ;
	public  Connection con;
	public Connection conectando;
	
	
	public static Connection getConnection(){

		try {
			Class.forName(driver);

			
			return DriverManager.getConnection(url, user, password);
			//System.setProperty("jdbc.Drivers", driver);	// seta a propriedade do driver de conexao			
			
			//con = DriverManager.getConnection(url,user,password);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conexão!"+e);
		}

	}
	
	
	public Connection conexao (){ // método responsável por realizar a conexao com o banco
		
		try {
			System.setProperty("jdbc.Drivers", driver);	// seta a propriedade do driver de conexao			
			
			conectando = DriverManager.getConnection(url,user,password);// realiza a conexao com o banco
		
//			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro:"+e.getMessage());

		}
		return conectando;
	
	
	}
	
	

	
	public void executaSQL(String sql) {
		// TODO Auto-generated method stub
		try {
			try {
				stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stm.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ResultSet res = ps.executeQuery();//ex
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro no executa SQL"+e);
			//e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	public static void desconectaConexao(Connection con){
		try{
			if(con != null)
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void closeConnection(Connection con, PreparedStatement pst){
		
	   	desconectaConexao(con);
		try{
			if(pst != null){
				pst.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs){// Sobrecarga de métodos, polimorfismo
		
       closeConnection(con, pst);		
		try{
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
