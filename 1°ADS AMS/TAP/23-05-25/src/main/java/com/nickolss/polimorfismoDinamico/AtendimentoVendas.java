package com.nickolss.polimorfismoDinamico;

public class AtendimentoVendas extends Atendimento {

    @Override
    public void responder() {
        System.out.println("Bem-vindo ao setor de Vendas! Em que posso ajudar com sua compra?");
    }

}
