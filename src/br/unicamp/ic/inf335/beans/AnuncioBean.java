package br.unicamp.ic.inf335.beans;

import java.net.URL;
import java.util.ArrayList;

public class AnuncioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


	private ProdutoBean produto;
	private ArrayList<URL> fotosUrl;
	private Double desconto; // Entre 0 e 1
	
	
	
	public ProdutoBean getProduto() {
		return produto;
	}

	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}

	public ArrayList<URL> getFotosUrl() {
		return fotosUrl;
	}

	public void setFotosUrl(ArrayList<URL> fotosUrl) {
		this.fotosUrl = fotosUrl;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		if (desconto < 0 || desconto > 1) {
			throw new IllegalArgumentException("Valor de desconto deve estar entre 0 e 1");
		}
		
		this.desconto = desconto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AnuncioBean () {
		produto = new ProdutoBean();
		fotosUrl = new ArrayList<URL>();
		desconto = 0.0;
	}

	public AnuncioBean(ProdutoBean produto, ArrayList<URL> fotosUrl, Double desconto) {
		super();
		this.produto = produto;
		this.fotosUrl = fotosUrl;
		this.desconto = desconto;
	}

	/**
	 * Calcula valor do anuncio 
	 * @return retona valor do produto menos o desconto 
	 */
	public Double getValor() {
		Double valor = produto.getValor();
		return valor - (valor * desconto);
	}
}
