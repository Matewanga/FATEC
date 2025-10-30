package com.nickolss.fretestrategyapp;

public class FreteMaritimo implements FreteStrategy {
    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double taxaFixa = 4.0;           // despacho portuário
        double porKm = 0.01 * distanciaKm; // baixo custo por km
        double porKg = 1.0 * pesoKg;       // baixo custo por kg
        return taxaFixa + porKm + porKg;
    }

    @Override
    public String nome() { return "Marítimo"; }
}
