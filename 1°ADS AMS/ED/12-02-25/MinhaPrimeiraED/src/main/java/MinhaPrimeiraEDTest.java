import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinhaPrimeiraEDTest {
    private MinhaPrimeiraED lista;

    @BeforeEach
    void setUp(){
        lista = new MinhaPrimeiraED();
    }

    @Test
    void testAdicionaObjetos() {
        lista.adiciona("Primeiro");
        lista.adiciona("Segundo");

        // Verificando se os elementos foram adicionados corretamente
        assertEquals(2, lista.tamanho());
        assertTrue(lista.contem("Primeiro"));
        assertTrue(lista.contem("Segundo"));
    }

    @Test
    void testAdicionaNaPosicao() {
        lista.adiciona("Primeiro");
        lista.adiciona("Segundo");
        lista.adiciona(1, "NovoSegundo");

        // Verifica se o objeto foi adicionado na posição correta
        assertEquals(3, lista.tamanho());
        assertEquals("NovoSegundo", lista.getObjeto(1));
    }

    @Test
    void testRemoveElemento() {
        lista.adiciona("Primeiro");
        lista.adiciona("Segundo");
        lista.remove(0);

        // Verifica se o elemento foi removido corretamente
        assertEquals(1, lista.tamanho());
        assertFalse(lista.contem("Primeiro"));
        assertTrue(lista.contem("Segundo"));
    }

    @Test
    void testPosicaoOcupada() {
        lista.adiciona("Primeiro");

        // Verifica se a posição está ocupada
        assertTrue(lista.posicaoOcupada(0));
        assertFalse(lista.posicaoOcupada(1));  // A posição 1 ainda está livre
    }

    @Test
    void testPosicaoValida() {
        lista.adiciona("Primeiro");

        // Verifica se a posição é válida
        assertTrue(lista.posicaoValida(0));  // A posição 0 é válida
        assertFalse(lista.posicaoValida(11)); // A posição 11 não é válida, pois o vetor começa com 10 posições
    }

    @Test
    void testCheio() {
        // Adiciona 10 elementos para preencher o vetor
        for (int i = 0; i < 10; i++) {
            lista.adiciona("Elemento " + i);
        }

        // Verifica se o vetor está cheio
        assertTrue(lista.cheio());
    }

    @Test
    void testCrescimentoVetor() {
        // Adiciona mais de 10 elementos, forçando o crescimento do vetor
        for (int i = 0; i < 20; i++) {
            lista.adiciona("Elemento " + i);
        }

        // Verifica se o vetor cresceu adequadamente
        assertEquals(20, lista.tamanho());
    }

    @Test
    void testVazio() {
        // Verifica se a lista está vazia no início
        assertTrue(lista.vazio());

        // Após adicionar um elemento, deve-se verificar se a lista não está mais vazia
        lista.adiciona("Elemento");
        assertFalse(lista.vazio());
    }

    @Test
    void testGetObjeto() {
        lista.adiciona("Elemento");

        // Verifica se o objeto retornado pela posição está correto
        assertEquals("Elemento", lista.getObjeto(0));
        assertNull(lista.getObjeto(1));  // Não existe elemento na posição 1
    }

    @Test
    void testConterElemento() {
        lista.adiciona("Elemento");

        // Verifica se a lista contém o elemento
        assertTrue(lista.contem("Elemento"));
        assertFalse(lista.contem("OutroElemento"));
    }

    @Test
    void testTamanho() {
        // Verifica o tamanho da lista após adições e remoções
        assertEquals(0, lista.tamanho());
        lista.adiciona("Primeiro");
        lista.adiciona("Segundo");
        assertEquals(2, lista.tamanho());
        lista.remove(0);
        assertEquals(1, lista.tamanho());
    }
}
