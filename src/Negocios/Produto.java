package Negocios;

import javax.swing.JOptionPane;

public class Produto {
	
	
	private int cod, qtd;
	private String nome;
	private String descricao;
	private double preco;
	
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		try{
		this.preco = preco;
		}catch(Exception e){
			System.out.println("Não é permitido valor 'nulo' ."+e);

		}
		
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(int cod, String nome, int qtd, String descricao) throws CodigoInvalidoException, NomeInvalidoExcepiton {
		// TODO Auto-generated constructor stub
	this.setCod(cod);
	this.setNome(nome);
	this.setQtd(qtd);
	this.setDescricao(descricao);
	
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) throws CodigoInvalidoException {
		if(cod == 0){	
			throw new CodigoInvalidoException("Não pode ser valor '0'");
		}else if((cod >= 0) && (cod <= 99999999)){
			this.cod = cod;
		}else{
			throw new CodigoInvalidoException();
		}
	}
		
		
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NomeInvalidoExcepiton {
		if(nome != null){
		this.nome = nome.toUpperCase();
	}else{
		throw new NomeInvalidoExcepiton("A coluna produto não pode ser nula!");
	}
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
