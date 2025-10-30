package com.nickolss.polimorfismoSobrecarga;

public class Fatura {
    // Método 1: Apenas valor
    public void emitirFatura(double valor) {
        System.out.println("Fatura emitida no valor de R$ " + valor);
    }

    // Método 2: Valor + nome do cliente
    public void emitirFatura(double valor, String cliente) {
        System.out.println("Fatura para " + cliente + " no valor de R$ " + valor);
    }

    // Método 3: Valor + nome do cliente + parcelas
    public void emitirFatura(double valor, String cliente, int parcelas) {
        double valorParcela = valor / parcelas;
        System.out.println("Fatura para " + cliente + " no valor total de R$ " + valor
                + " em " + parcelas + " parcelas de R$ " + valorParcela);
    }

}
