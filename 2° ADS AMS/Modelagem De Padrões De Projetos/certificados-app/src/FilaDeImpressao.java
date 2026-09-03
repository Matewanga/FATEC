/**
 * Padrão de projeto: SINGLETON
 *
 * Garante que exista uma única instância da fila de impressão em toda a
 * aplicação. Isso evita que duas conexões diferentes tentem falar com a
 * impressora central ao mesmo tempo, o que misturaria os documentos ou
 * travaria o equipamento.
 */
public class FilaDeImpressao {

    // A própria classe guarda a sua única instância.
    // "static" -> pertence à classe, não a um objeto específico.
    private static FilaDeImpressao instancia;

    // Construtor PRIVADO: ninguém de fora consegue usar "new FilaDeImpressao()".
    // A única forma de obter o objeto é através do método getInstancia().
    private FilaDeImpressao() {
        System.out.println(">> [Singleton] Conexão com a impressora central estabelecida.");
    }

    /**
     * Ponto único de acesso à instância.
     * Se ainda não existir, cria. Se já existir, devolve a que já existe.
     */
    public static FilaDeImpressao getInstancia() {
        if (instancia == null) {
            instancia = new FilaDeImpressao();
        }
        return instancia;
    }

    /**
     * Simula o envio dos dados para a impressora física.
     */
    public void imprimir(String dadosDoCertificado) {
        System.out.println("--------------------------------------------------");
        System.out.println("IMPRIMINDO NA FILA ÚNICA:");
        System.out.println(dadosDoCertificado);
        System.out.println("--------------------------------------------------");
    }
}
