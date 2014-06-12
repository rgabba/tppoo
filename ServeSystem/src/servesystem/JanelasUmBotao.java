/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author User
 */
public class JanelasUmBotao extends MainGUI {

    Solicitacao solicitacaoAtual;
    
    private static Random aleatorio = new Random();
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();
    
    private JButton botao;
    
    private JPanel pan_bot = new JPanel();

    JanelasUmBotao (Solicitacao solicitacaoAtual, String textoStatus, String textoBotao) {
        super(textoStatus + " " + solicitacaoAtual.id);
        this.solicitacaoAtual = solicitacaoAtual;
        botao = new JButton(textoBotao);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));

        pan_bot.setLayout(new FlowLayout());

        pan_bot.add(botao);
        
        botao.addActionListener(manipuladorbotao);
        container.add(pan_bot);
    }
    
    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == botao) {
                solicitacaoAtual.estado++;
                ServeSystem.salvarBanco();
                if(solicitacaoAtual.estado == 6) {
                    String i = String.valueOf(Math.abs(aleatorio.nextInt(1000000)));
                    JOptionPane.showMessageDialog(null, "Número da fatura: " + ("000000" + i).substring(i.length()));
                }
                JanelaSolicitacoesFunc.lista.updateUI();
                dispose();
            }
        }

    }
}

