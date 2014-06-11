/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;

/**
 *
 * @author User
 */
class JanelaPagamento extends MainGUI {

    Solicitacao solicitacaoAtual;
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();
   
    private JButton fecha = new JButton("Fechar");

    //Rótulos
    private JLabel rotulo_c1;
    private JLabel rotulo_c2;
    private JLabel rotulo_c3;

    //Painéis
    private JPanel pan_c1 = new JPanel();
    private JPanel pan_c2 = new JPanel();
    private JPanel pan_c3 = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaPagamento(Solicitacao solicitacaoAtual) {
        super("Pagamento da solicitação " + solicitacaoAtual.id);
        this.solicitacaoAtual = solicitacaoAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        rotulo_c1 = new JLabel("Forma de pagamento: " + solicitacaoAtual.getFormaPag());
        rotulo_c2 = new JLabel("Instituição de pagamento: " + solicitacaoAtual.getInstPag());
        rotulo_c3 = new JLabel("Número do recibo: " + solicitacaoAtual.getNPag());
        
        pan_c1.setLayout(new FlowLayout());
        pan_c2.setLayout(new FlowLayout());
        pan_c3.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_c1.add(rotulo_c1);
        pan_c2.add(rotulo_c2);
        pan_c3.add(rotulo_c3);
        pan_bot.add(fecha);
        
        fecha.addActionListener(manipuladorbotao);
        container.add(pan_c1);
        container.add(pan_c2);
        container.add(pan_c3);
        container.add(pan_bot);
    }
    
    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == fecha) {
                dispose();
            }
        }

    }
    
}

