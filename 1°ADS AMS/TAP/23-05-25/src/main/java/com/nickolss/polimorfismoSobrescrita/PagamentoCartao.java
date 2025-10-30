package com.nickolss.polimorfismoSobrescrita;

public class PagamentoCartao extends Pagamento {

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento no cartão de crédito de R$ " + valor + " processado com sucesso.");
    }

}
