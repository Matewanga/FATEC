package com.nickolss.polimorfismoDinamico;

public class AtendimentoFinanceiro extends Atendimento {

    @Override
    public void responder() {
        System.out.println("Boa tarde! Aqui é o setor Financeiro. Está com alguma dúvida sobre pagamentos?");
    }

}
