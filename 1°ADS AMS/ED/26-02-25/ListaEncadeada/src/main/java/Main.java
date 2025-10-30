class ListaEncadeada {
    private Celula primeiro;
    private Celula ultimo;
    private Celula posicaoAtual;

    public void adicionar(Pessoa valor) {
        Celula celula = new Celula(); // Cria uma nova célula (nó) para armazenar o valor.
        celula.setValor(valor);

        // Verifica se a lista está vazia (primeiro e último são null).
        if (primeiro == null && ultimo == null) {
            primeiro = celula; // Se a lista estiver vazia, o novo nó será tanto o primeiro quanto o último.
            ultimo = celula;
        } else {
            // Caso contrário, adiciona a célula no final da lista.
            ultimo.setProximo(celula); // Faz o último nó apontar para o novo nó.
            ultimo = celula; // O novo nó agora se torna o último da lista.
        }
    }

    public void remover() {
        if (primeiro.getProximo() != null) {
            // Se a lista não tiver apenas um elemento, encontra o penúltimo nó.
            Celula celula = this.recuperarPenultimo(this.primeiro);
            ultimo = celula; // O penúltimo nó agora se torna o último.
            celula.setProximo(null); // O último nó anterior agora aponta para null.
        } else {
            // Se a lista tiver apenas um elemento, ela se torna vazia após a remoção.
            primeiro = ultimo = null;
        }
    }

    private Celula recuperarPenultimo(Celula celula) {
        // Se o próximo nó for o último, retorna o nó atual como penúltimo.
        if (celula.getProximo().equals(ultimo)) {
            return celula;
        }
        // Se não for o penúltimo, recursivamente chama o método para o próximo nó.
        return recuperarPenultimo(celula.getProximo());
    }

    public boolean temProximo() {
        if (primeiro == null) {
            // Se a lista estiver vazia, não há próximo.
            return false;
        } else if (posicaoAtual == null) {
            // Se a posição atual for null (não iniciado), começa no primeiro nó.
            posicaoAtual = primeiro;
            return true;
        } else {
            // Verifica se o próximo nó existe. Se sim, avança para ele e retorna true.
            boolean temProximo = posicaoAtual.getProximo() != null ? true : false;
            posicaoAtual = posicaoAtual.getProximo(); // Atualiza a posição atual para o próximo nó.
            return temProximo;
        }
    }

    public Celula getPosicaoAtual() {
        return this.posicaoAtual;
    }
}

// Outro POJO, mas de célula
class Celula {
    private Celula proximo;
    private Pessoa valor;

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Pessoa getValor() {
        return valor;
    }

    public void setValor(Pessoa valor) {
        this.valor = valor;
    }
}


// Um simples POJO de pessoa
class Pessoa {
    private Integer id;
    private String nome;
    private String email;

    // Construtor padrão (sem parâmetros).
    public Pessoa() {
    }

    // Construtor parametrizado para inicializar os atributos com valores específicos.
    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
    }
}


public class Main {

    // Método principal (main) que inicia o programa
    public static void main(String[] args) {
        ListaEncadeada listaEncadeada = new ListaEncadeada();
        Main main = new Main();

        main.adicionarPessoa(listaEncadeada);
        main.remover(listaEncadeada);

        while (listaEncadeada.temProximo()) {
            System.out.println(listaEncadeada.getPosicaoAtual().getValor());
        }
    }

    // Método para adicionar várias pessoas à lista encadeada
    private void adicionarPessoa(ListaEncadeada listaEncadeada) {
        Pessoa p1 = new Pessoa(1, "João Silva", "joao@email.com");
        Pessoa p2 = new Pessoa(2, "Maria Souza", "maria@email.com");
        Pessoa p3 = new Pessoa(3, "Rogerio", "rogerio@email.com");
        Pessoa p4 = new Pessoa(4, "Giovanna", "giovanna@email.com");
        Pessoa p5 = new Pessoa(5, "Rebeca", "rebeca@email.com");

        listaEncadeada.adicionar(p1);
        listaEncadeada.adicionar(p2);
        listaEncadeada.adicionar(p3);
        listaEncadeada.adicionar(p4);
        listaEncadeada.adicionar(p5);
    }

    private void remover(ListaEncadeada listaEncadeada) {
        listaEncadeada.remover();
        listaEncadeada.remover();
        listaEncadeada.remover();
    }
}
