package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {
	
	private ProdutoBean produtoA;
	private ProdutoBean produtoB;
	private ProdutoBean produtoC;

	@BeforeEach
	void setupTest() {
		produtoA = new ProdutoBean("001", "Produto A", "Descrição A", 100.0, "Novo");
		produtoB = new ProdutoBean("002", "Produto B", "Descricao B", 150.0, "Usado");
		produtoC = new ProdutoBean("003", "Produto C", "Descricao C", 100.0, "Novo");
	}

	@Test
	void testProdutoBeanDefaultConstructor() {
        ProdutoBean produto = new ProdutoBean();
        assertNotNull(produto.getCodigo(), "Código não deveria ser nulo");
        assertNotNull(produto.getNome(), "Nome não deveria ser nulo");
        assertNotNull(produto.getDescricao(), "Descrição não deveria ser nula");
        assertEquals(0.0, produto.getValor(), "Valor deveria ser 0.0");
        assertNotNull(produto.getEstado(), "Estado não deveria ser nulo");
	}
	
	@Test
	void testProdutoBeanCustomConstructor() {
        assertEquals("001", produtoA.getCodigo());
        assertEquals("Produto A", produtoA.getNome());
        assertEquals("Descrição A", produtoA.getDescricao());
        assertEquals(100.0, produtoA.getValor());
        assertEquals("Novo", produtoA.getEstado());
	}
	
	@Test
    void testGettersAndSetters() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("XYZ");
        assertEquals("XYZ", produto.getCodigo());

        produto.setNome("Produto Teste");
        assertEquals("Produto Teste", produto.getNome());

        produto.setDescricao("Descrição Teste");
        assertEquals("Descrição Teste", produto.getDescricao());

        produto.setValor(99.99);
        assertEquals(99.99, produto.getValor());

        produto.setEstado("Semi-novo");
        assertEquals("Semi-novo", produto.getEstado());
    }
	
	@Test
    void compareToDeveRetornar1ParaValorMaior() {
        // produtoB (150.0) > produtoA (100.0)
        assertEquals(1, produtoB.compareTo(produtoA));
    }
	
    @Test
    void compareToDeveRetornar0ParaValoresIguais() {
        // produtoA (100.0) == produtoC (100.0)
        assertEquals(0, produtoA.compareTo(produtoC));
    }

    @Test
    void compareToDeveRetornarMenos1ParaValorMenor() {
        // produtoA (100.0) < produtoB (150.0)
        assertEquals(-1, produtoA.compareTo(produtoB));
    }

    @Test
    void testGetSerialVersionUid() {
        assertEquals(1L, ProdutoBean.getSerialversionuid());
    }

}
