package com.nickolss.observer;

public class Main {

    public static void main(String[] args) {
        FeedNotificacoes feed = new FeedNotificacoes();

        Observer email = new NotificadorEmail("aluno@exemplo.com");
        Observer sms = new NotificadorSMS("+55 11 99999-0000");

        feed.inscrever(email);
        feed.inscrever(sms);

        feed.publicar(new Mensagem("Aviso de Aula", "Hoje começaremos com padrões GoF"));
        feed.publicar(new Mensagem("Material", "Slides atualizados no AVA"));

        feed.desinscrever(sms);
        feed.publicar(new Mensagem("Lembrete", "Entrega do exercício até sexta"));
    }
}
