public class Main {
    public static void main(String[] args) {
        MinhaPrimeiraED lista = new MinhaPrimeiraED();

        // Teste 1: Adicionar elementos sequencialmente
        System.out.println("Teste 1: Adicionar elementos sequencialmente");
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");
        lista.adiciona("D");
        exibirLista(lista);

        // Teste 2: Adicionar em uma posição específica
        System.out.println("Teste 2: Adicionar em uma posição específica");
        lista.adiciona(1, "X");
        exibirLista(lista);

        // Teste 3: Remover um elemento de uma posição específica
        System.out.println("Teste 3: Remover um elemento de uma posição específica");
        lista.remove(2);
        exibirLista(lista);

        // Teste 4: Verificar se um objeto está na lista
        System.out.println("Teste 4: Verificar se um objeto está na lista");
        System.out.println("Contém 'A'? " + lista.contem("A"));
        System.out.println("Contém 'Z'? " + lista.contem("Z"));

        // Teste 5: Verificar tamanho da lista
        System.out.println("Teste 5: Verificar tamanho da lista");
        System.out.println("Tamanho da lista: " + lista.tamanho());

        // Teste 6: Teste de capacidade dinâmica
        System.out.println("Teste 6: Teste de capacidade dinâmica");
        for (int i = 0; i < 15; i++) {
            lista.adiciona(i, "Elemento-" + i);
        }
        exibirLista(lista);

        // Teste 7: Verificar se a lista está vazia
        System.out.println("Teste 7: Verificar se a lista está vazia");
        System.out.println("Está vazia? " + lista.vazio());

        // Teste 8: Obter um objeto de uma posição específica
        System.out.println("Teste 8: Obter um objeto de uma posição específica");
        System.out.println("Objeto na posição 0: " + lista.getObjeto(0));
        System.out.println("Objeto na posição 4: " + lista.getObjeto(4));
    }

    public static void exibirLista(MinhaPrimeiraED lista) {
        System.out.print("Lista: [ ");
        for (int i = 0; i < lista.tamanho(); i++) {
            System.out.print(lista.getObjeto(i) + " ");
        }
        System.out.println("]");
    }
}
