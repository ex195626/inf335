package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class AnuncioBeanTest {

    private ProdutoBean produto;
    private ArrayList<URL> fotos;
    private AnuncioBean anuncio;

    @BeforeEach
    void setupTest() throws MalformedURLException {
        produto = new ProdutoBean("001", "TV 4K", "Televisão de alta definição", 1000.0, "Novo");
        fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto1.jpg"));
        anuncio = new AnuncioBean(produto, fotos, 0.20); // 20% de desconto
    }


    @Test
    void testAnuncioBeanDefaultConstructor() {
        AnuncioBean an = new AnuncioBean();
        assertNotNull(an.getProduto());
        assertNotNull(an.getFotosUrl());
        assertTrue(an.getFotosUrl().isEmpty());
        assertEquals(0.0, an.getDesconto());
    }

    @Test
    void testAnuncioBeanCustomConstructor() {
        assertEquals(produto, anuncio.getProduto());
        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(0.20, anuncio.getDesconto());
    }

    @Test
    void testGettersAndSetters() throws MalformedURLException {
        AnuncioBean an = new AnuncioBean();
        
        ProdutoBean p = new ProdutoBean();
        an.setProduto(p);
        assertSame(p, an.getProduto());

        ArrayList<URL> f = new ArrayList<>();
        f.add(new URL("http://google.com"));
        an.setFotosUrl(f);
        assertSame(f, an.getFotosUrl());
        
        an.setDesconto(0.5);
        assertEquals(0.5, an.getDesconto());
    }

    @Test
    void testAnuncioBeanGetValor() {
    	anuncio.setDesconto(0.20);
        Double valorEsperado = 800.0;
        assertEquals(valorEsperado, anuncio.getValor());
        
    	anuncio.setDesconto(0.5);
    	valorEsperado = 500.0;
        assertEquals(valorEsperado, anuncio.getValor());
        
    	anuncio.setDesconto(0.0);
    	valorEsperado = 1000.0;
        assertEquals(valorEsperado, anuncio.getValor());
        
    	anuncio.setDesconto(1.0);
    	valorEsperado = 0.0;
        assertEquals(valorEsperado, anuncio.getValor());
    }

    @Test
    void testAnuncioBeanDescontoIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> anuncio.setDesconto(-10.0));
        assertThrows(IllegalArgumentException.class, () -> anuncio.setDesconto(110.0));
    }

    @Test
    void testGetSerialVersionUid() {
        assertEquals(1L, AnuncioBean.getSerialversionuid());
    }
}
