class DequeSimplesEstatico {
    private Object[] objects = new Object[10];
    private int totalObjetos = 0;

    public void enqueueLeft(Object element) throws Exception {
        if (cheio()) {
            throw new Exception("Deque cheio");
        }

        if (objects[0] == null) {
            objects[0] = element;
            totalObjetos++;
            return;
        }

        for (int i = totalObjetos; i > 0; i--) {
            objects[i] = objects[i - 1];
        }

        objects[0] = element;

        totalObjetos++;
    }

    public void enqueueRight(Object element) throws Exception {
        if (cheio()) {
            throw new Exception("Deque cheio");
        }

        objects[totalObjetos] = element;
        totalObjetos++;
    }

    public Object dequeueLeft() throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio, impossível remover");
        }

        Object objetoRemovido = objects[0];
        for(int i = 0; i < totalObjetos; i++){
            objects[i] = objects[i + 1];
        }

        totalObjetos--;
        return objetoRemovido;
    }

    public Object dequeueRight() throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio, impossível remover");
        }

        Object objetoRemovido = objects[totalObjetos - 1];
        objects[totalObjetos - 1] = null;
        totalObjetos--;
        return objetoRemovido;
    }

    public boolean vazio() {
        return totalObjetos == 0;
    }

    public boolean cheio() {
        return totalObjetos == objects.length;
    }

    public Object primeiro()throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio");
        }
        return objects[0];
    }

    public Object ultimo()throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio");
        }
        return objects[totalObjetos-1];
    }

    public void imprime() {
        System.out.println("Total obj: " + totalObjetos);

        System.out.println();

        System.out.print("[");

        for (int i = 0; i < totalObjetos; i++) {
            System.out.print(" " + objects[i]);
        }

        System.out.print("]");
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        try {
            DequeSimplesEstatico deque = new DequeSimplesEstatico();

            // Teste inserção esquerda
            deque.enqueueLeft("Gustavo");
            deque.enqueueLeft("Nickolas");
            deque.enqueueLeft("Pedro");
            deque.enqueueLeft("Tiago");

            System.out.println("Após inserções pela esquerda:");
            deque.imprime();

            // Teste cheio e vazio
            System.out.println("\nDeque está cheio? " + deque.cheio());
            System.out.println("Deque está vazio? " + deque.vazio());

            // Teste primeiro e último
            System.out.println("\nPrimeiro elemento: " + deque.primeiro());
            System.out.println("Último elemento: " + deque.ultimo());

            // Teste remoção esquerda
            System.out.println("\nRemovido da esquerda: " + deque.dequeueLeft());
            System.out.println("Após remoção pela esquerda:");
            deque.imprime();

            // Teste remoção direita
            System.out.println("\nRemovido da direita: " + deque.dequeueRight());
            System.out.println("Após remoção pela direita:");
            deque.imprime();

            // Teste cheio e vazio após remoções
            System.out.println("\nDeque está cheio? " + deque.cheio());
            System.out.println("Deque está vazio? " + deque.vazio());

            // Teste primeiro e último após remoções
            System.out.println("\nPrimeiro elemento: " + deque.primeiro());
            System.out.println("Último elemento: " + deque.ultimo());

            // Teste esvaziamento deque
            while (!deque.vazio()) {
                System.out.println("Removendo: " + deque.dequeueLeft());
            }
            System.out.println("Deque vazio: " + deque.vazio());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}