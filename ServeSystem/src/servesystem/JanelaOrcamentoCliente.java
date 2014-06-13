
package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JanelaOrcamentoCliente extends MainGUI {

    Solicitacao solicitacaoAtual;
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();
    
    private JList<Material> lista;
    private DefaultListModel<Material> model;
   
    private JButton aceita = new JButton("Aceitar");
    private JButton recusa = new JButton("Recusar");

    //Rótulos
    private JLabel rotulo_lista = new JLabel("Lista de produtos:");
    private JLabel rotulo_custoF;

    //Painéis
    private JPanel pan_titulo = new JPanel();
    private JPanel pan_lista = new JPanel();
    private JPanel pan_custoF = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaOrcamentoCliente(Solicitacao solicitacaoAtual) {
        super("Orçamento da Solicitacao " + solicitacaoAtual.id);
        this.solicitacaoAtual = solicitacaoAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        rotulo_custoF = new JLabel("Custo final: " + solicitacaoAtual.precoFinal());
        
        model = new DefaultListModel<>();
        Iterator it = solicitacaoAtual.listaMaterial.iterator();
        while(it.hasNext()) {
            model.addElement((Material)it.next());
        }
        lista = new JList<>(model);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(8); 
        
        pan_titulo.setLayout(new FlowLayout());
        pan_lista.setLayout(new FlowLayout());
        pan_custoF.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_titulo.add(rotulo_lista);
        pan_lista.add(lista);
        pan_custoF.add(rotulo_custoF);
        pan_bot.add(aceita);
        pan_bot.add(recusa);
        
        aceita.addActionListener(manipuladorbotao);
        recusa.addActionListener(manipuladorbotao);
        container.add(pan_titulo);
        container.add(pan_lista);
        container.add(pan_custoF);
        container.add(pan_bot);
    }
    
    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == aceita) {
                solicitacaoAtual.setEstado(4);
                JOptionPane.showMessageDialog(null, "Orçamento aprovado.");
                dispose();
            }
            if (evento.getSource() == recusa) {
                solicitacaoAtual.setEstado(8);
                JOptionPane.showMessageDialog(null, "Orçamento rejeitado.");
                dispose();
            }
        }

    }
}

