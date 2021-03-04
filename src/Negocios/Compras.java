package Negocios;



public class Compras {

	
private int id_compra;		

private String cliente;// O certo seria chamar a classe Cliente aqui, porem quando chamo...Depois não consigo
//                       manipular os atributos do cliente, pelo fato de la no banco de dados ser Strings ou inteiros.

private String produto;// O mesmo acontece em produto...eu tbm criei a String produto, mas possuo a classe produto... mas n a uso
private int qtdProduto;
private double valorCompra;
private String dataCompra;


public int getId_compra() {
	return id_compra;
}

public void setId_compra(int id_compra) throws CodigoInvalidoException {
	if(id_compra == 0 )
		throw new CodigoInvalidoException("ID não pode ser nulo!");	
		else
	this.id_compra = id_compra;
}


public String getCliente() {
	return cliente;
}

public void setCliente(String cliente) {
	this.cliente = cliente;
}





public String getProduto() {
	return produto;
}

public void setProduto(String produto) {
	this.produto = produto;
}

/*

public Cliente getCliente(){
	return cliente;
}

public void setCliente(Cliente cliente){
	this.cliente=cliente;
}

*/

/*
public Produto getProduto(){
	return produto;
}


public void setProduto(Produto produto){
	this.produto=produto;
}
*/

public int getQtdProduto() {
	return qtdProduto;
}

public void setQtdProduto(int qtdProduto) {
	this.qtdProduto = qtdProduto;
}

public double getValorCompra() {
	return valorCompra;
}

public void setValorCompra(double valorCompra) {
	this.valorCompra = valorCompra;
}

public String getDataCompra() {
	return dataCompra;
}

public void setDataCompra(String dataCompra) {
	this.dataCompra = dataCompra;
}


	

}
