/**
 * Padrão de projeto: PROTOTYPE
 *
 * A arte e os dados do curso são "pesados" para carregar (aqui simulamos
 * isso com o atributo dadosDaArte, que representaria uma imagem/layout
 * vindo do banco de dados). Em vez de recarregar tudo isso do zero para
 * cada aluno, carregamos UMA VEZ (o certificado "molde"/original) e depois
 * usamos clonar() para gerar cópias independentes, alterando apenas o
 * nome do aluno em cada cópia.
 */
public class Certificado implements Cloneable {

    private String nomeCurso;
    private String nomeAluno;

    // Simula o conteúdo pesado (arte/layout) carregado do banco de dados
    // uma única vez, quando o certificado original é criado.
    private String dadosDaArte;

    public Certificado(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.nomeAluno = ""; // nome do aluno começa em branco no molde
        this.dadosDaArte = carregarArtePesadaDoBanco(nomeCurso);
    }

    // Método privado só para simular o "custo alto" de carregar a arte.
    private String carregarArtePesadaDoBanco(String curso) {
        System.out.println(">> [Prototype] Carregando arte e dados do curso \""
                + curso + "\" do banco de dados (operação pesada, feita só uma vez)...");
        return "Layout-Oficial-" + curso.replace(" ", "-");
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getDados() {
        return "Certificado de Conclusão\n"
                + "Curso: " + nomeCurso + "\n"
                + "Aluno: " + nomeAluno + "\n"
                + "Arte: " + dadosDaArte;
    }

    /**
     * Método clonar(): implementa o Prototype.
     * Cria uma cópia independente do objeto atual (mesmo curso e mesma
     * arte já carregada), sem precisar acessar o banco de dados de novo.
     */
    public Certificado clonar() {
        try {
            return (Certificado) super.clone();
        } catch (CloneNotSupportedException e) {
            // Não deve acontecer, pois a classe implementa Cloneable.
            throw new RuntimeException("Erro ao clonar o certificado.", e);
        }
    }
}
