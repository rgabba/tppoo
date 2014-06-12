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
public class JanelaSolicitacoesCliente extends MainGUI {

    Cliente clienteAtual;
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    //Lista
    private JList<Solicitacao> lista;
    protected static DefaultListModel<Solicitacao> model;

    //Botoes
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");
    private JButton cria = new JButton("Criar Solicitação");

    //Rótulos
    private JLabel rotulo_nome = new JLabel("Lista de solicitações:");

    //Painéis
    private JPanel pan_nome = new JPanel();
    private JPanel pan_lista = new JPanel();
    private JPanel pan_bot = new JPanel();
    private JPanel pan_bot2 = new JPanel();

    JanelaSolicitacoesCliente(Cliente clienteAtual) {
        super("Suas solicitações");
        this.clienteAtual = clienteAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        model = new DefaultListModel<>();
        Iterator it = ServeSystem.listaSolicitacoesCliente(clienteAtual.cpf).iterator();
        while(it.hasNext()) {
            model.addElement((Solicitacao)it.next());
        }
        lista = new JList<>(model);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(8); 
        add(new JScrollPane(lista));

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
    
    private void janAprovOrcamento(Solicitacao solicitacao) {
        JanelaOrcamentoCliente jan_orcamentoC = new JanelaOrcamentoCliente(solicitacao);
        jan_orcamentoC.setSize(250, 250);
        jan_orcamentoC.setLocationRelativeTo(null);
        jan_orcamentoC.setResizable(true);
        jan_orcamentoC.setVisible(true);
    }
    private void janAprovExecucao(Solicitacao solicitacao) {
        JanelasUmBotao jan_orcamentoC = new JanelasUmBotao(solicitacao,"Aguardando execução","Execução concluída");
        jan_orcamentoC.setSize(250, 80);
        jan_orcamentoC.setLocationRelativeTo(null);
        jan_orcamentoC.setResizable(false);
        jan_orcamentoC.setVisible(true);
    }
    
    private void janPagamento(Solicitacao solicitacao) {
        JanelaConfirmaPagamento jan_pagamento = new JanelaConfirmaPagamento(solicitacao);
        jan_pagamento.setSize(450, 160);
        jan_pagamento.setLocationRelativeTo(null);
        jan_pagamento.setResizable(false);
        jan_pagamento.setVisible(true);
    }
    
    private void janSolicitacao(Solicitacao solicitacao) {
        switch(solicitacao.estado) {
            case 1:
                JOptionPane.showMessageDialog(null, "Solicitação cadastrada, favor aguardar orçamento.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Solicitação aberta, favor aguardar conclusão do orçamento.");
                break;
            case 3:
                janAprovOrcamento(solicitacao);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Aguardando início da execução.");
                break;
            case 5:
                janAprovExecucao(solicitacao);
                break;
            case 6:
                janPagamento(solicitacao);
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Solicitação encerrada.");
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Solicitação cancelada, favor criar nova.");
                break;
                
        }
    }
    
    private void janCriaSolicitacao(Cliente cliente) {
        JanelaCriaSolicitacao jan_criaSolicitacao = new JanelaCriaSolicitacao(cliente);
        jan_criaSolicitacao.setSize(450, 350);
        jan_criaSolicitacao.setLocationRelativeTo(null);
        jan_criaSolicitacao.setResizable(true);
        jan_criaSolicitacao.setVisible(true);
    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                janSolicitacao(lista.getSelectedValue());
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
            if (evento.getSource() == cria) {
                janCriaSolicitacao(clienteAtual);
            }
        }

    }

}
