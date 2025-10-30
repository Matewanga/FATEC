/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nickolss.lookandfell;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author ka1roo
 */
public class LookAndFell extends JFrame{
    
    private JButton btnMensagem;
    private JRadioButton rbMetal, rbMotif, rbWindows;
    private ButtonGroup group;
    
    public LookAndFell(){
        super("Exemplo de Look and Feel");
        
        // Button
        btnMensagem = new JButton("Hello, world!");
        
        // Look and Fell options
        rbMetal = new JRadioButton("Metal");
        rbMotif = new JRadioButton("Motif");
        rbWindows = new JRadioButton("Windows");
        
        // Group
        group = new ButtonGroup();
        group.add(rbMetal);
        group.add(rbMotif);
        group.add(rbWindows); 
        
        rbMetal.addActionListener(e -> setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"));
        rbMotif.addActionListener(e -> setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
        rbWindows.addActionListener(e -> setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
        
        setLayout(new FlowLayout());
        add(btnMensagem);
        add(rbMetal);
        add(rbMotif);
        add(rbWindows);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void setLookAndFeel(String look){
        try {
            UIManager.setLookAndFeel(look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Look and Feel unsupported");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LookAndFell());
    }
}
