
package servesystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;

public class JanelaSolicitacoesFunc extends MainGUI {

    Funcionario funcionarioAtual;
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    protected static JList<Solicitacao> lista;
    private DefaultListModel<Solicitacao> model;

    //Botoes
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");

    //Rótulos
    private JLabel rotulo_nome = new JLabel("Lista de solicitações:");

    //Painéis
    private JPanel pan_nome = new JPanel();;
    private JPanel pan_lista = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaSolicitacoesFunc(Funcionario funcionarioAtual) {
        super("Lista de solicitações");
        this.funcionarioAtual = funcionarioAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        model = new DefaultListModel<>();
        Iterator it = ServeSystem.listaSolicitacoesFuncionario(funcionarioAtual.cargo).iterator();
        while(it.hasNext()) {
            model.addElement((Solicitacao)it.next());
        }
        lista = new JList<>(model);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(8); 

        pan_nome.setLayout(new FlowLayout());
        pan_lista.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_nome.add(rotulo_nome);
        pan_lista.add(lista);
        pan_bot.add(confirma);
        pan_bot.add(cancela);
        
        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        container.add(pan_nome);
        container.add(pan_lista);
        container.add(pan_bot);
    }
    
    private void janExecutar (Solicitacao solicitacao) {
        JanelasUmBotao jan_executar = new JanelasUmBotao(solicitacao, "Execução da solicitação", "Em execução");
        jan_executar.setSize(250, 80);
        jan_executar.setLocationRelativeTo(null);
        jan_executar.setResizable(false);
        jan_executar.setVisible(true);
    }
    
    private void janOrcamento (Solicitacao solicitacao) {
        JanelaOrcamento jan_orcamento = new JanelaOrcamento(solicitacao);
        jan_orcamento.setSize(450, 225);
        jan_orcamento.setLocationRelativeTo(null);
        jan_orcamento.setResizable(false);
        jan_orcamento.setVisible(true);
    }
    
    private void janPagamento (Solicitacao solicitacao) {
        JanelaPagamento jan_pagamento = new JanelaPagamento(solicitacao);
        jan_pagamento.setSize(450, 150);
        jan_pagamento.setLocationRelativeTo(null);
        jan_pagamento.setResizable(false);
        jan_pagamento.setVisible(true);
    }
    
    private void janelasOrcamento (Solicitacao solicitacao) {
        switch(solicitacao.estado) {
            case 1: case 2:
                solicitacao.setEstado(2);
                janOrcamento(solicitacao);                
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Solicitação orçada, favor esperar resposta do cliente.");
                break;
            case 4:
                janExecutar (solicitacao);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Favor esperar resposta de execução do cliente.");
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Solicitação executada e fatura emitida - aguardando pagamento.");
                break;
            case 7:
                janPagamento(solicitacao);
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Solicitação cancelada.");
                break;
        }
    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                lista.getSelectedValue().setTecnico(funcionarioAtual);
                janelasOrcamento(lista.getSelectedValue());
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
        }

    }
}
