package aluno;

public class Aluno {
    private String nome;
    private double nota;

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setNota(double novaNota) {
        if (novaNota >= 0 && novaNota <= 10) {
            nota = novaNota;
        } else {
            System.out.println("Nota inválida!");
        }
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void exibirInformacoes() {
        System.out.println("Aluno: " + nome);
        System.out.println("Nota: " + nota);
    }

}
