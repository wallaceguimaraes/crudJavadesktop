package Negocios;

public class Fornecedor extends Pessoa{

	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(String cnpj, String nome, String telefone, String email) throws CnpjInvalidoException {
		super(cnpj,nome,telefone,email);
	}

	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.cpf;
	}

	@Override
	public void setCpf(String cnpj) throws CpfInvalidoException {
		// TODO Auto-generated method stub
	if(cnpj.length() >=14){
	       super.cpf=cnpj;
	}else{
      	   throw new CpfInvalidoException("CNPJ inválido!");
	      }
	  }
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.nome;
	}

	@Override
	public void setNome(String nome) throws NomeInvalidoExcepiton {
		// TODO Auto-generated method stub
		if(nome.length() >= 5)
		super.nome=nome.toUpperCase();
		else
	    throw new NomeInvalidoExcepiton("Nome do fornecedor inválido!"); 
	
	}

	@Override
	public String getTelefone() {
		// TODO Auto-generated method stub
		return super.telefone;
	}

	@Override
	public void setTelefone(String telefone) throws TelefoneIinvalidoException {
		// TODO Auto-generated method stub
		
		if(telefone.length() >= 10)
		super.telefone=telefone;
		else
			throw new TelefoneIinvalidoException();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.email;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
		super.email=email.toLowerCase();
		
		}

	
}  
