package com.nickolss.fretestrategyapp;

public class FreteAereo implements FreteStrategy {
    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double taxaFixa = 10.0;         // despacho + handling
        double porKm = 0.05 * distanciaKm; // mais caro por km
        double porKg = 5.0 * pesoKg;       // e por kg
        return taxaFixa + porKm + porKg;
    }

    @Override
    public String nome() { return "Aéreo"; }
}
