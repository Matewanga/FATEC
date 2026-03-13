/******************************************************************************
Programa: TemperaturaCidades
Descrição: Mostra algumas cidades, coleta temperaturas mensais
e calcula a média anual com sugestão de roupa.
*******************************************************************************/

import java.util.Scanner;

public class TemperaturaCidades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Lista de cidades sugeridas
        String[] cidadesSugeridas = {
            "São Paulo",
            "Rio de Janeiro",
            "Curitiba",
            "Salvador",
            "Porto Alegre"
        };

        // Curiosidades sobre as cidades
        String[] curiosidades = {
            "Maior cidade do Brasil.",
            "Famosa pelo Cristo Redentor.",
            "Conhecida pelo clima mais frio.",
            "Primeira capital do Brasil.",
            "Uma das cidades mais ao sul do país."
        };

        System.out.println("===== CIDADES DISPONÍVEIS =====");
        for (int i = 0; i < cidadesSugeridas.length; i++) {
            System.out.println((i + 1) + " - " + cidadesSugeridas[i] + " | Curiosidade: " + curiosidades[i]);
        }
        System.out.println("================================\n");

        String[] cidades = new String[3];
        double[][] temperaturas = new double[3][12];

        for (int i = 0; i < 3; i++) {

            System.out.print("Digite o nome da cidade escolhida: ");
            cidades[i] = sc.nextLine();

            double soma = 0;

            for (int j = 0; j < 12; j++) {
                System.out.print("Temperatura do mês " + (j + 1) + ": ");
                temperaturas[i][j] = sc.nextDouble();
                soma += temperaturas[i][j];
            }

            sc.nextLine(); // limpar buffer

            double media = soma / 12;

            System.out.println("\n===== RESULTADO =====");
            System.out.println("Cidade: " + cidades[i]);
            System.out.printf("Média anual: %.2f°C\n", media);

            if (media < 15) {
                System.out.println("Sugestão: Usar casaco pesado.");
            } else if (media < 22) {
                System.out.println("Sugestão: Usar casaco leve.");
            } else if (media < 28) {
                System.out.println("Sugestão: Usar camiseta.");
            } else {
                System.out.println("Sugestão: Usar roupas leves (shorts/regata).");
            }

            System.out.println("======================\n");
        }

        sc.close();
    }
}