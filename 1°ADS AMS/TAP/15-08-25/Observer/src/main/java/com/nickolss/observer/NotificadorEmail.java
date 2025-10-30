package com.nickolss.observer;

public class NotificadorEmail implements Observer {

    private final String email;

    public NotificadorEmail(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(Mensagem mensagem) {
        System.out.println("[EMAIL] para " + email + ": " + mensagem.resumo());
    }
}
