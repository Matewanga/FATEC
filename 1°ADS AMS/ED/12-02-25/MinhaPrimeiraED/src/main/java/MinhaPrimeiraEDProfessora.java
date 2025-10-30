public class MinhaPrimeiraED {
    private Object[] objetos = new Object[10];
    private int totalDeObjetos = 0;

    public void garantaEspaco() {
        // se o total de objetos for igual ao tamanho do vetor objetos
        // então declarar um novo vetor com o dobro de tamanho
        // transferir os dados do vetor objetos para o novo vetor
        if (totalDeObjetos == objetos.length) {
            Object[] novo_vetor = new Object[totalDeObjetos * 2];
            //Object[] novo_vetor = new Object[objetos.length * 2];
            for (int i = 0; i < objetos.length; i++) {
                novo_vetor[i] = objetos[i];
            }
            objetos = novo_vetor;
        }
    }

    public void adiciona(Object obj) {
        garantaEspaco();
        objetos[totalDeObjetos] = obj;
        totalDeObjetos++;
    }

    //sobrecarga
    public void adiciona(Object obj, int posicao) {
        garantaEspaco();
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao Invalida!!!");
        }

        //deslocar os elementos uma posicao a frente
        for (int i = totalDeObjetos - 1; i >= posicao; i--) {
            objetos[i + 1] = objetos[i];
        }

        objetos[posicao] = obj;
        totalDeObjetos++;
    }

    public boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < totalDeObjetos;
    }

    public boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeObjetos;
    }

    public boolean vetorEstaVazio() {
        return totalDeObjetos == 0;
    }

    public boolean vetorEstaCheio() {
        return (totalDeObjetos == objetos.length);
    }

    public void remove(int posicao) {
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao Invalida!!!");
        }
        for (int i = posicao; i < totalDeObjetos - 1; i++) {
            objetos[i] = objetos[i + 1];
        }
        totalDeObjetos--;
    }

    public boolean contem(Object obj) {
        for (int i = 0; i < totalDeObjetos; i++)
            if (obj.equals(objetos[i])) return true;
        return false;
    }

    public int getPosicaoObjeto(Object obj) {
        for (int i = 0; i < totalDeObjetos; i++)
            if (obj.equals(objetos[i])) return i;
        return -1;
    }

    public int tamanho() {
        return totalDeObjetos;
    }

    public Object getObjeto(int posicao) {
        if (posicaoOcupada(posicao)) return objetos[posicao];
        throw new IllegalArgumentException("Posicao não está ocupada");
    }
}