package Negocios;

public class CodigoInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodigoInvalidoException() {
		// TODO Auto-generated constructor stub
	super("C�digo do produto inv�lido!");
	
	}

	public CodigoInvalidoException(String msg){
		
		super(msg);
	}
	
}
