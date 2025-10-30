package com.nickolss.polimorfismoDinamico;

public class AtendimentoSuporte extends Atendimento {

    @Override
    public void responder() {
        System.out.println("Olá! Você está falando com o Suporte Técnico. Qual o problema?");
    }

}
