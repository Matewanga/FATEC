public class Stack {
    public char[] texto;
    private int top, totalObjects;

    public Stack(int tamanhoPalavra) {
        this.texto = new char[tamanhoPalavra];
        this.top = -1;
        this.totalObjects = 0;
    }

    // Empilhar
    public void push(char letra) {
        top++;
        texto[top] = letra;
        totalObjects++;

    }

    public char pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }

        char letra = texto[top];
        texto[top] = Character.MIN_VALUE;
        top--;
        totalObjects--;
        return letra;
    }

    public char top() {
        return texto[top];
    }

    public boolean isEmpty() {
        return totalObjects == 0;
    }

    public int size() {
        return totalObjects;
    }

    public void print() {
        System.out.print("[");
        for (int i = top; i >= 0; i--) {
            System.out.print(" " + texto[i]);
        }
        System.out.print("]");
    }
}