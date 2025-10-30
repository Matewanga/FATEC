/*
Stack adota a política LIFO
Só pode adicionar ou remover o topo
 */
public class Stack {
    private Object[] objects = new Object[5];
    private int top, totalObjects;

    public Stack(){
        this.top = -1;
    }

    // Empilhar
    public void push(Object element) throws Exception{
        if(isFull()) {
            throw new Exception("Stack is full");
        }

        top++;
        totalObjects++;
        objects[top] = element;
    }

    public Object pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }

        Object removedValue = objects[top];
        objects[top] = null;
        top--;
        totalObjects--;
        return removedValue;
    }

    public Object top(){
        return objects[top];
    }

    public boolean isEmpty(){
        return totalObjects == 0;
    }

    public boolean isFull(){
        return totalObjects == objects.length;
    }

    public int size(){
        return totalObjects;
    }

    public void print(){
        System.out.println("[");
        for(int i = top; i >= 0; i--){
            System.out.println(" " + objects[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        try {
            Stack stack = new Stack();
            System.out.println("--- Adicionando elementos ---");
            stack.push("a");
            stack.push("b");
            stack.print();

            System.out.println("--- Exibindo topo ---");
            System.out.println("O topo é " + stack.top());
            stack.print();

            System.out.println("--- Removendo elemento ---");
            System.out.println("Elemento removido " + stack.pop());
            System.out.println("Elemento removido " + stack.pop());

            System.out.println("--- Tentando remover elementos com pilha vazia ---");
            stack.print();
            stack.pop();
            stack.print();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
