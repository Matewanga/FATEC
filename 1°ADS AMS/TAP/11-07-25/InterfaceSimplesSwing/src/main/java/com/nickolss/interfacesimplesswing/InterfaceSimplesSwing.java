/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nickolss.interfacesimplesswing;

import javax.swing.JOptionPane;

/**
 *
 * @author ka1roo
 */
public class InterfaceSimplesSwing {

    public static void main(String[] args) {
        // Mensagem simples
        JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema de atendimento!");

        // Entrada de dados
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");

        // Saída personalizada
        JOptionPane.showMessageDialog(null, "Olá, " + nome + "! Vamos continuar...");

        // Confirmação
        int opcao = JOptionPane.showConfirmDialog(null, "Você deseja prosseguir?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
        }

        // Finalização
        JOptionPane.showMessageDialog(null, "Até logo, " + nome + "!");

    }
}
