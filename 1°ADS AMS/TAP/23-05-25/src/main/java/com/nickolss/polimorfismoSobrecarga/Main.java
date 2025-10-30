package com.nickolss.polimorfismoSobrecarga;

public class Main {

    public static void main(String[] args) {
        Fatura fatura = new Fatura();

        // Chamada 1: método com 1 parâmetro
        fatura.emitirFatura(500.0);

        // Chamada 2: método com 2 parâmetros
        fatura.emitirFatura(750.0, "Fabiana");

        // Chamada 3: método com 3 parâmetros
        fatura.emitirFatura(1200.0, "João", 4);
    }

}
