package Apresentacao;

import Negocios.CodigoInvalidoException;

public interface Calcular {
	
	public double retornarValorParcelas() throws CodigoInvalidoException;

	public double calcularCompras() throws CodigoInvalidoException;



}
