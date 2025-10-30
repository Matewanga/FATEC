package com.nickolss.polimorfismoEstatico;

public class Main {

    public static void main(String[] args) {
        CalculadoraDescontos descontos = new CalculadoraDescontos();

        double precoBase = 100.0;

        double comDescontoFixo = descontos.calcularDesconto(precoBase, 15.0);
        double comDescontoPercentual = descontos.calcularDesconto(precoBase, 20);    // 20%
        double comCupom = descontos.calcularDesconto(precoBase, "DESC10");

        System.out.println("Preço original: R$ " + precoBase);
        System.out.println("Desconto fixo de R$15: R$ " + comDescontoFixo);
        System.out.println("Desconto percentual de 20%: R$ " + comDescontoPercentual);
        System.out.println("Desconto com cupom 'DESC10': R$ " + comCupom);
    }

}
