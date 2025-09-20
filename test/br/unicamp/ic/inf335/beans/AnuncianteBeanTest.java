package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {

    private AnuncianteBean anunciante;

    @BeforeEach
    void setUp() {
        AnuncioBean anuncioA;
        AnuncioBean anuncioB;

        // Anuncio A: Produto de 100.0 com 10% de desconto = 90.0
        ProdutoBean produtoA = new ProdutoBean("001", "Produto A", "", 100.0, "Novo");
        anuncioA = new AnuncioBean(produtoA, new ArrayList<>(), 0.10);

        // Anuncio B: Produto de 220.0 com 50% de desconto = 110.0
        ProdutoBean produtoB = new ProdutoBean("002", "Produto B", "", 220.0, "Novo");
        anuncioB = new AnuncioBean(produtoB, new ArrayList<>(), 0.50);

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(anuncioA);
        anuncios.add(anuncioB);
        anunciante = new AnuncianteBean("João", "123.456.789-00", anuncios);
    }

    @Test
    void testValorMedioAnuncios() {
        // Valor médio esperado: (90.0 + 110.0) / 2 = 100.0
        assertEquals(100.0, anunciante.valorMedioAnuncios());
    }

    @Test
    void testValorMedioAnunciosSemAnuncios() {
        anunciante.setAnuncios(new ArrayList<>());
        assertTrue(anunciante.valorMedioAnuncios().isNaN(), "Divisão por zero deveria resultar em NaN");
    }
    
    @Test
    void testAddAnuncio() {
        int tamanhoAntes = anunciante.getAnuncios().size();
        ProdutoBean produtoC = new ProdutoBean("003", "Produto C", "", 50.0, "Novo");
        AnuncioBean anuncioC = new AnuncioBean(produtoC, new ArrayList<>(), 0.0);
        
        anunciante.addAnuncio(anuncioC);
        
        int tamanhoDepois = anunciante.getAnuncios().size();
        assertEquals(tamanhoAntes + 1, tamanhoDepois);
        assertTrue(anunciante.getAnuncios().contains(anuncioC));
    }

    @Test
    void testRemoveAnuncio() {
        int tamanhoAntes = anunciante.getAnuncios().size();
        AnuncioBean anuncioRemovido = anunciante.getAnuncios().get(0);

        anunciante.removeAnuncio(0);

        int tamanhoDepois = anunciante.getAnuncios().size();
        assertEquals(tamanhoAntes - 1, tamanhoDepois);
        assertFalse(anunciante.getAnuncios().contains(anuncioRemovido));
    }

    @Test
    void testRemoveAnuncioComIndiceInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> anunciante.removeAnuncio(99));
    }

    @Test
    void testConstrutoresGettersSetters() {
        AnuncianteBean an = new AnuncianteBean();
        assertNotNull(an.getNome());
        assertNotNull(an.getCPF());
        assertNotNull(an.getAnuncios());

        an.setNome("Maria");
        assertEquals("Maria", an.getNome());

        an.setCPF("987.654.321-99");
        assertEquals("987.654.321-99", an.getCPF());

        assertEquals("João", anunciante.getNome());
        assertEquals("123.456.789-00", anunciante.getCPF());
    }
}