public class FilaCircular {
    private int totalObjetos = 0;

    private class No {
        private Object item;
        private No prox;
    }

    private No inicio, fim;

    public FilaCircular() {
        this.inicio = new No();
        this.fim = inicio;
    }

    public void enqueue(Object element) {
        if (vazia()) {
            inicio.item = element;
        }

        No novoNo = new No();
        novoNo.item = element;
        fim.prox = novoNo;
        fim = novoNo;
        fim.prox = inicio;
        totalObjetos++;
    }

    public Object dequeue() throws Exception {
        if (vazia()) {
            throw new Exception("Fila vazia!");
        }
        inicio = inicio.prox;
        Object valorRemovido = inicio.item;
        totalObjetos--;
        return valorRemovido;
    }

    public boolean vazia() {
        return inicio == fim;
    }

    public void imprime() throws Exception {
        if (vazia()) {
            throw new Exception("Fila vazia!");
        }

        No auxiliar;
        auxiliar = inicio.prox;

        System.out.print("[");

        //Se o for não tiver o número de objetos, ele vai ficar imprimindo infinitamente, pois é uma fila circular
        for (int i = 0; i < totalObjetos; i++) {

            System.out.print(auxiliar.item + "-> proximo: ");
            auxiliar = auxiliar.prox;
        }

        System.out.print("]");
        System.out.println();
    }
}

class Main{
    public static void main(String[] args) {
        try {
            FilaCircular fila = new FilaCircular();

            // Teste inserção fila
            fila.enqueue("Gustavo");
            fila.enqueue("Nickolas");
            fila.enqueue("Pedro");
            fila.enqueue("Tiago");

            fila.imprime();

            // Removendo e imprimindo após cada remoção
            System.out.println("Removido: " + fila.dequeue());
            fila.imprime();

            System.out.println("Removido: " + fila.dequeue());
            fila.imprime();

            System.out.println("Removido: " + fila.dequeue());
            fila.imprime();

            System.out.println("Removido: " + fila.dequeue());
            fila.imprime();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}