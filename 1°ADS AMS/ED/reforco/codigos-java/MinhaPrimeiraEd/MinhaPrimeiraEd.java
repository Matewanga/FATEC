/*
 * REGRAS
 * ED Linear - Não permite buracos nulos no meio
 */

public class MinhaPrimeiraEd {
    public Object[] objetos = new Object[5];
    public int totalDeObjetos = 0;

    // Se a posição estiver ocupada, deslocar elementos para direita
    public void adiciona(int posicao, Object objeto) {
        if (posicaoValida(posicao)) {
            if (cheio()) {

                // Dobrar o tamanho do vetor
                Object[] novoVetor = new Object[objetos.length * 2];

                System.out.println("Dobrando tamanho do vetor...");
                for (int i = 0; i < objetos.length; i++) {
                    novoVetor[i] = objetos[i];
                }
                objetos = novoVetor;

            }

            if (posicaoOcupada(posicao)) {
                System.out.println("Deslocando objetos para direita");

                // Precisa começar da direita, por desloca para direita
                for (int i = totalDeObjetos; i > posicao; i--) {
                    objetos[i] = objetos[i - 1];
                }
                objetos[posicao] = objeto;
            } else {
                objetos[posicao] = objeto;
            }

            totalDeObjetos++;
        } else {
            System.out.println("Posição Inválida");
        }
    }

    // Adiciona na ordem do índice, caso não tenha espaço, não adicionar
    public void adiciona(Object objeto) {
        if (cheio()) {
            System.out.println("Vetor sem espaço");
            return;
        }

        objetos[totalDeObjetos] = objeto;
        totalDeObjetos++;
    }

    private boolean posicaoOcupada(int posicao) {
        return objetos[posicao] != null;
    }

    // Posição entre 0 e a última posição OCUPADA do vetor
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeObjetos;
    }

    // Remove o elemento na posição informada, imprime ele e desloca todos os
    // elementos a direita, uma posição a esquerda
    public void remove(int posicao) {
        if (!posicaoOcupada(posicao)) {
            System.out.println("Posição vazia");
            return;
        }

        System.out.println("Removendo objeto: " + objetos[posicao]);
        for (int i = posicao; i <= totalDeObjetos; i++) {
            objetos[i] = objetos[i + 1];
        }
        totalDeObjetos--;
    }

    public boolean contem(Object objeto) {
        for (Object objetoVetor : objetos) {
            if (objetoVetor.equals(objeto)) {
                return true;
            }
        }

        return false;
    }

    public Object getObjeto(int posicao) {
        if (!posicaoValida(posicao)) {
            System.out.println("Posição inválida");
        } else if (posicaoOcupada(posicao)) {
            return objetos[posicao];
        }

        return null;
    }

    public int tamanho() {
        return totalDeObjetos;
    }

    public boolean cheio() {
        return totalDeObjetos == objetos.length;
    }

    public void imprime() {
        System.out.print("[");
        for (Object objeto : objetos) {
            System.out.print(objeto + " ");
        }
        System.out.print("]");

        System.out.println();
    }

    public static void main(String[] args) {
        MinhaPrimeiraEd ed = new MinhaPrimeiraEd();
        System.out.println("==== Adicionando itens a lista ====");
        ed.adiciona("a");
        ed.adiciona("b");
        ed.adiciona("c");
        ed.imprime();

        System.out.println("==== Removendo elemento no indice 0 ====");
        ed.remove(0);
        ed.imprime();

        System.out.println("==== Enchendo a lista ====");
        ed.adiciona("d");
        ed.adiciona("e");
        ed.adiciona("f");
        ed.imprime();

        System.out.println("==== Tentado usar o adicionar(Objeto objeto) ====");
        ed.adiciona("g");
        ed.imprime();

        System.out.println("==== Tentado usar o adicionar(int positcao, Objeto objeto) ====");
        ed.adiciona(1, "g");
        ed.imprime();

        System.out.println("==== Removendo elemento na posicao 3 ====");
        ed.remove(3);
        ed.imprime();
    }
}