package com.nickolss.atividade;

public class NotificacaoSMS extends Notificacao {

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para cliente...");
    }

}
