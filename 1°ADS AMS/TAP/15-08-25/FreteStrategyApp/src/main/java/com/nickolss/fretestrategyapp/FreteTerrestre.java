package com.nickolss.fretestrategyapp;

public class FreteTerrestre implements FreteStrategy {
    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double taxaFixa = 6.0;          // custo de despacho
        double porKm = 0.02 * distanciaKm; // custo variável por distância
        double porKg = 2.0 * pesoKg;       // custo variável por peso
        return taxaFixa + porKm + porKg;
    }

    @Override
    public String nome() { return "Terrestre"; }
}
