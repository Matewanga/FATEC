package com.nickolss.polimorfismoSobrescrita;

public class PagamentoBoleto extends Pagamento {

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Gerando boleto bancário no valor de R$ " + valor);
    }

}
