package com.nickolss.observer;

public interface Sujeito {
    void inscrever(Observer o);
    void desinscrever(Observer o);
    void notificar(Mensagem m);
}
