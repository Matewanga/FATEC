/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nickolss.contentpane;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ka1roo
 */
public class ContentPane {

    public static void main(String[] args) {
        // Criação da janela
        JFrame frame = new JFrame("Exemplo com Content Pane");

        // Criação de componentes
        JLabel label = new JLabel("Olá, esse componente está no Content Pane!", JLabel.CENTER);
        JButton botao = new JButton("Clique aqui");

        // Obter o content pane e configurar o layout
        Container painel = frame.getContentPane();
        painel.setLayout(new BorderLayout());

        // Adiciona componentes ao content pane
        painel.add(label, BorderLayout.CENTER);
        painel.add(botao, BorderLayout.NORTH);

        // Configurações da janela
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);

    }
}
