/*
 * REGRAS:
 * FIFO - First in First Out
 * Só insere no final
 * Só remove do início
 * 
 * O dequeue não efetivamente remove, só motivmenta a variável de início, fazendo com que, ao imprimir o resultado, a fila dê a impressão de "andar"
 */

public class Fila {
    private Object[] objetos = new Object[10];
    private int totalDeObjetos = 0;
    private int inicio, fim = 0;

    public void enqueue(Object object) throws Exception {
        if ((fim) > objetos.length) {
            throw new Exception("Lista cheia");
        }

        if (vazio()) {
            objetos[0] = object;
        }

        totalDeObjetos++;
        objetos[fim] = object;
        this.fim++;
    }

    public Object dequeue() throws Exception {
        if (vazio()) {
            throw new Exception("Impossível remover itens, lista vazia.");
        }

        Object valor = objetos[inicio];
        inicio++;
        return valor;
    }

    public int tamanho() {
        return totalDeObjetos;
    }

    public boolean vazio() {
        return totalDeObjetos == 0;
    }

    public void imprime() {
        System.out.println("STATUS");
        System.out.println("Total obj: " + totalDeObjetos);
        System.out.println("Posição Inicio " + inicio);
        System.out.println("Posição fim " + fim);
        System.out.println();

        System.out.print("[");

        for (int i = inicio; i != fim; i++) {
            System.out.print(objetos[i] + " | ");
        }

        System.out.print("]");
        System.out.println();

        System.out.println("==//==");
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        try {
            System.out.println("-- Adicionando elementos --");
            fila.enqueue("a");
            fila.imprime();

            System.out.println("-- Adicionando mais elementos --");
            fila.enqueue("b");
            fila.enqueue("c");
            fila.enqueue("d");
            fila.imprime();

            System.out.println("-- Removendo elementos --");
            System.out.println("Removendo elemento: " + fila.dequeue());
            fila.imprime();

            System.out.println("-- Removendo elementos --");
            System.out.println("Removendo elemento: " + fila.dequeue());
            fila.imprime();

            System.out.println("-- Adicionando mais elementos --");
            fila.enqueue("e");
            fila.imprime();

            System.out.println("-- Removendo todos os elementos --");
            System.out.println("Removendo elemento: " + fila.dequeue());
            System.out.println("Removendo elemento: " + fila.dequeue());
            System.out.println("Removendo elemento: " + fila.dequeue());
            fila.imprime();
        } catch (Exception e) {

        }

    }
}
