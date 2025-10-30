public class DequeEncadeado {
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

    public DequeEncadeado() {
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

class main{
    public static void main(String[] args) {
        DequeEncadeado deque = new DequeEncadeado();

        //Adicionar elementos final
        System.out.println("Adicionando à direita:");
        deque.enqueueR("Gustavo");
        deque.enqueueR("Nickolas");
        deque.enqueueR("Pedro");
        deque.enqueueR("Tiago");
        deque.printDeque();

        //Remover elementos final
        System.out.println("Removendo da direita:");
        System.out.println("Removido: " + deque.dequeueR()); // Tiago
        deque.printDeque();

        //Adicionar elementos início
        System.out.println("Adicionando à esquerda:");
        deque.enqueueL("Tiago");
        deque.printDeque();

        //Remover elementos início
        System.out.println("Removendo da esquerda:");
        System.out.println("Removido: " + deque.dequeueL()); // Tiago
        deque.printDeque();

        //Remover todos elementos
        System.out.println("Removendo todos os elementos:");
        System.out.println("Removido: " + deque.dequeueL()); // Gustavo
        System.out.println("Removido: " + deque.dequeueL()); // Nickolas
        System.out.println("Removido: " + deque.dequeueL()); // Pedro
        deque.printDeque();

        //remover de um deque vazio
        try {
            deque.dequeueL();
        } catch (RuntimeException e) {
            System.out.println("Erro - Tentando remover de um deque vazio: " + e.getMessage());
        }
    }
}
