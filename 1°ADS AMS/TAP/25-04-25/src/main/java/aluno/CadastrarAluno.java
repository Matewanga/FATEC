package aluno;

import java.util.Scanner;

public class CadastrarAluno {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite nome: ");
        aluno1.setNome(scanner.next());
        System.out.print("Digite sua nota: ");
        aluno1.setNota(scanner.nextDouble());
        aluno1.exibirInformacoes();
    }
}
