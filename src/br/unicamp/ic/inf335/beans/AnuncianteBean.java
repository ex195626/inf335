/**
 * 
 */
package br.unicamp.ic.inf335.beans;

import java.util.ArrayList;

public class AnuncianteBean {

	private String nome;
	private String CPF;
	private ArrayList<AnuncioBean> anuncios;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public ArrayList<AnuncioBean> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(ArrayList<AnuncioBean> anuncios) {
		this.anuncios = anuncios;
	}
	
	public AnuncianteBean() {
		nome = "";
		CPF = "";
		anuncios = new ArrayList<AnuncioBean>();
	}

	public AnuncianteBean(String nome, String cPF, ArrayList<AnuncioBean> anuncios) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.anuncios = anuncios;
	}
	
	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void addAnuncio (AnuncioBean nAnuncio) {
		anuncios.add(nAnuncio);	
	}
	
	/**
	 * Remove um anuncio da lista de anuncios de um anunciante
	 * @param i Indice do anuncio a ser removido
	 * @throws IndexOutOfBoundsException se o indice for incorreto
	 */
	public void removeAnuncio (int i) {
		anuncios.remove(i);	
	}
	
	/**
	 * Calcula o valor medio de anuncios de um anuciante
	 * @return valor medio dos anuncios 
	 */
	public Double valorMedioAnuncios() {
		Double soma = 0.0;
		for (AnuncioBean an:anuncios) {
			soma += an.getValor();
		}
		return soma/anuncios.size();
	}

}
