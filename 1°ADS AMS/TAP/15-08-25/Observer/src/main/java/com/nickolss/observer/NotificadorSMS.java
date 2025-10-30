package com.nickolss.observer;

public class NotificadorSMS implements Observer {

    private final String numero;

    public NotificadorSMS(String numero) {
        this.numero = numero;
    }

    @Override
    public void atualizar(Mensagem mensagem) {
        System.out.println("[SMS] para " + numero + ": " + mensagem.resumo());
    }
}
