public class Main {
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.enqueueR(10);
        deque.enqueueR(20);
        deque.enqueueL(5);
        deque.enqueueL(1);
        deque.enqueueL(5);

        deque.printDeque(); // Deve mostrar: 1 5 10 20

        System.out.println("Removido do início: " + deque.dequeueL()); // 1
        System.out.println("Removido do fim: " + deque.dequeueR()); // 20

        deque.printDeque(); // Deve mostrar: 5 10
    }
}