/**
 * Classe Main - executa o roteiro da atividade:
 * 1) Preparação: obtém a instância única da FilaDeImpressao (Singleton).
 * 2) O Molde: cria o Certificado original (Prototype), com nome de curso
 *    e nome do aluno em branco.
 * 3) A Clonagem: usa clonar() para gerar dois clones do certificado original.
 * 4) Personalização: usa setNomeAluno() para nomear cada clone.
 * 5) Impressão: envia getDados() de cada clone para imprimir() da fila.
 * 6) Validação: imprime o teste de memória (clone1 == clone2), que deve
 *    resultar em false, provando que são objetos independentes.
 */
public class Main {

    public static void main(String[] args) {

        // 1) PREPARAÇÃO ---------------------------------------------------
        System.out.println("### 1) Preparação: obtendo a fila de impressão (Singleton) ###");
        FilaDeImpressao fila = FilaDeImpressao.getInstancia();

        // Prova de que é sempre a mesma instância, mesmo chamando de novo.
        FilaDeImpressao filaDeNovo = FilaDeImpressao.getInstancia();
        System.out.println("A fila é sempre a mesma instância? " + (fila == filaDeNovo));
        System.out.println();

        // 2) O MOLDE -------------------------------------------------------
        System.out.println("### 2) O Molde: criando o certificado original (Prototype) ###");
        Certificado certificadoOriginal = new Certificado("Engenharia de Software");
        System.out.println();

        // 3) A CLONAGEM ------------------------------------------------------
        System.out.println("### 3) A Clonagem: gerando dois clones a partir do original ###");
        Certificado clone1 = certificadoOriginal.clonar();
        Certificado clone2 = certificadoOriginal.clonar();
        System.out.println();

        // 4) PERSONALIZAÇÃO --------------------------------------------------
        System.out.println("### 4) Personalização: definindo o nome de cada aluno ###");
        clone1.setNomeAluno("Maria Silva");
        clone2.setNomeAluno("João Souza");
        System.out.println();

        // 5) IMPRESSÃO ---------------------------------------------------------
        System.out.println("### 5) Impressão: enviando os certificados para a fila única ###");
        fila.imprimir(clone1.getDados());
        fila.imprimir(clone2.getDados());
        System.out.println();

        // 6) VALIDAÇÃO OBRIGATÓRIA ------------------------------------------------
        System.out.println("### 6) Validação do Prototype: clone1 == clone2 ###");
        System.out.println("clone1 == clone2 -> " + (clone1 == clone2));
        System.out.println("(Deve ser 'false': são objetos diferentes na memória, "
                + "apenas com dados clonados do mesmo molde.)");
    }
}
