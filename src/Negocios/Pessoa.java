package Negocios;
        
public abstract class Pessoa {
        
	protected String cpf, nome, telefone,email;
	    
	    
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}   
	    
	public Pessoa(String cpf, String nome, String telefone, String email) {
		// TODO Auto-generated constructor stub
	    
		this.cpf=cpf;
		this.nome=nome;
		this.telefone=telefone;
		this.email= email;
        
		
	}

	public abstract String getCpf();

	public abstract void setCpf(String cpf) throws CpfInvalidoException,CnpjInvalidoException;

	public abstract String getNome();

	public abstract void setNome(String nome) throws NomeInvalidoExcepiton;

	public abstract String getTelefone();

	public abstract void setTelefone(String telefone) throws TelefoneIinvalidoException;
	
	public abstract String getEmail();
	
	public abstract void setEmail(String email);
	
}
