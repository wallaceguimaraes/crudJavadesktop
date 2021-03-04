package Negocios;

import Negocios.CpfInvalidoException;


public class Cliente extends Pessoa{

	
private String cpf,nome,telefone,email;
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cliente(String cpf, String nome, String telefone, String email) throws CpfInvalidoException, TelefoneIinvalidoException, NomeInvalidoExcepiton {
		// TODO Auto-generated constructor stub
		
	super(cpf, nome, telefone, email);	
	/*	
	this.setCpf(cpf);
	this.setNome(nome);
	this.setTelefone(telefone);;
	this.setEmail(email);
	*/
	}



	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.cpf;
	}
	
	@Override
	public void setCpf(String cpf) throws CpfInvalidoException {
		
		if(cpf == null){
			throw new CpfInvalidoException("CPF deve ser diferente de nulo!!");
		}else if(cpf.trim().length() >= 10){
			super.cpf = cpf;
		}else{ 
			throw new CpfInvalidoException();
		}	
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.nome;
	}



	@Override
	public void setNome(String nome) throws NomeInvalidoExcepiton {
		
		if(nome.length() >= 5) 
		 super.nome = nome.toUpperCase();
		//else
		// throw new NomeInvalidoExcepiton();
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
		//else
		 //throw new TelefoneIinvalidoException();
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
	
	
	
	
	
	/*
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws CpfInvalidoException {

		if(cpf == null){
			throw new CpfInvalidoException("CPF deve ser diferente de nulo!!");
		}else if(cpf.trim().length() >= 10){
			this.cpf = cpf;
		}else{ 
			throw new CpfInvalidoException("CPF inválido!");
		}
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) throws NomeInvalidoExcepiton{
		if(nome.length() >= 5)
	    this.nome = nome.toUpperCase();
		else
			throw new NomeInvalidoExcepiton();
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) throws TelefoneIinvalidoException {
	
		if(telefone.length() >=10 )
		this.telefone = telefone;
		else
			throw new TelefoneIinvalidoException();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email)  {
		
		//if(email.length() >= 15)
		this.email = email.toLowerCase();
		//lse
			//throw new EmailInvalidoException();
	
	}
	*/
	
}
