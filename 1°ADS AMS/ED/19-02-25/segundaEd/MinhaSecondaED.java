public class MinhaSegundaED {
    private String[] nomes = new String[26];
    public int quantidadeNomes = 0;

    public boolean validarNome(String nome){
        return nome != null && !nome.isBlank();
    }

    public int getIndice(String nome) {
        if(!validarNome(nome)){
            return -1;
        }

        char letraInicial = nome.toLowerCase().toCharArray()[0];

        return switch (letraInicial) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            case 'i' -> 8;
            case 'j' -> 9;
            case 'k' -> 10;
            case 'l' -> 11;
            case 'm' -> 12;
            case 'n' -> 13;
            case 'o' -> 14;
            case 'p' -> 15;
            case 'q' -> 16;
            case 'r' -> 17;
            case 's' -> 18;
            case 't' -> 19;
            case 'u' -> 20;
            case 'v' -> 21;
            case 'w' -> 22;
            case 'x' -> 23;
            case 'y' -> 24;
            case 'z' -> 25;
            default -> -1;
        };
    }

    public void adicionar(String nome) {
        int posicao = getIndice(nome);

        if (posicao == -1) {
            throw new IllegalArgumentException("Nome inválido ou letra inicial não mapeada.");
        }

        if (posicaoOcupada(posicao)) {
            System.out.println("Posição já ocupada por outro nome.");
        } else {
            nomes[posicao] = nome.toLowerCase(); // Deixa o nome em lowerCase para facilitar em possível exclusão futura
            quantidadeNomes++;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return nomes[posicao] != null && !nomes[posicao].isBlank();
    }

    public void remover(String nome) {
        int posicao = getIndice(nome);

        if (posicao == -1 || nomes[posicao] == null || !nome.equals(getNome(posicao))) {
            throw new IllegalArgumentException("Nome não encontrado para remoção ou nome digitado diferente do armazenado.");
        }

        nomes[posicao] = "";
        quantidadeNomes--;
    }


    public boolean contem(String nome) {
        int indice = getIndice(nome);
        try {
            return nomes[indice].equals(nome); //Verifica se o nome digitado está no vetor de nomes
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException("Nome inválido"); //Verifica se o índice é diferente de -1
        }
    }

    public String getNome(int posicao) {
        if (posicao < 0 || posicao >= 26) {
            throw new ArrayIndexOutOfBoundsException("Posição fora do intervalo.");
        }

        return nomes[posicao] != null ? nomes[posicao] : "Posição vazia";
    }

    public int totalNomes() {
        return quantidadeNomes;
    }
}