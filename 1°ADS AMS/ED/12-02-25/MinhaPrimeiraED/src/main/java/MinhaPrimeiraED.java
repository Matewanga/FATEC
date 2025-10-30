public class MinhaPrimeiraED {
    private Object[] objetos = new Object[10];
    public int totalDeObjetos = 0;

    /*
    A operação public void adiciona(Object objeto){..}
    deve adicionar elementos no vetor respeitando a ordem do índice.
    Caso não haja mais posições válidas, não adicionar.
    */
    public void adiciona(Object objeto) {
        if (totalDeObjetos < objetos.length) {
            for(int i = 0; i < objetos.length; i++){
                if(!posicaoOcupada(i)){
                    objetos[i] = objeto;
                    break;
                }
            }

            totalDeObjetos++;
        }else{
            System.out.println("Vetor cheio, impossível de adicionar novo objeto.");
        }
    }

    /*
    A operação public void adiciona(int posicao, Object objeto){..}
    deve adicionar um objeto numa determinada posição do vetor.
    Caso a posição esteja ocupada, deslocar os elementos uma posição à direita para
    não sobrepor o novo objeto.
    */

    public void adiciona(int posicao, Object objeto) {
        if (posicaoValida(posicao)) {

            if (posicaoOcupada(posicao)) {

                if (cheio()) {
                    for (int i = totalDeObjetos; i > posicao; i--) {
                        objetos[i] = objetos[i - 1];
                    }
                    objetos[posicao] = objeto;
                    totalDeObjetos++;
                } else {
                    for (int i = totalDeObjetos; i > posicao; i--) {
                        objetos[i] = objetos[i - 1];
                    }
                    objetos[posicao] = objeto;
                    totalDeObjetos++;
                }

            } else if (!cheio()) {
                for (int i = totalDeObjetos; i > posicao; i--) {
                    objetos[i] = objetos[i - 1];
                }
                objetos[posicao] = objeto;
                totalDeObjetos++;
            }

        } else {
            System.out.println("Posição Inválida");
        }
    }

    /*
    A operação private boolean posicaoOcupada(int posicao){..}
    deve verificar se a posição está ou não ocupada.
    Retornar True para ocupada e False para livre.
    */
    public boolean posicaoOcupada(int posicao) {
        return objetos[posicao] != null;
    }

    /*
    A operação private boolean posicaoValida(int posicao){..},
    deve retornar True se a posição for válida.
    Uma posição é válida se estiver entre os índices 0 e a última posição ocupada do vetor.
    */
    public boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < objetos.length;
    }

    /*
    A operação public void remove(int posicao){..}
    deve remover o elemento de uma determinada posição do vetor.
    No entanto, como a sequência dos índices não poderá ser pulada,
    se houver elementos nas posições à direita do vetor, você deverá
    deslocar todos os elementos para uma posição anterior.
    */
    public void remove(int posicao) {
        if (posicaoValida(posicao) && posicaoOcupada(posicao)) {
            for (int i = posicao; i < objetos.length - 1; i++) {
                objetos[i] = objetos[i + 1];
            }

            objetos[objetos.length - 1] = null;
            totalDeObjetos--;
        }
    }

    /*
    A operação public boolean contem(Object objeto){..}
    deve retornar True se o objeto pesquisado for encontrado no vetor.
    Implemente uma pesquisa linear conforme vimos em classe.
     */
    public boolean contem(Object objeto) {
        for (Object objetoNoVetor : objetos) {
            if (objeto.equals(objetoNoVetor)) {
                return true;
            }
        }
        return false;
    }

    /*
    A operação public Object getObjeto(int posicao){...}
    deve retornar o objeto de uma determinada posição.
     */
    public Object getObjeto(int posicao) {
        if (posicaoValida(posicao) && posicaoOcupada(posicao)) {
            return objetos[posicao];
        }

        return null;
    }

    /*
    A operação public int tamanho(){..}
    deve retornar quantos elementos existem no vetor.
     */
    public int tamanho() {
        return totalDeObjetos;
    }

    public boolean vazio() {
        return totalDeObjetos == 0;
    }

    /*
    Implemente uma operação que verifique se o vetor está cheio.
    O vetor estará cheio quando o total de objetos é igual ao tamanho do vetor.
    Sempre que o vetor estiver cheio, criar um novo vetor cujo tamanho deve
    ser o dobro do anterior, copiar os elementos para o novo vetor.
    Com esta operação, as operações adiciona sempre vão funcionar.
     */
    public boolean cheio() {
        if (objetos.length == totalDeObjetos) {
            Object[] novoVetor = new Object[objetos.length * 2];

            for (int i = 0; i < objetos.length; i++) {
                novoVetor[i] = objetos[i];
            }

            objetos = novoVetor;
            return true;
        }
        return false;
    }
}