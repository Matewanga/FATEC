public class Deque {
    private class No {
        Object item;
        No prox;
        No ant;

        No(Object item) {
            this.item = item;
            this.prox = null;
            this.ant = null;
        }
    }

    private No inicio;
    private No fim;

    public Deque() {
        this.inicio = null;
        this.fim = null;
    }

    // Adiciona no final (enqueue right)
    public void enqueueR(Object valor) {
        No novo = new No(valor);
        if (fim == null) { // Se a deque estiver vazia
            inicio = novo;
            fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }
    }

    // Adiciona no início (enqueue left)
    public void enqueueL(Object valor) {
        No novo = new No(valor);
        if (inicio == null) { // Se a deque estiver vazia
            inicio = novo;
            fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
    }

    // Remove do final (dequeue right)
    public Object dequeueR() {
        if (fim == null) {
            throw new RuntimeException("Deque vazio!");
        }
        Object valor = fim.item;
        fim = fim.ant;
        if (fim == null) {
            inicio = null;
        } else {
            fim.prox = null;
        }
        return valor;
    }

    // Remove do início (dequeue left)
    public Object dequeueL() {
        if (inicio == null) {
            throw new RuntimeException("Deque vazio!");
        }
        Object valor = inicio.item;
        inicio = inicio.prox;
        if (inicio == null) {
            fim = null;
        } else {
            inicio.ant = null;
        }
        return valor;
    }

    // Exibe os elementos do deque
    public void printDeque() {
        No atual = inicio;
        System.out.print("Deque: ");
        while (atual != null) {
            System.out.print(atual.item + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}
