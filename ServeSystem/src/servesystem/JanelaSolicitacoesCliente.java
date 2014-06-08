/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class JanelaSolicitacoesCliente extends MainGUI {

    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    //Lista
    private JList<Solicitacao> lista;

    //Botoes
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");
    private JButton cria = new JButton("Criar Solicitação");

    //Rótulos
    private JLabel rotulo_nome = new JLabel("Lista de solicitações");

    //Painéis
    private JPanel pan_nome = new JPanel();
    private JPanel pan_lista = new JPanel();
    private JPanel pan_bot = new JPanel();
    private JPanel pan_bot2 = new JPanel();

    JanelaSolicitacoesCliente(Cliente clienteAtual) {
        super("Suas solicitações");
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        lista = new JList<>((Solicitacao[])ServeSystem.listaSolicitacoesCliente(clienteAtual).toArray());
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(250, 80));

        pan_nome.setLayout(new FlowLayout());
        pan_lista.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());
        pan_bot2.setLayout(new FlowLayout());

        pan_nome.add(rotulo_nome);
        pan_lista.add(lista);
        pan_bot.add(confirma);
        pan_bot.add(cancela);
        pan_bot2.add(cria);
        
        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        cria.addActionListener(manipuladorbotao);
        container.add(pan_nome);
        container.add(pan_lista);
        container.add(pan_bot);
        container.add(pan_bot2);

    }
    
    private void janelaSolicitacao(Solicitacao solicitacao) {
        
    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                janelaSolicitacao(lista.getSelectedValue());
                dispose();
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
            if (evento.getSource() == cria) {
                dispose();
            }
        }

    }

}
