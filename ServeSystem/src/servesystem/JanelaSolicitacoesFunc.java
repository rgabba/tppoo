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
public class JanelaSolicitacoesFunc extends MainGUI {

    Funcionario funcionarioAtual;
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    private JList<Solicitacao> lista;
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

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {

            }
            if (evento.getSource() == cancela) {
                dispose();
            }
        }

    }
}
