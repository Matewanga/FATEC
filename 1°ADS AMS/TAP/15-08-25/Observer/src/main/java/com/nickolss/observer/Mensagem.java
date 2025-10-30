package com.nickolss.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensagem {

    private final String titulo;
    private final String conteudo;
    private final LocalDateTime dataHora = LocalDateTime.now();

    public Mensagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    // GRASP - Especialista: a própria mensagem sabe se resumir
    public String resumo() {
        String quando = dataHora.format(DateTimeFormatter.ofPattern("dd/MM HH:mm"));
        return "[" + quando + "] " + titulo + " - " + conteudo;
    }
}
