package com.nickolss.polimorfismoDinamico;

public class Main {

    public static void main(String[] args) {
        Atendimento atendimento;

        atendimento = new AtendimentoVendas();
        atendimento.responder(); // Chama o método sobrescrito da classe AtendimentoVendas

        atendimento = new AtendimentoSuporte();
        atendimento.responder(); // Chama o método sobrescrito da classe AtendimentoSuporte

        atendimento = new AtendimentoFinanceiro();
        atendimento.responder();     // Chama o método sobrescrito da classe AtendimentoFinanceiro
    }

}
