package Negocios;

public class CpfInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CpfInvalidoException() {
		// TODO Auto-generated constructor stub
	
	super("Cpf inv�lido!");

	}
	public CpfInvalidoException(String msg) {
		super(msg);
	}
	
	
	
}
