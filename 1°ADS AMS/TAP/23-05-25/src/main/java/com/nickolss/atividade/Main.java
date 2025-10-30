package com.nickolss.atividade;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Notificacao> notificacoes = List.of(
                new NotificacaoEmail(),
                new NotificacaoPush(),
                new NotificacaoSMS()
        );
        
        notificacoes.forEach((notificacao) -> {
            notificacao.enviar();
        });
    }
}
