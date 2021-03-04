package Negocios;

public class NomeInvalidoExcepiton extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NomeInvalidoExcepiton() {
		// TODO Auto-generated constructor stub
	
	super("Nome do cliente inválido!");
	}
	
public NomeInvalidoExcepiton(String msg){
	super(msg);
	
  }
}
