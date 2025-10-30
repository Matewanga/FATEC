package com.nickolss.polimorfismoSobrescrita;

public class Main {

    public static void main(String[] args) {
        Pagamento pagamento1 = new Pagamento();              // objeto da superclasse
        Pagamento pagamento2 = new PagamentoBoleto();        // objeto da subclasse Boleto
        Pagamento pagamento3 = new PagamentoCartao();        // objeto da subclasse Cartão

        pagamento1.processarPagamento(150.0);
        pagamento2.processarPagamento(500.0);
        pagamento3.processarPagamento(250.0);
    }

}