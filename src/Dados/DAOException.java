package Dados;

public class DAOException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DAOException() {
		super("Erro ao executar instrução no banco de dados!");
	}


	public DAOException(String msg){
		super(msg);
	}


	public DAOException(Throwable e) {
		super(e);
	}
}
	


