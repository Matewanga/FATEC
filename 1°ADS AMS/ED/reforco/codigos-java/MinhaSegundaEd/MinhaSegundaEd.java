public class MinhaSegundaEd {
    public String[] nomes = new String[26];
    public int totalNomes = 0;

    // Retorna a posição que o nome deve estar no vetor. Por exemplo, nomes que
    // começam com A ficam na posição 0
    public int getIndice(String nome) {
        char primeiraLetra = nome.toLowerCase().charAt(0);
        switch (primeiraLetra) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'q':
                return 16;
            case 'r':
                return 17;
            case 's':
                return 18;
            case 't':
                return 19;
            case 'u':
                return 20;
            case 'v':
                return 21;
            case 'w':
                return 22;
            case 'x':
                return 23;
            case 'y':
                return 24;
            case 'z':
                return 25;
            default:
                System.out.println("Letra não reconhecida no alfabeto latino ou nome inválido");
                return -1;
        }
    }

    // Caso a posição esteja ocupada, não adiciona
    public void adiciona(String nome) {
        if (!validaNome(nome)) {
            System.out.println("Nome inválido");
            return;
        } else if (posicaoOcupada(getIndice(nome))) {
            System.out.println("Posição ocupada");
            return;
        }

        nomes[getIndice(nome)] = nome.toLowerCase();
        totalNomes++;
    }

    private boolean posicaoOcupada(int posicao) {
        return nomes[posicao] != null;
    }

    public void remove(String nome) {
        if (!validaNome(nome)) {
            System.out.println("Nome inválido");
            return;
        } else if (!posicaoOcupada(getIndice(nome))) {
            System.out.println("Posição vazia");
            return;
        }

        nomes[getIndice(nome)] = null;

        totalNomes--;
    }

    public boolean contem(String nome) {
        if (!validaNome(nome)) {
            System.out.println("Nome inválido");
            return false;
        } else if (!posicaoOcupada(getIndice(nome))) {
            System.out.println("Posição vazia");
            return false;
        }
        String nomeArmazenado = nomes[getIndice(nome)];

        return nomeArmazenado.equals(nome.toLowerCase());
    }

    public boolean validaNome(String nome) {
        return !nome.isBlank() && getIndice(nome) != -1;
    }

    public int totalNomes() {
        return totalNomes;
    }

    public void imprime() {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }

    public static void main(String[] args) {
        MinhaSegundaEd ed = new MinhaSegundaEd();

        System.out.println("==== Adicionando Ana a lista ====");
        ed.adiciona("Ana");
        ed.imprime();

        System.out.println("==== Adicionando Bianca a lista ====");
        ed.adiciona("Bianca");
        ed.imprime();

        System.out.println("==== Tentando adicionar Bruno a lista ====");
        ed.adiciona("Bruno");
        ed.imprime();

        System.out.println("==== Removendo Ana da lista ====");
        ed.remove("Ana");
        ed.imprime();

        System.out.println("==== Verificando se Bianca está na lista ====");
        System.out.println("Bianca está na lista: " + ed.contem("Bianca"));

        System.out.println("==== Verificando se Nickolas está na lista ====");
        System.out.println("Nickolas está na lista: " + ed.contem("Nickolas"));

        System.out.println("==== Tentando adicionar nome inválido ====");
        ed.adiciona("123Nome");
        ed.imprime();

        System.out.println("==== Tentando remover nome inexistente ====");
        ed.remove("Jorge");
    }
}
