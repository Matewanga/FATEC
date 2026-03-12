/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class TemperaturaCidades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] cidades = new String[3];
        double[][] temperaturas = new double[3][12];
        double media;

        for (int i = 0; i < 3; i++) {

            System.out.print("Digite o nome da cidade: ");
            cidades[i] = sc.nextLine();

            double soma = 0;

            for (int j = 0; j < 12; j++) {
                System.out.print("Temperatura do mês " + (j + 1) + ": ");
                temperaturas[i][j] = sc.nextDouble();
                soma += temperaturas[i][j];
            }

            sc.nextLine(); // limpar buffer

            media = soma / 12;

            System.out.println("\nCidade: " + cidades[i]);
            System.out.println("Média anual: " + media + "°C");

            if (media < 15) {
                System.out.println("Sugestão: Usar casaco pesado.");
            } else if (media < 22) {
                System.out.println("Sugestão: Usar casaco leve.");
            } else if (media < 28) {
                System.out.println("Sugestão: Usar camiseta.");
            } else {
                System.out.println("Sugestão: Usar roupas leves (shorts/regata).");
            }

            System.out.println("-------------------------");
        }

        sc.close();
    }
}