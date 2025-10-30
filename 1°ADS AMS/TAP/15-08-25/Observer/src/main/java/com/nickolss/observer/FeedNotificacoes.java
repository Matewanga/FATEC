package com.nickolss.observer;

import java.util.ArrayList;
import java.util.List;

public class FeedNotificacoes implements Sujeito {

    private final List<Observer> observadores = new ArrayList<>();

    @Override
    public void inscrever(Observer o) {
        observadores.add(o);
    }

    @Override
    public void desinscrever(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificar(Mensagem m) {
        for (Observer o : observadores) {
            o.atualizar(m);
        }
    }

    // Ponto único de publicação (Especialista orquestra a notificação)
    public void publicar(Mensagem m) {
        notificar(m);
    }
}
