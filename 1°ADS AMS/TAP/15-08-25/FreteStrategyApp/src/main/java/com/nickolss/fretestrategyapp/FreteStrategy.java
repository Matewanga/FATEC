package com.nickolss.fretestrategyapp;

public interface FreteStrategy {

    /**
     * @param pesoKg peso em quilogramas
     * @param distanciaKm distância em quilômetros
     * @return custo total do frete
     */
    double calcular(double pesoKg, double distanciaKm);

    /**
     * Nome legível da estratégia.
     */
    String nome();
}
