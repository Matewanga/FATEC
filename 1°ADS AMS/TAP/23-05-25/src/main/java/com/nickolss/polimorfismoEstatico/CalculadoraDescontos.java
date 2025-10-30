package com.nickolss.polimorfismoEstatico;

public class CalculadoraDescontos {

    // Desconto fixo
    public double calcularDesconto(double precoOriginal, double valorDesconto) {
        return precoOriginal - valorDesconto;
    }

    // Desconto percentual
    public double calcularDesconto(double precoOriginal, int percentual) {
        return precoOriginal - (precoOriginal * percentual / 100.0);
    }

    // Desconto por cupom
    public double calcularDesconto(double precoOriginal, String cupom) {
        switch (cupom.toUpperCase()) {
            case "DESC10" -> {
                return precoOriginal - 10;
            }
            case "DESC20" -> {
                return precoOriginal - 20;
            }
            case "FRETEGRATIS" -> {
                System.out.println("Frete grátis aplicado! (sem desconto no produto)");
                return precoOriginal;
            }
            default -> {
                System.out.println("Cupom inválido.");
                return precoOriginal;
            }
        }
    }

}
