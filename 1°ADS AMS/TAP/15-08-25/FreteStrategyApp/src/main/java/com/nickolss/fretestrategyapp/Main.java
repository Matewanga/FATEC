package com.nickolss.fretestrategyapp;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        double pesoKg = 12.5;     // exemplo de pedido
        double distanciaKm = 850; // SP -> Salvador, por exemplo

        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // Inicia com estratégia TERRESTRE
        CalculadoraFrete calc = new CalculadoraFrete(new FreteTerrestre());
        double custoTerrestre = calc.calcular(pesoKg, distanciaKm);
        System.out.println("Estratégia: Terrestre | Custo = " + moeda.format(custoTerrestre));

        // Troca para AÉREO em tempo de execução
        calc.setStrategy(new FreteAereo());
        double custoAereo = calc.calcular(pesoKg, distanciaKm);
        System.out.println("Estratégia: Aéreo     | Custo = " + moeda.format(custoAereo));

        // Troca para MARÍTIMO em tempo de execução
        calc.setStrategy(new FreteMaritimo());
        double custoMaritimo = calc.calcular(pesoKg, distanciaKm);
        System.out.println("Estratégia: Marítimo  | Custo = " + moeda.format(custoMaritimo));
    }
}
