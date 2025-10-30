class Deque {
    private Object[] objects = new Object[1];
    private int totalObjetos = 0;

    public void enqueueLeft(Object element) {
        if (vazio()) {
            objects[0] = element;
            totalObjetos++;
            return;
        }

        System.out.println("Aumentando vetor para esquerda");
        Object[] novoVetor = new Object[objects.length + 1];
        novoVetor[0] = element;
        System.out.println("Novo tamanho do vetor: " + novoVetor.length);
        for (int i = 1; i <= objects.length; i++) {
            novoVetor[i] = objects[i - 1];
        }
        objects = novoVetor;
        totalObjetos++;
    }

    public void enqueueRight(Object element) {
        if (vazio()) {
            objects[0] = element;
            totalObjetos++;
            return;
        }

        System.out.println("Aumentado vetor para direita");
        Object[] novoVetor = new Object[objects.length + 1];
        novoVetor[novoVetor.length - 1] = element; //Adiciona o objeto na ultima posição
        System.out.println("Novo tamanho do vetor: " + novoVetor.length);
        for (int i = 0; i < novoVetor.length - 1; i++) {
            novoVetor[i] = objects[i];
        }

        objects = novoVetor;
        totalObjetos++;
    }

    public Object dequeueLeft() throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio");
        }

        System.out.println("Diminuindo o vetor pela esquerda");
        Object valorRemovido = objects[0];
        Object[] novoVetor = new Object[objects.length - 1];
        for (int i = 0; i < novoVetor.length; i++) {
            if (objects[i + 1] != null) {
                novoVetor[i] = objects[i + 1];
            }
        }

        objects = novoVetor;
        totalObjetos--;
        return valorRemovido;
    }

    public Object dequeueRight() throws Exception {
        if (vazio()) {
            throw new Exception("Deque vazio");
        }

        System.out.println("Diminuindo o vetor pela direita");
        Object valorRemovido = objects[objects.length - 1];
        Object[] novoVetor = new Object[objects.length - 1];
        for (int i = 0; i < novoVetor.length; i++) {
            novoVetor[i] = objects[i];
        }

        objects = novoVetor;
        totalObjetos--;
        return valorRemovido;
    }

    public boolean vazio() {
        return totalObjetos == 0;
    }

    public boolean cheio(){
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

        System.out.print("[");
        for (int i = 0; i < objects.length; i++) {
            System.out.print(" " + objects[i]);
        }
        System.out.print("]");
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Deque deque = new Deque();
        // Teste deque está vazio
        System.out.println("Deque está vazio? " + deque.vazio());

        // Teste adicionar esquerda
        System.out.println("Enfileirando à esquerda:");
        deque.enqueueLeft("Gustavo");
        deque.imprime();
        System.out.println();

        deque.enqueueLeft("Nickolas");
        deque.imprime();
        System.out.println();

        // Teste adicionar direita
        System.out.println("Enfileirando à direita:");
        deque.enqueueRight("Pedro");
        deque.imprime();
        System.out.println();

        deque.enqueueRight("Tiago");
        deque.imprime();
        System.out.println();

        // Teste primeiro e último elemento
        System.out.println("Primeiro elemento: " + deque.primeiro());
        System.out.println("Último elemento: " + deque.ultimo());

        // Teste deque cheio
        System.out.println("Deque está cheio? " + deque.cheio());

        // Teste remoção esquerda
        try {
            System.out.println("Removendo da esquerda: " + deque.dequeueLeft());
            deque.imprime();
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Teste remoção direita
        try {
            System.out.println("Removendo da direita: " + deque.dequeueRight());
            deque.imprime();
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Teste deque vazio após remoções
        System.out.println("Deque está vazio? " + deque.vazio());
    }
}

